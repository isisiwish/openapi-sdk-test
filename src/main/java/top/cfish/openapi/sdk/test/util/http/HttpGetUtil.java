package top.cfish.openapi.sdk.test.util.http;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import static top.cfish.openapi.sdk.test.util.http.constant.Constant.*;


/**
 * @author: isisiwish
 * @date: 2017/12/11
 * @time: 14:19
 */
@Slf4j
public class HttpGetUtil
{
    public static String doGet(String uri, String charset)
    {
        return HttpGetUtil.doGet(uri, null, null, DEFAULT_CONNECT_TIMEOUT, DEFAULT_SOCKET_TIMEOUT, charset);
    }
    
    public static String doGet(String uri)
    {
        return HttpGetUtil.doGet(uri, null, null, DEFAULT_CONNECT_TIMEOUT, DEFAULT_SOCKET_TIMEOUT, DEFAULT_CHARSET);
    }
    
    public static String doGet(String uri, HashMap<String, String> params)
    {
        return HttpGetUtil.doGet(uri, params, null, DEFAULT_CONNECT_TIMEOUT, DEFAULT_SOCKET_TIMEOUT, DEFAULT_CHARSET);
    }
    
    public static String doGet(String uri, HashMap<String, String> params, HashMap<String, String> headers)
    {
        return HttpGetUtil.doGet(uri, params, headers, DEFAULT_CONNECT_TIMEOUT, DEFAULT_SOCKET_TIMEOUT, DEFAULT_CHARSET);
    }
    
    public static String doGet(String uri, HashMap<String, String> params, HashMap<String, String> headers, int connectTimeout, int socketTimout, String charset)
    {
        String url = uri;
        try
        {
            // 拼接参数
            if (null != params)
            {
                url = url.concat("?").concat(getParamsEncodeUrl(params, charset));
            }
            
            HttpGet httpGet = new HttpGet(url);
            // 设置请求和传输超时时间
            RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(socketTimout).setConnectTimeout(connectTimeout).build();
            httpGet.setConfig(requestConfig);
            
            // 设置header
            if (null != headers && headers.size() > 0)
            {
                for (Map.Entry<String, String> header : headers.entrySet())
                {
                    httpGet.addHeader(header.getKey(), header.getValue());
                }
            }
            
            // 执行返回
            return RequestExecutor.doExecute(httpGet, charset);
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
    
    private static String getParamsEncodeUrl(HashMap<String, String> params, String charset)
    {
        if (params.size() == 0)
        {
            return "";
        }
        StringBuilder apiUri = new StringBuilder();
        try
        {
            for (Map.Entry<String, String> entry : params.entrySet())
            {
                apiUri.append(entry.getKey()).append("=").append(URLEncoder.encode(entry.getValue(), charset)).append("&");
            }
        }
        catch (UnsupportedEncodingException e)
        {
            log.error("字符集不支持", e);
            return null;
        }
        
        return apiUri.toString().substring(0, apiUri.length() - 1);
    }
}
