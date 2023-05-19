package com.ada.unittest.pokemontester.controller;

import com.ada.unittest.pokemontester.model.battle.PokemonBattleRequest;
import com.ada.unittest.pokemontester.service.PokemonBattleService;
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
    public ResponseEntity<String> comparePokemon(@RequestBody PokemonBattleRequest request) {
        String challenger = request.getChallenger();
        String challenged = request.getChallenged();

        int challengerTotalStats = pokemonBattleService.getComparisonPokemon(challenger);
        int challengedTotalStats = pokemonBattleService.getComparisonPokemon(challenged);

        String winner;

        if (challengerTotalStats > challengedTotalStats) {
            winner = challenger;
        } else if (challengerTotalStats < challengedTotalStats) {
            winner = challenged;
        } else {
            winner = "DRAW";
        }

        return ResponseEntity.ok("{\"winner\": \"" + winner + "\"}");
    }
}
