package top.cfish.openapi.sdk.test.util.db.mapper;

import top.cfish.openapi.sdk.test.util.db.OpenApiSdkTestMapper;
import top.cfish.openapi.sdk.test.util.db.entity.OpenApiSdkTestCaseId;
import org.apache.ibatis.annotations.Param;

/**
 * @author: isisiwish
 * @date: 2019/6/20
 * @time: 11:54
 */
public interface OpenApiSdkTestCaseIdMapper extends OpenApiSdkTestMapper
{
    int deleteByPrimaryKey(Integer id);
    
    int insert(OpenApiSdkTestCaseId record);
    
    int insertSelective(OpenApiSdkTestCaseId record);
    
    OpenApiSdkTestCaseId selectByPrimaryKey(Integer id);
    
    int updateByPrimaryKeySelective(OpenApiSdkTestCaseId record);
    
    int updateByPrimaryKey(OpenApiSdkTestCaseId record);
    
    int existsByCaseIdAndIp(@Param("caseId") Integer caseId, @Param("ip") String ip);
    
    int updateByCaseIdAndIp(OpenApiSdkTestCaseId record);
}
