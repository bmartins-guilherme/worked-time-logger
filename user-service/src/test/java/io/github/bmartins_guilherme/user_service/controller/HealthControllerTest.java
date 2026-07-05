package io.github.bmartins_guilherme.user_service.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.json.JsonCompareMode;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import io.github.bmartins_guilherme.user_service.dto.HealthDto;
import tools.jackson.databind.json.JsonMapper;

@WebMvcTest(HealthController.class)
public class HealthControllerTest {
    private final String BASE_URI = "/api/v1/health";
    private JsonMapper mapper = new JsonMapper();
    @Autowired
    private MockMvc mockMvc;
    
    @Test
    void testGetHealth() throws Exception {
        ResultMatcher statusCode = MockMvcResultMatchers.status().isOk();
        final String json = mapper.writeValueAsString(new HealthDto());
        ResultMatcher content = MockMvcResultMatchers.content().json(json, JsonCompareMode.STRICT);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get(BASE_URI);
        requestBuilder.contentType(MediaType.APPLICATION_JSON);
        mockMvc.perform(requestBuilder).andExpectAll(statusCode, content).andDo(MockMvcResultHandlers.print());
    }
}
