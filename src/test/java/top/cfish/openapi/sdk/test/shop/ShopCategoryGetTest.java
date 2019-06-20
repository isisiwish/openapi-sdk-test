package top.cfish.openapi.sdk.test.shop;

import top.cfish.openapi.sdk.test.SdkClientInstance;
import top.cfish.openapi.sdk.test.YApiClient;
import top.cfish.openapi.sdk.test.util.annotation.Passed;
import top.cfish.openapi.sdk.test.vo.CaseId;
import top.cfish.openapi.sdk.test.vo.CaseInfo;
import com.dangdang.openplatform.openapi.sdk.SdkClient;
import com.dangdang.openplatform.openapi.sdk.request.shop.ShopCategoryRequest;
import com.dangdang.openplatform.openapi.sdk.response.shop.ShopCategoryResponse;
import org.testng.annotations.Test;
import top.cfish.openapi.sdk.test.AssertResult;

/**
 * @author: isisiwish
 * @date: 2019/6/20
 * @time: 14:27
 */
public class ShopCategoryGetTest
{
    @Passed
    @Test
    public void test1() throws Exception
    {
        CaseId caseId = new CaseId(1329, "下载店内分类");
        CaseInfo apiResponse = YApiClient.get(caseId);
        
        SdkClient sdkClient = SdkClientInstance.getClient();
        ShopCategoryRequest request = new ShopCategoryRequest();
        ShopCategoryResponse sdkResponse = sdkClient.excute(request);
        
        AssertResult.assertResult(sdkResponse, apiResponse);
    }
}
