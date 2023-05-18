package com.ada.unittest.pokemontester.service;

import com.ada.unittest.pokemontester.model.battle.PokemonBattleRequest;
import com.ada.unittest.pokemontester.model.battle.PokemonBattleResponse;

public interface PokemonBattleService {
    PokemonBattleResponse getComparisonPokemon(PokemonBattleRequest request);
}