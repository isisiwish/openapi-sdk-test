package top.cfish.openapi.sdk.test;

import com.alibaba.fastjson.JSON;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import top.cfish.openapi.sdk.test.util.config.InitConfig;
import top.cfish.openapi.sdk.test.util.config.annotation.Conf;
import top.cfish.openapi.sdk.test.util.config.annotation.Scan;
import top.cfish.openapi.sdk.test.util.http.HttpGetUtil;
import top.cfish.openapi.sdk.test.vo.CaseId;
import top.cfish.openapi.sdk.test.vo.CaseInfo;
import top.cfish.openapi.sdk.test.vo.YApiResponse;


/**
 * @author: isisiwish
 * @date: 2019/6/12
 * @time: 17:49
 */
@Scan
@Slf4j
@Setter
public class YApiClient
{
    @Conf("yapi.url")
    private static String yApiUrl;
    
    static
    {
        InitConfig.putAllConf();
    }
    
    /**
     * 对YApi调用进行简单封装
     */
    public static CaseInfo get(CaseId caseId)
    {
        String url = yApiUrl + caseId.getId();
        String yApiResult = HttpGetUtil.doGet(url);
        YApiResponse yApiResponse = JSON.parseObject(yApiResult, YApiResponse.class);
        CaseInfo caseInfo = yApiResponse.getCaseInfo();
        
        return caseInfo;
    }
}
