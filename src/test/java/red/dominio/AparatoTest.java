package red.dominio;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AparatoTest {

    @Test
    @DisplayName("Comprobar Encendido Aparato")
    void testEncender() {

        Aparato aparato = new Aparato();
        aparato.encender();
        assertAll(
                () -> assertEquals(true,  aparato.getEncendido())

        );
    }

    @Test
    @DisplayName("Comprobar Apagado Aparato")
    void testApagar() {

        Aparato aparato = new Aparato();
        aparato.apagar();
        assertAll(
                () -> assertEquals(false,  aparato.getEncendido())

        );
    }


}

