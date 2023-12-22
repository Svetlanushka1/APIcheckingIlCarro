package helpers;

import dto.AuthRequestDTO;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class RestAssuredHelper {
    public String BASE_URI = "https://ilcarro-backend.herokuapp.com";
    String apiLoginURI = "/v1/user/login/usernamepassword";
    public String authHeader = "Authorizations";
    String endPointCarAdd = "/v1/cars";
    String endPointCarEdit = "/v1/cars/edit";
    String endPointCarSearch = "/v1/cars/search";
   // String endPointGetCars = "/v1/cars/my";
    String endPointCarBooking = "/v1/cars/{serialNumber}/booking";
    public String getToken() {
/*
AuthenticationBodyDto{
username*	string
password*	string
pattern: ^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@$#^&*!])(?=.*[a-zA-Z]).{8,}$
}
 */
        AuthRequestDTO loginBody = AuthRequestDTO.builder()
                .username("haifa@gmail.com")
                .password("Haifa082022$").build();

    String token = RestAssured
            .given()
                 .log().all()
            .when()
                    .contentType(ContentType.JSON)
                    .body(loginBody)
                    .post(BASE_URI + apiLoginURI)
            .then()
                    .log().all()
                    .statusCode(200)
                    .extract().response().jsonPath().getString("token");
        System.out.println("token: " + token);
        return token;
    }
}
