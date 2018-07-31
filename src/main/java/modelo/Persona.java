package modelo;

public class Persona {

    private int tiempoDeLlegada;
    private int tiempoDeSalida;


    Persona(int tiempoDeLlegada) {
        this.tiempoDeLlegada = tiempoDeLlegada;
        this.tiempoDeSalida = 0;
    }

    public int getTiempoDeLlegada() {
        return tiempoDeLlegada;
    }

    public void setTiempoDeLlegada(int tiempoDeLlegada) {
        this.tiempoDeLlegada = tiempoDeLlegada;
    }

    public int getTiempoDeSalida() {
        return tiempoDeSalida;
    }

    public void setTiempoDeSalida(int tiempoDeSalida) {
        this.tiempoDeSalida = tiempoDeSalida;
    }

    public int getTiempoEnSistema() {
        return tiempoDeSalida - tiempoDeLlegada;
    }
}
