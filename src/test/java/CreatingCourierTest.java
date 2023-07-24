import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.Matchers.equalTo;
import static io.restassured.RestAssured.given;

public class CreatingCourierTest {

    @Before
    public void setUp() {
        RestAssured.baseURI = "http://qa-scooter.praktikum-services.ru";
    }
//-----------------------------------------------------------------------------------------------------

    @Test
    @DisplayName("Creating a courier")
    public void CreatingCourier(){

        Courier courier = new Courier("ninja27","1234", "saske");

        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(courier)
                .when()
                .post("/api/v1/courier");

        response.then().assertThat().statusCode(201)
                .and()
                .assertThat().body("ok", equalTo(true));

    }

    @Test
    @DisplayName("two identical couriers")
    public void TwoIdenticalCouriers(){
        Courier courier = new Courier("ninja27","1234", "saske");

        Response response1 = given()
                .header("Content-type", "application/json")
                .and()
                .body(courier)
                .when()
                .post("/api/v1/courier");

        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(courier)
                .when()
                .post("/api/v1/courier");

        response.then().assertThat().statusCode(409)
                .and()
                .assertThat().body("message", equalTo("Этот логин уже используется. Попробуйте другой."));

    }

    @Test
    @DisplayName("Required fields")
    public void RequiredFields(){
        Courier courier = new Courier("ninja27");

        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(courier)
                .when()
                .post("/api/v1/courier");

        response.then().assertThat().statusCode(400)
                .and()
                .assertThat().body("message", equalTo("Недостаточно данных для создания учетной записи"));

    }
//------------------------------------------------------------------------------------------------------------------------

    @After
    public void delited() {

        Courier courier = new Courier("ninja27","1234");
        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(courier)
                .when()
                .post("/api/v1/courier/login");

        String responseString = response.body().asString();
        String id = responseString.substring(6, 12);

        given()
                .header("Content-type", "application/json")
                .and()
                .body(responseString)
                .when()
                .delete("/api/v1/courier/{id}", id);

    }

}
