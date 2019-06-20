package top.cfish.openapi.sdk.test.util.db.mapper;

import top.cfish.openapi.sdk.test.util.db.OpenApiSdkTestMapper;
import top.cfish.openapi.sdk.test.util.db.entity.OpenApiSdkTestLog;
import org.apache.ibatis.annotations.Select;


/**
 * @author: isisiwish
 * @date: 2019/6/17
 * @time: 14:36
 */
public interface OpenApiSdkTestLogMapper extends OpenApiSdkTestMapper
{
    int deleteByPrimaryKey(Long id);
    
    int insert(OpenApiSdkTestLog record);
    
    int insertSelective(OpenApiSdkTestLog record);
    
    OpenApiSdkTestLog selectByPrimaryKey(Long id);
    
    int updateByPrimaryKeySelective(OpenApiSdkTestLog record);
    
    int updateByPrimaryKey(OpenApiSdkTestLog record);
    
    @Select("select count(1) from open_api_sdk_test_log")
    int count();
}
