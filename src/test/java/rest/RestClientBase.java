package rest;

import io.restassured.http.ContentType;
import io.restassured.response.ExtractableResponse;
import io.restassured.specification.RequestSpecification;
import org.example.config.RestAssuredConfig;
import org.example.pojoClasses.Board;
import org.testng.annotations.BeforeClass;

import static io.restassured.RestAssured.given;

public abstract class RestClientBase {
    public static RequestSpecification requestSpecification;

    @BeforeClass
    public void setUp() {
        requestSpecification = RestAssuredConfig.getRequestSpecification();
    }

    public ExtractableResponse postRequest (Board body) {
        return
                given().contentType(ContentType.JSON)
                        .spec(requestSpecification)
                        .body(body)
                        .relaxedHTTPSValidation()
                        .when()
                        .post()
                        .then()
                        .extract();
    }

    public ExtractableResponse getRequest (String path) {
        return
            given()
                .spec(requestSpecification)
                .relaxedHTTPSValidation()
                .when()
                .get(path)
                .then()
                .extract();
    }

    public ExtractableResponse putRequest (String path, Board body) {
        return
                given()
                        .contentType(ContentType.JSON)
                        .spec(requestSpecification)
                        .body(body)
                        .relaxedHTTPSValidation()
                        .when()
                        .put(path)
                        .then()
                        .extract();
    }

    public ExtractableResponse deleteRequest (String path) {
        return
                given()
                        .contentType(ContentType.JSON)
                        .spec(requestSpecification)
                        .relaxedHTTPSValidation()
                        .when()
                        .delete(path)
                        .then()
                        .extract();
    }

}
