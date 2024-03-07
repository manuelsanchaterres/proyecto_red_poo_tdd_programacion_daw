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
        ArrayList<Aparato> listaAparatosEncendidos = Main.listaAparatosEncendidos(listaAparatos);
        Red redElectrica = new Red();
        redElectrica.calcularConsumoTotal(listaAparatosEncendidos);
        double totalConsumoActual = redElectrica.getTotalConsumoActual();

        //System.out.println(television.getEncendido()? "Televisión Encendida":"Televisión Apagada");

    }

    public static ArrayList<Aparato> listaAparatosEncendidos(ArrayList<Aparato> listaAparatos){

        ArrayList<Aparato> listaAparatosEncendidos = new ArrayList<Aparato>();

        for (int i = 0; i < listaAparatos.size(); i++) {

            if (listaAparatos.get(i).getEncendido()){

                listaAparatosEncendidos.add(listaAparatos.get(i));
            }

        }

        return listaAparatosEncendidos;
    }
}
