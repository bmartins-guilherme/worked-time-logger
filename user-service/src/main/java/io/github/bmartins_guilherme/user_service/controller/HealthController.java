package io.github.bmartins_guilherme.user_service.controller;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import io.github.bmartins_guilherme.user_service.dto.HealthResponse;
import io.github.bmartins_guilherme.user_service.swagger.HealthSwagger;

@Controller
@RequestMapping("/api/v1/health")
public class HealthController implements HealthSwagger {
    @Override
    @GetMapping
    public ResponseEntity<HealthResponse> getHealth() {
        return new ResponseEntity<HealthResponse>(new HealthResponse(), HttpStatusCode.valueOf(200));
    }
}
