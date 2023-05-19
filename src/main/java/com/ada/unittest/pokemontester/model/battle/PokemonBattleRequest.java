package com.ada.unittest.pokemontester.model.battle;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PokemonBattleRequest {
    private String challenger;
    private String challenged;
}
