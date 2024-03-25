package red.dominio;

import java.util.ArrayList;

public class SistemaSeguridadMenosConsumo extends SistemaSeguridadBasico{

    public SistemaSeguridadMenosConsumo(Red red){
        super(red);
    }
    public void apagarAparatosRed(){

        ArrayList<Aparato> listaAparatos = red.getListaAparatos();

        // listadoAparatos ordenado por consumo de Menor a Mayor
        listaAparatos.sort((aparato1,aparato2) -> String.valueOf(aparato1.getConsumo()).compareTo(String.valueOf(aparato2.getConsumo())));
        int contadorIndiceAparatos = 0;
        while (!red.esRedEstable()){;
            listaAparatos.get(contadorIndiceAparatos).apagar();
            contadorIndiceAparatos++;

        }
        System.out.printf(listaAparatos.toString());
//        System.out.printf(" Consumo Actual Red: %f, Potencia Máxima Red: %f",red.getConsumoActual(),red.getPotenciaMaxima());

    }
}
