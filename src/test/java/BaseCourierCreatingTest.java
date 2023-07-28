import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Before;

public class BaseCourierCreatingTest extends BaseCourierTest {
    @Before
    public void setUp() {
        String BASE_URL = RestAssured.baseURI = "http://qa-scooter.praktikum-services.ru";

        CourierDTO courier = new CourierDTO("ninja249","1234","saske");

        CourierClientCreating courierCreating = new CourierClientCreating();
        Response response = courierCreating.Creating(courier);

    }
}
