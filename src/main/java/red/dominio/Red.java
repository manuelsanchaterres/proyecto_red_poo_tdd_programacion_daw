package red.dominio;

import java.util.ArrayList;
public class Red {

    private ArrayList<Aparato> listaAparatos = new ArrayList<Aparato>();
    private final double potenciaMaxima;

    @Override
    public String toString() {
        return "Red{" +
                "listaAparatos=" + listaAparatos +
                ", potenciaMaxima=" + potenciaMaxima +
                '}';
    }

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

    public double getPotenciaMaxima(){

        return potenciaMaxima;

    }

    public ArrayList<Aparato> getListaAparatos(){

        return listaAparatos;
    }

    public boolean esRedEstable(){

        return potenciaMaxima >= getConsumoActual();
    }

//    public boolean plenaCapacidadUsoRed(){
//
//        return potenciaMaxima == getConsumoActual();
//    }

//    public boolean temporizadorCapacidadUsoRed(){
//
//        long start = System.currentTimeMillis();
//
//        long start = System.currentTimeMillis();
//        return potenciaMaxima == getConsumoActual();
//    }



}
