package courier;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class CourierClient extends RestAssuredClient{

    private final String ROOT = "/courier";
    private final String LOGIN = ROOT + "/login";
    private final String COURIER = ROOT + "/{courierId}";


    public boolean createCourier(Courier courier) {
        return requestSpecification
                .body(courier)
                .when()
                .post(ROOT)
                .then().log().all()
                .assertThat()
                .statusCode(201)
                .extract()
                .path("ok");
    }

    public void createExistedCourier(CourierCredentials creds) {
        Response response = given()
                .baseUri(URL)
                .header("Content-type", "application/json")
                .and()
                .body(creds)
                .when()
                .post(ROOT);
                response.then().log().all()
                .assertThat()
                        .statusCode(409)
                        .and()
                        .body("message", equalTo("Этот логин уже используется. Попробуйте другой."));
    }

    public void createCourierWithoutLogin(Courier courier) {
        Response response = given()
                .baseUri(URL)
                .header("Content-type", "application/json")
                .and()
                .body(courier)
                .when()
                .post(ROOT);
        response.then().log().all()
                .assertThat()
                .statusCode(400)
                .and()
                .body("message", equalTo("Недостаточно данных для создания учетной записи"));
    }

    public void createCourierWithoutPassword(Courier courier) {
        Response response = given()
                .baseUri(URL)
                .header("Content-type", "application/json")
                .and()
                .body(courier)
                .when()
                .post(ROOT);
        response.then().log().all()
                .assertThat()
                .statusCode(400)
                .and()
                .body("message", equalTo("Недостаточно данных для создания учетной записи"));
    }

    public int loginCourier(CourierCredentials creds){
        return requestSpecification
                .body(creds)
                .when()
                .post(LOGIN)
                .then().log().all()
                .assertThat()
                .statusCode(200)
                .extract()
                .path("id");
    }

    public void noLoginCourier(CourierCredentials creds){
        Response response = given().log().all()
                .baseUri(URL)
                .header("Content-type", "application/json")
                .and()
                .body(creds)
                .when()
                .post(LOGIN);
        response.then().log().all()
                .assertThat()
                .statusCode(400)
                .and()
                .body("message", equalTo("Недостаточно данных для входа"));
    }

    public void noPasswordCourier(CourierCredentials creds){
        Response response = given().log().all()
                .baseUri(URL)
                .header("Content-type", "application/json")
                .and()
                .body(creds)
                .when()
                .post(LOGIN);
        response.then().log().all()
                .assertThat()
                .statusCode(400)
                .and()
                .body("message", equalTo("Недостаточно данных для входа"));
    }

    public void incorrectLoginCourier(CourierCredentials creds){
        Response response = given()
                .baseUri(URL)
                .header("Content-type", "application/json")
                .and()
                .body(creds)
                .when()
                .post(LOGIN);
        response.then().log().all()
                .assertThat()
                .statusCode(404)
                .and()
                .body("message", equalTo("Учетная запись не найдена"));
    }

    public void incorrectPasswordCourier(CourierCredentials creds){
        Response response = given()
                .baseUri(URL)
                .header("Content-type", "application/json")
                .and()
                .body(creds)
                .when()
                .post(LOGIN);
        response.then().log().all()
                .assertThat()
                .statusCode(404)
                .and()
                .body("message", equalTo("Учетная запись не найдена"));
    }

    public void delete(int courierId){
        requestSpecification.pathParam("courierId", courierId)
                .when()
                .delete(COURIER)
                .then().log().all()
                .assertThat()
                .statusCode(200);
    }
}
