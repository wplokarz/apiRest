package org.example.config;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import io.github.cdimascio.dotenv.Dotenv;
public class RestAssuredConfig {
    public static RequestSpecification getRequestSpecification() {
        Dotenv dotenv = Dotenv.configure().load();
        String baseUri = "https://api.trello.com/1/boards/";
        String apiKey = dotenv.get("API_KEY");
        String token = dotenv.get("TOKEN");
        return RestAssured.given()
                .baseUri(baseUri)
                .queryParam("key", apiKey)
                .queryParam("token", token);
    }
}
