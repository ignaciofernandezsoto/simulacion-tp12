package modelo;

public class Tiempo {

    private static final int TIEMPO_FINAL_DIAS = 365;
    private static final int TIEMPO_INICIAL_DIA_MINUTOS = 300;
    private static final int TIEMPO_FINAL_DIA_MINUTOS = 1320;

    private int tiempoDias;
    private int tiempoMinutos;

    public Tiempo() {
        this.tiempoMinutos = TIEMPO_INICIAL_DIA_MINUTOS;
        this.tiempoDias = 0;
    }

    public void avanzar(int minutos) {

        this.tiempoMinutos += minutos;

        if(this.tiempoMinutos >= TIEMPO_FINAL_DIA_MINUTOS) {
            // vaciamiento?
            this.tiempoMinutos = TIEMPO_INICIAL_DIA_MINUTOS;
            this.tiempoDias += 1;
        }

        if(this.tiempoDias >= TIEMPO_FINAL_DIAS) {
            // vaciamiento?
        }

    }

    public int getDiasActuales() {

        return this.tiempoDias;

    }

    public int getMinutosActuales() {

        return this.tiempoMinutos;

    }

}