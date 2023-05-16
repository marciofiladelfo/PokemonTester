package com.ada.unittest.pokemontester.controller;

import com.ada.unittest.pokemontester.model.*;
import com.ada.unittest.pokemontester.service.impl.PokemonServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class PokemonControllerTest {

    @Mock
    private PokemonServiceImpl service;
    @InjectMocks
    private PokemonController controller;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(this.controller).build();
    }

    @Test
    void testGetPokemonByName() throws Exception {

        Pokemon pokemon = new Pokemon();
        pokemon.setId(1);
        pokemon.setName("Pikachu");

        Mockito.when(service.getPokemonByName(Mockito.any())).thenReturn(pokemon);
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/pokemon/pikachu")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(pokemon)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
        Mockito.verify(service, times(1)).getPokemonByName("pikachu");

    }

    @Test
    public void testGetPokemonEvolutionWithSuccess() throws Exception {

        Species species = new Species();
        species.setName("TEST");

        Evolution evolution = Evolution.builder()
                .evolvesTo(List.of(Evolution.builder().build()))
                .species(species)
                .build();

        Chain chain = new Chain();
        chain.setEvolvesTo(List.of(evolution));
        chain.setSpecies(species);

        Form form = new Form();
        form.setChain(chain);

        Mockito.when(service.getPokemonEvolution(Mockito.any())).thenReturn(form);
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/pokemon/evolution/charmander")
                        .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(form)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
        Mockito.verify(service, times(1)).getPokemonEvolution("charmander");
    }

    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}