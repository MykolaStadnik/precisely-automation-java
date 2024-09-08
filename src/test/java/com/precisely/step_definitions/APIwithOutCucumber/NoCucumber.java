package com.precisely.step_definitions.APIwithOutCucumber;

import com.precisely.utilities.ConfigurationReader;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.*;

public class NoCucumber {
    @BeforeAll
    public static void init() {
        RestAssured.baseURI = ConfigurationReader.getProperty("apibaseuri");
    }

    static String id;

    @DisplayName("GET All breeds")
    @Test
    @Order(1)
    public void test1() {
        JsonPath jsonPath = given()
                .accept(ContentType.JSON)
                .when()
                .get("/breeds")
                .then()
                .statusCode(200).extract().jsonPath();
        id = jsonPath.getString("data[0].id");
    }

    @DisplayName("GET Breed by id")
    @Test
    @Order(2)
    public void test2() {
        given()
                .accept(ContentType.JSON)
                .pathParam("id",id)
                .when()
                .get("/breeds/{id}")
                .then()
                .statusCode(200)
                .body("data.id", is(id),
                        "data.attributes.life.max", instanceOf(Integer.class),
                        "data.attributes.hypoallergenic", instanceOf(Boolean.class),
                        "links.self", containsString("https://"));
    }
}
