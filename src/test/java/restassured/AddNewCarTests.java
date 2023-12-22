package restassured;

import dto.CarDTO;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.startsWith;

public class AddNewCarTests extends helpers.RestAssuredHelper {
  /*  @Test
    public void addNewCarPositive() {
        CarDTO car = CarDTO.builder()
                .serialNumber("")
                .city("")
                .model("")
                .manufacture("")
                .pricePerDay(Double.parseDouble(""))
                .build();


        RestAssured
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
