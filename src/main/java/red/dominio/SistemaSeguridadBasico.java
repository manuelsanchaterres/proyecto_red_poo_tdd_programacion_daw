package red.dominio;

import java.util.ArrayList;

public class SistemaSeguridadBasico {
    protected Red red;

    public SistemaSeguridadBasico(Red red){
        this.red = red;
    }
    public void apagarAparatosRed(){

        ArrayList<Aparato> listaAparatosNoCriticos = red.getListaAparatosNoCriticos();
        ArrayList<Aparato> listaAparatos = red.getListaAparatos();
        // listadoAparatos No Críticos ordenado por consumo de Mayor a Menor
        listaAparatosNoCriticos.sort((aparato1,aparato2) -> String.valueOf(aparato1.getPrioridad()).compareTo(String.valueOf(aparato2.getPrioridad())));
        int contadorIndiceAparatos = 0;
        // mientras la red no se estable y no hayamos recorrido toda la lista listaAparatosNoCriticos apagaremos aparatos
        while (!red.esRedEstable() && (contadorIndiceAparatos <= listaAparatosNoCriticos.size()-1)){

            // apagamos en listaAparatosNoCriticos
            listaAparatosNoCriticos.get(contadorIndiceAparatos).apagar();

            // apagamos en listaAparatos
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
