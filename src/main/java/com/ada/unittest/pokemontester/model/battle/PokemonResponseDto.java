package com.ada.unittest.pokemontester.model.battle;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class PokemonResponseDto {
    private List<PokemonStatDto> stats;
}
