package com.ada.unittest.pokemontester.service;

import com.ada.unittest.pokemontester.model.Pokemon;
import com.ada.unittest.pokemontester.service.impl.PokemonServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class PokemonServiceTest {

    @Mock
    private RestTemplate template;

    @InjectMocks
    private PokemonServiceImpl service;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testPokemonService() {
        Pokemon pokemon = new Pokemon();
        pokemon.setName("pikachu");

        Mockito.when(
                template.getForEntity("https://pokeapi.co/api/v2/pokemon/" + pokemon.getName(), Pokemon.class))
                .thenReturn(new ResponseEntity<>(pokemon, HttpStatus.OK)
                );

        Pokemon expectedResponse = service.getPokemonByName("pikachu");

        Assertions.assertEquals(pokemon.getName(), expectedResponse.getName());

    }

}
