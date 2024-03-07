package red.dominio;

public class Aparato {

    private boolean encendido = false;

    public boolean getEncendido() {
        return encendido;
    }

    public void encender() {
        encendido = true;
    }

    public void apagar() {
        encendido = false;
    }
}
