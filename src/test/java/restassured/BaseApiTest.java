package restassured;

import api.CarsAPI;
import api.UserApi;
import dto.UserDTO;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;

public class BaseApiTest {

    String token ="";//!= null
    UserApi userApi = new UserApi();
    CarsAPI carsApi = new CarsAPI();
    SoftAssert softAssert = new SoftAssert();

    UserDTO userDto = UserDTO.builder()
            .username("haifa@gmail.com")
            .password("Haifa082022$")
            .build();

    @BeforeSuite(alwaysRun = true)
    public void getToken(){
        token = UserApi.getToken();
        System.out.println("token: " + token);
    }

}
