package modelo;

import modelo.subte.Subte;
import modelo.subte.TipoDeSubte;
import modelo.turno.Turno;
import modelo.turno.TurnoManager;

public class Simulacion {

    private final int avanceDelTiempo;
    private ManagerDeSubtes managerDeSubtes;
    private Frecuencia frecuencia;
    private TurnoManager turnoManager;
    private Tiempo tiempo;
    private int tiempoDeLlegadaSubte;
    private int cantArrepentidos;
    private int caudalDeSalida = 10;

    public Simulacion(int avanceDelTiempo,
                      int cantidadDeVagones,
                      int cantidadDeEidan,
                      int cantidadDeCAF,
                      int frecuenciaManana,
                      int frecuenciaTarde,
                      int frecuenciaNoche,
                      TipoDeSubte subteAComenzar,
                      ) {

        this.avanceDelTiempo = avanceDelTiempo;
        this.managerDeSubtes = new ManagerDeSubtes(cantidadDeVagones, cantidadDeEidan, cantidadDeCAF, subteAComenzar);
        this.frecuencia = new Frecuencia(frecuenciaManana, frecuenciaTarde, frecuenciaNoche);
        this.turnoManager = new TurnoManager();
        this.cantArrepentidos = 0;
        this.tiempo = new Tiempo();

    }

    public Resultado simular(int capacidadDelAnden) {

        Anden anden = new Anden(capacidadDelAnden);
        tiempo.avanzar(avanceDelTiempo);
        this.tiempoDeLlegadaSubte = tiempo.getMinutosActuales() + this.frecuencia.obtenerFrecuencia(this.tiempo.getMinutosActuales());

        Turno turno = this.turnoManager.obtenerTurno(this.tiempo.getMinutosActuales());
        Subte subte = this.managerDeSubtes.getProximoSubte();

        while(tiempo.getMinutosActuales() < tiempoDeLlegadaSubte) {
            anden.restarPersonasLlegadasDelSubte(caudalDeSalida);
            int personasLlegadas = turno.obtenerCantPersonasLlegadasAnden();
            int personasSupuestasEnAnden = anden.getPersonasTotales() + personasLlegadas;
            if(personasSupuestasEnAnden > anden.getCapacidadMaxima()) cantArrepentidos += personasLlegadas;
            else anden.agregarPersonasLlegadasDeLaCalle(personasLlegadas);

            tiempo.avanzar(avanceDelTiempo);
        }
        int personasBajadasDelSubte = turno.obtenerCantPersonasBajadasSubte();
        if(!(subte.estasLleno(personasBajadasDelSubte) && anden.estasLleno())) {
            subte.restarPasajeros(personasBajadasDelSubte);
           int pasajerosSubidos = subte.agregarPasajeros(anden.getPersonasLlegadasDeLaCalle());
           anden.restarPersonasLlegadasDeLaCalle(pasajerosSubidos);
           anden.agregarPersonasLlegadasDelSubte(personasBajadasDelSubte);
        }



    }

}
