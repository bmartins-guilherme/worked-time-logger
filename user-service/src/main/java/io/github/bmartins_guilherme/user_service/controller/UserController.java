package io.github.bmartins_guilherme.user_service.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.bmartins_guilherme.user_service.dto.CreateUserRequest;
import io.github.bmartins_guilherme.user_service.dto.CreateUserResponse;
import io.github.bmartins_guilherme.user_service.swagger.UserSwagger;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/v1/users")
public class UserController implements UserSwagger{
    
    @Override
    @PostMapping
    public ResponseEntity<CreateUserResponse> create(@Valid @RequestBody CreateUserRequest request) {
        // TODO Auto-generated method stub
        return ResponseEntity.ok(new CreateUserResponse());
    }
}
