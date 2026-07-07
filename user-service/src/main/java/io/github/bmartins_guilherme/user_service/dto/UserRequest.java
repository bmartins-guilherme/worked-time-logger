package io.github.bmartins_guilherme.user_service.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Data Transfer Object used for creating a user")
public class UserRequest {
    @Schema(description = "A unique name used to identify the user", example = "richard.s.white")
    private String username;
    @Schema(description = "A sequence of minimum 8 characters that contains number, lowercase, uppercase and special characters", example = "#r1Chard")
    private String password;
    private UserDetailsRequest userDetails;
}
