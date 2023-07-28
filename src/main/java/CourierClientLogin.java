import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class CourierClientLogin {
    String BASE_PATH_LOGIN = "/api/v1/courier/login";

    public Response Login (CourierDTO courier) {

        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(courier)
                .when()
                .post(BASE_PATH_LOGIN);

        return response;
    }

}
