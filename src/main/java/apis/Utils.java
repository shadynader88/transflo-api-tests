package apis;

import com.github.javafaker.Faker;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Utils {

    private static final Faker faker = new Faker();

    //Generic GET request
    @SuppressWarnings("unchecked")
    public static Response getRequest(Map<String, Object> request) {

        Response response = given()
                .log().method().log().uri()
                .urlEncodingEnabled(true)
                .contentType(ContentType.JSON)
                .headers((Map<String, Object>) request.get("headers"))
                .get(request.get("url").toString());
        System.out.println("Status Code: " + response.statusCode());
        System.out.println("Time taken: " + response.getTime());
        if (response.getContentType().contains(ContentType.JSON.toString())) {
            System.out.println("Response: " + response.getBody().asPrettyString());
        }
        return response;
    }

    //Generic POST request
    @SuppressWarnings("unchecked")
    public static Response postRequest(Map<String, Object> request) {

        Response response = given()
                .log().method().log().uri()
                .urlEncodingEnabled(true)
                .contentType(ContentType.JSON)
                .headers((Map<String, Object>) request.get("headers"))
                .body(request.get("body"))
                .post(request.get("url").toString());
        System.out.println("Status Code: " + response.statusCode());
        System.out.println("Time taken: " + response.getTime());
        if (response.getContentType().contains(ContentType.JSON.toString())) {
            System.out.println("Response: " + response.getBody().asPrettyString());
        }
        return response;
    }

    //Generic PUT request
    @SuppressWarnings("unchecked")
    public static Response putRequest(Map<String, Object> request) {

        Response response = given()
                .log().method().log().uri()
                .urlEncodingEnabled(true)
                .contentType(ContentType.JSON)
                .headers((Map<String, Object>) request.get("headers"))
                .body(request.get("body"))
                .put(request.get("url").toString());
        System.out.println("Status Code: " + response.statusCode());
        System.out.println("Time taken: " + response.getTime());
        if (response.getContentType().contains(ContentType.JSON.toString())) {
            System.out.println("Response: " + response.getBody().asPrettyString());
        }
        return response;
    }

    //Read Json file and return as JsonObject
    public static JSONObject readJsonFile(String pathname) {

        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject = (JSONObject) new JSONParser().parse(new FileReader(pathname));
        } catch (IOException | ParseException | NullPointerException ex) {
            ex.printStackTrace();
        }
        return jsonObject;
    }

    //Generate Random Number
    public static String generateRandomNumber(int digits) {

        return faker.number().digits(digits);
    }
}
