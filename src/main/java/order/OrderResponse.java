package order;


import lombok.Data;

@Data
public class OrderResponse {

    String firstName;
    String lastName;
    String address;
    String metroStation;
    String phone;
    int rentTime;
    String deliveryDate;
    String comment;
    String[] color;
}
