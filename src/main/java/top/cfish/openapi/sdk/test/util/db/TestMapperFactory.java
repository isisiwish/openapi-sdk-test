package top.cfish.openapi.sdk.test.util.db;

import top.cfish.openapi.sdk.test.util.db.mapper.OpenApiSdkTestCaseIdMapper;
import top.cfish.openapi.sdk.test.util.db.mapper.OpenApiSdkTestLogMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;

/**
 * @author: isisiwish
 * @date: 2019/6/20
 * @time: 12:00
 */
@Slf4j
public class TestMapperFactory
{
    private static OpenApiSdkTestLogMapper openApiSdkTestLogMapper = null;
    private static OpenApiSdkTestCaseIdMapper openApiSdkTestCaseIdMapper = null;
    
    static
    {
        try
        {
            URL url = Thread.currentThread().getContextClassLoader().getResource("");
            File file = new File(url.getPath() + "mybatis-config.xml");
            InputStream inputStream = new FileInputStream(file);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession sqlSession = sqlSessionFactory.openSession();
            openApiSdkTestLogMapper = sqlSession.getMapper(OpenApiSdkTestLogMapper.class);
            openApiSdkTestCaseIdMapper = sqlSession.getMapper(OpenApiSdkTestCaseIdMapper.class);
        }
        catch (Exception e)
        {
            log.error("", e);
        }
    }
    
    public static OpenApiSdkTestMapper getMapper(String mapperName)
    {
        switch (mapperName)
        {
            case "OpenApiSdkTestLogMapper":
                return openApiSdkTestLogMapper;
            case "OpenApiSdkTestCaseIdMapper":
                return openApiSdkTestCaseIdMapper;
            default :
                return null;
        }
    }
}
