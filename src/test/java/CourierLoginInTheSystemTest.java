import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.Matchers.equalTo;


public class CourierLoginInTheSystemTest extends BaseCourierCreatingTest {

    @Test
    @DisplayName("Login")
    public void login() {//Вход в систему

        CourierDTO courier = new CourierDTO("ninja249","1234");

        CourierClientLogin courierClientLogin = new CourierClientLogin();
        Response response = courierClientLogin.Login(courier);

        response.then().assertThat().statusCode(200)
                .and()
                .assertThat().body("id", notNullValue());
    }


    @Test
    @DisplayName("Error in the login or password field")
    public void loginOrPasswordError() {// Ошибка в поле логина или пароля

        CourierDTO courier = new CourierDTO("ninj249","1234");

        CourierClientLogin courierClientLogin = new CourierClientLogin();
        Response response = courierClientLogin.Login(courier);

        response.then().assertThat().statusCode(404)
                .and()
                .assertThat().body("message", equalTo("Учетная запись не найдена"));

    }


    @Test
    @DisplayName("Missing password")
    public void missingField() {//Отсутствует пароль

        CourierDTO courier = new CourierDTO("ninja249","");

        CourierClientLogin courierClientLogin = new CourierClientLogin();
        Response response = courierClientLogin.Login(courier);

        response.then().assertThat().statusCode(400)
                .and()
                .assertThat().body("message", equalTo("Недостаточно данных для входа"));
    }

    @Test
    @DisplayName("Non-existent user or password")
    public void nonExistentUsernameOrPassword() {//Не существующий пользователь или пароль

        CourierDTO courier = new CourierDTO("ninj9","123");

        CourierClientLogin courierClientLogin = new CourierClientLogin();
        Response response = courierClientLogin.Login(courier);

        response.then().assertThat().statusCode(404)
                .and()
                .assertThat().body("message", equalTo("Учетная запись не найдена"));
    }
}