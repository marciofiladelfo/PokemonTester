package com.ada.unittest.pokemontester.service.impl;

import com.ada.unittest.pokemontester.exception.PokemonNotFoundException;
import com.ada.unittest.pokemontester.model.battle.PokemonBattleRequest;
import com.ada.unittest.pokemontester.model.battle.PokemonBattleResponse;
import com.ada.unittest.pokemontester.model.battle.PokemonResponseDto;
import com.ada.unittest.pokemontester.service.PokemonBattleService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class PokemonBattleServiceImpl implements PokemonBattleService {

    @Override
    public PokemonBattleResponse getComparisonPokemon(PokemonBattleRequest request) {
        String challenger = request.getChallenger();
        String challenged = request.getChallenged();

        // Mapa com os atributos dos Pokémon
        Map<String, Map<String, Integer>> attributes = new HashMap<>();
        try {
            attributes.put(challenged, createAttributes());
            attributes.put(challenger, createAttributes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Obter os atributos do Pokémon desafiador e do Pokémon desafiado
        Map<String, Integer> challengerAttributes = attributes.get(challenger);
        Map<String, Integer> challengedAttributes = attributes.get(challenged);

        if (challengerAttributes != null && challengedAttributes != null) {
            // Calcular o total de atributos de cada Pokémon
            int challengerTotal = calculateTotal(challengerAttributes);
            int challengedTotal = calculateTotal(challengedAttributes);

            // Determinar o vencedor
            String winner;
            if (challengerTotal > challengedTotal) {
                winner = challenger;
            } else if (challengerTotal < challengedTotal) {
                winner = challenged;
            } else {
                winner = "DRAW";
            }

            return new PokemonBattleResponse(winner);
        } else {
            throw new PokemonNotFoundException();
        }
    }

    private Map<String, Integer> createAttributes() throws IOException {
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet("https://pokeapi.co/api/v2/pokemon/charmander");

        HttpResponse response = httpClient.execute(request);
        String jsonResponse = EntityUtils.toString(response.getEntity());

        ObjectMapper objectMapper = new ObjectMapper();
        PokemonResponseDto attributesResponse = objectMapper.readValue(jsonResponse, PokemonResponseDto.class);

        // Acessar os atributos do Pokémon
        int hp = attributesResponse.getStats().get(0).getBaseStat();
        int attack = attributesResponse.getStats().get(1).getBaseStat();
        int defense = attributesResponse.getStats().get(2).getBaseStat();
        int speed = attributesResponse.getStats().get(5).getBaseStat();

        Map<String, Integer> attributes = new HashMap<>();
        attributes.put("hp", hp);
        attributes.put("attack", attack);
        attributes.put("defense", defense);
        attributes.put("speed", speed);
        return attributes;

    }

    private int calculateTotal(Map<String, Integer> attributes) {
        return attributes.values().stream().mapToInt(Integer::intValue).sum();
    }

}
