package restassured;

import org.testng.annotations.Test;

public class AuthTests extends BaseApiTest{
    @Test
    public void loginApiTest(){

    }
    @Test
    public void LoginApiTest(){
        softAssert.assertEquals(100,200);
        softAssert.assertEquals(userApi.getStatusCodeResponseLogin(user),200);
        softAssert.assertAll();
    }
}
