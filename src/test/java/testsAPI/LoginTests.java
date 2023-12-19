package testsAPI;

import com.google.gson.Gson;
import data.DataProviderLogin;
import dto.AuthRequestDTO;
import dto.AuthResponseDTO;
import dto.ErrorDTO;
import okhttp3.*;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTests {

    @Test

    public void loginPositive() throws IOException {

        Gson gson = new Gson();
        OkHttpClient client = new OkHttpClient();
        final MediaType JSON = MediaType.get("application/json; charset=utf-8");

        //1 create the request
        AuthRequestDTO authRequestDTO = AuthRequestDTO.builder()
                .username("haifa@gmail.com")
                .password("Haifa082022$")
                .build();
        //2 send this request to the server
        RequestBody requestBody = RequestBody.create(gson.toJson(authRequestDTO), JSON);

        Request request = new Request.Builder()
                .url("https://ilcarro-backend.herokuapp.com/v1/user/login/usernamepassword")
                .post(requestBody)
                .build();

        // 3 get the response
        Response response = client.newCall(request).execute();
        //4 convert the received response to JavaFormat
        if (response.isSuccessful()) {
            AuthResponseDTO authResponseDTO = gson.fromJson(response.body().string(), AuthResponseDTO.class);
            String token = authResponseDTO.getAccessToken();
            System.out.println("Token: " + token);
            System.out.println(response.code());
            Assert.assertEquals(response.code(), 200);
        } else {
            ErrorDTO errorDTO = gson.fromJson(response.body().string(), ErrorDTO.class);
            Assert.assertEquals(response.code(), 401);
            Assert.assertEquals(response.message(), "Login or Password incorrect");


        }


    }

    /* @Test

      public void loginPropertiesPositive() throws IOException {

          Gson gson = new Gson();
          OkHttpClient client = new OkHttpClient();
          final MediaType JSON =MediaType.get("application/json; charset=utf-8");


          //1 create the request
          AuthRequestDTO authRequestDTO = AuthRequestDTO.builder()
                  .username("haifa@gmail.com")
                  .password("Haifa082022$")
                  .build();
          //2 send this request to the server
          RequestBody requestBody = RequestBody.create(gson.toJson(authRequestDTO), JSON);

          Request request = new Request.Builder()
                  .url("src/test/resources/datalogin.csv")
                  .post(requestBody)
                  .build();

          // 3 get the response
          Response response = client.newCall(request).execute();
          //4 convert the received response to JavaFormat
          if (response.isSuccessful()) {
              AuthResponseDTO authResponseDTO = gson.fromJson(response.body().string(), AuthResponseDTO.class);
              String token = authResponseDTO.getAccessToken();
              System.out.println("Token: " + token);
              System.out.println(response.code());
              Assert.assertEquals(response.code(),200);
          }else{
              ErrorDTO errorDTO = gson.fromJson(response.body().string(), ErrorDTO.class);
              Assert.assertEquals(response.code(),401);
              Assert.assertEquals(response.message(), "Login or Password incorrect");


          }


      }*/
    @Test(groups = {"smoke"}, dataProvider = "loginCSV",dataProviderClass = DataProviderLogin.class)
    public void loginCSVPositive(AuthRequestDTO authRequestDTO) throws IOException {

        Gson gson = new Gson();
        OkHttpClient client = new OkHttpClient();
        final MediaType JSON = MediaType.get("application/json; charset=utf-8");

        // take the data from SCV file
        //2 send this request to the server
        RequestBody requestBody = RequestBody.create(gson.toJson(authRequestDTO), JSON);

        Request request = new Request.Builder()
                .url("https://ilcarro-backend.herokuapp.com/v1/user/login/usernamepassword")
                .post(requestBody)
                .build();

        // 3 get the response
        Response response = client.newCall(request).execute();
        //4 convert the received response to JavaFormat
        if (response.isSuccessful()) {
            AuthResponseDTO authResponseDTO = gson.fromJson(response.body().string(), AuthResponseDTO.class);
            String token = authResponseDTO.getAccessToken();
            System.out.println("Token: " + token);
            System.out.println(response.code());
            Assert.assertEquals(response.code(), 200);
        } else {
            ErrorDTO errorDTO = gson.fromJson(response.body().string(), ErrorDTO.class);
            Assert.assertEquals(response.code(), 401);
            Assert.assertEquals(response.message(), "Login or Password incorrect");


        }

    }
    @Test(groups = {"smoke"}, dataProvider = "loginCSV_negative()",dataProviderClass = DataProviderLogin.class)
    public void loginCSV_negative(AuthRequestDTO authRequestDTO) throws IOException {

        Gson gson = new Gson();
        OkHttpClient client = new OkHttpClient();
        final MediaType JSON = MediaType.get("application/json; charset=utf-8");

        // take the data from SCV file
        //2 send this request to the server
        RequestBody requestBody = RequestBody.create(gson.toJson(authRequestDTO), JSON);

        Request request = new Request.Builder()
                .url("https://ilcarro-backend.herokuapp.com/v1/user/login/usernamepassword")
                .post(requestBody)
                .build();

        // 3 get the response
        Response response = client.newCall(request).execute();
        //4 convert the received response to JavaFormat
        if (response.isSuccessful()) {
            AuthResponseDTO authResponseDTO = gson.fromJson(response.body().string(), AuthResponseDTO.class);
            String token = authResponseDTO.getAccessToken();
            System.out.println("Token: " + token);
            System.out.println(response.code());
            Assert.assertEquals(response.code(), 200);
        } else {
            ErrorDTO errorDTO = gson.fromJson(response.body().string(), ErrorDTO.class);
            Assert.assertEquals(response.code(), 401);
            Assert.assertEquals(response.message(), "Login or Password incorrect");


        }

    }

}
