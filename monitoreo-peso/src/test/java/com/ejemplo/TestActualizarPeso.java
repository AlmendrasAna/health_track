package test.java.com.ejemplo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import main.java.com.ejemplo.Usuario;

class UsuarioTest{
Usuario usuario = new Usuario("Maria",150);
@Test
void testActualizarPeso() {
double newPeso = usuario.actualizarPeso(130);
assertEquals(130, newPeso);
}


}
