package top.cfish.openapi.sdk.test.order;

import top.cfish.openapi.sdk.test.SdkClientInstance;
import top.cfish.openapi.sdk.test.YApiClient;
import top.cfish.openapi.sdk.test.util.annotation.Passed;
import top.cfish.openapi.sdk.test.vo.CaseId;
import top.cfish.openapi.sdk.test.vo.CaseInfo;
import com.dangdang.openplatform.openapi.sdk.SdkClient;
import com.dangdang.openplatform.openapi.sdk.request.order.OrderPayInfoGetResquest;
import com.dangdang.openplatform.openapi.sdk.response.order.OrderPayInfoGetReponse;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;
import top.cfish.openapi.sdk.test.AssertResult;

/**
 * @author: isisiwish
 * @date: 2019/6/12
 * @time: 15:41
 */
@Slf4j
public class OrderGetOrderPayInfoTest
{
    @Passed
    @Test
    public void test1() throws Exception
    {
        // 调用YApi
        CaseId caseId = new CaseId(1244, "获取商家订单到款信息");
        CaseInfo apiResponse = YApiClient.get(caseId);
        
        // 通过SDK调用
        SdkClient sdkClient = SdkClientInstance.getClient();
        OrderPayInfoGetResquest request = new OrderPayInfoGetResquest();
        // 使用YApi的调用参数作为SDK的调用参数
        request.setOrderId((String)apiResponse.getParams().get("orderId"));
        OrderPayInfoGetReponse sdkResponse = sdkClient.excute(request);
        
        // 对SDK及YApi结果进行断言
        AssertResult.assertResult(sdkResponse, apiResponse);
    }
}
