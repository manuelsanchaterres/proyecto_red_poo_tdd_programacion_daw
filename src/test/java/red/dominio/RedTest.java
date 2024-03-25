package red.dominio;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class RedTest {
//    private static Red redElectrica;
//    @BeforeAll
//    @DisplayName("Crear Instancia Aparato Para Resto de Tests")
//    public static void crearInstanciaAparato() {
//        System.out.println("Instantiating Contact Manager before the Test Execution");
//        redElectrica = new Red(11.0);
//    }
    @Test
    @DisplayName("Comprobar Consumo Actual Red 1 Aparato Apagado")
    void testGetConsumoActual1AparatoApagado() {

        Aparato aparato = new Aparato("television",2.5,2, false);
        aparato.apagar();
        Red redElectrica = new Red(11.0);
        redElectrica.addAparato(aparato);
        assertEquals(0,redElectrica.getConsumoActual());
    }
    @Test
    @DisplayName("Comprobar Consumo Actual Red 1 Aparato Encendido")
    void testGetConsumoActual1AparatoEncendido() {

        Aparato aparato = new Aparato("television",2.5,2, false);
        aparato.encender();
        Red redElectrica = new Red(11.0);
        redElectrica.addAparato(aparato);
        assertEquals(2.5,redElectrica.getConsumoActual());
    }

    @Test
    @DisplayName("Comprobar Consumo Actual Red 2 Aparatos Encendidos")
    void testGetConsumoActual2AparatosEncendidos() {

        Aparato aparato1 = new Aparato("television",2.5,2, false);
        aparato1.encender();
        Aparato aparato2 = new Aparato("plancha",4.3,3, false);
        aparato2.encender();
        Red redElectrica = new Red(11.0);
        redElectrica.addAparato(aparato1);
        redElectrica.addAparato(aparato2);
        assertEquals(6.8,redElectrica.getConsumoActual());
    }

    private static ArrayList<Aparato> listadoAparatosTest() {
        ArrayList<Aparato> listadoAparatos = new ArrayList<>();

        listadoAparatos.add(new Aparato("television",2.5,2, false));
        listadoAparatos.add(new Aparato("radiador",3.7,1, false));
        listadoAparatos.add(new Aparato("nevera",1.7,5, true));
        listadoAparatos.add(new Aparato("calentador",3.2,4, true));
        listadoAparatos.add(new Aparato("secador",4.1,2, false));
        return listadoAparatos;
    }

    private static ArrayList<String> estadoEncendidoApagoAparato() {
        ArrayList<String> estadoEncendidoApagadoAparato = new ArrayList<>();

        estadoEncendidoApagadoAparato.add("encender");
        estadoEncendidoApagadoAparato.add("apagar");
        estadoEncendidoApagadoAparato.add("encender");
        estadoEncendidoApagadoAparato.add("encender");
        estadoEncendidoApagadoAparato.add("encender");
        return estadoEncendidoApagadoAparato;
    }

    @Test
    @DisplayName("Comprobar Consumo Actual Red con Aparatos Encendidos y Apagados")
    void testGetConsumoActualAparatosEncendidosyApagados() {

        ArrayList<Aparato> listadoAparatosTest = listadoAparatosTest();
        ArrayList<String> estadoEncendidoApagadoAparato = estadoEncendidoApagoAparato();
        Red redElectrica = new Red(11.0);
        for (int i = 0; i < listadoAparatosTest.size(); i++) {

            if(estadoEncendidoApagadoAparato.get(i).equals("encender")){

                listadoAparatosTest.get(i).encender();
            }else{

                listadoAparatosTest.get(i).apagar();
            }

            redElectrica.addAparato(listadoAparatosTest.get(i));
        }
        assertEquals(11.5,redElectrica.getConsumoActual());
    }

    @Test
    @DisplayName("Comprobar Añadido 5 Aparatos a la Red")
    void testAddAparatos() {

        ArrayList<Aparato> listadoAparatosTest = listadoAparatosTest();
        Red redElectrica = new Red(11.0);
        for (int i = 0; i < listadoAparatosTest.size(); i++) {

            redElectrica.addAparato(listadoAparatosTest.get(i));
        }
        assertEquals(5, redElectrica.size());
    }
    private static Stream<Arguments> testEsRedEstableArgumentsProvider() {
        List<Arguments> listWithArguments = List.of(
                Arguments.of(3000.00, 2500.00, 8000.00, true),
                Arguments.of(2500.00, 5000.00, 4000.00, false),
                Arguments.of(0.0, 0.0, 1000.00, true),
                Arguments.of(400, 5200, 1000.00, false),
                Arguments.of(3400, 1400, 0.0, false)
        );
        return listWithArguments.stream();
    }
    @ParameterizedTest
    @DisplayName("Comprobar Si hay o No Sobrecarga")
    @MethodSource("testEsRedEstableArgumentsProvider")
    public void testEsRedEstable(double consumoAparato1, double consumoAparato2, double potenciaMaxima, boolean valorEsperado) {

        Aparato aparato1 = new Aparato("television",consumoAparato1, 3, false);
        aparato1.encender();
        Aparato aparato2 = new Aparato("nevera",consumoAparato2, 5, true);
        aparato2.encender();
        Red redElectrica = new Red(potenciaMaxima);
        redElectrica.addAparato(aparato1);
        redElectrica.addAparato(aparato2);
        assertEquals(valorEsperado, redElectrica.esRedEstable());
    }

}
