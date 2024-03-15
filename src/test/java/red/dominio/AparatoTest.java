package red.dominio;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AparatoTest {

    private static Aparato aparato;
    @BeforeAll
    @DisplayName("Crear Instancia Aparato Para Resto de Tests")
    public static void crearInstanciaAparato() {
        System.out.println("Instantiating Contact Manager before the Test Execution");
        aparato = new Aparato("television", 2.5,1);
    }
    @Test
    @DisplayName("Comprobar Constructor Aparato")
    void testConstructorAparato() {

        aparato.encender();
        assertAll(
                () -> assertEquals("television",  aparato.getNombre()),
                () -> assertEquals(2.5,  aparato.getConsumoActual()),
                () -> assertEquals(1,  aparato.getPrioridad())
        );
    }

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

    @Test
    @DisplayName("Lectura Consumo Aparato")
    void testGetConsumo() {

        assertAll(
                () -> assertEquals(2.5, aparato.getConsumo())

        );
    }

    @Test
    @DisplayName("Lectura Consumo Actual Aparato Apagado")
    void testGetConsumoActualApagado() {

        aparato.apagar();
        assertAll(
                () -> assertEquals(0, aparato.getConsumoActual())

        );
    }

    @Test
    @DisplayName("Lectura Consumo Actual Aparato Encendido")
    void testGetConsumoActualEncendido() {

        aparato.encender();
        assertAll(
                () -> assertEquals(2.5, aparato.getConsumoActual())

        );
    }

    @Test
    @DisplayName("Leer Nombre Aparato")
    void testGetNombre() {
        assertAll(
                () -> assertEquals("television", aparato.getNombre())

        );
    }

    @Test
    @DisplayName("Leer Prioridad Aparato")
    void testGetPrioridad() {
        assertAll(
                () -> assertEquals(1, aparato.getPrioridad())

        );
    }




}

