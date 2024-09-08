package com.precisely.step_definitions;

import com.precisely.utilities.ConfigurationReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static org.hamcrest.CoreMatchers.is;

public class DogApiStepDefinitions {
    RequestSpecification givenPart;
    ValidatableResponse thenPart;
    Response response;

    @Given("Accept header is {string}")
    public void accept_header_is(String contentType) {
            givenPart = RestAssured.given().log().uri().accept(contentType);
    }
    @When("I send GET request to {string} endpoint")
    public void i_send_get_request_to_endpoint(String endpoint) {
        response = givenPart.when().get(ConfigurationReader.getProperty("apibaseuri") + endpoint).prettyPeek();
        thenPart = response.then();
    }
    @Then("status code should be {int}")
    public void status_code_should_be(Integer statusCode) {
        thenPart.statusCode(statusCode);
    }
    @Then("Response Content type is {string}")
    public void response_content_type_is(String contentType) {
        thenPart.contentType(contentType);
    }
    @Then("the field value for {string} path should be equal to {string}")
    public void the_field_value_for_path_should_be_equal_to(String path, String valueToMach) {
        thenPart.body(path,is(valueToMach));
    }

}
