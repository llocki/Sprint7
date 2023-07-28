import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class GetOrders {
    String BASE_PATH_ORDERS_GET = "/api/v1/orders";
    public Response ordersGet () {
        Response response = given()
                .header("Content-type", "application/json")
                .when()
                .get(BASE_PATH_ORDERS_GET);

        return response;
    }

}
