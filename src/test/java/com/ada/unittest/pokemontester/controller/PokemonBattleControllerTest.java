package com.ada.unittest.pokemontester.controller;

import com.ada.unittest.pokemontester.model.Stat;
import com.ada.unittest.pokemontester.model.Stats;
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

import java.util.List;

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

        Stat stat = new Stat();
        stat.setName("Test");

        Stats stats = new Stats();
        stats.setBaseStat(1);
        stats.setStat(stat);
        stats.setWeight(89);
        stats.setEffort(0);
        PokemonBattleResponse response = new PokemonBattleResponse(List.of(stats));

        when(service.getComparisonPokemon(any())).thenReturn(0);

        mockMvc.perform(MockMvcRequestBuilders
                .post("/pokemon/battle")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonToStringUtils.asJsonString(response)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());

        verify(service, times(1)).getComparisonPokemon(any());

    }

}
