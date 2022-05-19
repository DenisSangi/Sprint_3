import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import order.OrderClient;
import order.OrderResponse;
import org.junit.Test;

import static org.junit.Assert.*;


public class getOrderBodyTest {

    private OrderClient orderClient = new OrderClient();

    @Test
    @DisplayName("Get order's list")
    @Description("Base test of \"/order\" endpoint. Checking code status and response's body")
    public void getOrderBody(){
        OrderResponse orderResponse = orderClient.getOrder();
        assertNotNull(orderResponse);
        //System.out.println(orderResponse);
    }
}