import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.Matchers.equalTo;


public class CourierLoginInTheSystemTest {

    @Before
    public void setUp() {
        RestAssured.baseURI = "http://qa-scooter.praktikum-services.ru";


        Courier courier = new Courier("ninja27", "1234", "saske");

        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(courier)
                .when()
                .post("/api/v1/courier");
    }


    @Test
    @DisplayName("Login")
    public void login(){//Вход в систему
        Courier courier = new Courier("ninja27","1234");

        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(courier)
                .when()
                .post("/api/v1/courier/login");

        response.then().assertThat().statusCode(200)
                .and()
                .assertThat().body("id", notNullValue());
    }

    @Test
    @DisplayName("Error in the login or password field")
    public void loginOrPasswordError(){// Ошибка в поле логина или пароля
        Courier courier = new Courier("ninj27","1234");

        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(courier)
                .when()
                .post("/api/v1/courier/login");

        response.then().assertThat().statusCode(404)
                .and()
                .assertThat().body("message", equalTo("Учетная запись не найдена"));
    }

    @Test
    @DisplayName("Missing password")
    public void missingField(){//Отсутствует пароль
        Courier courier = new Courier("ninja27", "");

        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(courier)
                .when()
                .post("/api/v1/courier/login");

        response.then().assertThat().statusCode(400)
                .and()
                .assertThat().body("message", equalTo("Недостаточно данных для входа"));
    }

    @Test
    @DisplayName("Non-existent user or password")
    public void nonExistentUsernameOrPassword(){//Не существующий пользователь или пароль
        Courier courier = new Courier("ninja","123");

        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(courier)
                .when()
                .post("/api/v1/courier/login");

        response.then().assertThat().statusCode(404)
                .and()
                .assertThat().body("message", equalTo("Учетная запись не найдена"));
    }

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