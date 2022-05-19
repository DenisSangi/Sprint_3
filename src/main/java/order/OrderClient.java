package order;

import courier.RestAssuredClient;

public class OrderClient extends RestAssuredClient {
    private final String ROOT = "/orders";

    public int createOrder(Order order){
        return requestSpecification.log().all()
                .body(order)
                .when()
                .post(ROOT)
                .then().log().all()
                .assertThat()
                .statusCode(201)
                .extract()
                .statusCode();
    }

    public OrderResponse getOrder(){
        return requestSpecification.log().all()
                .when()
                .get(ROOT)
                .then().log().all()
                .assertThat()
                .statusCode(200)
                .extract()
                .body()
                .as(OrderResponse.class);
    }

}
