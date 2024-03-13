package red.dominio;

public class Aparato {

    private boolean encendido = false;
    private final double consumo;
    private String name = "";
    private int prioridad = 0;

    public Aparato (double consumo){
        this.consumo = consumo;
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

//    public void setConsumo(double consumo) {
//       this.consumo = consumo;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

}
