package io.github.bmartins_guilherme.user_service.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.json.JsonCompareMode;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.json.JsonMapper;

import io.github.bmartins_guilherme.user_service.dto.HealthResponse;

@WebMvcTest(HealthController.class)
public class HealthControllerTest {
    private final String URI = "/api/v1/health";
    private JsonMapper jsonMapper = new JsonMapper();
    @Autowired
    private MockMvc mvc;

    @Test
    void testGetHealth() throws Exception {
        // Assertions
        final ResultMatcher statusCode = MockMvcResultMatchers.status().is(200);
        final String json = jsonMapper.writeValueAsString(new HealthResponse());
        final ResultMatcher content = MockMvcResultMatchers.content().json(json, JsonCompareMode.STRICT);
        // Request
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get(URI);
        requestBuilder.accept(MediaType.APPLICATION_JSON);
        mvc.perform(requestBuilder).andExpectAll(statusCode, content).andDo(MockMvcResultHandlers.print());
    }
}
