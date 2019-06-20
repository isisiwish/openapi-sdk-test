package top.cfish.openapi.sdk.test.vo;

import top.cfish.openapi.sdk.test.util.db.TestMapperFactory;
import top.cfish.openapi.sdk.test.util.db.entity.OpenApiSdkTestCaseId;
import top.cfish.openapi.sdk.test.util.db.mapper.OpenApiSdkTestCaseIdMapper;
import top.cfish.openapi.sdk.test.util.net.NetUtil;
import lombok.Getter;

/**
 * @author: isisiwish
 * @date: 2019/6/20
 * @time: 11:40
 */
@Getter
public class CaseId
{
    private int id;
    private String desc;
    
    public CaseId(int id, String desc)
    {
        this.id = id;
        this.desc = desc;
    
        String ip = NetUtil.getLocalIp();
    
        OpenApiSdkTestCaseIdMapper mapper = (OpenApiSdkTestCaseIdMapper)TestMapperFactory.getMapper("OpenApiSdkTestCaseIdMapper");
        OpenApiSdkTestCaseId record = new OpenApiSdkTestCaseId(id, desc, ip);
        int count = mapper.existsByCaseIdAndIp(id, ip);
        if (count == 0)
        {
            mapper.insert(record);
        }
        else
        {
            mapper.updateByCaseIdAndIp(record);
        }
    }
}
