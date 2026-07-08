package io.github.bmartins_guilherme.user_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.bmartins_guilherme.user_service.model.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

}
