import courier.Courier;
import courier.CourierCredentials;
import courier.CourierClient;
import io.qameta.allure.junit4.DisplayName;
import io.qameta.allure.Description;
import org.junit.Before;
import org.junit.Test;


public class CourierTestNegativeChecks {

    private Courier courier = Courier.getRandom();
    private Courier courierWithoutLogin = Courier.noLogin();
    private Courier courierWithoutPassword = Courier.noPassword();
    private Courier courierWithWrongLogin = Courier.wrongLogin();
    private Courier courierWithWrongPassword = Courier.wrongPassword();

    private CourierClient courierClient;

    @Before
    public void setup(){
        courierClient = new CourierClient();
    }

    @Test
    @DisplayName("Existed courier creation test") // имя теста
    @Description("Negative test of \"/courier\" endpoint. Checking code status and response's body after request with existed courier's data were send")
    public void createExistedCourierAndCheckResponse() {
        courierClient.createCourier(courier);
        CourierCredentials creds = CourierCredentials.from(courier);
        courierClient.createExistedCourier(creds);
    }

    @Test
    @DisplayName("Courier without login creation test") // имя теста
    @Description("Negative test of \"/courier\" endpoint. Checking code status and response's body after no-login request were send")
    public void createCourierWithoutLoginAndCheckResponse() {
        courierClient.createCourierWithoutLogin(courierWithoutLogin);
    }

    @Test
    @DisplayName("Courier without password creation test") // имя теста
    @Description("Negative test of \"/courier\" endpoint. Checking code status and response's body after no-password request were send")
    public void createCourierWithoutPasswordAndCheckResponse() {
        courierClient.createCourierWithoutPassword(courierWithoutPassword);
    }

    @Test
    @DisplayName("Courier without login test") // имя теста
    @Description("Negative test of \"/courier/login\" endpoint. Checking code status and response's body when login = null")
    public void loginCourierWithoutLogin() {
        CourierCredentials creds = CourierCredentials.from(courierWithoutLogin);
        courierClient.noLoginCourier(creds);
    }

    @Test
    @DisplayName("Courier without password test") // имя теста
    @Description("Negative test of \"/courier/login\" endpoint. Checking code status and response's body when password = null")
    public void loginCourierWithoutPassword() {
        CourierCredentials creds = CourierCredentials.from(courierWithoutPassword);
        courierClient.noPasswordCourier(creds);
    }

    @Test
    @DisplayName("Courier with wrong login test") // имя теста
    @Description("Negative test of \"/courier/login\" endpoint. Checking code status and response's body when login is incorrect")
    public void loginCourierWithWrongLogin() {
        CourierCredentials creds = CourierCredentials.from(courierWithWrongLogin);
        courierClient.incorrectLoginCourier(creds);
    }

    @Test
    @DisplayName("Courier with wrong password test") // имя теста
    @Description("Negative test of \"/courier/login\" endpoint. Checking code status and response's body when password password is incorrect")
    public void loginCourierWithWrongPassword() {
        CourierCredentials creds = CourierCredentials.from(courierWithWrongPassword);
        courierClient.incorrectPasswordCourier(creds);
    }
}
