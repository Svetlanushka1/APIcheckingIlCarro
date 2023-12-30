package restassured;


import dto.AddNewCarDTO;
import org.testng.annotations.Test;

public class AddNewCarTests extends BaseApiTest{
  @Test
    public void addNewCarPositive() {
      String serNumber = randomUtils.generateDigitsString(12);
      AddNewCarDTO addNewCar = AddNewCarDTO.builder()
              .serialNumber(serNumber)
              .manufacture("qa40")
              .model("corsa")
              .year(1990)
              .fuel("Petrol")
              .seats(2)
              .carClass("ads")
              .pricePerDay(9)
              .about("fff")
              .city("Tel Aviv")
              .build();
      softAssert.assertEquals(carsApi.getStatusCodeResponseAddNewCar(addNewCar, token), 200);
      softAssert.assertEquals(carsApi.getMessageResponseAddNewCar(addNewCar, token),
              "Car added successfully");
      softAssert.assertAll();


     /*   RestAssured
                .given()
                .log().all()
                .when()
                .log().all()
                .contentType(ContentType.JSON)
                .header("", "Bearer" + getToken())
                .body(car)
                .post(baseURI + apiAddCarURI)
                .then()
                .log().all()
                .satatusCode(200)
                .assertThat().body("message",startsWith("message",startsWith("message"));
        ;

    }*/
  }

}
