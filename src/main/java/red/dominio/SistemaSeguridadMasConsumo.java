package red.dominio;

import java.util.ArrayList;

public class SistemaSeguridadMasConsumo extends SistemaSeguridadBasico{

    public SistemaSeguridadMasConsumo(Red red){
        super(red);
    }
    public void apagarAparatosRed(){

        ArrayList<Aparato> listaAparatos = red.getListaAparatos();

        // listadoAparatos ordenado por consumo de Mayor a Menor
        listaAparatos.sort((aparato1,aparato2) -> String.valueOf(aparato2.getConsumo()).compareTo(String.valueOf(aparato1.getConsumo())));
        int contadorIndiceAparatos = 0;
        while (!red.esRedEstable()){;
            listaAparatos.get(contadorIndiceAparatos).apagar();
            contadorIndiceAparatos++;

        }

    }
}
