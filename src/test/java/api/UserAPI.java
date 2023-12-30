package api;

import dto.AuthResponseDTO;
import dto.UserDTO;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserAPI extends BaseAPI{

    Response responseLogin = null;

    private Response getResponseLogin(UserDTO user) {
        responseLogin = given()
                .body(user)
                .when()
                .post(baseUrl + "/v1/user/login/usernamepassword")
                .thenReturn();
        return responseLogin;
    }

    public String getToken(UserDTO user) {
        if(responseLogin == null) {
            getResponseLogin(user);
        }
        return responseLogin.getBody().as(AuthResponseDTO.class).getAccessToken();
    }

    public int getStatusCodeResponseLogin(UserDTO user) {
        if(responseLogin == null) {
            getResponseLogin(user);
        }
        return responseLogin.getStatusCode();
    }

    public void setResponseLoginNull() {
        responseLogin = null;
    }

//    public String getToken(UserDTO user) {
//        responseLogin = given()
//                .body(user)
//                .when()
//                .post(baseUrl + "/v1/user/login/usernamepassword")
//                .thenReturn();
//        return responseLogin.getBody().as(AuthDTO.class).getAccessToken();
//    }
}