import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import order.Order;
import order.OrderClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

import static org.junit.Assert.*;


@RunWith(Parameterized.class)
public class createOrderTest {

    private Order defaultOrder = Order.getDefaultOrder();
    private List<String> color;
    int expectedCode;
    private OrderClient orderClient = new OrderClient();

    public createOrderTest(List<String> color, int expectedCode) {
        this.color = color;
        this.expectedCode = expectedCode;
    }

    @Parameterized.Parameters
    public static Object[][] createOrderWithColor() {
        return new Object[][]{
                {List.of("BLACK"), 201},
                {List.of("GREY"), 201},
                {List.of("BLACK", "GREY"), 201},
                {null, 201},
        };
    }

    @Test
    @DisplayName("Create Order with different colors")
    @Description("Base test of \"/order\" endpoint. Checking code status and response's body")
    public void createColoredOrder() {
        Order order = defaultOrder.setColor(color);
        int actualCode = orderClient.createOrder(order);
        assertEquals(expectedCode, actualCode);
    }
}