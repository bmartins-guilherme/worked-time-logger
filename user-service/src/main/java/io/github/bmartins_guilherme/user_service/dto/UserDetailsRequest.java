package io.github.bmartins_guilherme.user_service.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Schema(description = "Data Transfer Object used for requesting storage of details about the user", requiredMode = RequiredMode.REQUIRED)
public class UserDetailsRequest {
    @Schema(description = "Full legal name of the user", example = "Richard Smith White", requiredMode = RequiredMode.REQUIRED)
    @NotBlank(message = "This field is required.")
    private String name;
    @Schema(description = "Personal email of the user", example = "richard.s.white@gmail.com", requiredMode = RequiredMode.REQUIRED)
    @NotBlank(message = "This field is required.")
    @Email(message = "Invalid email format.", regexp = "[A-z0-9]+([_\\.][A-z0-9]+)*@[A-z0-9]+([_\\.][A-z0-9]+)+")
    private String email;
}