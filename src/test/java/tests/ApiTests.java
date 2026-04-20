package tests;

import base.BaseTest;
import endpoints.PetEndpoints;
import io.restassured.response.Response;
import models.Category;
import models.Pet;
import models.Tag;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import java.util.List;

public class ApiTests extends BaseTest {

    @Test(priority = 1)
    public void shouldCreatePet() {
        Pet pet = buildAvailablePet();

        Response response = PetEndpoints.createPet(pet);

        Assert.assertEquals(response.getStatusCode(), 200, "Status code mismatch!");
        Assert.assertEquals(response.jsonPath().getInt("id"), PET_ID, "ID mismatch!");
        Assert.assertEquals(response.jsonPath().getString("category.name"), "cesur", "Category name mismatch!");
        Assert.assertEquals(response.jsonPath().getString("name"), "kopek", "Pet name mismatch!");
        Assert.assertEquals(response.jsonPath().getString("status"), "available", "Status mismatch!");
    }

    @Test(priority = 2)
    public void shouldGetPetById() {
        Response response = PetEndpoints.getPetById(PET_ID);

        Assert.assertEquals(response.getStatusCode(), 200, "Status code mismatch!");
        Assert.assertEquals(response.getStatusLine(), "HTTP/1.1 200 OK", "Status line mismatch!");
        Assert.assertEquals(response.getHeader("Content-Type"), "application/json", "Content-Type mismatch!");
        Assert.assertTrue(response.getTime() <= 5000, "Response time exceeded 5 seconds");
        Assert.assertTrue(response.body().asString().contains("kopek"), "Response body does not contain expected value");
        Assert.assertEquals(response.jsonPath().getInt("id"), PET_ID, "ID doesn't match!");
    }

    @Test(priority = 3)
    public void shouldUpdatePet() {
        Pet pet = buildSoldPet();

        Response response = PetEndpoints.updatePet(pet);

        Assert.assertEquals(response.getStatusCode(), 200, "Status code mismatch!");
        Assert.assertEquals(response.jsonPath().getInt("id"), PET_ID, "ID mismatch!");
        Assert.assertEquals(response.jsonPath().getString("category.name"), "pamuk", "Category name mismatch!");
        Assert.assertEquals(response.jsonPath().getString("name"), "kedi", "Pet name mismatch!");
        Assert.assertEquals(response.jsonPath().getString("status"), "sold", "Status mismatch!");
        Assert.assertEquals(response.jsonPath().getString("tags[0].name"), "tekir", "Tag name mismatch!");
    }

    @Test(priority = 4)
    public void shouldDeletePet() {
        Response response = PetEndpoints.deletePet(PET_ID);

        Assert.assertEquals(response.getStatusCode(), 200, "Status code mismatch!");
        Assert.assertEquals(response.jsonPath().getString("message"), String.valueOf(PET_ID),
                "Delete confirmation message mismatch!");
    }

    private Pet buildAvailablePet() {
        return new Pet(
                PET_ID,
                new Category(0, "cesur"),
                "kopek",
                List.of("string"),
                List.of(new Tag(0, "alman_kurdu")),
                "available"
        );
    }

    private Pet buildSoldPet() {
        return new Pet(
                PET_ID,
                new Category(0, "pamuk"),
                "kedi",
                List.of("string"),
                List.of(new Tag(0, "tekir")),
                "sold"
        );
    }
}