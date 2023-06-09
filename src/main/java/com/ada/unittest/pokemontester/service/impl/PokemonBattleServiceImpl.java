package com.ada.unittest.pokemontester.service.impl;

import com.ada.unittest.pokemontester.model.Pokemon;
import com.ada.unittest.pokemontester.model.Stats;
import com.ada.unittest.pokemontester.model.battle.PokemonBattleResponse;
import com.ada.unittest.pokemontester.service.PokemonBattleService;
import com.ada.unittest.pokemontester.service.PokemonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class PokemonBattleServiceImpl implements PokemonBattleService {

    private static final String BASE_URL = "https://pokeapi.co/api/v2/pokemon";

    @Override
    public int getComparisonPokemon(String pokemonName) {
        String apiUrl = BASE_URL + "/" + pokemonName;
        RestTemplate restTemplate = new RestTemplate();
        PokemonBattleResponse pokemonResponse = restTemplate.getForObject(apiUrl, PokemonBattleResponse.class);

        if (pokemonResponse != null) {
            return pokemonResponse.getStats().stream()
                    .mapToInt(Stats::getBaseStat)
                    .sum();
        }

        return 0;
    }


}
