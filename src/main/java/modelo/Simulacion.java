package modelo;

public class Simulacion {

    private ManagerDeSubtes managerDeSubtes;
    private Frecuencia frecuencia;
    private Tiempo tiempo;

    public Simulacion(int cantidadDeVagones,
                      int cantidadDeEidan,
                      int cantidadDeCAF,
                      int frecuenciaManana,
                      int frecuenciaTarde,
                      int frecuenciaNoche) {

        this.managerDeSubtes = new ManagerDeSubtes(cantidadDeVagones, cantidadDeEidan, cantidadDeCAF);
        this.frecuencia = new Frecuencia(frecuenciaManana, frecuenciaTarde, frecuenciaNoche);
        this.tiempo = new Tiempo();

    }

    public Resultado simular() {

    }

}
