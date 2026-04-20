package base;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    protected static final String BASE_URI = "https://petstore.swagger.io/v2";
    protected static final int PET_ID = 9756;

    @BeforeSuite
    public void setup() {
        RestAssured.baseURI = BASE_URI;
    }
}