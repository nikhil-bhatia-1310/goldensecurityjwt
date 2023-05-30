package com.nik.golden.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nik.golden.security.models.Pokemon;

import java.util.Optional;

public interface PokemonRepository extends JpaRepository<Pokemon, Integer> {
    Optional<Pokemon> findByType(String type);
}
