package apis.MWS;

import apis.RequestBody;
import apis.TestBase;
import apis.Utils;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import models.Driver;
import org.testng.Assert;

import java.util.LinkedHashMap;
import java.util.Map;

import static io.restassured.path.xml.XmlPath.CompatibilityMode.HTML;

public class driverAPIs_MWS {

    public static Response validateDriver(Driver driver){

        Map<String, Object> request = new LinkedHashMap<>();
        Map<String, Object> headers = new LinkedHashMap<>();
        headers.put("Authorization", "Basic " + TestBase.mobileToken);
        request.put("headers", headers);
        request.put("body", RequestBody.validateDriverBody(driver));
        request.put("url", "api/v7/recipients/validation/" + TestBase.fleetID);

        Response response = Utils.postRequest(request);
        Assert.assertEquals(response.getStatusCode(), 200);
        return response;
    }

    public static String generateDriverToken(String email){

            Response response = RestAssured
                    .given()
                    .contentType(ContentType.URLENC)
                    .formParam("UserName", email)
                    .formParam("Password", "")
                    .header("Cookie", TestBase.requestVerificationToken)
                    .when()
                    .post(TestBase.baseURL + "AdminTools/Security/GenerateIntegrationKey");

        Assert.assertEquals(response.getStatusCode(), 200);
        XmlPath htmlPath = new XmlPath(HTML, response.getBody().asString());
        String token = htmlPath.getString("html.body.div[1].div.div.div.text()").trim();
        token = token.split("\n")[0];
        return token;
    }
}
