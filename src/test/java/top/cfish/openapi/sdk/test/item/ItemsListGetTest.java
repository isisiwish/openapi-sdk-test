package top.cfish.openapi.sdk.test.item;

import top.cfish.openapi.sdk.test.SdkClientInstance;
import top.cfish.openapi.sdk.test.YApiClient;
import top.cfish.openapi.sdk.test.util.annotation.Passed;
import top.cfish.openapi.sdk.test.vo.CaseId;
import top.cfish.openapi.sdk.test.vo.CaseInfo;
import com.dangdang.openplatform.openapi.sdk.SdkClient;
import com.dangdang.openplatform.openapi.sdk.request.item.ItemsListGetRequest;
import com.dangdang.openplatform.openapi.sdk.requestmodel.item.ItemsListGet;
import com.dangdang.openplatform.openapi.sdk.response.item.ItemsListGetResponse;
import org.testng.annotations.Test;
import top.cfish.openapi.sdk.test.AssertResult;

/**
 * @author: isisiwish
 * @date: 2019/6/19
 * @time: 14:43
 */
public class ItemsListGetTest
{
    @Passed
    @Test
    public void test1() throws Exception
    {
        CaseId caseId = new CaseId(1321, "查询商品列表信息");
        CaseInfo apiResponse = YApiClient.get(caseId);
        
        SdkClient sdkClient = SdkClientInstance.getClient();
        sdkClient.setVersion("2.0");
        ItemsListGetRequest request = new ItemsListGetRequest();
        ItemsListGet get = new ItemsListGet();
        request.setItemsListGet(get);
        ItemsListGetResponse sdkResponse = sdkClient.excute(request);
        
        AssertResult.assertResult(sdkResponse, apiResponse);
    }
    
    @Passed
    @Test
    public void test2() throws Exception
    {
        CaseId caseId = new CaseId(1369, "查询商品列表信息");
        CaseInfo apiResponse = YApiClient.get(caseId);
        
        SdkClient sdkClient = SdkClientInstance.getClient();
        sdkClient.setVersion("2.0");
        ItemsListGetRequest request = new ItemsListGetRequest();
        ItemsListGet get = new ItemsListGet();
        get.setIts("9998");
        request.setItemsListGet(get);
        ItemsListGetResponse sdkResponse = sdkClient.excute(request);
        
        AssertResult.assertResult(sdkResponse, apiResponse);
    }
    
    @Passed
    @Test
    public void test3() throws Exception
    {
        CaseId caseId = new CaseId(1377, "查询商品列表信息");
        CaseInfo apiResponse = YApiClient.get(caseId);
        
        SdkClient sdkClient = SdkClientInstance.getClient();
        sdkClient.setVersion("2.0");
        ItemsListGetRequest request = new ItemsListGetRequest();
        ItemsListGet get = new ItemsListGet();
        get.setDatatype("8992");
        request.setItemsListGet(get);
        ItemsListGetResponse sdkResponse = sdkClient.excute(request);
        
        AssertResult.assertResult(sdkResponse, apiResponse);
    }
    
    @Passed
    @Test
    public void test4() throws Exception
    {
        CaseId caseId = new CaseId(1385, "查询商品列表信息");
        CaseInfo apiResponse = YApiClient.get(caseId);
        
        SdkClient sdkClient = SdkClientInstance.getClient();
        sdkClient.setVersion("2.0");
        ItemsListGetRequest request = new ItemsListGetRequest();
        ItemsListGet get = new ItemsListGet();
        get.setItb("linning");
        request.setItemsListGet(get);
        ItemsListGetResponse sdkResponse = sdkClient.excute(request);
        
        AssertResult.assertResult(sdkResponse, apiResponse);
    }
    
    @Passed
    @Test
    public void test5() throws Exception
    {
        CaseId caseId = new CaseId(1393, "查询商品列表信息");
        CaseInfo apiResponse = YApiClient.get(caseId);
        
        SdkClient sdkClient = SdkClientInstance.getClient();
        sdkClient.setVersion("2.0");
        ItemsListGetRequest request = new ItemsListGetRequest();
        ItemsListGet get = new ItemsListGet();
        get.setItb("王者荣耀");
        request.setItemsListGet(get);
        ItemsListGetResponse sdkResponse = sdkClient.excute(request);
        
        AssertResult.assertResult(sdkResponse, apiResponse);
    }
    
}

