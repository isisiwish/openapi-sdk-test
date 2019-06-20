package top.cfish.openapi.sdk.test;

import com.dangdang.openplatform.openapi.sdk.SdkClient;
import top.cfish.openapi.sdk.test.util.config.annotation.Conf;
import top.cfish.openapi.sdk.test.util.config.annotation.Scan;


/**
 * @author: isisiwish
 * @date: 2019/6/12
 * @time: 15:43
 */
@Scan
public class SdkClientInstance
{
    @Conf("test.appKey")
    private static String appKey;
    
    @Conf("test.appSecret")
    private static String appSecret;
    
    @Conf("test.appSession")
    private static String appSession;
    
    private SdkClientInstance()
    {
    
    }
    
    private static SdkClient instance = null;
    
    public static synchronized SdkClient getClient()
    {
        if (instance == null)
        {
            instance = new SdkClient(appKey, appSecret, appSession, "1.0");
        }
        return instance;
    }
}
