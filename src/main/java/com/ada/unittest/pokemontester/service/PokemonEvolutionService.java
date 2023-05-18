package com.ada.unittest.pokemontester.service;

import com.ada.unittest.pokemontester.model.evolution.PokemonEvolution;

public interface PokemonEvolutionService {
    PokemonEvolution getEvolutionLine(String name);
}
