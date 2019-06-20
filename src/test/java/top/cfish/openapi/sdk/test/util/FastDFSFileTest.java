package top.cfish.openapi.sdk.test.util;

import top.cfish.openapi.sdk.test.util.dfs.FastDFSFile;
import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;
import org.testng.annotations.Test;


/**
 * @author: yule
 * @date: 2019/6/17
 * @time: 16:47
 */
@Slf4j
public class FastDFSFileTest
{
    @Test
    public void testSaveFile() throws Exception
    {
        String file = "E:\\MC\\openapi-sdk-test\\.\\test-output/20190617-1607-report.html";
        String res = FastDFSFile.saveFile(file);
        log.info("{}", res);
        Assert.assertNotNull(res);
    }
}
