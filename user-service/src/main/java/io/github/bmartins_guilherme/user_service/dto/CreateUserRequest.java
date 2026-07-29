package io.github.bmartins_guilherme.user_service.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Schema(name = "User Request", description = "Data Transfer Object used for creating a user")
public class CreateUserRequest {
    @Schema(description = "A unique name used to identify the user", example = "richard.s.white", requiredMode = RequiredMode.REQUIRED)
    @NotBlank(message = "This field is required.")
    private String username;
    @Schema(description = "A sequence of minimum 8 characters that contains number, lowercase, uppercase and special characters", example = "#r1Chard",
     requiredMode = RequiredMode.REQUIRED)
    @NotBlank(message = "This field is required.")
    private String password;
    @Valid
    private UserDetailsRequest userDetails;
}
