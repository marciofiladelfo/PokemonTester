package com.ada.unittest.pokemontester.controller;

import com.ada.unittest.pokemontester.model.battle.PokemonBattleRequest;
import com.ada.unittest.pokemontester.model.battle.PokemonBattleResponse;
import com.ada.unittest.pokemontester.service.PokemonBattleService;
import com.ada.unittest.pokemontester.service.PokemonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pokemon")
@RequiredArgsConstructor
public class PokemonBattleController {

    private final PokemonBattleService pokemonBattleService;

    @PostMapping("/battle")
    public ResponseEntity<PokemonBattleResponse> battlePokemon(@RequestBody PokemonBattleRequest request) {
        var result = pokemonBattleService.getComparisonPokemon(request);
        return ResponseEntity.ok(result);
    }
}
