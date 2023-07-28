import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class CourierClientDelite {
    String BASE_PATH_DELITED = "/api/v1/courier/{id}";

    public Response Delited (String responseString, String id) {

        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(responseString)
                .when()
                .delete(BASE_PATH_DELITED, id);

        return response;

    }
}
