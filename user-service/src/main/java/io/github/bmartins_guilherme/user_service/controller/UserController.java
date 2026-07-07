package io.github.bmartins_guilherme.user_service.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import io.github.bmartins_guilherme.user_service.dto.UserRequest;
import io.github.bmartins_guilherme.user_service.dto.UserResponse;
import io.github.bmartins_guilherme.user_service.swagger.UserSwagger;


@Controller
@RequestMapping("/api/v1/users")
public class UserController implements UserSwagger{
    @Override
    @PostMapping
    public ResponseEntity<UserResponse> create(@RequestBody UserRequest request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }
}
