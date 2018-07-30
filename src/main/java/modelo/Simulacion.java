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
    private int personasQueEntraronAlSistemaDesdeLaCalle;
    private int personasEnAndenPorMinuto;
    private int sumatoriaLlegadasDeLaCalle;
    private int sumatoriaSalidasDeLaCalle;

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
        this.personasQueEntraronAlSistemaDesdeLaCalle = 0;
        this.personasEnAndenPorMinuto = 0;
        this.sumatoriaLlegadasDeLaCalle = 0;
        this.sumatoriaSalidasDeLaCalle = 0;

    }

    public Resultado simular() {

        Anden anden = new Anden();

        while(tiempo.getMinutosActuales() < tiempo.TIEMPO_FINAL_DIA_MINUTOS) {

            System.out.println("Son las " + tiempo.getMinutosActuales() + " minutos");

            tiempo.avanzarMinutos(avanceDelTiempo);
            Turno turno = this.turnoManager.obtenerTurno(this.tiempo.getMinutosActuales());

            this.tiempoDeLlegadaSubte = tiempo.getMinutosActuales() + turno.obtenerFrecuencia();

            Subte subte = this.managerDeSubtes.getProximoSubte();

            while (tiempo.getMinutosActuales() < tiempoDeLlegadaSubte && tiempoDeLlegadaSubte < tiempo.TIEMPO_FINAL_DIA_MINUTOS) {

                System.out.println("Entra gente de la calle!");

                this.personasEnAndenPorMinuto += anden.getPersonasTotales();
                turno = this.turnoManager.obtenerTurno(this.tiempo.getMinutosActuales());
                anden.restarPersonasLlegadasDelSubte();
                int personasLlegadas = turno.cantPersonasQueLleganDeLaCalle();
                this.personasQueEntraronAlSistemaDesdeLaCalle += personasLlegadas;

                int arrepentidosActuales = anden.obtenerPersonasArrepentidas(personasLlegadas);

                cantArrepentidos += arrepentidosActuales;

                int personasQueEntraronAlAnden = personasLlegadas - arrepentidosActuales;

                this.sumatoriaLlegadasDeLaCalle += tiempo.getMinutosActuales() * personasQueEntraronAlAnden;
                anden.agregarPersonasLlegadasDeLaCalle(personasQueEntraronAlAnden);

                tiempo.avanzarMinutos(avanceDelTiempo);
            }

            Turno.PersonasDelSubte personasDelSubte = turno.getPersonasDelSubte(subte.capacidadMaxima());

            int personasQueQuierenBajarDelSubte = personasDelSubte.getCantPersonasQueBajanEnLacroze();
            int personasQueSeQuedanEnElSubte = personasDelSubte.getCantPersonasQueSeQuedanEnElSubte();

            int personasTotalesEnElSubte = personasQueSeQuedanEnElSubte + personasQueQuierenBajarDelSubte;
            if (!(subte.estasLleno(personasTotalesEnElSubte) && anden.estasLleno())) {
                int pasajerosSubidos = subte.pasajerosQuePuedenViajar(anden.getPersonasLlegadasDeLaCalle());
                anden.restarPersonasLlegadasDeLaCalle(pasajerosSubidos);
                anden.agregarPersonasLlegadasDelSubte(personasQueQuierenBajarDelSubte);
                this.sumatoriaSalidasDeLaCalle += tiempo.getMinutosActuales() * pasajerosSubidos;
            }

        }
        while(anden.estasConGente()) {
            int personasDeLaCalleQueSalieron = anden.vaciarYObtenerPersonasDeLaCalleQueSalieron();
            this.sumatoriaSalidasDeLaCalle += tiempo.getMinutosActuales() * personasDeLaCalleQueSalieron;
        }

        return new ConstructorDeResultado()
                .construir(
                        personasEnAndenPorMinuto,
                        sumatoriaLlegadasDeLaCalle,
                        sumatoriaSalidasDeLaCalle,
                        personasQueEntraronAlSistemaDesdeLaCalle,
                        cantArrepentidos,
                        tiempo.getMinutosActuales(),
                        tiempo.getDiasActuales()
                );

    }

}
