package io.github.bmartins_guilherme.user_service.service;


import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import io.github.bmartins_guilherme.user_service.dto.CreateUserRequest;
import io.github.bmartins_guilherme.user_service.dto.CreateUserResponse;
import io.github.bmartins_guilherme.user_service.model.UserEntity;
import io.github.bmartins_guilherme.user_service.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    
    public CreateUserResponse create(CreateUserRequest request) {
        request.setPassword(passwordEncoder.encode(request.getPassword()));
        log.info("Preparing object to save in the database: {}", request);
        UserEntity entity = modelMapper.map(request, UserEntity.class);
        entity = userRepository.save(entity);
        CreateUserResponse response = modelMapper.map(entity, CreateUserResponse.class);
        log.info("Returning saved object: {}", response);
        return response;
    }
}
