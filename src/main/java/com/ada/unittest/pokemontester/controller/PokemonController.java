package com.ada.unittest.pokemontester.controller;

import com.ada.unittest.pokemontester.model.Pokemon;
import com.ada.unittest.pokemontester.service.PokemonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pokemon")
@RequiredArgsConstructor
public class PokemonController {
    private final PokemonService pokemonService;

    @GetMapping("/{name}")
    public ResponseEntity<Pokemon> getPokemonByName(@PathVariable String name) {
        var result = pokemonService.getPokemonByName(name);
        return ResponseEntity.ok(result);
    }
}
