package top.cfish.openapi.sdk.test.util;

import top.cfish.openapi.sdk.test.util.http.HttpGetUtil;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

import java.util.HashMap;

/**
 * @author: yule
 * @date: 2019/6/20
 * @time: 10:46
 */
@Slf4j
public class HttpGetUtilTest
{
    @Test
    public void testHttpGetUtil()
    {
        String fullUrl = HttpGetUtil.doGet("http://10.10.0.21:8500/index/radar/getFullIndex?tokenId=123");
        log.info("{}", fullUrl);
        
        HashMap<String, String> params = new HashMap<String, String>();
        params.put("tokenId", "123");
        String paramsUrl = HttpGetUtil.doGet("http://10.10.0.21:8500/index/radar/getFullIndex", params);
        log.info("{}", paramsUrl);
    }
}
