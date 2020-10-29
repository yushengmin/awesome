package awesome.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.*;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HttpRequest {
    private static  CloseableHttpClient httpClient;
    //    public static final String CHARSET = "UTF-8";
    // 采用静态代码块，初始化超时时间配置，再根据配置生成默认httpClient对象
    static {
        HttpHost proxy = new HttpHost("127.0.0.1", 8888);
        RequestConfig config = RequestConfig.custom().setConnectTimeout(60000).setSocketTimeout(15000)
//                .setProxy(proxy)
                .build();
        httpClient = HttpClientBuilder.create().setDefaultRequestConfig(config).build();
    }
    //判断是否为空
    private static boolean isEmpty(final CharSequence cs) {
        return cs == null || cs.length() == 0;
    }

    //只带url
    public static String doGet(String url){
        return doGet(url,null,null);
    }
    //带url和参数
    public static String doGet(String url,Map<String,Object> params){
        return doGet(url,params,null);
    }

    //带url、参数、cookie
    public static String doGet(String url, Map<String,Object> params,BasicCookieStore cookie){
        String result = null;
        String apiUrl=null;
        List<NameValuePair> formparams = new ArrayList<NameValuePair>();
        try {
            if (params !=null && !params.isEmpty()) {
                // 参数写进formparams
                apiUrl = getUrlWithParams(url, params);

            }else {
                apiUrl=url;

            }
            HttpGet httpGet = new HttpGet(apiUrl);
            if(cookie.toString().length()>2){
                httpClient = HttpClientBuilder.create()
                        .setDefaultCookieStore(cookie)
                        .build();
            }
            CloseableHttpResponse response = httpClient.execute(httpGet);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != 200) {
                httpGet.abort();
                throw new RuntimeException("HttpClient,error status code :" + statusCode);
            }
            HttpEntity entity = response.getEntity();

            if (entity != null) {
                result = EntityUtils.toString(entity, "utf-8");
            }
            EntityUtils.consume(entity);

            response.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        JSONObject json1 = JSONObject.parseObject(result);
        String jsonString3= JSON.toJSONString(json1);
        return jsonString3;
    }


    //带url
    public static String doPost(String url) {
        return doPost(url,null,null);
    }
    //带url、参数
    public static String doPost(String url,Map<String,Object> parameters) {

        return doPost(url,parameters,null);
    }
//    //带url、参数
//    public static String doPost(String url,Map<String,String> parameters,String headers ) {
//        return doPost(url,parameters,headers,null);
//    }

    //带url、参数、cookie
    //httpClient
    public static String doPost(String url,Map<String,Object> parameters,BasicCookieStore cookie) {
        // 创建一个post请求
        HttpPost post = new HttpPost(url);
        //post 数据处理
        List<NameValuePair> formparams = new ArrayList<NameValuePair>();

        if (parameters!=null&&!parameters.isEmpty()) {
            for(String key : parameters.keySet()){
                formparams.add(new BasicNameValuePair(key,parameters.get(key).toString()));
            }
            UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams, Consts.UTF_8);
            post.setEntity(entity);
        }

        // 获取返回对象
        String result = "";
        CloseableHttpResponse resp;
        if(cookie.toString().length()>2){
            httpClient = HttpClientBuilder.create()
                    .setDefaultCookieStore(cookie)
                    .build();
        }

        try {
            resp = httpClient.execute(post);
            // http 状态 200 404 302 500
            StatusLine line = resp.getStatusLine();
//            System.out.println(line);
            // 结果
            HttpEntity httpEntity = resp.getEntity();
            // 结果转换
            result = EntityUtils.toString(httpEntity, "utf-8");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        JSONObject json1 = JSONObject.parseObject(result);
        String jsonString3= JSON.toJSONString(json1);
        return jsonString3;
    }





    //请求返回的是cookie信息
    public static BasicCookieStore doCookiePost(String url,Map<String,String> parameters){
        // 创建一个post请求
        HttpPost post = new HttpPost(url);
        //post 数据处理
        List<NameValuePair> formparams = new ArrayList<NameValuePair>();
        if (!parameters.isEmpty()) {
            for(String key : parameters.keySet()){
                formparams.add(new BasicNameValuePair(key,parameters.get(key)));
            }
            UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams, Consts.UTF_8);
            post.setEntity(entity);
        }
        CloseableHttpResponse resp=null;

        try {
            resp = httpClient.execute(post);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Header[] headers = resp.getHeaders("Set-Cookie");
    //        HashMap<String, String> cookies = new HashMap<String, String>(3);
        BasicCookieStore cookieStore = new BasicCookieStore();
        for (Header header : headers) {
            String key=header.getValue().substring(0,header.getValue().indexOf('='));
            String value=header.getValue().substring(header.getValue().indexOf("=") + 1, header.getValue().indexOf(';'));
            BasicClientCookie tokenCookie = new BasicClientCookie(key,value);
            tokenCookie.setPath("/");
            tokenCookie.setDomain(url.substring(url.indexOf("/")+2,url.lastIndexOf(":")));
            cookieStore.addCookie(tokenCookie);
        }
        return cookieStore;
    }






    //url json
    public static String doPostJson(String url,String jsonParam,String headers) {
        // 请求
        HttpPost post = new HttpPost(url);
        //postjson 数据处理
        StringEntity entity = new StringEntity(jsonParam.toString(),"utf-8");//解决中文乱码问题
        entity.setContentEncoding("UTF-8");
        entity.setContentType("application/json");
        post.setEntity(entity);

        if (!isEmpty(headers)) {
            String[] header_array = headers.split("&");
            for (String line : header_array) {
                String[] header = line.split("=");
                post.addHeader(header[0], header[1]);
            }

        }

        String result = "";
        CloseableHttpResponse resp;
        try {
            resp = httpClient.execute(post);
            // http 状态 200 404 302 500
            StatusLine line = resp.getStatusLine();
            // 结果
            HttpEntity httpEntity = resp.getEntity();
            // 结果转换
            result = EntityUtils.toString(httpEntity, "utf-8");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }



    private static String getUrlWithParams(String url, Map<String, Object> params) {
        boolean first = true;
        StringBuilder sb = new StringBuilder(url);
        for (String key : params.keySet()) {
            char ch = '&';
            if (first == true) {
                ch = '?';
                first = false;
            }
            String value = params.get(key).toString();
            try {
                String sval = URLEncoder.encode(value, "UTF-8");
                sb.append(ch).append(key).append("=").append(sval);
            } catch (UnsupportedEncodingException e) {
            }
        }
        return sb.toString();
    }










}



