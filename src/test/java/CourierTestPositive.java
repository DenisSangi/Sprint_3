import courier.Courier;
import courier.CourierCredentials;
import courier.CourierClient;
import io.qameta.allure.junit4.DisplayName;
import io.qameta.allure.Description;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;


public class CourierTestPositive {

    private Courier courier = Courier.getRandom();

    private CourierClient courierClient;
    private int courierId;

    @Before
    public void setup() {
        courierClient = new CourierClient();
    }

    @After
    public void teardown(){
        courierClient.delete(courierId);
    }

    @Test
    @DisplayName("New courier creation test") // имя теста
    @Description("Base test of \"/courier\" endpoint. Checking code status and response's body after correct request were send")
    public void createCourierAndCheckResponse() {
        boolean created = courierClient.createCourier(courier);
        assertTrue(created);
        CourierCredentials creds = CourierCredentials.from(courier);
        courierId = courierClient.loginCourier(creds);
    }

    @Test
    @DisplayName("Courier successful login test") // имя теста
    @Description("Base test of \"/courier/login\" endpoint. Checking code status and response's body after courier's login")
    public void loginCourierCorrect() {
        boolean created = courierClient.createCourier(courier);
        assertTrue(created);
        CourierCredentials creds = CourierCredentials.from(courier);
        courierId = courierClient.loginCourier(creds);
        assertNotEquals(0, courierId);
    }
}
