package com.ada.unittest.pokemontester.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class UrlEvolutionLine {

    @JsonProperty("evolution_chain")
    private UrlEvolutionChain evolutionChain;
}
