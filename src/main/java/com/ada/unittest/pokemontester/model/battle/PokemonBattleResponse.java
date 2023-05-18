package com.ada.unittest.pokemontester.model.battle;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PokemonBattleResponse {
    private String winner;

    public PokemonBattleResponse(String winner) {
        this.winner = winner;
    }
}
