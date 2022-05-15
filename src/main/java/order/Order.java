package order;

import lombok.Data;
import org.apache.commons.lang3.RandomStringUtils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

@Data
public class Order {

    String firstName;
    String lastName;
    String address;
    String metroStation;
    String phone;
    int rentTime;
    String deliveryDate;
    String comment;
    String[] color;

    public Order(String firstName, String lastName, String address, String metroStation, String phone, int rentTime, String deliveryDate, String comment, String[] color){
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.metroStation = metroStation;
        this.phone = phone;
        this.rentTime = rentTime;
        this.deliveryDate = deliveryDate;
        this.comment = comment;
        this.color = color;
    }

    public static Order CreateOrderWithBlackColor() {
        String firstName = RandomStringUtils.randomAlphanumeric(10);
        String lastName = RandomStringUtils.randomAlphanumeric(10);
        String address = RandomStringUtils.randomAlphanumeric(10);
        String metroStation = RandomStringUtils.randomNumeric(2);
        String phone = RandomStringUtils.randomNumeric(11);
        int rentTime = Integer.parseInt(RandomStringUtils.randomNumeric(1));
        String deliveryDate = getDate();
        String comment = RandomStringUtils.randomAlphanumeric(10);
        String [] color = getColor(new String[]{"BLACK"});

        return new Order(firstName, lastName, address, metroStation, phone, rentTime, deliveryDate, comment, color);
    }

    public static Order CreateOrderWithGreyColor() {
        String firstName = RandomStringUtils.randomAlphanumeric(10);
        String lastName = RandomStringUtils.randomAlphanumeric(10);
        String address = RandomStringUtils.randomAlphanumeric(10);
        String metroStation = RandomStringUtils.randomNumeric(2);
        String phone = RandomStringUtils.randomNumeric(11);
        int rentTime = Integer.parseInt(RandomStringUtils.randomNumeric(1));
        String deliveryDate = getDate();
        String comment = RandomStringUtils.randomAlphanumeric(10);
        String [] color = getColor(new String[]{"GREY"});

        return new Order(firstName, lastName, address, metroStation, phone, rentTime, deliveryDate, comment, color);
    }

    public static Order CreateOrderWithBothColors() {
        String firstName = RandomStringUtils.randomAlphanumeric(10);
        String lastName = RandomStringUtils.randomAlphanumeric(10);
        String address = RandomStringUtils.randomAlphanumeric(10);
        String metroStation = RandomStringUtils.randomNumeric(2);
        String phone = RandomStringUtils.randomNumeric(11);
        int rentTime = Integer.parseInt(RandomStringUtils.randomNumeric(1));
        String deliveryDate = getDate();
        String comment = RandomStringUtils.randomAlphanumeric(10);
        String [] color = {"BLACK", "GREY"};

        return new Order(firstName, lastName, address, metroStation, phone, rentTime, deliveryDate, comment, color);
    }

    public static Order CreateOrderWithoutColor() {
        String firstName = RandomStringUtils.randomAlphanumeric(10);
        String lastName = RandomStringUtils.randomAlphanumeric(10);
        String address = RandomStringUtils.randomAlphanumeric(10);
        String metroStation = RandomStringUtils.randomNumeric(2);
        String phone = RandomStringUtils.randomNumeric(11);
        int rentTime = Integer.parseInt(RandomStringUtils.randomNumeric(1));
        String deliveryDate = getDate();
        String comment = RandomStringUtils.randomAlphanumeric(10);
        String [] color = null;

        return new Order(firstName, lastName, address, metroStation, phone, rentTime, deliveryDate, comment, color);
    }

    public static String getDate(){
        LocalDate baseDate = LocalDate.now();
        Integer maximumRandomValue = 10;
        Integer randomDays = (int)(maximumRandomValue*Math.random());
        LocalDate randomDate = baseDate.plusDays(randomDays);
        String dateAsString = DateTimeFormatter.ofPattern("yyyy-MM-dd").format(randomDate);
        return dateAsString;
    }

    public static String[] getColor(String[] colors){
        String randomColor = colors[new Random().nextInt(colors.length)];
        return new String[]{(randomColor)};
    }
}


