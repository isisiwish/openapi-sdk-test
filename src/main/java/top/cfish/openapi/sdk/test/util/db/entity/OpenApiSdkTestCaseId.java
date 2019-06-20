package top.cfish.openapi.sdk.test.util.db.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author: isisiwish
 * @date: 2019/6/20
 * @time: 11:54
 */
@Getter
@Setter
public class OpenApiSdkTestCaseId
{
    private Integer id;
    
    private Integer caseId;
    
    private String caseDesc;
    
    private String ip;
    
    private Date createTime;
    
    private Date updateTime;
    
    public OpenApiSdkTestCaseId(Integer caseId, String caseDesc, String ip)
    {
        this.caseId = caseId;
        this.caseDesc = caseDesc;
        this.ip = ip;
    }
}
