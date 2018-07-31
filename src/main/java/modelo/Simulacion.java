package modelo;

import modelo.fdp.AveriaSubte.AveriaDeSubte;
import modelo.fdp.AveriaSubte.TiempoDeReparacion;
import modelo.subte.Subte;
import modelo.subte.TipoDeSubte;
import modelo.turno.Turno;
import modelo.turno.TurnoManager;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Simulacion {

    private final int avanceDelTiempo;
    private ManagerDeSubtes managerDeSubtes;
    private TurnoManager turnoManager;
    private Tiempo tiempo;
    private int tiempoDeLlegadaSubte;
    private int cantArrepentidos;
    public int personasQueEntraronAlSistemaDesdeLaCalle;
    private int personasEnAndenPorMinuto;
    private int sumatoriaLlegadasDeLaCalle;
    private int sumatoriaSalidasDeLaCalle;
    private List<Persona> pasajerosSalidosCalle;
    private int tiempoProximaReparacion;
    private AveriaDeSubte averiaDeSubte;
    private TiempoDeReparacion tiempoDeReparacion;

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
        this.pasajerosSalidosCalle = new ArrayList<>();
        this.tiempoProximaReparacion = 0;
        this.averiaDeSubte = new AveriaDeSubte();
        this.tiempoDeReparacion = new TiempoDeReparacion();

    }

    public Resultado simular() {

        Anden anden = new Anden();
        while (tiempo.getDiasActuales() <= tiempo.TIEMPO_FINAL_DIAS){
            tiempo.reiniciarDia();
            System.out.println("Simulando subte día: " + tiempo.getDiasActuales());
            while (tiempo.getMinutosActuales() < tiempo.TIEMPO_FINAL_DIA_MINUTOS) {

                System.out.println("Son las " + tiempo.getMinutosActuales() + " minutos");

                tiempo.avanzarMinutos(avanceDelTiempo);
                Turno turno = this.turnoManager.obtenerTurno(this.tiempo.getMinutosActuales());

                int frecuenciaDeSubte = turno.obtenerFrecuencia();
                if (tiempo.getMinutosActuales() <= this.tiempoProximaReparacion && tiempo.getDiasActuales() <= this.tiempoDeReparacion.getDiaQueInicio()) {
                    System.out.println("Se está reparando el subte. La frecuencia sigue siendo menos");
                    System.out.println("El tiempo de reparación sigue siendo de: " + tiempoProximaReparacion);
                    frecuenciaDeSubte *= 1.2;
                } else {
                    int probabilidadAveriaSubte = this.averiaDeSubte.obtenerValor();
                    if (probabilidadAveriaSubte < 0.1) {
                        System.out.println("Se rompió el subte. La frecuencia pasa a ser menos");
                        this.tiempoDeReparacion.setValorInicial(tiempo.getMinutosActuales());
                        this.tiempoDeReparacion.setDiaQueInicio(tiempo.getDiasActuales());
                        this.tiempoProximaReparacion = this.tiempoDeReparacion.obtenerValor(tiempo.getDiasActuales());
                        System.out.println("El tiempo de reparación será de: " + tiempoProximaReparacion);
                        System.out.println("El tiempo de ahora es de: " + tiempo.getMinutosActuales());
                        frecuenciaDeSubte *= 1.2;
                    }
                }

                this.tiempoDeLlegadaSubte = tiempo.getMinutosActuales() + frecuenciaDeSubte;

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

                    List<Persona> personasDeLaCalleAlAnden = new ArrayList<>();
                    IntStream.range(0, personasQueEntraronAlAnden).forEach(i -> personasDeLaCalleAlAnden.add(
                            new Persona(tiempo.getMinutosActuales())));
                    anden.agregarPersonasLlegadasDeLaCalle(personasDeLaCalleAlAnden);

                    tiempo.avanzarMinutos(avanceDelTiempo);
                }
                if (tiempoDeLlegadaSubte < tiempo.TIEMPO_FINAL_DIA_MINUTOS) {
                    turno = this.turnoManager.obtenerTurno(this.tiempo.getMinutosActuales());
                    Turno.PersonasDelSubte personasDelSubte = turno.getPersonasDelSubte(subte.capacidadMaxima());

                    int personasQueQuierenBajarDelSubte = personasDelSubte.getCantPersonasQueBajanEnLacroze();
                    int personasQueSeQuedanEnElSubte = personasDelSubte.getCantPersonasQueSeQuedanEnElSubte();

                    int personasTotalesEnElSubte = personasQueSeQuedanEnElSubte + personasQueQuierenBajarDelSubte;
                    if (!(subte.estasLleno(personasTotalesEnElSubte) && anden.estasLleno())) {
                        List<Persona> pasajerosSubidos = anden
                                .realizarIntercambioDePasajerosYDevolverLosQuePudieronSubir(
                                        personasQueQuierenBajarDelSubte,
                                        subte.capacidadMaxima() - personasTotalesEnElSubte
                                );
                        pasajerosSubidos.forEach(pasajeros -> pasajeros.setTiempoDeSalida(tiempo.getMinutosActuales()));
                        this.pasajerosSalidosCalle.addAll(pasajerosSubidos);

                    }
                } else
                    break; // sale del while para generar vaciamiento

            }
            tiempo.avanzarUnDia();
    }
        while(anden.estasConGente()) {
            List<Persona> personasDeLaCalleQueSalieron = anden.vaciarYObtenerPersonasDeLaCalleQueSalieron();
            personasDeLaCalleQueSalieron.forEach(personas -> personas.setTiempoDeSalida(tiempo.getMinutosActuales()));
            this.pasajerosSalidosCalle.addAll(personasDeLaCalleQueSalieron);
            this.tiempo.avanzarMinutos(avanceDelTiempo);
        }

        return new ConstructorDeResultado()
                .construir(
                        personasEnAndenPorMinuto,
                        pasajerosSalidosCalle,
                        personasQueEntraronAlSistemaDesdeLaCalle,
                        cantArrepentidos,
                        tiempo.getMinutosActuales(),
                        tiempo.getDiasActuales()
                );

    }

}
