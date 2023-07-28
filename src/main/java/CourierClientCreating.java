import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class CourierClientCreating {
    String BASE_PATH_CREATING = "/api/v1/courier";

    public Response Creating (CourierDTO courier){
        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(courier)
                .when()
                .post(BASE_PATH_CREATING);
        return response;
    }}
