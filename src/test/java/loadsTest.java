import apis.CommonMethods;
import apis.IWS.loadsAPIs;
import apis.TestBase;
import io.restassured.response.Response;
import models.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class loadsTest extends TestBase {

    Response response;

    @Test
    void assignSimpleLoad()  {
        
        Driver driver = CommonMethods.createNewDriver();

        Response loadResponse = loadsAPIs.createSimpleLoad(driver);
        
       // Assert.assertEquals(loadResponse.path("LoadNumber"), "123");

    }
}
