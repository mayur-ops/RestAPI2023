package com.RestAPI2023.StepDefinationPackage;

import com.RestAPI2023.BaseClassPackage.BaseClass;
import com.RestAPI2023.PageObjectPackage.ListOfUsers;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItems;

public class ListOfUserSteps extends BaseClass {

    ListOfUsers listOfUsers = new ListOfUsers();

    @Given("base URI")
    public void base_uri() {
    requestSpecification = given().baseUri(listOfUsers.getBaseURI());
    }
    @When("user use get method resource")
    public void user_use_get_method_resource() {
    response = requestSpecification.when().get(listOfUsers.getResource());
    }
    @Then("user should able to see response status code {int}")
    public void user_should_able_to_see_response_status_code(Integer int1) {
    response.then().log().all().assertThat().statusCode(200).body("data.id",hasItems(7,8,9,10));
    }
}
