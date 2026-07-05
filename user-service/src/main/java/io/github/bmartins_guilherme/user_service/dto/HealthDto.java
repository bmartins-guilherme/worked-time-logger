package io.github.bmartins_guilherme.user_service.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Schema(description = "API Health")
public class HealthDto {
    @Schema(description = "Status of API health", example = "UP")
    private final String status = "UP";
}
