package io.github.bmartins_guilherme.user_service.swagger;

import org.springframework.http.ResponseEntity;

import io.github.bmartins_guilherme.user_service.dto.HealthDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Health", description = "Endpoint for checking API health")
public interface HealthSwagger {

    @Operation(summary = "Get the API health", description = "Endpoint for checking if service is up",
        responses = { @ApiResponse(responseCode = "200", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = HealthDto.class))})})
    ResponseEntity<HealthDto> getHealth();

    
}
