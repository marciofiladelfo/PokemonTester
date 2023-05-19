package com.ada.unittest.pokemontester.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Pokemon {

    @JsonProperty("id")
    private int id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("height")
    private int height;
    @JsonProperty("weight")
    private int weight;
    @JsonProperty("locationAreaEncounters")
    private List<String> locationAreaEncounters;
    @JsonProperty("stats")
    private List<Stats> stats;
    @JsonProperty("types")
    private List<Types> types;
    @JsonProperty("species")
    private Species species;
}
