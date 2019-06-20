package top.cfish.openapi.sdk.test.util.http;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;


/**
 * @author: isisiwish
 * @date: 2017/12/11
 * @time: 15:45
 */
@Slf4j
public class RequestExecutor
{
    public static int getHttpStatusCode(HttpUriRequest httpUriRequest) throws IOException
    {
        HttpResponse httpResponse = HttpClientBuilder.create().build().execute(httpUriRequest);
        return httpResponse.getStatusLine().getStatusCode();
    }
    
    public static String doExecute(HttpUriRequest httpUriRequest, String respCharset) throws HttpClientException
    {
        CloseableHttpClient closeableHttpClient = null;
        String url = httpUriRequest.getURI().toString();
        
        try
        {
            // 创建HttpClient
            closeableHttpClient = HttpClientBuilder.create().build();
            
            // 执行请求
            HttpResponse httpResponse = closeableHttpClient.execute(httpUriRequest);
            
            // 获取响应消息实体
            int httpStatus = httpResponse.getStatusLine().getStatusCode();
            
            if (httpStatus == HttpStatus.SC_OK)
            {
                // 使用getEntity方法获得返回结果
                byte[] bytearray = EntityUtils.toByteArray(httpResponse.getEntity());
                return new String(bytearray, respCharset);
            }
            else
            {
                log.debug("do request failure, HttpStatus={}, url={}", httpStatus, url);
                throw new HttpClientException("do request failure, HttpStatus=" + httpStatus, url);
            }
        }
        catch (UnsupportedEncodingException e)
        {
            log.debug("url={}", url, e);
            throw new HttpClientException(e, url);
        }
        catch (IOException e)
        {
            log.debug("url={}", url, e);
            throw new HttpClientException(e, url);
        }
        finally
        {
            try
            {
                // 关闭流并释放资源
                closeableHttpClient.close();
            }
            catch (IOException e)
            {
                log.debug("url={}", url, e);
                throw new HttpClientException(e, url);
            }
        }
    }
}
