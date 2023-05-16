package com.ada.unittest.pokemontester.service;

import com.ada.unittest.pokemontester.model.Form;
import com.ada.unittest.pokemontester.model.Pokemon;

public interface PokemonService {
    Pokemon getPokemonByName(String name);
    Form getPokemonEvolution(String name);

}
