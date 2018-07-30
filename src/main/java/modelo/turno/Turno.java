package modelo.turno;

import modelo.fdp.FDPIntervalos;

import static java.lang.Math.min;

public abstract class Turno {

    private FDPIntervalos cantPersonasQueBajanEnLacroze;
    private FDPIntervalos cantPersonasQueViajanEnElSubte;
    private FDPIntervalos cantPersonasQueLleganDeLaCalle;
    private int frecuencia;

    public Turno(FDPIntervalos cantPersonasQueBajanEnLacroze,
                FDPIntervalos cantPersonasQueViajanEnElSubte,
                FDPIntervalos cantPersonasQueLleganDeLaCalle,
                int frecuencia) {

        this.cantPersonasQueBajanEnLacroze = cantPersonasQueBajanEnLacroze;
        this.cantPersonasQueViajanEnElSubte = cantPersonasQueViajanEnElSubte;
        this.cantPersonasQueLleganDeLaCalle = cantPersonasQueLleganDeLaCalle;
        this.frecuencia = frecuencia;

    }

    public PersonasDelSubte getPersonasDelSubte(int capacidadDelSubte) {

        PersonasDelSubte personasDelSubte = new PersonasDelSubte();

        int personasEnElSubte = this.cantPersonasQueViajanEnElSubte.obtenerValor();
        int personasQueBajan = this.cantPersonasQueBajanEnLacroze.obtenerValor();

        float bajanRespectoAlTotal = (float) personasQueBajan / personasEnElSubte;

        int personasEnElSubteConCapacidadMaxima = min(personasEnElSubte, capacidadDelSubte);

        int personasQueBajanConCapacidadMaxima = (int) (bajanRespectoAlTotal * personasEnElSubteConCapacidadMaxima);

        personasDelSubte.setCantPersonasQueBajanEnLacroze(personasQueBajanConCapacidadMaxima);
        personasDelSubte.setCantPersonasQueSeQuedanEnElSubte(personasEnElSubteConCapacidadMaxima - personasQueBajanConCapacidadMaxima);

        return personasDelSubte;

    }

    public int cantPersonasQueLleganDeLaCalle() {

        return this.cantPersonasQueLleganDeLaCalle.obtenerValor();

    }

    public int obtenerFrecuencia() {

        return this.frecuencia;

    }

    public class PersonasDelSubte {

        private int cantPersonasQueBajanEnLacroze;
        private int cantPersonasQueSeQuedanEnElSubte;

        public int getCantPersonasQueBajanEnLacroze() {
            return cantPersonasQueBajanEnLacroze;
        }

        public void setCantPersonasQueBajanEnLacroze(int cantPersonasQueBajanEnLacroze) {
            this.cantPersonasQueBajanEnLacroze = cantPersonasQueBajanEnLacroze;
        }

        public int getCantPersonasQueSeQuedanEnElSubte() {
            return cantPersonasQueSeQuedanEnElSubte;
        }

        public void setCantPersonasQueSeQuedanEnElSubte(int cantPersonasQueSeQuedanEnElSubte) {
            this.cantPersonasQueSeQuedanEnElSubte = cantPersonasQueSeQuedanEnElSubte;
        }
    }

}
