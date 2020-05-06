package rest_assured.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.any;
import static org.hamcrest.MatcherAssert.assertThat;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import rest_assured.restApiFramework.RestTestBuilder;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.Matchers.*;

public class MyStepdefs {

    public static ResponseOptions<Response> response;
    public static String token;


    @Given("^I perform Get operation with \"([^\"]*)\"$")
    public void iPerformGetOperationWith(String arg0) throws Throwable {
        given()
                .contentType(ContentType.JSON);
    }

    @When("^I perform Get for the user id with (\\d+)$")
    public void iPerformGetForTheUserIdWith(int id) {
        when()
                .get(String.format("https://reqres.in/api/users/%d",id))
                .then()
                .body("data.first_name",is("Janet"))
                .statusCode(200);
    }



    @Given("I perform {string} operation with {string}")
    public void iPerformOperationWith(String method, String path) {

        RestTestBuilder testBuilder=new RestTestBuilder(path,method,null);
        response=testBuilder.executeJust();
    }

//    @Given("I perform {string} operation with {string}")
//    public void iPerformOperationWith(String method, String path, DataTable table) {
//        List<String> column = table.column(1);
//        System.out.println("column = " + column);
//        Map<String,String> body=new HashMap<>();
//        body.put("name",column.get(0));
//        body.put("job",column.get(1));
//        System.out.println("body = " + body);
//
//        RestTestBuilder testBuilder=new RestTestBuilder(path,method,null);
//        response=testBuilder.ExecuteWithBody(body);
//    }


    @Then("I should see the First_Name as {string}")
    public void iShouldSeeTheFirst_NameAs(String fname) {
        String name = response.getBody().jsonPath().get("name").toString();
        assertThat(name,is(fname));

    }

    @And("I should see the status_code as {int}")
    public void iShouldSeeTheStatus_codeAs(int statusCode) {
        assertThat(response.getStatusCode(),is(statusCode));
    }
}
