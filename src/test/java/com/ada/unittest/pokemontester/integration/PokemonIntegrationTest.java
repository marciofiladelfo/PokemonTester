package com.ada.unittest.pokemontester.integration;


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
@SpringBootTest
public class PokemonIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldReturnPokemonDataWithSuccesWhenCallingPokemonController() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/pokemon/charmander")
                        .contentType(MediaType.APPLICATION_JSON)
                ).andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("{\"id\":4,\"name\":\"charmander\",\"height\":6,\"weight\":85,\"locationAreaEncounters\":null,\"stats\":[{\"base_stat\":39,\"effort\":0,\"weight\":0,\"stat\":{\"name\":\"hp\"}},{\"base_stat\":52,\"effort\":0,\"weight\":0,\"stat\":{\"name\":\"attack\"}},{\"base_stat\":43,\"effort\":0,\"weight\":0,\"stat\":{\"name\":\"defense\"}},{\"base_stat\":60,\"effort\":0,\"weight\":0,\"stat\":{\"name\":\"special-attack\"}},{\"base_stat\":50,\"effort\":0,\"weight\":0,\"stat\":{\"name\":\"special-defense\"}},{\"base_stat\":65,\"effort\":1,\"weight\":0,\"stat\":{\"name\":\"speed\"}}],\"types\":[{\"type\":{\"name\":\"fire\"}}],\"species\":{\"name\":\"charmander\"}}"))
                .andDo(MockMvcResultHandlers.print());
    }

}
