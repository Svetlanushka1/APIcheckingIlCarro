package restassured;

import api.CarsAPI;
import api.UserAPI;
import dto.UserDTO;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;
import data.RandomUtils;
import property.ConfigProperties;;

public class BaseApiTest {
    public String BASE_URI = "https://ilcarro-backend.herokuapp.com";
    public String apiLoginURI = "/v1/user/login/usernamepassword";
    public String authHeader = "Authorizations";
    public String endPointCarAdd = "/v1/cars";
    public String endPointCarEdit = "/v1/cars/edit";
    public String endPointCarSearch = "/v1/cars/search";
    public String endPointGetCars = "/v1/cars/my";
    public String endPointCarBooking = "/v1/cars/{serialNumber}/booking";
    String token ="";//!= null
    UserAPI userApi = new UserAPI();
    CarsAPI carsApi = new CarsAPI();
    SoftAssert softAssert = new SoftAssert();
    RandomUtils randomUtils = new RandomUtils();

    UserDTO user = UserDTO.builder()
            .username(ConfigProperties.getProperty("username"))
            .password(ConfigProperties.getProperty("password"))
            .build();
    //TODO take user's data from scv file

    @BeforeSuite(alwaysRun = true)
    public void getToken(){
        token = userApi.getToken(user);
        System.out.println("token: " + token);
    }

}

