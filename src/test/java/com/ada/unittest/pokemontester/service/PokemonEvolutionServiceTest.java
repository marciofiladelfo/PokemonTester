package com.ada.unittest.pokemontester.service;

import com.ada.unittest.pokemontester.model.evolution.PokemonEvolution;
import com.ada.unittest.pokemontester.service.impl.PokemonEvolutionServiceImpl;
import com.ada.unittest.pokemontester.service.impl.PokemonServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class PokemonEvolutionServiceTest {

    @InjectMocks
    private PokemonEvolutionServiceImpl service;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testPokemonEvolutionTest() {
        PokemonEvolution pokemonEvolution = service.getEvolutionLine("pikachu");

        Assertions.assertEquals(List.of("pichu", "pikachu", "raichu"), pokemonEvolution.getForms());
    }

}
