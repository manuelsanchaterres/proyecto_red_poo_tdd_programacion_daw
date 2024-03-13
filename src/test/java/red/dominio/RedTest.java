package red.dominio;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import red.main.Main;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class RedTest {

    @Test
    @DisplayName("Comprobar Consumo 1 Aparato")
    void testConsumoActual1Aparato() {

        ArrayList <Aparato> listaAparatos = new ArrayList<Aparato>();
        Aparato television = new Aparato(2.5);
        television.encender();
        listaAparatos.add(television);
        television.setName("television");
        Red redElectrica = new Red(7.5);
        ArrayList <Aparato> listaAparatosEncendidos = redElectrica.listaAparatosEncendidos(listaAparatos);
        redElectrica.calcularConsumoTotal(listaAparatosEncendidos);
        assertEquals(2.5,redElectrica.getTotalConsumoActual());

    }

    @Test
    @DisplayName("Comprobar Consumo 2 Aparatos")
    void testConsumoActual2Aparatos() {

        ArrayList <Aparato> listaAparatos = new ArrayList<Aparato>();
        Aparato television = new Aparato(2.5);
        television.encender();
        television.setName("television");
        listaAparatos.add(television);
        Aparato calefactor = new Aparato(4.5);
        calefactor.encender();
        calefactor.setName("calefactor");
        listaAparatos.add(calefactor);
        Red redElectrica = new Red(8.5);
        ArrayList <Aparato> listaAparatosEncendidos = redElectrica.listaAparatosEncendidos(listaAparatos);
        redElectrica.calcularConsumoTotal(listaAparatosEncendidos);
        assertEquals(7.0,redElectrica.getTotalConsumoActual());

    }

    @ParameterizedTest
    @DisplayName("Test Parametrizado Asignar Consumo Máximo Red")
    @ValueSource(doubles = {15.0, 4.5, 25.0, 8.5, 14.3})
    void testSetConsumoMaximo(double potenciaMaximaRedEsperada) {
        Red redElectrica = new Red(potenciaMaximaRedEsperada);
        assertEquals(potenciaMaximaRedEsperada, redElectrica.getConsumoMaximo());
    }

    @Test
    @DisplayName("Example of Disabled Test")
    @Disabled("Not implemented yet")
    void name() {
    }

    private static Stream<Arguments> determinarSobreCargaArgumentsProvider() {
        List<Arguments> listWithArguments = List.of(
                Arguments.of(3000.00, 2500.00, 7000.00, false),
                Arguments.of(2500.00, 5000.00, 4000.00, true),
                Arguments.of(0.0, 0.0, 1000.00, false)
        );
        return listWithArguments.stream();
    }
    @ParameterizedTest
    @DisplayName("Comprobar Si hay o No Sobrecarga")
    @MethodSource("determinarSobreCargaArgumentsProvider")
    public void testDeterminarSobreCarga(double potenciaAparato1, double potenciaAparato2, double potenciaMaxima, boolean valorEsperado) {
        ArrayList <Aparato> listaAparatos = new ArrayList<Aparato>();
        Aparato television = new Aparato(potenciaAparato1);
        television.encender();
        television.setName("television");
        listaAparatos.add(television);
        Aparato calefactor = new Aparato(potenciaAparato2);
        calefactor.encender();
        calefactor.setName("calefactor");
        listaAparatos.add(calefactor);
        Red redElectrica = new Red(potenciaMaxima);
        redElectrica.calcularConsumoTotal(listaAparatos);
        assertEquals(valorEsperado, redElectrica.determinarSobreCarga());
    }

}
