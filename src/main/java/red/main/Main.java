package red.main;
import red.dominio.Aparato;
import red.dominio.Red;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        // LISTADO APARATOS
        ArrayList<Aparato> listaAparatos = new ArrayList<Aparato>();
        // CREAMOS APARATO Y LO AÑADIMOS A LISTADO DE APARATOS
        Aparato television = new Aparato(2.5);
        listaAparatos.add(television);
        Aparato nevera = new Aparato(3.2);
        listaAparatos.add(nevera);
        Aparato calefaccion = new Aparato(2.8);
        listaAparatos.add(calefaccion);
//        ENCENDEMOS APARATOS (POR DEFECTO APAGADOS) Y ASIGNAMOS SU CONSUMO Y SU NOMBRE
        television.setName("television");
        television.encender();
        calefaccion.setName("calefaccion");
        calefaccion.encender();
        nevera.setName("nevera");
        nevera.encender();
        // LISTADO APARATOS ENCENDIDOS
        Red redElectrica = new Red(15.0);
        ArrayList<Aparato> listaAparatosEncendidos = redElectrica.listaAparatosEncendidos(listaAparatos);
        redElectrica.calcularConsumoTotal(listaAparatosEncendidos);
        double totalConsumoActual = redElectrica.getTotalConsumoActual();

        //System.out.println(television.getEncendido()? "Televisión Encendida":"Televisión Apagada");

    }


}
