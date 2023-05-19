package com.ada.unittest.pokemontester.model.battle;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PokemonBattleRequest {

    @JsonProperty("challenger")
    private String challenger;
    @JsonProperty("challenged")
    private String challenged;

}
