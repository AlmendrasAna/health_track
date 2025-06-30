package com.ejemplo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UsuarioTest {
    Usuario usuario = new Usuario("Maria", 150);

    @Test
    void testActualizarPeso() {
        usuario.actualizarPeso(130);
        double newPeso = usuario.getPeso();
        assertEquals(130, newPeso);
    }

}
