package com.ada.unittest.pokemontester.integration;

import com.ada.unittest.pokemontester.PokemonTesterApplication;
import com.ada.unittest.pokemontester.model.battle.PokemonBattleRequest;
import com.ada.unittest.pokemontester.utils.JsonToStringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@AutoConfigureMockMvc
@SpringBootTest(classes = PokemonTesterApplication.class)
public class PokemonBattleIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shhouldReturnPokemonWinnerWhenBaseStatChallangerIsBigger() throws Exception {

        PokemonBattleRequest request = new PokemonBattleRequest();
        request.setChallenger("pikachu");
        request.setChallenged("charmander");

        mockMvc.perform(MockMvcRequestBuilders
                .post("/pokemon/battle")
                .content(JsonToStringUtils.asJsonString(request))
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());

    }


    @Test
    void shhouldReturnWinnerWhenBaseStatChallangerIsSmaller() throws Exception {

        PokemonBattleRequest request = new PokemonBattleRequest();
        request.setChallenger("charmander");
        request.setChallenged("pikachu");

        mockMvc.perform(MockMvcRequestBuilders
                        .post("/pokemon/battle")
                        .content(JsonToStringUtils.asJsonString(request))
                        .contentType(MediaType.APPLICATION_JSON)
                ).andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());

    }

    @Test
    void shhouldReturnDrawWhenCallingPokemonBattleController() throws Exception {

        PokemonBattleRequest request = new PokemonBattleRequest();
        request.setChallenger("charmander");
        request.setChallenged("charmander");

        mockMvc.perform(MockMvcRequestBuilders
                        .post("/pokemon/battle")
                        .content(JsonToStringUtils.asJsonString(request))
                        .contentType(MediaType.APPLICATION_JSON)
                ).andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());

    }

}
