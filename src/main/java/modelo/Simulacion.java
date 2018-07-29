package modelo;

public class Simulacion {

    private int cantidadDeVagones;
    private int cantidadDeEidan;
    private int cantidadDeCAF;
    private int frecuenciaManana;
    private int frecuenciaTarde;
    private int frecuenciaNoche;

    public Simulacion(int cantidadDeVagones,
                      int cantidadDeEidan,
                      int cantidadDeCAF,
                      int frecuenciaManana,
                      int frecuenciaTarde,
                      int frecuenciaNoche) {
        this.cantidadDeVagones = cantidadDeVagones;
        this.cantidadDeEidan = cantidadDeEidan;
        this.cantidadDeCAF = cantidadDeCAF;
        this.frecuenciaManana = frecuenciaManana;
        this.frecuenciaTarde = frecuenciaTarde;
        this.frecuenciaNoche = frecuenciaNoche;
    }

    public Resultado simular() {

    }

}
