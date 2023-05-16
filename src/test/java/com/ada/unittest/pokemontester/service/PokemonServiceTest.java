package com.ada.unittest.pokemontester.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;

import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class PokemonServiceTest {

    @InjectMocks
    private PokemonService service;

    @Test
    void testGetPokemonByName() {

    }
}
