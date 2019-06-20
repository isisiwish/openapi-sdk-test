package top.cfish.openapi.sdk.test.util.config;

import top.cfish.openapi.sdk.test.util.config.annotation.Conf;
import top.cfish.openapi.sdk.test.util.config.annotation.Scan;
import top.cfish.openapi.sdk.test.util.file.PackageUtil;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Set;


/**
 * @author: isisiwish
 * @date: 2019/6/13
 * @time: 22:31
 */
@Slf4j
public class InitConfig
{
    public static void putAllConf()
    {
        // 添加@Scan注解的class进行扫描
        Set<Class<?>> classSet = PackageUtil.getClasses("");
        // 对set中的class进行注解匹配， 设置field
        classSet.forEach(InitConfig::putInConf);
    }
    
    private static void putInConf(Class<?> clazz)
    {
        // 获取field数组
        Field[] fields = clazz.getDeclaredFields();
        HashMap<String, String> propertiesMap = null;
        try
        {
            Scan confSource = clazz.getAnnotation(Scan.class);
            String propertyFile = confSource.value();
            propertiesMap = LoadProperties.getInstance().loadSources(propertyFile);
        }
        catch (Exception e)
        {
            log.error("properties文件获取异常", e);
        }
        
        for (Field field : fields)
        {
            // 如果field添加了@Conf注解
            if (field.isAnnotationPresent(Conf.class))
            {
                // static变量检查
                if ((field.getModifiers() & 8) == 0)
                {
                    throw new RuntimeException("配置项必须为static变量");
                }
                
                Conf conf = field.getAnnotation(Conf.class);
                String propertiesValue = propertiesMap.get(conf.value());
                
                try
                {
                    field.setAccessible(true);
                    field.set(field, String.valueOf(propertiesValue));
                }
                catch (IllegalAccessException e)
                {
                    log.error("field访问异常", e);
                }
            }
        }
    }
}
