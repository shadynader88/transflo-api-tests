package apis.MWS;

import apis.TestBase;
import apis.Utils;
import io.restassured.response.Response;
import org.testng.Assert;

import java.util.LinkedHashMap;
import java.util.Map;


public class fleetAPIs {

    public static Response getFleetInfo() {

        Map<String, Object> request = new LinkedHashMap<>();
        Map<String, Object> headers = new LinkedHashMap<>();
        headers.put("Authorization", "Basic " + TestBase.mobileToken);
        request.put("headers", headers);
        request.put("url", "api/v7/recipients/" + TestBase.fleetID);

        Response response = Utils.getRequest(request);
        Assert.assertEquals(response.getStatusCode(), 200);
        return response;
    }
}
