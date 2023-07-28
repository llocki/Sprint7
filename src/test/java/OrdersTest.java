import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.Matchers.equalTo;


@RunWith(Parameterized.class)
public class OrdersTest extends BaseCourierTest{

    private final String firstName;
    private final String lastName;
    private final String address;
    private final int metroStation;
    private final String phone;
    private final int rentTime;
    private final String deliveryDate;
    private final String comment;
    private final String[] color;


    public OrdersTest(String firstName, String lastName, String address, int metroStation, String phone, int rentTime, String deliveryDate, String comment, String[] color) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.metroStation = metroStation;
        this.phone = phone;
        this.rentTime = rentTime;
        this.deliveryDate = deliveryDate;
        this.comment = comment;
        this.color= color;
    }


    @Parameterized.Parameters
    public static Object[][] getCredentials() {
        OrdersDTO orders = new OrdersDTO();

        String[] arr = {"BLACK"};
        String[] arr1 = {"GREY"};
        String[] arr2 = {"BLACK","GREY"};
        String[] arr3 = {""};

        return new Object[][]{
                {"Naruto", "Uchiha", "Konoha, 142 apt.", 4 ,"+7 800 355 35 35", 5, "2020-06-06", "Saske, come back to Konoha", arr},
                {"Vova", "Ivanov", "Moskow, 115 apt.", 3 ,"+7 832 444 78 25", 3, "2020-07-07", "Saske, come back to Konoha", arr1},
                {"Bob", "Petrov", "Ryazan, 25 apt.", 1 ,"+7 874 362 88 46", 4, "2020-02-03", "Saske, come back to Konoha", arr2},
                {"Nick", "Gromov", "Moskow, 5 apt.", 2 ,"+7 866 486 58 45", 4, "2020-08-08", "Saske, come back to Konoha", arr3},
        };
    }

    @Test
    @DisplayName("Create an order")
    public void orderCreation(){

        OrdersDTO orders = new OrdersDTO(firstName, lastName, address, metroStation, phone, rentTime, deliveryDate, comment, color);
//---------------------------------------------------------------------------------------------------------------------------------
        //Создание заказа
        OrdersClientCreating ordersClient = new OrdersClientCreating();
        Response response =  ordersClient.Creating(orders);

        response.then().assertThat().statusCode(201)
                .and()
                .assertThat().body("track", notNullValue());

        String responseString = response.body().asString();
        String track = responseString.substring(9, 15);

//------------------------------------------------------------------------------
        //Удаление заказа

        OrdersClientDelited ordersClientDelited = new OrdersClientDelited();
        Response response_1 = ordersClientDelited.Delite(responseString ,track);

        response_1.then().assertThat().statusCode(200)
                .and()
                .assertThat().body("ok", equalTo(true));

    }
}