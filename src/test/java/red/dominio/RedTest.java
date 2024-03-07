package red.dominio;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import red.main.Main;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RedTest {

    @Test
    @DisplayName("Comprobar Encendido Aparato")
    void testgetTotalConsumoActual() {
        // LISTADO APARATOS
        ArrayList<Aparato> listaAparatos = new ArrayList<Aparato>();
        // CREAMOS APARATO Y LO AÑADIMOS A LISTADO DE APARATOS
        Aparato television = new Aparato();
        listaAparatos.add(television);
        Aparato nevera = new Aparato();
        listaAparatos.add(nevera);
        Aparato calefaccion = new Aparato();
        listaAparatos.add(calefaccion);
//        ENCENDEMOS APARATOS (POR DEFECTO APAGADOS) Y ASIGNAMOS SU CONSUMO Y SU NOMBRE
        television.setName("television");
        television.setConsumo(2.5);
        television.encender();
        calefaccion.setName("calefaccion");
        calefaccion.setConsumo(3.2);
        calefaccion.encender();
        nevera.setName("nevera");
        nevera.setConsumo(2.8);
        // LISTADO APARATOS ENCENDIDOS
        ArrayList<Aparato> listaAparatosEncendidos = Main.listaAparatosEncendidos(listaAparatos);
        Red redElectrica = new Red();
        redElectrica.calcularConsumoTotal(listaAparatosEncendidos);
//        television y calefaccion encendidos
        assertEquals(5.7, redElectrica.getTotalConsumoActual());
        television.apagar();
        nevera.encender();
        ArrayList<Aparato> listaAparatosEncendidos2 = Main.listaAparatosEncendidos(listaAparatos);
        redElectrica.calcularConsumoTotal(listaAparatosEncendidos2);
//        calefaccion y nevera encendidos
        assertEquals(6.0, redElectrica.getTotalConsumoActual());
        television.encender();
        ArrayList<Aparato> listaAparatosEncendidos3= Main.listaAparatosEncendidos(listaAparatos);
        redElectrica.calcularConsumoTotal(listaAparatosEncendidos3);
//        television, calefaccion y nevera encendidos
        assertEquals(8.5, redElectrica.getTotalConsumoActual());

    }

}
