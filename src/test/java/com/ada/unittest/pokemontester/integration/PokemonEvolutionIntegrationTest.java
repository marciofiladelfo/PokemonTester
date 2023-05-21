package com.ada.unittest.pokemontester.integration;

import com.ada.unittest.pokemontester.PokemonTesterApplication;
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
public class PokemonEvolutionIntegrationTest {


    @Autowired
    private MockMvc mockMvc;


    @Test
    void shouldReturnPokemonEvolutionWithSuccessWhenCallingController() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/pokemon/evolutionline/charmander")
                        .contentType(MediaType.APPLICATION_JSON)
                ).andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("{\"forms\":[\"charmander\",\"charmeleon\",\"charizard\"]}"))
                .andDo(MockMvcResultHandlers.print());

    }

}
