package top.cfish.openapi.sdk.test.util.http.constant;

import java.nio.charset.Charset;

/**
 * @author: isisiwish
 * @date: 2017/12/11
 * @time: 16:07
 */
public class Constant
{
    // UTF-8编码
    public static final class UTF_8_ENCODE
    {
        public static final String CHARSET_NAME = "UTF-8";
        public static final Charset CHARSET = Charset.forName(CHARSET_NAME);
    }
    
    // GBK编码
    public static final class GBK_ENCODE
    {
        public static final String CHARSET_NAME = "GBK";
        public static final Charset CHARSET = Charset.forName(CHARSET_NAME);
    }
    
    // 系统默认编码
    public static final class DEFAULT_ENCODE
    {
        public static final String CHARSET_NAME = UTF_8_ENCODE.CHARSET_NAME;
        public static final Charset CHARSET = UTF_8_ENCODE.CHARSET;
    }
    
    // 连接时间60s
    public static final int DEFAULT_CONNECT_TIMEOUT = 60000;
    
    // 数据传输时间60s
    public static final int DEFAULT_SOCKET_TIMEOUT = 60000;
    
    public static final String DEFAULT_CHARSET = Constant.DEFAULT_ENCODE.CHARSET_NAME;
}
