package red.dominio;

import java.util.ArrayList;
public class Red {

    private ArrayList<Aparato> listaAparatos = new ArrayList<Aparato>();
    private final double potenciaMaxima;
    public Red (double potenciaMaxima){
        this.potenciaMaxima = potenciaMaxima;
    }

    public void addAparato(Aparato aparato){

        listaAparatos.add(aparato);
    }

    public int size(){

        return listaAparatos.size();
    }

    public double getConsumoActual(){

        double consumoActual = 0.0;

        for (Aparato aparato: listaAparatos){

            consumoActual += aparato.getConsumoActual();
        }

        return consumoActual;

    }

    public boolean esRedEstable(){

        return potenciaMaxima > getConsumoActual();
    }

}
