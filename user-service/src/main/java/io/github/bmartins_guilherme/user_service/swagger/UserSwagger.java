package io.github.bmartins_guilherme.user_service.swagger;

import org.springframework.http.ResponseEntity;

import io.github.bmartins_guilherme.user_service.dto.UserRequest;
import io.github.bmartins_guilherme.user_service.dto.UserResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "User", description = "Endpoints for users manage their own data")
public interface UserSwagger {
    @Operation(summary = "Create User", description = "Endpoint to register a new user in the system", method = "GET",
    responses = { @ApiResponse(responseCode = "201", content = {@Content(schema = @Schema(implementation = UserResponse.class))})}
    )
    ResponseEntity<UserResponse> create(@RequestBody UserRequest request);
}
