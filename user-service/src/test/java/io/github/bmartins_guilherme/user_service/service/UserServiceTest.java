package io.github.bmartins_guilherme.user_service.service;

import static org.mockito.ArgumentMatchers.any;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import io.github.bmartins_guilherme.user_service.dto.UserDetailsRequest;
import io.github.bmartins_guilherme.user_service.dto.UserDetailsResponse;
import io.github.bmartins_guilherme.user_service.dto.CreateUserRequest;
import io.github.bmartins_guilherme.user_service.dto.CreateUserResponse;
import io.github.bmartins_guilherme.user_service.model.UserDetailsEntity;
import io.github.bmartins_guilherme.user_service.model.UserEntity;
import io.github.bmartins_guilherme.user_service.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@SpringBootTest
@RequiredArgsConstructor
public class UserServiceTest {
    private final ModelMapper mapper = new ModelMapper();
    @Autowired
    private UserService service;
    @MockitoBean
    private UserRepository userRepository;

    @Test
    void testCreateUser() {
        // Preparing testing
        UserDetailsRequest userDetailsRequest = new UserDetailsRequest("Richard Smith White", "richard.s.white@gmail.com");
        CreateUserRequest request = new CreateUserRequest("richard.s.white", "#r1Chard", userDetailsRequest);
        // Expected result
        UserDetailsResponse expectedDetailsResponse = new UserDetailsResponse(
            1, "Richard Smith White", "richard.s.white@gmail.com");
        CreateUserResponse expected = new CreateUserResponse(
            1, "richard.s.white", "$2a$10$6ZAWpaz3UbSyeajrR3mYceEiiWwvBKYFoSdTao44pZ9ubqtK1l0ae", expectedDetailsResponse);
        // Mocking return
        UserDetailsEntity userDetailsEntity = new UserDetailsEntity(1, "Richard Smith White", "richard.s.white@gmail.com");
        UserEntity entity = new UserEntity(1, userDetailsEntity, "richard.s.white", expected.getPassword());
        Mockito.when(userRepository.save(any(UserEntity.class))).thenReturn(entity);
        // Exectuing method
        CreateUserResponse actual = service.create(request);
        // Assertion
        Assertions.assertEquals(expected, actual);
    }
}
