package top.cfish.openapi.sdk.test.util.http;

import top.cfish.openapi.sdk.test.util.http.constant.HttpMethodType;
import org.apache.http.client.methods.HttpGet;

import java.io.IOException;
import java.util.HashMap;


/**
 * @author: isisiwish
 * @date:2017/12/11
 * @time: 17:10
 */
public class HttpUtil
{
    public static int requestStatusCode(String uri) throws IOException
    {
        HttpGet httpGet = new HttpGet(uri);
        return RequestExecutor.getHttpStatusCode(httpGet);
    }
    
    public static String request(String url, HttpMethodType requestMethod, HashMap<String, String> params, HashMap<String, String> headers)
    {
        String responseMsg = null;
        
        switch (requestMethod)
        {
            case METHOD_GET:
                responseMsg = HttpGetUtil.doGet(url, params, headers);
                break;
            case METHOD_POST:
                responseMsg = HttpPostUtil.doPost(url, params, headers);
                break;
            case METHOD_DELETE:
            case METHOD_PUT:
            default:
                break;
        }
        return responseMsg;
    }
}
