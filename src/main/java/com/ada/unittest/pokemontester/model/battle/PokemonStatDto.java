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
public class PokemonStatDto {
    @JsonProperty("base_stat")
    private int baseStat;
}
