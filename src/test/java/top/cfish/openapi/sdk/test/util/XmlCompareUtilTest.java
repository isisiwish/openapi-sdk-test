package top.cfish.openapi.sdk.test.util;

import top.cfish.openapi.sdk.test.util.xml.XmlCompareUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author: yule
 * @date: 2019/6/19
 * @time: 17:45
 */
public class XmlCompareUtilTest
{
    @Test
    public void testCompare() throws Exception
    {
        String sdkXml = "<?xml version=\"1.0\" encoding=\"GBK\"?>\n" + "<response>\n" + "<functionID><![CDATA[searchItems]]></functionID>\n" + "<time><![CDATA[2019-06-19 00:00:00]]></time>\n" + "</response>";
        String apiXml = "<?xml version=\"1.0\" encoding=\"GBK\"?>\n" + "<response>\n" + "<functionID><![CDATA[searchItems]]></functionID>\n" + "<time><![CDATA[2019-06-19 00:00:01]]></time>\n" + "</response>";
        
        boolean rs = XmlCompareUtil.compare(sdkXml, apiXml);
        Assert.assertTrue(rs);
    }
}
