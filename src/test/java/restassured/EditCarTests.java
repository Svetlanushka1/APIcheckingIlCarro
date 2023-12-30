package restassured;

import dto.CarDTO;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

import static org.hamcrest.Matchers.*;

public class EditCarTests extends helpers.RestAssuredHelper{
    Random random = new Random();
    int i = random.nextInt(10);
    CarDTO carDTO;
    String endPointCarEdit = "/v1/cars/edit";
    String serialNumber = "";
    @BeforeMethod
    public void precondition(){
        CarDTO car = CarDTO.builder()
                .serialNumber("")
                .city("")
                .model("")
                .manufacture("")
                .pricePerDay(Double.parseDouble(""))
                .build();
    }
   @Test
    public void addNewCarPositive() {



        RestAssured
                .given()
                .log().all()
                .when()
                .log().all()
                .contentType(ContentType.JSON)
                .header("", "Bearer" + getToken())
                .body(carDTO)
                .put(BASE_URI + endPointCarEdit)
                .then()
                .log().all()
                .statusCode(200)
                .assertThat().body("message",emptyString());
        ;

    }
}
