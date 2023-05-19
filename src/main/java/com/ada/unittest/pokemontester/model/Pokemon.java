package com.ada.unittest.pokemontester.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Pokemon {
    private int id;
    private String name;
    private int height;
    private int weight;
    private List<String> locationAreaEncounters;
    private List<Stats> stats;
    private List<Types> types;
    private Species species;
}
