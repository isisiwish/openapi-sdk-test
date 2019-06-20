package top.cfish.openapi.sdk.test.util.config;


import top.cfish.openapi.sdk.test.util.file.FileUtil;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Properties;


/**
 * @author: isisiwish
 * @date: 2019/6/13
 * @time: 20:17
 */
public class LoadProperties
{
    /**
     * 单例，避免重复构造对象
     */
    private LoadProperties()
    {
    
    }
    
    private static LoadProperties instance = null;
    
    public static synchronized LoadProperties getInstance()
    {
        if (instance == null)
        {
            instance = new LoadProperties();
        }
        return instance;
    }
    
    // 增加缓存，避免反复加载properties
    private static HashMap<String, HashMap<String, String>> propertiesPathMap = new HashMap<>();
    
    public HashMap<String, String> loadSources(String path) throws IOException
    {
        HashMap<String, String> cacheMap = propertiesPathMap.get(path);
        if (null != cacheMap)
        {
            return cacheMap;
        }
        
        Properties properties = new Properties();
        InputStream in = FileUtil.getFileInputStream(path);
        if (null == in)
        {
            return null;
        }
        properties.load(in);
        HashMap<String, String> propertiesMap = convertToMap(properties);
        propertiesPathMap.put(path, propertiesMap);
        return propertiesMap;
    }
    
    // 将properties转换为map，成为k-v对，只支持string作为k，v；不能像Spring支持List及对象
    private HashMap<String, String> convertToMap(Properties properties)
    {
        HashMap<String, String> rsMap = new HashMap<>();
        Enumeration<Object> keys = properties.keys();
        while (keys.hasMoreElements())
        {
            Object key = keys.nextElement();
            Object value = properties.get(key);
            if (key instanceof String && value instanceof String)
            {
                rsMap.put((String)key, (String)value);
            }
        }
        return rsMap;
    }
}
