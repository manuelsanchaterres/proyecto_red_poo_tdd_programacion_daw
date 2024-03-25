package red.dominio;

import java.util.ArrayList;

public class SistemaSeguridadMasConsumo extends SistemaSeguridadBasico{

    public SistemaSeguridadMasConsumo(Red red){
        super(red);
    }
    public void apagarAparatosRed(){

        ArrayList<Aparato> listaAparatosNoCriticos = red.getListaAparatosNoCriticos();
        ArrayList<Aparato> listaAparatos = red.getListaAparatos();
        // listadoAparatos No Críticos ordenado por consumo de Mayor a Menor
        listaAparatosNoCriticos.sort((aparato1,aparato2) -> String.valueOf(aparato2.getConsumo()).compareTo(String.valueOf(aparato1.getConsumo())));
        int contadorIndiceAparatos = 0;

        while (!red.esRedEstable() && (contadorIndiceAparatos <= listaAparatosNoCriticos.size()-1)){

            listaAparatosNoCriticos.get(contadorIndiceAparatos).apagar();

            for(int i = 0; i < listaAparatos.size(); i++) {

                if (listaAparatos.get(i).getNombre().equals(listaAparatosNoCriticos.get(contadorIndiceAparatos).getNombre())){

                    listaAparatos.get(i).apagar();
                }
            }
            contadorIndiceAparatos++;
        }

        if (!red.esRedEstable()) {

            new SistemaAlarma(red.getConsumoActual()-red.getPotenciaMaxima());
        }

    }
}
