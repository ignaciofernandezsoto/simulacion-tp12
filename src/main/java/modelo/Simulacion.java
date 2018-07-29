package modelo;

import modelo.subte.Subte;
import modelo.subte.TipoDeSubte;
import modelo.turno.Turno;
import modelo.turno.TurnoManager;

public class Simulacion {

    private final int avanceDelTiempo;
    private ManagerDeSubtes managerDeSubtes;
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
                      TipoDeSubte subteAComenzar) {

        this.avanceDelTiempo = avanceDelTiempo;
        this.managerDeSubtes = new ManagerDeSubtes(cantidadDeVagones, cantidadDeEidan, cantidadDeCAF, subteAComenzar);
        this.turnoManager = new TurnoManager(frecuenciaManana, frecuenciaTarde, frecuenciaNoche);
        this.cantArrepentidos = 0;
        this.tiempo = new Tiempo();

    }

    public Resultado simular(int capacidadDelAnden) {

        Anden anden = new Anden(capacidadDelAnden);
        tiempo.avanzar(avanceDelTiempo);
        Turno turno = this.turnoManager.obtenerTurno(this.tiempo.getMinutosActuales());

        this.tiempoDeLlegadaSubte = tiempo.getMinutosActuales() + turno.obtenerFrecuencia();

        Subte subte = this.managerDeSubtes.getProximoSubte();

        while(tiempo.getMinutosActuales() < tiempoDeLlegadaSubte) {

            turno = this.turnoManager.obtenerTurno(this.tiempo.getMinutosActuales());
            anden.restarPersonasLlegadasDelSubte(caudalDeSalida);
            int personasLlegadas = turno.cantPersonasQueSeQuedanEnElSubte(subte.capacidadMaxima());
            int personasSupuestasEnAnden = anden.getPersonasTotales() + personasLlegadas;
            if(personasSupuestasEnAnden > anden.getCapacidadMaxima()) cantArrepentidos += personasLlegadas;
            else anden.agregarPersonasLlegadasDeLaCalle(personasLlegadas);

            tiempo.avanzar(avanceDelTiempo);
        }

        int personasQueQuierenBajarDelSubte = turno.cantPersonasQueBajanEnLacroze(subte.capacidadMaxima());

        if(!(subte.estasLleno(personasQueQuierenBajarDelSubte) && anden.estasLleno())) {
           int pasajerosSubidos = subte.pasajerosQuePuedenViajar(anden.getPersonasLlegadasDeLaCalle());
           anden.restarPersonasLlegadasDeLaCalle(pasajerosSubidos);
           anden.agregarPersonasLlegadasDelSubte(personasQueQuierenBajarDelSubte);
        }



    }



}
