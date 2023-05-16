package com.ada.unittest.pokemontester.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Evolution {

    @JsonProperty("evolves_to")
    private List<Evolution> evolvesTo;
    @JsonProperty("species")
    private Species species;

}
