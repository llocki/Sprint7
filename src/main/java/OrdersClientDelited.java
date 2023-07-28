import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class OrdersClientDelited {

    String BASE_PATH_DELITED = "/api/v1/orders/cancel?track=";
    public Response Delite (String responseString , String track) {

        Response response_1 = given()
                .header("Content-type", "application/json")
                .and()
                .body(responseString)
                .when()
                .put(BASE_PATH_DELITED + track);

        return response_1;
    }
}
