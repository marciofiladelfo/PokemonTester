package com.ada.unittest.pokemontester.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties
public class Stats {

    @JsonProperty("base_stat")
    private int baseStat;
    @JsonProperty("effort")
    private int effort;
    @JsonProperty("weight")
    private int weight;
    @JsonProperty("stat")
    private Stat stat;
}
