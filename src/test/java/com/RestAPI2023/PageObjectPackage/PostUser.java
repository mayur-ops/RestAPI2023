package com.RestAPI2023.PageObjectPackage;

public class PostUser {

    public String postBaseURI(){
        String URL = "https://reqres.in/";
        return URL;
    }

    public String postResource(){
        String resourceAndQueryParam = "/api/users";
        return resourceAndQueryParam;
    }

    public String postPayloadBody(){
        String PayloadBody = "{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"leader\"\n" +
                "}";
        return PayloadBody;
    }
}
