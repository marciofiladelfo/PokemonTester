package com.ada.unittest.pokemontester.model;

import com.ada.unittest.pokemontester.model.*;
import com.ada.unittest.pokemontester.model.battle.PokemonBattleRequest;
import com.ada.unittest.pokemontester.model.battle.PokemonBattleResponse;
import com.ada.unittest.pokemontester.model.battle.PokemonResponseDto;
import com.ada.unittest.pokemontester.model.battle.PokemonStatDto;
import com.ada.unittest.pokemontester.model.evolution.PokemonEvolution;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ModelTest {

    @InjectMocks private Pokemon pokemon;
    @InjectMocks private Species species;
    @InjectMocks private Stats stats;
    @InjectMocks private Stat stat;
    @InjectMocks private Types types;
    @InjectMocks private Type type;
    @InjectMocks private PokemonEvolution evolution;
    @InjectMocks private PokemonBattleRequest request;
    @InjectMocks private PokemonBattleResponse response;
    @InjectMocks private PokemonResponseDto responseDto;
    @InjectMocks private PokemonStatDto statDto;

    @Test
    void testPokemon() {
        pokemon.setId(1);
        pokemon.getId();
        pokemon.setName("Pikachu");
        pokemon.getName();
        pokemon.setHeight(1);
        pokemon.getHeight();
        pokemon.setWeight(1);
        pokemon.getWeight();
        pokemon.setLocationAreaEncounters(List.of("Test"));
        pokemon.getLocationAreaEncounters();
        pokemon.setSpecies(species);
        pokemon.getSpecies();
        pokemon.getWeight();
        pokemon.setStats(null);
        pokemon.getStats();
        pokemon.setTypes(null);
        pokemon.getTypes();
    }

    @Test
    void testSpecies() {
        species.setName("Charmander");
        species.getName();
        species.setUrl("https://test.com.br");
        species.getUrl();
    }

    @Test
    void testStats() {
        stats.setBaseStat(1);
        stats.getBaseStat();
        stats.setStat(stat);
        stats.getStat();
    }

    @Test
    void testStat() {
        stat.setName("Charmander");
        stat.setUrl("https://Test.com.br");
        stat.getName();
        stat.getUrl();
    }

    @Test
    void testTypes() {
        types.setType(type);
        types.getType();
    }

    @Test
    void testType() {
        type.setName("Ratata");
        type.getName();
    }

    @Test
    void testEvolution() {
        evolution.setForms(List.of("Pichu", "raichu"));
        evolution.getForms();
    }

    @Test
    void testPokemonBattleRequest() {
        request.setChallenged("pikachu");
        request.getChallenged();
        request.setChallenger("charmander");
        request.getChallenger();
    }

    @Test
    void testPokemonBattleResponse() {
        response.setWinner("pikachu");
        response.getWinner();
    }

    @Test
    void testPokemonResponseDto() {
        responseDto.setStats(List.of(new PokemonStatDto(1)));
        responseDto.getStats();
    }

    @Test
    void testPokemonStatDto() {
        statDto.setBaseStat(1);
        statDto.getBaseStat();
    }
}
