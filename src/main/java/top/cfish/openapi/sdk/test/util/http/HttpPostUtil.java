package top.cfish.openapi.sdk.test.util.http;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static top.cfish.openapi.sdk.test.util.http.constant.Constant.DEFAULT_CHARSET;
import static top.cfish.openapi.sdk.test.util.http.constant.Constant.DEFAULT_CONNECT_TIMEOUT;
import static top.cfish.openapi.sdk.test.util.http.constant.Constant.DEFAULT_SOCKET_TIMEOUT;


/**
 * @author: isisiwish
 * @date: 2017/12/11
 * @time: 16:18
 */
@Slf4j
public class HttpPostUtil
{
    public static String doPost(String uri)
    {
        return doPost(uri, null, null, DEFAULT_CONNECT_TIMEOUT, DEFAULT_SOCKET_TIMEOUT, DEFAULT_CHARSET);
    }
    
    public static String doPost(String uri, HashMap<String, String> params)
    {
        return doPost(uri, params, null, DEFAULT_CONNECT_TIMEOUT, DEFAULT_SOCKET_TIMEOUT, DEFAULT_CHARSET);
    }
    
    public static String doPost(String uri, HashMap<String, String> params, HashMap<String, String> headers)
    {
        return doPost(uri, params, headers, DEFAULT_CONNECT_TIMEOUT, DEFAULT_SOCKET_TIMEOUT, DEFAULT_CHARSET);
    }
    
    public static String doPostBody(String uri, String content)
    {
        return doPostBody(uri, content, null,  DEFAULT_CONNECT_TIMEOUT, DEFAULT_SOCKET_TIMEOUT, DEFAULT_CHARSET);
    }
    
    public static String doPostJson(String uri, String json)
    {
        HashMap<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        
        return doPostBody(uri, json, headers, DEFAULT_CONNECT_TIMEOUT, DEFAULT_SOCKET_TIMEOUT, DEFAULT_CHARSET);
    }
    
    public static String doPost(String uri, HashMap<String, String> params, HashMap<String, String> headers, int connectTimeout, int socketTimout, String charset)
    {
        String url = uri;
        try
        {
            HttpPost httpPost = new HttpPost(url);
            // 设置请求和传输超时时间
            RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(socketTimout).setConnectTimeout(connectTimeout).build();
            httpPost.setConfig(requestConfig);
    
            // 设置header
            if (null != headers && headers.size() > 0)
            {
                for (Map.Entry<String, String> header : headers.entrySet())
                {
                    httpPost.addHeader(header.getKey(), header.getValue());
                }
            }
            else
            {
                if (null != params && params.size() > 0)
                {
                    httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded");
                }
            }
            // 设置参数
            if (null != params && params.size() > 0)
            {
                List<BasicNameValuePair> postData = new ArrayList<BasicNameValuePair>();
                for (Map.Entry<String, String> entry : params.entrySet())
                {
                    postData.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
                }
                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(postData, charset);
                httpPost.setEntity(entity);
            }
            
           
            return RequestExecutor.doExecute(httpPost, charset);
        }
        catch (HttpClientException e)
        {
            log.error("", e);
            return null;
        }
        catch (Exception e)
        {
            log.error("", e);
            return null;
        }
    }
    
    public static String doPostBody(String uri, String content, HashMap<String, String> headers, int connectTimeout, int socketTimout, String charset)
    {
        String url = uri;
        try
        {
            HttpPost httpPost = new HttpPost(url);
            // 设置请求和传输超时时间
            RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(socketTimout).setConnectTimeout(connectTimeout).build();
            httpPost.setConfig(requestConfig);
            
            // 设置参数
            if (null != content)
            {
                StringEntity entity = new StringEntity(content, charset);
                httpPost.setEntity(entity);
            }
            // 设置header
            if (null != headers && headers.size() > 0)
            {
                for (Map.Entry<String, String> header : headers.entrySet())
                {
                    httpPost.addHeader(header.getKey(), header.getValue());
                }
            }
            return RequestExecutor.doExecute(httpPost, charset);
        }
        catch (HttpClientException e)
        {
            log.error("", e);
            return null;
        }
        catch (Exception e)
        {
            log.error("", e);
            return null;
        }
    }
}
