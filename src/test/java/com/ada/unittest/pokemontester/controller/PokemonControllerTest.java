package com.ada.unittest.pokemontester.controller;

import com.ada.unittest.pokemontester.model.Pokemon;
import com.ada.unittest.pokemontester.service.impl.PokemonServiceImpl;
import com.ada.unittest.pokemontester.utils.JsonToStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.*;

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
                        .content(JsonToStringUtils.asJsonString(pokemon)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
        verify(service, times(1)).getPokemonByName("pikachu");

    }

    @Test
    void shouldReturnNotFoundWhenCallingPokemonController() throws Exception {
        Pokemon pokemon = new Pokemon();
        pokemon.setId(1);
        pokemon.setName("Pikachu");

        Mockito.when(service.getPokemonByName(Mockito.any())).thenReturn(pokemon);
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/pokemon/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JsonToStringUtils.asJsonString(pokemon)))
                .andExpect(MockMvcResultMatchers.status().isNotFound())
                .andDo(MockMvcResultHandlers.print());
    }


}