package red.dominio;

public class Aparato {

    private boolean encendido;
    private double consumo;
    private String nombre;
    private int prioridad;

    public Aparato (String nombre, double consumo, int prioridad){
        this.consumo = consumo;
        this.prioridad = prioridad;
        this.nombre = nombre;
    }
    public Aparato (){
    }
    public boolean getEncendido() {
        return encendido;
    }

    public void encender() {
        encendido = true;
    }

    public void apagar() {
        encendido = false;
    }
    public double getConsumo() {
        return consumo;
    }

    public double getConsumoActual(){

        return encendido ? consumo: 0;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPrioridad() {
        return prioridad;
    }

}
