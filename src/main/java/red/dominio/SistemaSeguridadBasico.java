package red.dominio;

import java.util.ArrayList;

public class SistemaSeguridadBasico {
    protected Red red;

    public SistemaSeguridadBasico(Red red){
        this.red = red;
    }
    public void apagarAparatosRed(){

        ArrayList<Aparato> listaAparatos = red.getListaAparatos();

        // listadoAparatos ordenado por prioridad
        listaAparatos.sort((aparato1,aparato2) -> String.valueOf(aparato1.getPrioridad()).compareTo(String.valueOf(aparato2.getPrioridad())));
        int contadorIndiceAparatos = 0;
        while (!red.esRedEstable()){;
            listaAparatos.get(contadorIndiceAparatos).apagar();
            contadorIndiceAparatos++;

        }

        System.out.printf(" Consumo Actual Red: %f, Potencia Máxima Red: %f",red.getConsumoActual(),red.getPotenciaMaxima());

    }
}
