package red.dominio;

import java.util.ArrayList;
import red.dominio.Aparato;
public class Red {

    final private double consumoMáximo = 20.0;
    private double totalConsumoActual = 0.0;

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
//        SistemaSeguridad.determinarSobreCarga(this.totalConsumoActual, consumoMáximo);
    }
}
