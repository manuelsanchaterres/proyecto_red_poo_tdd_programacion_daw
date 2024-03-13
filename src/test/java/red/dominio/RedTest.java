package red.dominio;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import red.main.Main;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class RedTest {

    @Test
    @DisplayName("Comprobar Consumo 1 Aparato")
    void testConsumoActual1Aparato() {

        ArrayList <Aparato> listaAparatos = new ArrayList<Aparato>();
        Aparato television = new Aparato();
        television.encender();
        television.setConsumo(2.5);
        listaAparatos.add(television);
        television.setName("television");
        Red redElectrica = new Red();
        ArrayList <Aparato> listaAparatosEncendidos = redElectrica.listaAparatosEncendidos(listaAparatos);
        redElectrica.calcularConsumoTotal(listaAparatosEncendidos);
        assertEquals(2.5,redElectrica.getTotalConsumoActual());

    }

    @Test
    @DisplayName("Comprobar Consumo 2 Aparatos")
    void testConsumoActual2Aparatos() {

        ArrayList <Aparato> listaAparatos = new ArrayList<Aparato>();
        Aparato television = new Aparato();
        television.encender();
        television.setConsumo(2.5);
        television.setName("television");
        listaAparatos.add(television);
        Aparato calefactor = new Aparato();
        calefactor.encender();
        calefactor.setConsumo(4.5);
        calefactor.setName("calefactor");
        listaAparatos.add(calefactor);
        Red redElectrica = new Red();
        ArrayList <Aparato> listaAparatosEncendidos = redElectrica.listaAparatosEncendidos(listaAparatos);
        redElectrica.calcularConsumoTotal(listaAparatosEncendidos);
        assertEquals(7.0,redElectrica.getTotalConsumoActual());

    }

    @ParameterizedTest
    @DisplayName("Test Parametrizado Asignar Consumo Máximo Red")
    @ValueSource(doubles = {15.0, 4.5, 25.0, 8.5, 14.3})
    void testSetConsumoMaximo(double potenciaMaximaRedEsperada) {
        Red redElectrica = new Red();
        redElectrica.setConsumoMaximo(potenciaMaximaRedEsperada);
        assertEquals(potenciaMaximaRedEsperada, redElectrica.getConsumoMaximo());
    }

    @Test
    @DisplayName("Example of Disabled Test")
    @Disabled("Not implemented yet")
    void name() {
    }

}
