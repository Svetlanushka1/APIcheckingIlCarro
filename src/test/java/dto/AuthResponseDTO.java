package dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@Builder
@ToString
public class AuthResponseDTO {
    /*
    TokenDto{
accessToken	string
}
     */
    String accessToken;
}
