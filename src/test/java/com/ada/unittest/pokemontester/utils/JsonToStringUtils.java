package com.ada.unittest.pokemontester.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

public interface JsonToStringUtils {

    static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
