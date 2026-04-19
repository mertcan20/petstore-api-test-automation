package requests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ApiTests {

    private static final String BASE_URI = "https://petstore.swagger.io/v2";
    private static final int PET_ID = 9756;

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = BASE_URI;
    }

    @Test(priority = 2)
    public void shouldGetPetById() {
        Response response = given()
                .when()
                .get("/pet/" + PET_ID);

        Assert.assertEquals(response.getStatusCode(), 200, "Status code mismatch!");
        Assert.assertEquals(response.getStatusLine(), "HTTP/1.1 200 OK", "Status line mismatch!");
        Assert.assertEquals(response.getHeader("Content-Type"), "application/json", "Content-Type mismatch!");
        Assert.assertTrue(response.getTime() <= 5000, "Response time exceeded 5 seconds");
        Assert.assertTrue(response.body().asString().contains("kopek"), "Response body does not contain expected value");
        Assert.assertEquals(response.jsonPath().getInt("id"), PET_ID, "ID doesn't match!");

        System.out.println("Status Code = " + response.getStatusCode());
        System.out.println("Status Line = " + response.getStatusLine());
        System.out.println("Content Type = " + response.getContentType());
        System.out.println("Response Time = " + response.getTime());

        response.prettyPrint();
    }

    @Test(priority = 1)
    public void shouldCreatePet() {
        String requestBody = """
        {
            "id": 9756,
            "category": {
                "id": 0,
                "name": "cesur"
            },
            "name": "kopek",
            "photoUrls": [
                "string"
            ],
            "tags": [
                {
                    "id": 0,
                    "name": "alman kurdu"
                }
            ],
            "status": "available"
        }
        """;

        Response response = given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("/pet");

        Assert.assertEquals(response.getStatusCode(), 200, "Status code mismatch!");
        Assert.assertEquals(response.jsonPath().getInt("id"), PET_ID, "ID mismatch!");
        Assert.assertEquals(response.jsonPath().getString("category.name"), "cesur", "Category name mismatch!");
        Assert.assertEquals(response.jsonPath().getString("name"), "kopek", "Pet name mismatch!");
        Assert.assertEquals(response.jsonPath().getString("status"), "available", "Status mismatch!");

        response.prettyPrint();
    }

    @Test(priority = 3)
    public void shouldUpdatePet() {
        String requestBody = """
        {
            "id": 9756,
            "category": {
                "id": 0,
                "name": "pamuk"
            },
            "name": "kedi",
            "photoUrls": [
                "string"
            ],
            "tags": [
                {
                    "id": 0,
                    "name": "tekir"
                }
            ],
            "status": "sold"
        }
        """;

        Response response = given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .put("/pet");

        Assert.assertEquals(response.getStatusCode(), 200, "Status code mismatch!");
        Assert.assertEquals(response.jsonPath().getInt("id"), PET_ID, "ID mismatch!");
        Assert.assertEquals(response.jsonPath().getString("category.name"), "pamuk", "Category name mismatch!");
        Assert.assertEquals(response.jsonPath().getString("name"), "kedi", "Pet name mismatch!");
        Assert.assertEquals(response.jsonPath().getString("status"), "sold", "Status mismatch!");
        Assert.assertEquals(response.jsonPath().getString("tags[0].name"), "tekir", "Tag name mismatch!");

        response.prettyPrint();
    }
    /*@Test(priority = 5)
    public void shouldReturn404ForInvalidPetId() {
        Response response = given()
                .when()
                .get("/pet/999999999");

        Assert.assertEquals(response.getStatusCode(), 404, "Expected 404 for non-existing pet id!");
    }
*/

    @Test(priority = 4)
    public void shouldDeletePet() {
        Response response = given()
                .when()
                .delete("/pet/" + PET_ID);

        Assert.assertEquals(response.getStatusCode(), 200, "Status code mismatch!");
        Assert.assertEquals(response.jsonPath().getString("message"), String.valueOf(PET_ID),
                "Delete confirmation message mismatch!");
    }
}