package rest_assured;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class TestCase01 {

//    @Test
    public void test00(){

//        when().get("https://reqres.in/api/users?page=1").then().statusCode(201);
        Response response = RestAssured.get("https://reqres.in/api/users?page=1");
        response.peek().prettyPrint();
        int statusCode = response.getStatusCode();
        System.out.println("statusCode = " + statusCode);

    }

//    @Test
    public void test01(){
        Response response=get("https://reqres.in/api/users?page=2");
        System.out.println("response.statusCode = " + response.statusCode());
        response.getStatusCode();
        System.out.println("response.getStatusCode() = " + response.getStatusCode());
        response.getBody().asString();
        System.out.println("response.getBody() = " + response.getBody().asString());
        response.getContentType();
        System.out.println("response.getContentType() = " + response.getContentType());
        response.getBody().prettyPrint();
        System.out.println("response.getBody().prettyPrint() = " + response.getBody().prettyPrint());
    }

    @Test
    public void test02(){
        given()
                .contentType(ContentType.JSON)
        .when()
                .get("https://reqres.in/api/users/2")
        .then()
                .body("data.first_name",is("Janet"))
                .statusCode(200);
    }
}
