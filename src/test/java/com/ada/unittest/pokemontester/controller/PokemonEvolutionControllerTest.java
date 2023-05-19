package com.ada.unittest.pokemontester.controller;

import com.ada.unittest.pokemontester.model.evolution.PokemonEvolution;
import com.ada.unittest.pokemontester.service.impl.PokemonEvolutionServiceImpl;
import com.ada.unittest.pokemontester.utils.JsonToStringUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;
import static org.mockito.Mockito.*;

public class PokemonEvolutionControllerTest {

    @Mock
    private PokemonEvolutionServiceImpl service;
    @InjectMocks
    private PokemonEvolutionController controller;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(this.controller).build();
    }
    @Test
    public void testGetPokemonEvolutionWithSuccess() throws Exception {

        PokemonEvolution pokemonEvolution = new PokemonEvolution(List.of("charmander", "charmileaon", "charlizard"));

        when(service.getEvolutionLine(any())).thenReturn(pokemonEvolution);
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/pokemon/evolutionline/charmander")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JsonToStringUtils.asJsonString(pokemonEvolution)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
        verify(service, times(1)).getEvolutionLine("charmander");
    }

}
