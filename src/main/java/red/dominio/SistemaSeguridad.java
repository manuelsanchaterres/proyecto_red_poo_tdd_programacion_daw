package red.dominio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SistemaSeguridad {

    public void apagarAparatosRed(Red redElectrica){

        ArrayList<Aparato> listaAparatos = redElectrica.getListaAparatos();

        // listadoAparatos ordenado por prioridad
        listaAparatos.sort((aparato1,aparato2) -> String.valueOf(aparato1.getPrioridad()).compareTo(String.valueOf(aparato2.getPrioridad())));

        int contadorIndiceAparatos = 0;
        while (!redElectrica.esRedEstable()){;
            listaAparatos.get(contadorIndiceAparatos).apagar();
            contadorIndiceAparatos++;

        }

        System.out.printf(" Consumo Actual Red: %f, Potencia Máxima Red: %f",redElectrica.getConsumoActual(),redElectrica.getPotenciaMaxima());

    }
}
