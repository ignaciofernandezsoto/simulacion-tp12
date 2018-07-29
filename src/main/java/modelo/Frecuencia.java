package modelo;

public class Frecuencia {

    private static int INICIO_MANANA = 300; // 5am
    private static int INICIO_TARDE = 660; // 11am
    private static int INICIO_NOCHE = 1020; // 17pm
    private static int FIN_NOCHE = 1320; // 22pm

    private int frecuenciaManana;
    private int frecuenciaTarde;
    private int frecuenciaNoche;

    public Frecuencia(int frecuenciaManana, int frecuenciaTarde, int frecuenciaNoche) {
        this.frecuenciaManana = frecuenciaManana;
        this.frecuenciaTarde = frecuenciaTarde;
        this.frecuenciaNoche = frecuenciaNoche;
    }

    public int obtenerFrecuencia(int minutos) {

        if(minutos >= INICIO_MANANA && minutos < INICIO_TARDE)
            return this.frecuenciaManana;

        if(minutos >= INICIO_TARDE && minutos <= INICIO_NOCHE)
            return this.frecuenciaTarde;

        if(minutos >= INICIO_NOCHE && minutos < FIN_NOCHE)
            return this.frecuenciaNoche;

        throw new RuntimeException("No pueden llegar minutos superiores a las 22pm!");

    }

}
