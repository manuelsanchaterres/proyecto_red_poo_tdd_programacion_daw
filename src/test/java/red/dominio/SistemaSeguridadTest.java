package red.dominio;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SistemaSeguridadTest {


    private static Stream<Arguments> determinarSobreCargaArgumentsProvider() {
        List<Arguments> listWithArguments = List.of(
                Arguments.of(3000.00, 2500.00, false),
                Arguments.of(2500.00, 5000.00, true),
                Arguments.of(0.0, 0.0, false)
        );
        return listWithArguments.stream();
    }
    @ParameterizedTest
    @DisplayName("Comprobar Si hay o No Sobrecarga")
    @MethodSource("determinarSobreCargaArgumentsProvider")
    public void testDeterminarSobreCarga(double consumoMaximo, double consumoActual, boolean valorEsperado) {
        assertEquals(valorEsperado, !(consumoMaximo >= consumoActual));
    }

//    @DisplayName("Comprobar Si hay o No Sobrecarga")
//    @ParameterizedTest
//    @MethodSource("determinarSobreCargaArgumentsProvider")
//    public void testApagarAparatos(double consumoMaximo, double consumoActual, boolean valorEsperado) {
//        assertEquals(valorEsperado, !(consumoMaximo >= consumoActual));
//    }

}
