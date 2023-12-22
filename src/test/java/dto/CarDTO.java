package dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@Builder
@ToString
public class CarDTO {
    /*
    CarDto{
serialNumber*	string
manufacture*	string
model*	string
year*	string
fuel*	string
seats*	integer($int32)
carClass*	string
pricePerDay*	number($double)
about	string
city*	string
lat	number($double)
lng	number($double)
image	string
owner	string
bookedPeriods	[...]
}
     */
    String serialNumber;
    String manufacture;
    String model;
    int year;
    String fuel;
    int seats;
    String carClass;
    double pricePerDay;
    String about;
    String city;
}
