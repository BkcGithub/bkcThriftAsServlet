package com.bkc.util;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HttpClientUtils {

    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(HttpClientUtils.class.getName());
    private final int DEFAULT_TIMEOUT = 1800;
    private static int READ_TIMEOUT = 1800;
    private static int CONNECT_TIMEOUT = 1800;

    private static HttpClientUtils ins;

    private org.apache.http.client.HttpClient client;
    private int timeout = DEFAULT_TIMEOUT;

    private HttpClientUtils() {
        if (client == null) {
            client = HttpClients.custom()
                .setMaxConnPerRoute(20)
                .setMaxConnTotal(150)
                .build();
        }
    }

    public static HttpClientUtils getInstance() {
        if (ins == null) {
            synchronized (HttpClientUtils.class) {
                if (ins == null) {
                    ins = new HttpClientUtils();
                }
            }
        }
        return ins;
    }

    public String doPostWithResult(String uri, Map<String, String> paramMap) {
        String json = null;
        log.info("HttpClientUtil.doPostWithResult ========= Call [{}] Start ==========", uri);
        HttpPost request = new HttpPost(uri);
        try {
            RequestConfig config = RequestConfig.custom()
                .setConnectionRequestTimeout(DEFAULT_TIMEOUT)
                .setConnectTimeout(CONNECT_TIMEOUT)
                .setSocketTimeout(DEFAULT_TIMEOUT).build();
            request.setConfig(config);
            request.setHeader("Connection", "close");
            request.setHeader("ContentType", "application/x-www-form-urlencoded");
            List<NameValuePair> params = new ArrayList<NameValuePair>(0);
            if (paramMap != null && !paramMap.isEmpty()) {
                for (String key : paramMap.keySet()) {
                    params.add(new BasicNameValuePair(key, paramMap.get(key)));
                }
                request.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
            }
            HttpResponse response = client.execute(request);
            log.debug("Response status code: {}", response.getStatusLine().getStatusCode());
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                json = EntityUtils.toString(response.getEntity(), "utf-8");
                log.debug("Payload : {}", json);
            }
        } catch (Exception e) {
            log.error("HttpClient has exception!，uri{}, message: {}", uri, e.getMessage(), e);
        } finally {
            request.releaseConnection();
        }
        log.info("========= Call [{}] End ==========", uri);
        return json;
    }

    public static String doHttpPostIO(String url, String param) {
        HttpURLConnection conn = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            conn = (HttpURLConnection)realUrl.openConnection();
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setConnectTimeout(CONNECT_TIMEOUT);
            conn.setReadTimeout(READ_TIMEOUT);
            if(StringUtils.isNotEmpty(param)) {
                conn.getOutputStream().write(param.getBytes("utf-8"));
            }
            in = new BufferedReader(new InputStreamReader(conn.getInputStream(),"utf-8"));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            log.error("doHttpPostIO url{}-param{}-exception{}",url,param,e.getMessage());
        }
        finally{
            try{
                if(in!=null){
                    in.close();
                }
                if(conn != null) {
                    conn.disconnect();
                }
            }
            catch(IOException ex){
                log.error("doHttpPostIO url{}-param{}-exception{}",url,param,ex.getMessage());
            }
        }
        return result;
    }

}
