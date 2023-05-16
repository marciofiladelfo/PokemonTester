package com.ada.unittest.pokemontester.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ModelTest {

    @InjectMocks
    private Pokemon pokemon;
    @InjectMocks
    private Species species;
    @InjectMocks
    private Stats stats;
    @InjectMocks
    private Stat stat;
    @InjectMocks
    private Types types;
    @InjectMocks
    private Type type;
    @InjectMocks
    private Form form;
    @InjectMocks
    private Chain chain;
    @InjectMocks
    private Evolution evolution;
    @InjectMocks
    private PokemonEvolution pokemonEvolution;
    @InjectMocks
    private UrlEvolutionLine evolutionLine;
    @InjectMocks
    private UrlEvolutionChain evolutionChain;

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
    void testPokemonEvolution() {
        pokemonEvolution.setForms(List.of(form));
        pokemonEvolution.getForms();
    }

    @Test
    void testForm() {
        form.setChain(chain);
        form.getChain();
    }

    @Test
    void testChain() {
        chain.setEvolvesTo(List.of(evolution));
        chain.getEvolvesTo();
        chain.setSpecies(species);
        chain.getSpecies();
    }

    @Test
    void testEvolution() {
        evolution.setEvolvesTo(List.of(evolution));
        evolution.setSpecies(species);
        evolution.getEvolvesTo();
        evolution.getSpecies();
    }

    @Test
    void testUrlEvolutionChain() {
        evolutionChain.setUrl("https://test.com.br");
        evolutionChain.getUrl();
    }
    @Test
    void testUrlEvolutionLine() {
        evolutionLine.setEvolutionChain(evolutionChain);
        evolutionLine.getEvolutionChain();
    }
}
