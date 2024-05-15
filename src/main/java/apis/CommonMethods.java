package apis;

import apis.IWS.driverAPIs_IWS;
import apis.MWS.driverAPIs_MWS;
import apis.MWS.fleetAPIs;
import models.Driver;

public class CommonMethods {

    public static Driver registerNewDriver() {

        Driver driver = new Driver();

        fleetAPIs.getFleetInfo();

        driverAPIs_MWS.validateDriver(driver);

        driverAPIs_IWS.registerDriver(driver);

        return driver;
    }
}
