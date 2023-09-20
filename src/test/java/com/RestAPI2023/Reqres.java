package com.RestAPI2023;

import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItems;

public class Reqres {

    @Test
    public void getDemo(){
    given().baseUri("https://reqres.in/")
            .when().get("/api/users?page=2")
            .then().log().all()
            .assertThat().statusCode(200)
            .and().body("data.id",hasItems(7,8,9,10))
            .and().contentType(ContentType.JSON)
            .and().body("total_pages",equalTo(2));
    }
}
