package com.RestAPI2023.StepDefinationPackage;

import com.RestAPI2023.BaseClassPackage.BaseClass;
import com.RestAPI2023.PageObjectPackage.PostUser;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class PostUserSteps extends BaseClass {

    PostUser postUser = new PostUser();

    @Given("base URI, ContentType and body")
    public void base_uri_content_type_and_body() {
    requestSpecification = given().baseUri(postUser.postBaseURI())
            .contentType(ContentType.JSON)
            .body(postUser.postPayloadBody());
    }
    @When("user provide resource and parameter along with POST method")
    public void user_provide_resource_and_parameter_along_with_post_method() {
    response = requestSpecification.when().post(postUser.postResource());
    }
    @Then("user should be able to see status code, content type, response body as per requirement")
    public void user_should_be_able_to_see_status_code_content_type_response_body_as_per_requirement() {
    response.then().log().all().assertThat().statusCode(201).and().body("name",is("morpheus"));
    }

}
