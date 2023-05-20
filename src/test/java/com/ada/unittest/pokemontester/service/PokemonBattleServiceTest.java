package com.ada.unittest.pokemontester.service;

import com.ada.unittest.pokemontester.model.Pokemon;
import com.ada.unittest.pokemontester.model.Stat;
import com.ada.unittest.pokemontester.model.Stats;
import com.ada.unittest.pokemontester.model.battle.PokemonBattleResponse;
import com.ada.unittest.pokemontester.service.impl.PokemonBattleServiceImpl;
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

import java.util.List;

public class PokemonBattleServiceTest {

    @Mock
    private RestTemplate template;

    @InjectMocks
    private PokemonBattleServiceImpl service;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testPokemonBattleService() {
        Stat stat = new Stat();
        stat.setName("hp");

        Stats stats = new Stats();
        stats.setBaseStat(309);
        stats.setEffort(1);
        stats.setStat(stat);

        PokemonBattleResponse response = new PokemonBattleResponse();
        response.setStats(List.of(stats));

        Mockito.when(template.getForObject("https://pokeapi.co/api/v2/pokemon/charmander" , PokemonBattleResponse.class)).thenReturn(null);
        int expectedResponse = service.getComparisonPokemon("charmander");

        Assertions.assertEquals(expectedResponse, response.getStats().get(0).getBaseStat());
    }

}
