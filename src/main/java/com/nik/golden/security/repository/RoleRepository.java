package com.nik.golden.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nik.golden.security.models.Role;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByName(String name);
}
