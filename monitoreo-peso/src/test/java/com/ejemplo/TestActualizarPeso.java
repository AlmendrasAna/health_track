package com.ejemplo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UsuarioTest {
    Usuario usuario = new Usuario("Maria", 150);

    @Test
    void testGetPeso() {

        double newPeso = usuario.getPeso();
        assertEquals(150, newPeso);
    }

    @Test
    void testGetNombre() {

        String newNombre = usuario.getNombre();
        assertEquals("Maria", newNombre);
    }

    @Test
    void testActualizarPeso() {
        usuario.actualizarPeso(130);
        double newPeso = usuario.getPeso();
        assertEquals(130, newPeso);
    }

}
