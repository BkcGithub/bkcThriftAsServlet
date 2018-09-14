package com.datadeal.wechatuser;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.bkc.util.CommonUtil;
import com.bkc.util.HttpClientUtils;
import com.bkc.util.WriteToFileAppend;
import org.apache.commons.lang3.StringUtils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DealUnionId {
    static Connection conn = null;

    public static void main(String[] args) {

        DealUnionId db = new DealUnionId();
        db.init();
        exec();

    }

    private static void exec() {
        String token = getAccessToken();
        System.out.println(token);

        Statement stmt = null;
        ResultSet rs = null;
        //准备sql操作语句
        String sql =
            "select * from t_wechat_user where source_id = 'gh_b48f224eb457' and delete_flag = 0 and union_id is null";

        try {
            stmt = conn.createStatement();

            rs = stmt.executeQuery(sql);
            /*rs.next();

            System.out.println(rs.getInt(1));*/
            JSONObject params = new JSONObject();
            List<WechatUser> wechatUsers = new ArrayList<>();

            //从结果集中提取数据
            while (rs.next()) {
                int id = rs.getInt("id");
                int userId = rs.getInt("user_id");
                String openId = rs.getString("open_id");
                WechatUser user = new WechatUser();
                user.setId(id);
                user.setOpenId(openId);
                user.setUserId(userId);
                wechatUsers.add(user);
            }
            PrintStream ps = null;
            try {
                ps = new PrintStream(new FileOutputStream("/Users/bkc/Desktop/text"));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            int listSize = wechatUsers.size();
            System.out.println("totalCount " + listSize);
            int current = 1;
            if (listSize > 0) {
                int count = listSize / 100 + 1;
                for (int i = 0; i < count; i++) {
                    /**
                     * 0 99
                     * 100 199
                     * 200 299
                     */
                    int from = i * 100;
                    int to = from + 100;
                    if (i == count - 1) {
                        to = listSize;
                    }
                    List<WechatUser> subList = wechatUsers.subList(from, to);
                    List<JSONObject> list = new ArrayList<>();
                    for (WechatUser user : subList) {
                        JSONObject item = new JSONObject();
                        item.put("openid", user.getOpenId());
                        item.put("lang", "zh_CN");
                        list.add(item);
                    }
                    params.put("user_list", list);

                    String result = HttpClientUtils
                        .doHttpPostIO("https://api.weixin.qq.com/cgi-bin/user/info/batchget?access_token=" + token,
                            params.toJSONString());

                    if (StringUtils.isNotBlank(result)) {
                        JSONObject resultObj = JSONObject.parseObject(result);
                        if (null != resultObj && !resultObj.isEmpty()) {
                            JSONArray array = resultObj.getJSONArray("user_info_list");
                            if (null != array && !array.isEmpty()) {
                                int size = array.size();
                                if (size > 0) {
                                    for (int k = 0; k < size; k++) {
                                        JSONObject object = array.getJSONObject(k);
                                        String openId = object.getString("openid");
                                        String nickname = object.getString("nickname");
                                        String unionid = object.getString("unionid");

                                        String sqlUpdate =
                                            "update ent_portal_prod.t_wechat_user set union_id = \'" + unionid
                                                + "\', wechat_nickname = \'" + CommonUtil.filterEmojiV2(nickname) + "\' where open_id = \'"
                                                + openId + "\';\r\n";
                                        //System.out.println(sqlUpdate);
                                        try {
                                            System.out.println("deal " + current++);
                                            ps.write(sqlUpdate.getBytes());

                                        } catch (IOException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                }
                            }

                        }

                    }

                    params.clear();
                }

            }
            ps.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            close(conn, stmt, rs);
        }
    }

    public static void init() {
        // 不同的数据库有不同的驱动
        String driverName = "com.mysql.jdbc.Driver";
        String url =
            "jdbc:mysql://172.16.116.41:3306/ent_portal_prod?useUnicode=true&characterEncoding=UTF-8&allowMultiQueries=true";
        String user = "portal_Bkaichuan";
        String password = "wfB@Fed0";

        try {
            // 加载驱动
            Class.forName(driverName);
            // 设置 配置数据
            // 1.url(数据看服务器的ip地址 数据库服务端口号 数据库实例)
            // 2.user
            // 3.password
            conn = DriverManager.getConnection(url, user, password);
            // 开始连接数据库
            System.out.println("数据库连接成功..");
        } catch (ClassNotFoundException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }

    }

    public static void close(Connection conn, Statement stmt, ResultSet rs) {
        if (rs != null)
            try {
                rs.close();
            } catch (SQLException e1) {
                e1.printStackTrace();
                throw new RuntimeException(e1);
            }
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
    }

    private static String getAccessToken() {
        String accessToken = null;
        //从社区获取token
        String requestUrl = "http://social.sunlands.com/community/weixin/getWxTokenAndTicket";
        String jsonObjectStr = HttpClientUtils.doHttpPostIO(requestUrl, null);
        if (!StringUtils.isEmpty(jsonObjectStr)) {
            JSONObject jsonObject = JSONObject.parseObject(jsonObjectStr);
            if (null != jsonObject) {
                try {
                    if (jsonObject.getIntValue("rs") == 1) {

                        accessToken = jsonObject.getJSONObject("resultMessage").getString("accessToken");
                    }
                } catch (JSONException e) {
                    accessToken = null;
                }
            }
        }
        return accessToken;
    }

}
