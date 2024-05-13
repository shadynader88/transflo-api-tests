import apis.IWS.driverAPIs_IWS;
import apis.MWS.driverAPIs_MWS;
import apis.MWS.fleetAPIs;
import apis.TestBase;
import io.restassured.response.Response;
import models.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class driverRegistrationTest extends TestBase {

    Response response;

    @Test
    void registerNewDriver()  {

        Driver driver = new Driver();

        response = fleetAPIs.getFleetInfo();
        Assert.assertEquals(response.path("recipientId"), fleetID);
        Assert.assertEquals(response.path("name"), "Transflo Transport Group");

        response = driverAPIs_MWS.validateDriver(driver);
        Assert.assertEquals(response.path("name"), fleetID + " - Transflo Transport Group");

        response = driverAPIs_IWS.registerDriver(driver);
        Assert.assertEquals(response.path("Email"), driver.email);
    }
}
