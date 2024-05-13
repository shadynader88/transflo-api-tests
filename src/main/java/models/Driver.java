package models;

import apis.TestBase;
import apis.Utils;
import com.github.javafaker.Faker;
import apis.MWS.driverAPIs_MWS;

public class Driver {

    public String ID;
    public String phoneNumber;
    public String email;
    public String firstName;
    public String lastName;
    public String token;

    public Driver() {

        Faker faker = new Faker();
        this.firstName = faker.name().firstName();
        this.lastName = faker.name().lastName();
        this.phoneNumber = Utils.generateRandomNumber(10);
        this.ID = this.phoneNumber;
        this.email = TestBase.targetEnvironment + "_" + this.firstName.toLowerCase() + "_" + this.ID + "@transflo.com";
        System.out.println("Driver Email: " + this.email);
    }

    public void setDriverToken() {
        this.token = driverAPIs_MWS.generateDriverToken(this.email);
    }
}

