package io.github.bmartins_guilherme.user_service.dto;

import java.io.Serializable;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
@Schema(description = "API Health")
public class HealthResponse implements Serializable {
    @Schema(description = "Status of API health", example = "UP")
    private final String status = "UP";
}
