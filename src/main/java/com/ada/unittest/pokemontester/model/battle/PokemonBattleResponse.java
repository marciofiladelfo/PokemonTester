package com.ada.unittest.pokemontester.model.battle;

import com.ada.unittest.pokemontester.model.Stats;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PokemonBattleResponse {

    @JsonProperty("stats")
    private List<Stats> stats;

}
