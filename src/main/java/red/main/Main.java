package red.main;
import red.dominio.Aparato;
import red.dominio.Red;
import red.dominio.SistemaSeguridadBasico;

public class Main {

    public static void main(String[] args) {

        Aparato aparato1 = new Aparato("television",2.5, 3);
        aparato1.encender();
        Aparato aparato2 = new Aparato("nevera",4.5, 5);
        aparato2.encender();
        Aparato aparato3 = new Aparato("secador",1.2, 1);
        aparato3.encender();

        System.out.println("Aparato 1: " +aparato1);
        System.out.println("Aparato 2: " +aparato2);
        System.out.println("Aparato 3: " +aparato3);
        Red redElectrica = new Red(8);
        redElectrica.addAparato(aparato1);
        redElectrica.addAparato(aparato2);
        redElectrica.addAparato(aparato3);
        System.out.println("Red Eléctrica: " + redElectrica);

        if (!redElectrica.esRedEstable()
//                || redElectrica.plenaCapacidadUsoRed()
        ){
            SistemaSeguridadBasico sistemaSeguridad = new SistemaSeguridadBasico(redElectrica);
            sistemaSeguridad.apagarAparatosRed();
        }

    }


}
