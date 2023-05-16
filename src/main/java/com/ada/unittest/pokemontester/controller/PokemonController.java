package com.ada.unittest.pokemontester.controller;

import com.ada.unittest.pokemontester.model.Form;
import com.ada.unittest.pokemontester.model.Pokemon;
import com.ada.unittest.pokemontester.model.PokemonEvolution;
import com.ada.unittest.pokemontester.service.PokemonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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
        Pokemon result = pokemonService.getPokemonByName(name);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/evolution/{name}")
    public ResponseEntity<Form> getpokemonEvolutionByName(@PathVariable String name) {
        Form result = pokemonService.getPokemonEvolution(name);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

}
