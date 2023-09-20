package com.RestAPI2023;

import extraResource.Payload;
import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class GoogleAPI {

    @Test
    public void postDemo(){
        given().baseUri("https://rahulshettyacademy.com").contentType(ContentType.JSON)
                .body(Payload.googleAPI())
                .when().post("/maps/api/place/add/json?key =qaclick123")
                .then().log().all()
                .assertThat().statusCode(200)
                .and().body("scope",is("APP"))
                .and().contentType(ContentType.JSON);
    }

    @Test
    public void putDemo(){
        given().baseUri("https://rahulshettyacademy.com").contentType(ContentType.JSON)
                .body("{\n" +
                        "\"place_id\":\"255265205cefd6b590fc7a82d417a96a\",\n" +
                        "\"address\":\"70 Summer walk, USA\",\n" +
                        "\"key\":\"qaclick123\"\n" +
                        "}\n")
                .when().put("/maps/api/place/update/json?key=qaclick123")
                .then().log().all()
                .assertThat().statusCode(200);
    }

    @Test
    public void deleteDemo(){
        given().baseUri("https://rahulshettyacademy.com").contentType(ContentType.JSON)
                .body("{\n" +
                        "    \"place_id\":\"255265205cefd6b590fc7a82d417a96a\"\n" +
                        "}\n")
                .when().body("/maps/api/place/delete/json?key=qaclick123").then().log().all();
    }
}
