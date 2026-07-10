package io.github.bmartins_guilherme.user_service.service;


import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import io.github.bmartins_guilherme.user_service.dto.UserRequest;
import io.github.bmartins_guilherme.user_service.dto.UserResponse;
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
    
    public UserResponse create(UserRequest request) {
        request.setPassword(passwordEncoder.encode(request.getPassword()));
        log.info("Preparing object to save in the database: {}", request);
        UserEntity entity = modelMapper.map(request, UserEntity.class);
        entity = userRepository.save(entity);
        UserResponse response = modelMapper.map(entity, UserResponse.class);
        log.info("Returning saved object: {}", response);
        return response;
    }
}
