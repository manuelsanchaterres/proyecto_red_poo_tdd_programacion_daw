package red.dominio;

import java.util.ArrayList;
public class Red {

    private double consumoMaximo = 0.0;
    private double totalConsumoActual = 0.0;
    private ArrayList<Aparato> listaAparatosEncendidos = new ArrayList<Aparato>();
    public double getTotalConsumoActual(){

        return totalConsumoActual;
    }

    public void calcularConsumoTotal(ArrayList<Aparato> listaAparatos){

        double totalConsumoActual = 0.0;
        for (int i = 0; i < listaAparatos.size(); i++) {

            if (listaAparatos.get(i).getEncendido()){

                totalConsumoActual += listaAparatos.get(i).getConsumo() ;
            }

        }

        this.totalConsumoActual = totalConsumoActual;
//        UNA VEZ CALCULADO EL TOTAL DE CONSUMO ACTUAL DEBEMOS CALCULAR SI HAY SOBRECARGA EN LA RED SPRINT 03
        if (SistemaSeguridad.determinarSobreCarga(this.totalConsumoActual, consumoMaximo)){
            SistemaSeguridad.apagarAparatos();
        };
    }

    public ArrayList<Aparato> listaAparatosEncendidos(ArrayList<Aparato> listaAparatos){

        ArrayList<Aparato> listaAparatosEncendidos = new ArrayList<Aparato>();

        for (int i = 0; i < listaAparatos.size(); i++) {

            if (listaAparatos.get(i).getEncendido()){

                listaAparatosEncendidos.add(listaAparatos.get(i));
            }

        }
        this.listaAparatosEncendidos = listaAparatosEncendidos;

        return listaAparatosEncendidos;
    }

    public ArrayList<Aparato> getListaAparatosEncendidos(){

        return listaAparatosEncendidos;
    }



    public double getConsumoMaximo() {
        return consumoMaximo;
    }

    public void setConsumoMaximo(double consumoMaximo) {
        this.consumoMaximo = consumoMaximo;
    }
}
