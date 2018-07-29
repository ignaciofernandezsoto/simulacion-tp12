package modelo;

public class Tiempo {

    private static final int TIEMPO_FINAL_DIAS = 365;
    private static final int TIEMPO_INICIAL_DIA_MINUTOS = 300;
    public final int TIEMPO_FINAL_DIA_MINUTOS = 1320;

    private int tiempoDias;
    private int tiempoMinutos;

    public Tiempo() {
        this.tiempoMinutos = TIEMPO_INICIAL_DIA_MINUTOS;
        this.tiempoDias = 1;
    }

    public void avanzarMinutos(int minutos) {

        this.tiempoMinutos += minutos;

    }

    public void avanzarUnDia() {

        this.tiempoDias++;

    }

    public int getDiasActuales() {

        return this.tiempoDias;

    }

    public int getMinutosActuales() {

        return this.tiempoMinutos;

    }

}