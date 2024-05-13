package apis;

import models.Driver;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;

public class RequestBody {

    @SuppressWarnings("unchecked")
    public static String validateDriverBody(Driver driver) {

        JSONObject requestBody = Utils.readJsonFile("data/json/validateDriver");
        JSONObject user = (JSONObject) requestBody.get("user");
        user.put("email", driver.email);
        user.put("firstName", driver.firstName);
        user.put("lastName", driver.lastName);
        user.put("phoneNumber", driver.phoneNumber);
        return requestBody.toString();
    }

    @SuppressWarnings("unchecked")
    public static String registerDriverBody(Driver driver) {

        JSONObject requestBody = Utils.readJsonFile("data/json/registerDriver");
        requestBody.put("Email", driver.email);
        requestBody.put("FirstName", driver.firstName);
        requestBody.put("LastName", driver.lastName);
        requestBody.put("PhoneNumber", driver.phoneNumber);
        JSONObject fields = (JSONObject) ((JSONArray) requestBody.get("Fields")).get(0);
        fields.put("Value", driver.ID);
        return requestBody.toString();
    }

    @SuppressWarnings("unchecked")
    public static String simpleLoadBody(Driver driver) {

        JSONObject requestBody = Utils.readJsonFile("data/json/simpleLoad");
        requestBody.put("Assignment", driver.email);
        JSONObject load = (JSONObject) requestBody.get("Load");
        load.put("Id", Utils.generateRandomNumber(6));
        load.put("BolNumber", Utils.generateRandomNumber(6));
        load.put("OrderNumber", Utils.generateRandomNumber(6));
        load.put("ProNumber", Utils.generateRandomNumber(6));
        load.put("RecipientId", TestBase.fleetID);

        return requestBody.toString();
    }
}
