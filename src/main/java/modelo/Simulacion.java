package modelo;

public class Simulacion {

    private ManagerDeSubtes managerDeSubtes;
    private Frecuencia frecuencia;

    public Simulacion(int cantidadDeVagones,
                      int cantidadDeEidan,
                      int cantidadDeCAF,
                      int frecuenciaManana,
                      int frecuenciaTarde,
                      int frecuenciaNoche) {

        this.managerDeSubtes = new ManagerDeSubtes(cantidadDeVagones, cantidadDeEidan, cantidadDeCAF);
        this.frecuencia = new Frecuencia(frecuenciaManana, frecuenciaTarde, frecuenciaNoche);

    }

    public Resultado simular() {

    }

}
