import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class OrdersClientCreating {
    String basePathOrdersCreating = "/api/v1/orders";
    @Step("Request to create an order")
    public Response Creating (OrdersDTO order) {

        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(order)
                .when()
                .post(basePathOrdersCreating);

        return response;
    }
}
