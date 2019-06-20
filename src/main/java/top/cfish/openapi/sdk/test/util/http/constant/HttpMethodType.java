package top.cfish.openapi.sdk.test.util.http.constant;


/**
 * @author: isisiwish
 * @date: 2017/12/11
 * @time: 15:16
 */
public enum HttpMethodType
{
    METHOD_GET(1, "GET"),
    METHOD_POST(2, "POST"),
    METHOD_PUT(3, "PUT"),
    METHOD_DELETE(4, "DELETE");
    
    private Integer type;
    private String method;
    
    HttpMethodType(Integer type, String method)
    {
        this.type = type;
        this.method = method;
    }
    
    public Integer getType()
    {
        return this.type;
    }
    
    public String getMethod()
    {
        return this.method;
    }
    
    public static String getMethodByType(Integer type)
    {
        if (METHOD_GET.getType().intValue() == type.intValue())
        {
            return METHOD_GET.getMethod();
        }
        if (METHOD_POST.getType().intValue() == type.intValue())
        {
            return METHOD_POST.getMethod();
        }
        if (METHOD_PUT.getType().intValue() == type.intValue())
        {
            return METHOD_PUT.getMethod();
        }
        if (METHOD_DELETE.getType().intValue() == type.intValue())
        {
            return METHOD_DELETE.getMethod();
        }
        return null;
    }
    
    public static HttpMethodType getTypeByMethod(String method)
    {
        if (METHOD_GET.getMethod().equals(method))
        {
            return METHOD_GET;
        }
        if (METHOD_POST.getMethod().equals(method))
        {
            return METHOD_POST;
        }
        if (METHOD_PUT.getMethod().equals(method))
        {
            return METHOD_PUT;
        }
        if (METHOD_DELETE.getMethod().equals(method))
        {
            return METHOD_DELETE;
        }
        return null;
    }
}
