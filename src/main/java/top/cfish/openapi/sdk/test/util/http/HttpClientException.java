package top.cfish.openapi.sdk.test.util.http;


/**
 * @author: isisiwish
 * @date: 2017/12/11
 * @time: 15:32
 */
public class HttpClientException extends Exception
{
    private String httpUrl = null;
    private Exception exception = null;
    
    public HttpClientException(String message, String httpUrl)
    {
        super(message);
        this.httpUrl = httpUrl;
    }
    
    public HttpClientException(Exception e, String httpUrl)
    {
        super();
        this.httpUrl = httpUrl;
        this.exception = e;
    }
    
    @Override
    public String getMessage()
    {
        if (exception != null)
        {
            return exception.getMessage() + ", url=" + this.httpUrl;
        }
        else
        {
            return super.getMessage() + ", url=" + this.httpUrl;
        }
    }
    
    public Exception getException()
    {
        return exception;
    }
    
    @Override
    public Throwable getCause()
    {
        return exception;
    }
    
    public void setHttpUrl(String httpUrl)
    {
        this.httpUrl = httpUrl;
    }
    
    public void setException(Exception exception)
    {
        this.exception = exception;
    }
    
    @Override
    public String toString()
    {
        if (exception != null)
        {
            return exception.toString();
        }
        else
        {
            return super.toString();
        }
    }
}
