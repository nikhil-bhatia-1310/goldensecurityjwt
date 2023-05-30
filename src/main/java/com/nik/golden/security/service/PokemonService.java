package com.nik.golden.security.service;

import java.util.List;

import com.nik.golden.security.dto.PokemonDto;
import com.nik.golden.security.dto.PokemonResponse;

public interface PokemonService {
    PokemonDto createPokemon(PokemonDto pokemonDto);
    PokemonResponse getAllPokemon(int pageNo, int pageSize);
    PokemonDto getPokemonById(int id);
    PokemonDto updatePokemon(PokemonDto pokemonDto, int id);
    void deletePokemonId(int id);
}
