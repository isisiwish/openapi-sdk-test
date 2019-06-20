package top.cfish.openapi.sdk.test.util;

import top.cfish.openapi.sdk.test.util.config.InitConfig;
import top.cfish.openapi.sdk.test.util.config.annotation.Conf;
import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


/**
 * @author: yule
 * @date: 2019/6/14
 * @time: 17:25
 */
@Slf4j
public class InitConfigTest
{
    /**
     * 使用junit或testng等单元测试，根目录会成为test-classes，config.properties需放置于test目录的resources
     */
    @Conf("server.port")
    public static String port;
    
    @BeforeMethod
    public void setUp()
    {
        InitConfig.putAllConf();
    }
    
    @Test
    public void testAnnotationConf()
    {
        log.info("server.port : {}", port);
        Assert.assertEquals(port, "12306");
    }
}
