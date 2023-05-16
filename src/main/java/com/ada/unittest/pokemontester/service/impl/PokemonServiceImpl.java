package com.ada.unittest.pokemontester.service.impl;

import com.ada.unittest.pokemontester.model.Form;
import com.ada.unittest.pokemontester.model.Pokemon;
import com.ada.unittest.pokemontester.model.UrlEvolutionLine;
import com.ada.unittest.pokemontester.service.PokemonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
public class PokemonServiceImpl implements PokemonService {
    private static final String BASE_URL = "https://pokeapi.co/api/v2/";

    private final RestTemplate restTemplate;

    @Override
    public Pokemon getPokemonByName(String name) {
        String url = BASE_URL + "/pokemon/" + name;
        ResponseEntity<Pokemon> response = restTemplate.getForEntity(url, Pokemon.class);
        return response.getBody();
    }

    @Override
    public Form getPokemonEvolution(String name) {
        Pokemon pokemon = this.getPokemonByName(name);
        UrlEvolutionLine urlEvolutionChain = this.getEvolutionChain(pokemon.getId());
        String url = urlEvolutionChain.getEvolutionChain().getUrl();
        String path = url.substring(42 , url.length() - 1);
        Form form = this.getEvolutionLine(Integer.parseInt(path));
        return form;
    }

    private UrlEvolutionLine getEvolutionChain(int name) {
        final String URI = "pokemon-species/";

        UrlEvolutionLine urlEvolutionLine = new UrlEvolutionLine();

        urlEvolutionLine =  WebClient
                .create(BASE_URL)
                .get()
                .uri(URI + "/{id}", name)
                .retrieve()
                .bodyToMono(UrlEvolutionLine.class).block();

        return urlEvolutionLine;
    }

    private Form getEvolutionLine(int path) {
        final String URI = "evolution-chain/";

        Form form = WebClient
                .create(BASE_URL)
                .get()
                .uri(URI + "{id}", path)
                .retrieve()
                .bodyToMono(Form.class).block();
        return form;

    }

}
