package com.botelho.duckapp.testutil;

import com.botelho.duckapp.entity.Pato;
import com.botelho.duckapp.enums.StatusPato;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AssertUtil {

    public static void assertPatoEquals(Pato expected, Pato actual) {
        assertNotNull(expected);
        assertNotNull(actual);
        assertEquals(expected.getId(), actual.getId());
        assertEquals(expected.getNome(), actual.getNome());
        assertEquals(expected.getRaca(), actual.getRaca());
        assertEquals(expected.getIdade(), actual.getIdade());
        assertEquals(expected.getSexo(), actual.getSexo());
        assertEquals(expected.getStatus(), actual.getStatus());
        assertEquals(expected.getMae(), actual.getMae());
    }

    public static void assertPatoStatus(Pato pato, StatusPato expectedStatus) {
        assertNotNull(pato);
        assertEquals(expectedStatus, pato.getStatus());
    }

    // Outras asserções necessárias
    // ...
}
