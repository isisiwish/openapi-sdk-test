package top.cfish.openapi.sdk.test.util.report.log;

import org.testng.Reporter;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;


/**
 * @author: isisiwish
 * @date: 2019/6/13
 * @time: 15:52
 */
public class ReporterOutputStream extends OutputStream
{
    // sout开关，已经通过log打印，无需使用sout，设定为false
    private final boolean logToStandardOut = false;
    
    private ByteArrayOutputStream out = new ByteArrayOutputStream();
    
    @Override
    public void write(int b)
    {
        out.write(b);
    }
    
    @Override
    public void write(byte b[], int off, int len)
    {
        out.write(b, off, len);
    }
    
    @Override
    public void flush()
    {
        // 解决html报告中xml标签被当做html标签
        String textAreaXml = "<textarea class=\"code-block maxxed\">" + out.toString() + "</textarea>";
        Reporter.log(textAreaXml, logToStandardOut);
        out.reset();
    }
    
    @Override
    public void close()
    {
        flush();
    }
}
