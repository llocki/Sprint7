import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.After;

public class BaseCourierTest {
    String baseUrl = RestAssured.baseURI = "http://qa-scooter.praktikum-services.ru";

    @After
    public void delited() {

        CourierDTO courier = new CourierDTO("ninja249","1234");

        CourierClientLogin courierClientLogin = new CourierClientLogin();
        Response response = courierClientLogin.Login(courier);


        String responseString = response.body().asString();
        String id = responseString.substring(6, 12);


        CourierClientDelite courierClientDelite = new CourierClientDelite();
        Response response1 = courierClientDelite.Delited(responseString, id);

    }
}
