package com.ada.unittest.pokemontester.service.impl;

import com.ada.unittest.pokemontester.model.Pokemon;
import com.ada.unittest.pokemontester.service.PokemonService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class PokemonServiceImpl implements PokemonService {
    private static final String BASE_URL = "https://pokeapi.co/api/v2/";

    private final RestTemplate restTemplate;

    @Override
    public Pokemon getPokemonByName(String name) {
        String url = BASE_URL + "pokemon/" + name;
        ResponseEntity<Pokemon> response = restTemplate.getForEntity(url, Pokemon.class);
        return response.getBody();
    }

}
