package dto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@Builder
@ToString
public class UserDTO {
    String username;
    String password;
    String firstName;
    String lastName;
}
