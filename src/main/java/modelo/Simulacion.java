package modelo;

public class Simulacion {

    private int cantidadDeVagones;
    private int cantidadDeEidan;
    private int cantidadDeCAF;
    private Frecuencia frecuencia;

    public Simulacion(int cantidadDeVagones,
                      int cantidadDeEidan,
                      int cantidadDeCAF,
                      int frecuenciaManana,
                      int frecuenciaTarde,
                      int frecuenciaNoche) {
        this.cantidadDeVagones = cantidadDeVagones;
        this.cantidadDeEidan = cantidadDeEidan;
        this.cantidadDeCAF = cantidadDeCAF;
        this.frecuencia = new Frecuencia(frecuenciaManana, frecuenciaTarde, frecuenciaNoche);
    }

    public Resultado simular() {

    }

}
