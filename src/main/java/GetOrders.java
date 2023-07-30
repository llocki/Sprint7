import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class GetOrders {
    String basePathOrdersGet = "/api/v1/orders";
    @Step("Query returning a list of clients")
    public Response ordersGet () {
        Response response = given()
                .header("Content-type", "application/json")
                .when()
                .get(basePathOrdersGet);

        return response;
    }

}
