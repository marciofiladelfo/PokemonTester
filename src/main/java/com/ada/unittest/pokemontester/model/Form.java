package com.ada.unittest.pokemontester.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Form {

    @JsonProperty("chain")
    private Chain chain;

}
