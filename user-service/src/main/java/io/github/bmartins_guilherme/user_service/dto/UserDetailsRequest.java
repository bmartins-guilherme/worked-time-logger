package io.github.bmartins_guilherme.user_service.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import lombok.Data;

@Data
@Schema(description = "Data Transfer Object used for requesting storage of details about the user", requiredMode = RequiredMode.REQUIRED)
public class UserDetailsRequest {
    @Schema(description = "Full legal name of the user", example = "Richard Smith White", requiredMode = RequiredMode.REQUIRED)
    private String name;
    @Schema(description = "Personal email of the user", example = "richard.s.white@gmail.com", requiredMode = RequiredMode.REQUIRED)
    private String email;
}
