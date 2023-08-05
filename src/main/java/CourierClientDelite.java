import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class CourierClientDelite {
    String basePathDelited = "/api/v1/courier/{id}";


    @Step("Request to remove a client")
    public Response Delited (String responseString, String id) {

        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(responseString)
                .when()
                .delete(basePathDelited, id);

        return response;

    }

}
