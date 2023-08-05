import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class CourierClientCreating {
    String basePathCreating = "/api/v1/courier";

    @Step("Request to create a courier")
    public Response Creating (CourierDTO courier){
        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(courier)
                .when()
                .post(basePathCreating);
        return response;
}
}
