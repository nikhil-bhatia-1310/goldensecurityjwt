package com.nik.golden.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nik.golden.security.models.UserEntity;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    Optional<UserEntity> findByUsername(String username);
    Boolean existsByUsername(String username);
}
