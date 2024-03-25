package red.dominio;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SistemaSeguridadMenosConsumoTest {

    private static Stream<Arguments> testApagarAparatosPotenciaRedProvider() {
        List<Arguments> listWithArguments = List.of(
                Arguments.of(11.0, 8),
                Arguments.of(7.5, 7),
                Arguments.of(5, 5),
                Arguments.of(4.5, 0),
                Arguments.of(0, 0)

        );
        return listWithArguments.stream();
    }

    @ParameterizedTest
    @DisplayName("Prueba Apagado Aparatos Según Prioridad y Potencia Máxima Red")
    @MethodSource("testApagarAparatosPotenciaRedProvider")
    public void testApagarAparatos(double potenciaMaximaRed, double consumoActualEsperado) {
        Aparato aparato1 = new Aparato("television",2, 5);
        aparato1.encender();
        Aparato aparato2 = new Aparato("nevera",5, 3);
        aparato2.encender();
        Aparato aparato3 = new Aparato("secador",1, 4);
        aparato3.encender();
        Red redElectrica = new Red(potenciaMaximaRed);
        redElectrica.addAparato(aparato1);
        redElectrica.addAparato(aparato2);
        redElectrica.addAparato(aparato3);
        SistemaSeguridadMenosConsumo sistemaSeguridad = new SistemaSeguridadMenosConsumo(redElectrica);
        sistemaSeguridad.apagarAparatosRed();
        assertEquals(consumoActualEsperado,redElectrica.getConsumoActual());
        System.out.printf(redElectrica.getListaAparatos().toString());
    }

}
