import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class CourierClientLogin {
    String basePathLogin = "/api/v1/courier/login";

    @Step("Request for client login in the system")
    public Response Login (CourierDTO courier) {

        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(courier)
                .when()
                .post(basePathLogin);

        return response;
    }

}
