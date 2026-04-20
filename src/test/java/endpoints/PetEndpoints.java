package endpoints;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class PetEndpoints {

    private static final String PET_PATH = "/pet";

    public static Response createPet(Object body) {
        return given()
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post(PET_PATH);
    }

    public static Response getPetById(int petId) {
        return given()
                .when()
                .get(PET_PATH + "/" + petId);
    }

    public static Response updatePet(Object body) {
        return given()
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .put(PET_PATH);
    }

    public static Response deletePet(int petId) {
        return given()
                .when()
                .delete(PET_PATH + "/" + petId);
    }
}