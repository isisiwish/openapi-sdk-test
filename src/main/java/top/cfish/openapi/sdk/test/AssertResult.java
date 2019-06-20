package top.cfish.openapi.sdk.test;

import top.cfish.openapi.sdk.test.util.db.TestMapperFactory;
import top.cfish.openapi.sdk.test.util.db.entity.OpenApiSdkTestLog;
import top.cfish.openapi.sdk.test.util.db.mapper.OpenApiSdkTestLogMapper;
import top.cfish.openapi.sdk.test.util.net.NetUtil;
import top.cfish.openapi.sdk.test.util.xml.XmlCompareUtil;
import top.cfish.openapi.sdk.test.vo.CaseInfo;
import com.dangdang.openplatform.openapi.sdk.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;


/**
 * @author: isisiwish
 * @date: 2019/6/14
 * @time: 18:22
 */
@Slf4j
public class AssertResult
{
    private static String getParentStackTrace()
    {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        StackTraceElement parent = stackTrace[2];
        String tag = null;
        for (int i = 1; i < stackTrace.length; i++)
        {
            StackTraceElement e = stackTrace[i];
            if (!e.getClassName().equals(parent.getClassName()))
            {
                tag = e.getClassName() + "." + e.getMethodName();
                break;
            }
        }
        if (tag == null)
        {
            tag = parent.getClassName() + "." + parent.getMethodName();
            
        }
        return tag;
    }
    
    private static void dumpResult(String originalSdk, String originalYApi, String method)
    {
        OpenApiSdkTestLogMapper mapper = (OpenApiSdkTestLogMapper)TestMapperFactory.getMapper("OpenApiSdkTestLogMapper");
        OpenApiSdkTestLog testLog = new OpenApiSdkTestLog(method, NetUtil.getLocalIp(), originalSdk, originalYApi);
        mapper.insert(testLog);
    }
    
    public static void assertResult(BaseResponse sdkResponse, CaseInfo apiResponse) throws Exception
    {
        String parent = getParentStackTrace();
        String originalSdk = sdkResponse.getBody();
        String originalYApi = apiResponse.getResBody();
        
        // 对结果入库保存
        dumpResult(originalSdk, originalYApi, parent);
        
        // 将结果保存至log及报告，便于调试比较
        log.info("sdk reslut\r\n{}", originalSdk);
        log.info("yapi reslut\r\n{}", originalYApi);
    
        Assert.assertTrue(XmlCompareUtil.compare(originalSdk, originalYApi));
    }
}
