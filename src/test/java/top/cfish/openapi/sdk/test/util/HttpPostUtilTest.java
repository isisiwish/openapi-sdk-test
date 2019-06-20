package top.cfish.openapi.sdk.test.util;

import top.cfish.openapi.sdk.test.util.http.HttpPostUtil;
import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;

/**
 * @author: yule
 * @date: 2019/6/20
 * @time: 10:44
 */
@Slf4j
public class HttpPostUtilTest
{
    @Test
    public void testHttpPostUtil()
    {
        String url = "http://jgs.bg-online.com.cn/api";
        
        HashMap<String, String> params = new HashMap<>();
        params.put("logisticsId", "logisticsId");
        params.put("passwd", "passwd");
        params.put("time", "time");
        params.put("sign", "sign");
        params.put("method", "ect.trades.sold.get");
        params.put("is_not_download", "false");
        
        HashMap<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/x-www-form-urlencoded");
        
        String json = HttpPostUtil.doPost(url, params, headers);
        log.info("{}", json);
        Assert.assertNotNull(json);
    }
}
