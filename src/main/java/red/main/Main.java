package red.main;
import red.dominio.Aparato;
import red.dominio.Red;
import red.dominio.SistemaSeguridad;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Aparato aparato1 = new Aparato("television",2.5, 3);
        aparato1.encender();
        Aparato aparato2 = new Aparato("nevera",4.5, 5);
        aparato2.encender();
        Aparato aparato3 = new Aparato("secador",1.2, 1);
        aparato3.encender();
        Red redElectrica = new Red(5);
        redElectrica.addAparato(aparato1);
        redElectrica.addAparato(aparato2);
        redElectrica.addAparato(aparato3);

        if (!redElectrica.esRedEstable()){
            SistemaSeguridad sistemaSeguridad = new SistemaSeguridad();
            sistemaSeguridad.apagarAparatosRed(redElectrica);
        }

    }


}
