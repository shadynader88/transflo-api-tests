package apis;

import io.restassured.RestAssured;
import org.json.simple.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

public class TestBase {

    public static String targetEnvironment;
    public static String baseURL;
    public static String basePath;
    public static String integrationToken;
    public static String mobileToken;
    public static String fleetID;
    public static String requestVerificationToken;


    //Get Base URL
    public static void readEnvironmentAttributes() {
        targetEnvironment = System.getProperty("target_environment");
        JSONObject env_file = Utils.readJsonFile("data/env_config/" + targetEnvironment + "_env");
        baseURL = env_file.get("baseURL").toString();
        basePath = env_file.get("basePath").toString();
        integrationToken = env_file.get("integrationToken").toString();
        mobileToken = env_file.get("mobileToken").toString();
        fleetID = env_file.get("fleetID").toString();
        requestVerificationToken = env_file.get("requestVerificationToken").toString();
    }

    //Set Base URl
    @BeforeSuite
    public void setBaseURL() {
        readEnvironmentAttributes();
        RestAssured.baseURI = baseURL;
        RestAssured.basePath = basePath;
        System.out.println("Running on " + targetEnvironment.toUpperCase() + " environment");
    }
}
