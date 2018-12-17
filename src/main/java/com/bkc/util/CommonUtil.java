package com.bkc.util;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommonUtil {
    /**
     * 根据IP地址获取客户端的MAC
     * @param ipAddress
     * @return
     * @throws IOException
     */
    public static String getMACAddress(String ipAddress) throws IOException {
        System.out.println("客户端的IP地址为："+ipAddress);
        String str = "", strMAC = "", macAddress = "";
        Process pp = Runtime.getRuntime().exec("nbtstat -a " + ipAddress);
        InputStreamReader ir = new InputStreamReader(pp.getInputStream());
        LineNumberReader input = new LineNumberReader(ir);
        for (int i = 1; i < 100; i++) {
            str = input.readLine();
            if (str != null) {
                if (str.indexOf("MAC Address") > 1) {
                    strMAC = str.substring(str.indexOf("MAC Address") + 14,str.length());
                    break;
                }
            }
        }
        if (strMAC.length() < 17) {

            return "Error!";
        }
        macAddress = strMAC.substring(0, 2) + ":" + strMAC.substring(3, 5)+ ":" + strMAC.substring(6, 8) + ":" + strMAC.substring(9, 11)+ ":" + strMAC.substring(12, 14) + ":"+ strMAC.substring(15, 17);
        System.out.println("客户端的MAC地址为："+macAddress);
        return macAddress;
    }
    /**
     * 获取客户端IP地址
     * @return
     */
    public static String getIpAddr(HttpServletRequest req) throws IOException {
        String ipAddress = req.getHeader("x-forwarded-for");
        if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress))
            ipAddress = req.getHeader("Proxy-Client-IP");
        if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress))
            ipAddress = req.getHeader("WL-Proxy-Client-IP");
        if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress))
            ipAddress = req.getHeader("HTTP_X_FORWARDED_FOR");
        if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress))
            ipAddress = req.getHeader("HTTP_CLIENT_IP");
        if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress))
            ipAddress = req.getRemoteAddr();
        String host = req.getRemoteHost();
        String ip = ipAddress+":"+host;
        System.out.println("访问者IP="+ip);
        return ip;
    }

    public static String filterEmojiV2(String source) {
        if (StringUtils.isBlank(source)) {
            return source;
        }
        String patternString = "[\uD84A\uDD8F]|[\uD83E\uDDD0-\uD83E\uDDDA]|[\uD83C\uDC04-\uD83C\uDE1A]|[\uD83D\uDC66-\uD83D\uDC69]|[uD83D\uDC96]|[\uD83D\uDC66\uD83C\uDFFB-\uD83D\uDC69\uD83C\uDFFF]|[\uD83D\uDE45\uD83C\uDFFB-\uD83D\uDE4F\uD83C\uDFFF]|[\uD83C\uDC00-\uD83D\uDFFF]|[\uD83E\uDD10-\uD83E\uDDC0]|[\uD83D\uDE00-\uD83D\uDE4F]|[\uD83D\uDE80-\uD83D\uDEF6]";
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(source);

        return matcher.replaceAll("");
    }

    public static String getRandomString(int length){
        String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random=new Random();
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<length;i++){
            int number=random.nextInt(62);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }

}
