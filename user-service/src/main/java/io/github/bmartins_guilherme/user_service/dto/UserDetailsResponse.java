package io.github.bmartins_guilherme.user_service.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Data Transfer Object used for returning stored details about the user")
public class UserDetailsResponse {
    @Schema(description = "A unique identifier for the user details", example = "1")
    private Integer id;
    @Schema(description = "Full legal name of the user", example = "Richard Smith White")
    private String name;
    @Schema(description = "Personal email of the user", example = "richard.s.white@gmail.com")
    private String email;
}
