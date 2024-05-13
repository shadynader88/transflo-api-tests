package apis.IWS;

import apis.RequestBody;
import apis.TestBase;
import apis.Utils;
import io.restassured.response.Response;
import models.Driver;
import org.testng.Assert;

import java.util.LinkedHashMap;
import java.util.Map;

public class loadsAPIs {

    public static Response createSimpleLoad(Driver driver){

        Map<String, Object> request = new LinkedHashMap<>();
        Map<String, Object> headers = new LinkedHashMap<>();
        headers.put("Authorization", "Basic " + TestBase.integrationToken);
        request.put("headers", headers);
        request.put("body", RequestBody.simpleLoadBody(driver));
        request.put("url", "integration/api/v1/loads/simple");

        Response response = Utils.postRequest(request);
        Assert.assertEquals(response.getStatusCode(), 200);
        return response;
    }
}
