import io.qameta.allure.Step;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class OrdersClientDelited {

    String basePathOrdersDelited = "/api/v1/orders/cancel?track=";
    @Step("Request to delete an order")
    public Response Delite (String responseString , String track) {

        Response response_1 = given()
                .header("Content-type", "application/json")
                .and()
                .body(responseString)
                .when()
                .put(basePathOrdersDelited + track);

        return response_1;
    }
}
