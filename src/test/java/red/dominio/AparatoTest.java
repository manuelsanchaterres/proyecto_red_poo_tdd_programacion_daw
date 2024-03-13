package red.dominio;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AparatoTest {
    @Test
    @DisplayName("Comprobar Constructor Aparato")
    void testConstructorAparato() {

        Aparato aparato = new Aparato(4.5);
        aparato.encender();
        assertAll(
                () -> assertEquals(4.5,  aparato.getConsumo())

        );
    }

    @Test
    @DisplayName("Comprobar Encendido Aparato")
    void testEncender() {

        Aparato aparato = new Aparato(0);
        aparato.encender();
        assertAll(
                () -> assertEquals(true,  aparato.getEncendido())

        );
    }

    @Test
    @DisplayName("Comprobar Apagado Aparato")
    void testApagar() {

        Aparato aparato = new Aparato(0);
        aparato.apagar();
        assertAll(
                () -> assertEquals(false,  aparato.getEncendido())

        );
    }

    @Test
    @DisplayName("Comprobar Escritura de Consumo")
    void testSetConsumo() {

        Aparato aparato = new Aparato(4.5);
        assertAll(
                () -> assertEquals(4.5, aparato.getConsumo())

        );
    }

    @Test
    @DisplayName("Comprobar Escritura Nombre de Aparato")
    void testSetName() {

        Aparato aparato = new Aparato(0);
        aparato.setName("television");
        assertAll(
                () -> assertEquals("television", aparato.getName())

        );
    }



}

