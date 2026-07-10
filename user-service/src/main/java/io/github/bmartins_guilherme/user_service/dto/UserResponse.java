package io.github.bmartins_guilherme.user_service.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Data Transfer Object used for returning the stored user data")
public class UserResponse {
    @Schema(description = "A unique identifier of the user", example = "1")
    private Integer id;
    @Schema(description = "A unique name used to identify the user", example = "richard.s.white")
    private String username;
    @Schema(description = "A sequence of minimum 8 characters that contains number, lowercase, uppercase and special characters", example = "#r1Chard")
    private String password;
    private UserDetailsResponse userDetails;    
}
