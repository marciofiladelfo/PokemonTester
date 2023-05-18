package com.ada.unittest.pokemontester.service.impl;

import com.ada.unittest.pokemontester.model.evolution.PokemonEvolution;
import com.ada.unittest.pokemontester.service.PokemonEvolutionService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PokemonEvolutionServiceImpl implements PokemonEvolutionService {

    private final String BASE_URL = "https://pokeapi.co/api/v2/pokemon-species/";

    @Override
    public PokemonEvolution getEvolutionLine(String name) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        String url = BASE_URL + name.toLowerCase();
        List<String> formas = new ArrayList<>();

        try {
            HttpGet request = new HttpGet(url);
            CloseableHttpResponse response = httpClient.execute(request);

            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode data = objectMapper.readTree(response.getEntity().getContent());

            String evolucoes = data.get("evolution_chain").get("url").asText();
            request = new HttpGet(evolucoes);
            response = httpClient.execute(request);
            JsonNode evolucoesData = objectMapper.readTree(response.getEntity().getContent());

            JsonNode currentEvolution = evolucoesData.get("chain");
            while (currentEvolution != null) {
                String forma = currentEvolution.get("species").get("name").asText();
                formas.add(forma);
                currentEvolution = currentEvolution.get("evolves_to").get(0);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return new PokemonEvolution(formas);
    }
}
