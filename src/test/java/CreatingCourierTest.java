import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.Test;
import static org.hamcrest.Matchers.equalTo;

public class CreatingCourierTest extends BaseCourierTest {


    @Test
    @DisplayName("Creating a courier")
    public void CreatingCourier(){

        CourierDTO courier = new CourierDTO("ninja249","1234", "saske");


        CourierClientCreating courierCreating = new CourierClientCreating();
        Response response = courierCreating.Creating(courier);


        response.then().assertThat().statusCode(201)
                .and()
                .assertThat().body("ok", equalTo(true));

    }


    @Test
    @DisplayName("two identical couriers")
    public void TwoIdenticalCouriers(){

        CourierDTO courier = new CourierDTO("ninja249","1234", "saske");

        CourierClientCreating courierCreating = new CourierClientCreating();
        Response response = courierCreating.Creating(courier);

        CourierClientCreating courierCreating_1 = new CourierClientCreating();
        Response response_1 = courierCreating.Creating(courier);

        response_1.then().assertThat().statusCode(409)
                .and()
                .assertThat().body("message", equalTo("Этот логин уже используется. Попробуйте другой."));
    }


    @Test
    @DisplayName("Required fields")
    public void RequiredFields(){

        CourierDTO courier = new CourierDTO("ninja249");

        CourierClientCreating courierCreating = new CourierClientCreating();
        Response response = courierCreating.Creating(courier);

        response.then().assertThat().statusCode(400)
                .and()
                .assertThat().body("message", equalTo("Недостаточно данных для создания учетной записи"));
    }
}
