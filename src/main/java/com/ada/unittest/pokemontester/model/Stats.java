package com.ada.unittest.pokemontester.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties
public class Stats {
    private int baseStat;
    private int effort;
    private int weight;
    private Stat stat;
}
