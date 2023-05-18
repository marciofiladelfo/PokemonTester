package com.ada.unittest.pokemontester.model.battle;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PokemonBattleRequest {
    private String challenger;
    private String challenged;
}
