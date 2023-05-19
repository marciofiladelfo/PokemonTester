package com.ada.unittest.pokemontester.controller;

import com.ada.unittest.pokemontester.model.battle.PokemonBattleRequest;
import com.ada.unittest.pokemontester.model.battle.PokemonBattleResponse;
import com.ada.unittest.pokemontester.service.impl.PokemonBattleServiceImpl;
import com.ada.unittest.pokemontester.utils.JsonToStringUtils;
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

import static org.mockito.Mockito.*;

public class PokemonBattleControllerTest {

    @Mock
    private PokemonBattleServiceImpl service;

    @InjectMocks
    private PokemonBattleController controller;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(this.controller).build();
    }

    @Test
    void testPokemonBattleController() throws Exception {

        PokemonBattleResponse response = new PokemonBattleResponse("Pikachu");

        when(service.getComparisonPokemon(any())).thenReturn(response);

        mockMvc.perform(MockMvcRequestBuilders
                .post("/pokemon/battle")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonToStringUtils.asJsonString(response)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());

        verify(service, times(1)).getComparisonPokemon(any());

    }

}
