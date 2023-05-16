package com.ada.unittest.pokemontester.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class PokemonEvolution {

    @JsonProperty("forms")
    private List<Form> forms;

}
