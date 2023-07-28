import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class OrdersClientCreating {
    String BASE_PATH_ORDERS_CREATING = "/api/v1/orders";
    public Response Creating (OrdersDTO order) {

        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(order)
                .when()
                .post(BASE_PATH_ORDERS_CREATING);

        return response;
    }
}
