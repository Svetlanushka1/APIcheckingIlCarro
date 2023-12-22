package restassured;

import dto.AuthRequestDTO;
import helpers.RestAssuredHelper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.anything;

public class LoginAssuredTests extends helpers.RestAssuredHelper {
 /*   @Test
    public void loginPositiveStep1(){
        String loginBody = "{\n" +
                "   \"username\": \"abc@def.com\", \n" +
                "   \"password\": \"$Abcdef12345\" \n" +
                "}";
        String loginURI = "https://ilcarro-backend.herokuapp.com/v1/user/login/usernamepassword";

        RestAssured
                .given()
                    .log().all()
                .when()
                    .contentType(ContentType.JSON)
                    .body(loginBody)
                    .post(loginURI)
                .then()
                .log().ifStatusCodeIsEqualTo(200)
                .assertThat().body("token", anything());
    }
    @Test
    public void loginPositiveStep2(){
        String loginURI = "https://ilcarro-backend.herokuapp.com/v1/user/login/usernamepassword";
    AuthRequestDTO loginBody = AuthRequestDTO.builder()
            .username("haifa@gmail.com")
            .password("haifa082022$").build();


        RestAssured
                .given()
                .log().all()
                .when()
                .contentType(ContentType.JSON)
                .body(loginBody)
                .post(loginURI)
                .then()
                .log().ifStatusCodeIsEqualTo(200)
                .assertThat().body("token", anything());
    }*/
    @Test
    public void loginPositiveUsingHelper(){

        AuthRequestDTO loginBody = AuthRequestDTO.builder()
                .username("haifa@gmail.com")
                .password("Haifa082022$")
                .build();

        RestAssured
                .given()
                    .log().all()
                .when()
                    .contentType(ContentType.JSON)
                    .body(loginBody)
                    .post(BASE_URI + "/v1/user/login/usernamepassword")
                .then()
                    .log().ifStatusCodeIsEqualTo(200)
                .extract().response().jsonPath().getString("token");
                    //.assertThat().body("token", anything());
    }

}
