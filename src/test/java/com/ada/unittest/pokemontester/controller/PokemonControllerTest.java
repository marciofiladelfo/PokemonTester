package com.ada.unittest.pokemontester.controller;

import com.ada.unittest.pokemontester.model.Pokemon;
import com.ada.unittest.pokemontester.service.impl.PokemonServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Objects;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

class PokemonControllerTest {

    @Mock
    PokemonServiceImpl pokemonServiceImpl;
    @InjectMocks
    PokemonController pokemonController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetPokemonByName() {

        Pokemon pokemon = new Pokemon();
        pokemon.setId(1);
        pokemon.setName("Pikachu");

        when(pokemonServiceImpl.getPokemonByName(anyString())).thenReturn(pokemon);

        String result = Objects.requireNonNull(pokemonController.getPokemonByName("name").getBody()).getName();
        Assertions.assertEquals("Pikachu", result);
    }

}