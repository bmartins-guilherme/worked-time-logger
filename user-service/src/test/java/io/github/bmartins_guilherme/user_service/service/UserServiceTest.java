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
import io.github.bmartins_guilherme.user_service.dto.UserRequest;
import io.github.bmartins_guilherme.user_service.dto.UserResponse;
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
        UserRequest request = new UserRequest("richard.s.white", "#r1Chard", userDetailsRequest);
        // Expected result
        UserResponse expected = mapper.map(request, UserResponse.class);
        expected.setId(1);
        expected.getUserDetails().setId(1);
        expected.setPassword("$2a$10$6ZAWpaz3UbSyeajrR3mYceEiiWwvBKYFoSdTao44pZ9ubqtK1l0ae");
        // Mocking return
        UserDetailsEntity userDetailsEntity = new UserDetailsEntity(1, "Richard Smith White", "richard.s.white@gmail.com");
        UserEntity entity = new UserEntity(1, userDetailsEntity, "richard.s.white", expected.getPassword());
        Mockito.when(userRepository.save(any(UserEntity.class))).thenReturn(entity);
        // Exectuing method
        UserResponse actual = service.create(request);
        // Assertion
        Assertions.assertEquals(expected, actual);
    }
}
