package rest_assured.restApiFramework;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

public class RestTestBuilder {

    private RequestSpecBuilder builder = new RequestSpecBuilder();
    private ApiMethods method;
    private String url;

    public RestTestBuilder(String uri, String method, String token) {
        this.url = "https://reqres.in/api" + uri;
        this.method = ApiMethods.valueOf(method);
        if (token!=null)
            builder.addHeader("Authorization", "Bearer " + token);
    }

    private ResponseOptions<Response> executeTest() {
        RequestSpecification requestSpecification = builder.build();
        RequestSpecification request = RestAssured.given();
        request.contentType(ContentType.JSON);
        request.spec(requestSpecification);
        switch (method){
            case GET:
                return request.get(this.url);
            case POST:
                return request.post(this.url);
            case PUT:
                return request.put(this.url);
            case DELETE:
                return request.delete(this.url);
        }
        return null;
    }

    public ResponseOptions<Response> executeJust(){
        return executeTest();
    }

    public String Authenticate(Object body) {
        builder.setBody(body);
        return executeTest().getBody().jsonPath().get("access_token");
    }

    public ResponseOptions<Response> ExecuteWithQueryParams(Map<String, String> queryPath) {
        builder.addQueryParams(queryPath);
        return executeTest();
    }

    public ResponseOptions<Response> ExecuteWithPathParams(Map<String, String> pathParams) {
        builder.addPathParams(pathParams);
        return executeTest();
    }

    public ResponseOptions<Response> ExecuteWithBody(Map<String, String> body) {
        builder.setBody(body);
        return executeTest();
    }

    public ResponseOptions<Response> ExecuteWithPathParamsAndBody(Map<String, String> pathParams, Map<String, String> body) {
        builder.setBody(body);
        builder.addPathParams(pathParams);
        return executeTest();
    }

}