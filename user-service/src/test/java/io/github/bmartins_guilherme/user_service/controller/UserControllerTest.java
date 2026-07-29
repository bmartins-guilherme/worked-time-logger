package io.github.bmartins_guilherme.user_service.controller;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.resttestclient.autoconfigure.AutoConfigureRestTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.client.EntityExchangeResult;
import org.springframework.test.web.servlet.client.RestTestClient;
import org.springframework.test.web.servlet.client.RestTestClient.ResponseSpec;

import com.fasterxml.jackson.databind.json.JsonMapper;

import io.github.bmartins_guilherme.user_service.dto.CreateUserRequest;
import io.github.bmartins_guilherme.user_service.dto.CreateUserResponse;
import io.github.bmartins_guilherme.user_service.dto.UserDetailsRequest;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureRestTestClient
public class UserControllerTest {
    private static String BASE_URI = "/api/v1/users";
    private final JsonMapper jsonMapper = new JsonMapper();
    @Autowired
    private RestTestClient restTestClient;

    @Test
    void createUser_WhenFieldsAreNull_ReturnBadRequest() throws Exception {
        // Expectations
        Map<String, String> expected = new HashMap<>();
        expected.put("username", "This field is required.");
        expected.put("password", "This field is required.");
        expected.put("userDetails.email", "This field is required.");
        expected.put("userDetails.name", "This field is required.");
        // Prepare request
        UserDetailsRequest detailsRequest = new UserDetailsRequest(null, null);
        CreateUserRequest userRequest = new CreateUserRequest(null, null, detailsRequest);
        String payload = jsonMapper.writeValueAsString(userRequest);
        // Request
        ResponseSpec responseSpec = restTestClient.post().uri(BASE_URI).contentType(MediaType.APPLICATION_JSON).body(payload).exchange();
        ParameterizedTypeReference<Map<String, String>> typeReference = new ParameterizedTypeReference<Map<String, String>> () {};
        EntityExchangeResult<Map<String, String>> result = responseSpec.returnResult(typeReference);
        // Assertions
        Assertions.assertEquals(HttpStatus.BAD_REQUEST, result.getStatus());
        Assertions.assertEquals(expected, result.getResponseBody());
    }
}
