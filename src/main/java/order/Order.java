package order;

import lombok.Data;
import org.apache.commons.lang3.RandomStringUtils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

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
    List<String> color;

    public Order(String firstName, String lastName, String address, String metroStation, String phone, int rentTime, String deliveryDate, String comment, List<String> color){
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

    public static Order getDefaultOrder() {
        String firstName = RandomStringUtils.randomAlphanumeric(10);
        String lastName = RandomStringUtils.randomAlphanumeric(10);
        String address = RandomStringUtils.randomAlphanumeric(10);
        String metroStation = RandomStringUtils.randomNumeric(2);
        String phone = RandomStringUtils.randomNumeric(11);
        int rentTime = Integer.parseInt(RandomStringUtils.randomNumeric(1));
        String deliveryDate = getDate();
        String comment = RandomStringUtils.randomAlphanumeric(10);
        List <String> color = List.of("BLACK");

        return new Order(firstName, lastName, address, metroStation, phone, rentTime, deliveryDate, comment, color);
    }

    public static String getDate(){
        LocalDate baseDate = LocalDate.now();
        int maximumRandomValue = 10;
        int randomDays = (int)(maximumRandomValue*Math.random());
        LocalDate randomDate = baseDate.plusDays(randomDays);
        return DateTimeFormatter.ofPattern("yyyy-MM-dd").format(randomDate);
    }

    public Order setColor(List<String> color){
        this.color = color;
        return new Order(firstName, lastName, address, metroStation, phone, rentTime, deliveryDate, comment, color);
    }
}


