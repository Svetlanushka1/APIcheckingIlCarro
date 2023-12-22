package restassured;

import dto.CarDTO;
import dto.CarListDTO;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetAllCarsTests extends helpers.RestAssuredHelper {
    /*
    "eyJhbGciOiJIUzI1NiJ9.eyJyb2xlcyI6WyJST0xFX1VTRVIiXSwic3ViIjoiaGFpZmFAZ21haWwuY29tIiwiaXNzIjoiUmVndWxhaXQiLCJleHAiOjE3MDM4NTg3MTUsImlhdCI6MTcwMzI1ODcxNX0.1L6IchjLwK_wMoN_OTOC3VHENX9VtYryPboRjvxokus";
     */
    String endPointGetCars = "/v1/cars/my";
  @Test
    public void getAllCars(){

    CarListDTO carsList =  RestAssured
                .given()
                    .log().all()
                .when()
                    .log().all()
                    .contentType(ContentType.JSON)
                    .header("Authorization", "Bearer: " + getToken())
                    .get(BASE_URI + endPointGetCars)
                .then()
                    .log().all()
                    .assertThat().statusCode(200)
                    .extract()
                    .as(CarListDTO.class);

      for(CarDTO car: carsList.getCarsList()){
          System.out.println(car.getSerialNumber());
          System.out.println(car.getCity());

      }
      Assert.assertFalse(carsList.toString().isEmpty());

    }
}
