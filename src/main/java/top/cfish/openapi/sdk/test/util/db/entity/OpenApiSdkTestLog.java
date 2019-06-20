package top.cfish.openapi.sdk.test.util.db.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;


/**
 * @author: isisiwish
 * @date: 2019/6/17
 * @time: 14:36
 */
@Getter
@Setter
public class OpenApiSdkTestLog
{
    private Long id;
    
    private String method;
    
    private String ip;
    
    private String originalSdk;
    
    private String originalYapi;
    
    private Date createTime;
    
    public OpenApiSdkTestLog(String method, String ip, String originalSdk, String originalYapi)
    {
        this.method = method;
        this.ip = ip;
        this.originalSdk = originalSdk;
        this.originalYapi = originalYapi;
    }
}
