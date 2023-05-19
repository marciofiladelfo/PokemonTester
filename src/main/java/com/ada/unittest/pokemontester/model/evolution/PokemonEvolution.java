package com.ada.unittest.pokemontester.model.evolution;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PokemonEvolution {

    @JsonProperty("forms")
    private List<String> forms;

    public PokemonEvolution(List<String> forms) {
        this.forms = forms;
    }
}
