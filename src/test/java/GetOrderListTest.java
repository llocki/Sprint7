import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.notNullValue;

public class GetOrderListTest extends BaseOrderTest{


    @Test
    @DisplayName("Order list")
    public void orderList(){

        GetOrders getOrders = new GetOrders();
        Response response = getOrders.ordersGet();

        response.then()
                .assertThat().body("orders", notNullValue());
    }
}
