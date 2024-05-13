package apis.IWS;

import apis.RequestBody;
import apis.TestBase;
import apis.Utils;
import io.restassured.response.Response;
import models.Driver;
import org.testng.Assert;

import java.util.LinkedHashMap;
import java.util.Map;

public class driverAPIs_IWS {

    public static Response registerDriver(Driver driver){

        Map<String, Object> request = new LinkedHashMap<>();
        Map<String, Object> headers = new LinkedHashMap<>();
        headers.put("Authorization", "Basic " + TestBase.integrationToken);
        request.put("headers", headers);
        request.put("body", RequestBody.registerDriverBody(driver));
        request.put("url", "integration/api/v2/drivers/" + TestBase.fleetID + "/registrations");

        Response response = Utils.postRequest(request);
        Assert.assertEquals(response.getStatusCode(), 200);
        return response;
    }
}
