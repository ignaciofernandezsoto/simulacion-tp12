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
    private int sumatoriaPersonasPorMinuto;
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
        this.sumatoriaPersonasPorMinuto = 0;
        this.sumatoriaLlegadasDeLaCalle = 0;
        this.sumatoriaSalidasDeLaCalle = 0;

    }

    public Resultado simular(int capacidadDelAnden) {

        Anden anden = new Anden(capacidadDelAnden);

        while(tiempo.getMinutosActuales() < tiempo.TIEMPO_FINAL_DIA_MINUTOS) {

            System.out.println("Son las " + tiempo.getMinutosActuales() + " minutos");

            tiempo.avanzarMinutos(avanceDelTiempo);
            Turno turno = this.turnoManager.obtenerTurno(this.tiempo.getMinutosActuales());

            this.tiempoDeLlegadaSubte = tiempo.getMinutosActuales() + turno.obtenerFrecuencia();

            Subte subte = this.managerDeSubtes.getProximoSubte();

            while (tiempo.getMinutosActuales() < tiempoDeLlegadaSubte) {

                System.out.println("Entra gente de la calle!");

                this.sumatoriaPersonasPorMinuto += anden.getPersonasTotales();

                turno = this.turnoManager.obtenerTurno(this.tiempo.getMinutosActuales());
                anden.restarPersonasLlegadasDelSubte();
                int personasLlegadas = turno.cantPersonasQueLleganDeLaCalle();
                this.personasQueEntraronAlSistemaDesdeLaCalle += personasLlegadas;
                cantArrepentidos += anden.obtenerPersonasArrepentidas(personasLlegadas);

                int personasQueEntraronAlAnden = personasLlegadas - cantArrepentidos;

                this.sumatoriaLlegadasDeLaCalle = tiempo.getMinutosActuales() * personasQueEntraronAlAnden;
                if(personasQueEntraronAlAnden < 0)
                    System.out.println("rip");
                anden.agregarPersonasLlegadasDeLaCalle(personasQueEntraronAlAnden);

                tiempo.avanzarMinutos(avanceDelTiempo);
            }

            int personasQueQuierenBajarDelSubte = turno.cantPersonasQueBajanEnLacroze(subte.capacidadMaxima());

            if (!(subte.estasLleno(personasQueQuierenBajarDelSubte) && anden.estasLleno())) {
                int pasajerosSubidos = subte.pasajerosQuePuedenViajar(anden.getPersonasLlegadasDeLaCalle());
                anden.restarPersonasLlegadasDeLaCalle(pasajerosSubidos);
                anden.agregarPersonasLlegadasDelSubte(personasQueQuierenBajarDelSubte);
                this.sumatoriaSalidasDeLaCalle = tiempo.getMinutosActuales() * pasajerosSubidos;
            }

        }

        return new ConstructorDeResultado()
                .construir(
                        sumatoriaPersonasPorMinuto,
                        sumatoriaLlegadasDeLaCalle,
                        sumatoriaSalidasDeLaCalle,
                        personasQueEntraronAlSistemaDesdeLaCalle,
                        cantArrepentidos,
                        tiempo.getMinutosActuales(),
                        tiempo.getDiasActuales()
                );

    }

}
