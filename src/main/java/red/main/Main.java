package red.main;
import red.dominio.Aparato;
import red.dominio.Red;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
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
        nevera.encender();
        // LISTADO APARATOS ENCENDIDOS
        Red redElectrica = new Red();
        ArrayList<Aparato> listaAparatosEncendidos = redElectrica.listaAparatosEncendidos(listaAparatos);
        redElectrica.calcularConsumoTotal(listaAparatosEncendidos);
        double totalConsumoActual = redElectrica.getTotalConsumoActual();

        //System.out.println(television.getEncendido()? "Televisión Encendida":"Televisión Apagada");

    }


}
