package courier;

import lombok.Data;
import org.apache.commons.lang3.RandomStringUtils;

@Data
public class Courier {

    String login;
    String password;
    String name;

    public Courier(String login, String password, String name) {
        this.login = login;
        this.password = password;
        this.name = name;
    }

    public static Courier getRandom() {
        String login = RandomStringUtils.randomAlphanumeric(10);
        String password = RandomStringUtils.randomAlphanumeric(10);
        String name = RandomStringUtils.randomAlphanumeric(10);

        return new Courier(login, password, name);
    }

    public static Courier noLogin() {
        String password = RandomStringUtils.randomAlphanumeric(10);
        String name = RandomStringUtils.randomAlphanumeric(10);

        return new Courier(null, password, name);
    }

    public static Courier noPassword() {
        String login = RandomStringUtils.randomAlphanumeric(10);
        String name = RandomStringUtils.randomAlphanumeric(10);

        return new Courier(login, null, name);
    }

    public static Courier wrongLogin() {
        String login = "WrongLoginCourier";
        String password = RandomStringUtils.randomAlphanumeric(10);
        String name = RandomStringUtils.randomAlphanumeric(10);

        return new Courier(login, password, name);
    }

    public static Courier wrongPassword() {
        String login = RandomStringUtils.randomAlphanumeric(10);
        String password = "WrongPasswordCourier";
        String name = RandomStringUtils.randomAlphanumeric(10);

        return new Courier(login, password, name);
    }
}
