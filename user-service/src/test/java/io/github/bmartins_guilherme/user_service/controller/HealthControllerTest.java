package io.github.bmartins_guilherme.user_service.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.resttestclient.autoconfigure.AutoConfigureRestTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.client.EntityExchangeResult;
import org.springframework.test.web.servlet.client.RestTestClient;
import org.springframework.test.web.servlet.client.RestTestClient.ResponseSpec;

import io.github.bmartins_guilherme.user_service.dto.HealthResponse;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureRestTestClient
public class HealthControllerTest {
    private final String URI = "/api/v1/health";
    @Autowired
    private RestTestClient restTestclient;

    @Test
    void testGetHealth() throws Exception {
        HealthResponse expectedResponse = new HealthResponse();
        // Prepare Request
        ResponseSpec responseSpec = this.restTestclient.get().uri(URI).accept(MediaType.APPLICATION_JSON).exchange();
        // Assertions
        ParameterizedTypeReference<HealthResponse> typeReference = new ParameterizedTypeReference<HealthResponse> () {};
        EntityExchangeResult<HealthResponse> result = responseSpec.returnResult(typeReference);
        HttpStatusCode statusCode = result.getStatus();
        HealthResponse response = result.getResponseBody();
        Assertions.assertEquals(HttpStatusCode.valueOf(200), statusCode);
        Assertions.assertEquals(expectedResponse, response);
    }
}
