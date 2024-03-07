package red.main;
import red.dominio.Aparato;

public class Main {

    public static void main(String[] args) {

        Aparato television = new Aparato();

        television.apagar();
        System.out.println(television.getEncendido()? "Televisión Encendida":"Televisión Apagada");
    }
}
