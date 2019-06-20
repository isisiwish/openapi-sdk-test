package top.cfish.openapi.sdk.test.util.report.log;

import ch.qos.logback.core.OutputStreamAppender;
import com.google.common.base.Joiner;
import org.testng.ITestResult;
import org.testng.Reporter;

import java.io.OutputStream;


/**
 * @author: isisiwish
 * @date: 2019/6/13
 * @time: 16:28
 */
public class ReporterAppender<E> extends OutputStreamAppender<E>
{
    @Override
    public void start()
    {
        ReporterOutputStream ros = new ReporterOutputStream();
        super.setOutputStream(ros);
        super.start();
    }
    
    @Override
    protected void subAppend(E event)
    {
        if (started)
        {
            super.subAppend(event);
        }
    }
    
    @Override
    public void setOutputStream(OutputStream outputStream)
    {
        throw new UnsupportedOperationException("The output stream of " + this.getClass().getName() + " cannot be altered");
    }
    
    @Override
    public String toString()
    {
        ITestResult testResult = Reporter.getCurrentTestResult();
        return Joiner.on("").join(Reporter.getOutput(testResult));
    }
}
