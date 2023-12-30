package restassured;

import api.CarsAPI;
import api.UserAPI;
import dto.UserDTO;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;
import data.RandomUtils;;

public class BaseApiTest {
    public String BASE_URI = "https://ilcarro-backend.herokuapp.com";
    String token ="";//!= null
    UserAPI userApi = new UserAPI();
    CarsAPI carsApi = new CarsAPI();
    SoftAssert softAssert = new SoftAssert();
    RandomUtils randomUtils = new RandomUtils();

    UserDTO user = UserDTO.builder()
            .username("haifa@gmail.com")
            .password("Haifa082022$")
            .build();
    //TODO take user's data from scv file

    @BeforeSuite(alwaysRun = true)
    public void getToken(){
        token = userApi.getToken(user);
        System.out.println("token: " + token);
    }

}
