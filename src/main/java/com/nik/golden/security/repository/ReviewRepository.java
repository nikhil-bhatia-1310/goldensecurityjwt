package com.nik.golden.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nik.golden.security.models.Review;

import java.util.List;


public interface ReviewRepository extends JpaRepository<Review, Integer> {
    List<Review> findByPokemonId(int pokemonId);
}
