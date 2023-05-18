package com.ada.unittest.pokemontester.controller;

import com.ada.unittest.pokemontester.model.evolution.PokemonEvolution;
import com.ada.unittest.pokemontester.service.PokemonEvolutionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pokemon")
@RequiredArgsConstructor
public class PokemonEvolutionController {

    private final PokemonEvolutionService pokemonEvolutionService;

    @GetMapping("/evolutionline/{name}")
    public ResponseEntity<PokemonEvolution> getLinhaEvolutiva(@PathVariable String name) {
        var result = pokemonEvolutionService.getEvolutionLine(name);
        return ResponseEntity.ok(result);
    }
}
