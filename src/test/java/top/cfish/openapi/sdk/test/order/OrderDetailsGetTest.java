package top.cfish.openapi.sdk.test.order;

import top.cfish.openapi.sdk.test.SdkClientInstance;
import top.cfish.openapi.sdk.test.YApiClient;
import top.cfish.openapi.sdk.test.util.annotation.Failed;
import top.cfish.openapi.sdk.test.vo.CaseId;
import top.cfish.openapi.sdk.test.vo.CaseInfo;
import com.dangdang.openplatform.openapi.sdk.SdkClient;
import com.dangdang.openplatform.openapi.sdk.request.order.OrderDetailsGetRequest;
import com.dangdang.openplatform.openapi.sdk.requestmodel.order.OrderDetailsGet;
import com.dangdang.openplatform.openapi.sdk.response.order.OrderDetailsGetResponse;
import org.testng.annotations.Test;
import top.cfish.openapi.sdk.test.AssertResult;

/**
 * @author: isisiwish
 * @date: 2019/6/19
 * @time: 14:07
 */
public class OrderDetailsGetTest
{
    @Failed("YApi返回结果乱码")
    @Test(enabled = false)
    public void test1() throws Exception
    {
        // 调用YApi
        CaseId caseId = new CaseId(1305, "查看订单详细信息");
        CaseInfo apiResponse = YApiClient.get(caseId);
        
        // 通过SDK调用
        SdkClient sdkClient = SdkClientInstance.getClient();
        OrderDetailsGetRequest request = new OrderDetailsGetRequest();
        OrderDetailsGet orderDetailsGet = new OrderDetailsGet();
        orderDetailsGet.setO("13101234567");
        request.setOrderDetailsGet(orderDetailsGet);
        OrderDetailsGetResponse sdkResponse = sdkClient.excute(request);
        
        // 对SDK及YApi结果进行断言
        AssertResult.assertResult(sdkResponse, apiResponse);
    }
}
