package modelo.turno;

import modelo.fdp.FDPIntervalos;

import static java.lang.Math.min;

public abstract class Turno {

    private FDPIntervalos cantPersonasQueBajanEnLacroze;
    private FDPIntervalos cantPersonaQueSeQuedanEnElSubte;
    private FDPIntervalos cantPersonasQueLleganDeLaCalle;
    private int frecuencia;

    public Turno(FDPIntervalos cantPersonasQueBajanEnLacroze,
                FDPIntervalos cantPersonaQueSeQuedanEnElSubte,
                FDPIntervalos cantPersonasQueLleganDeLaCalle,
                int frecuencia) {

        this.cantPersonasQueBajanEnLacroze = cantPersonasQueBajanEnLacroze;
        this.cantPersonaQueSeQuedanEnElSubte = cantPersonaQueSeQuedanEnElSubte;
        this.cantPersonasQueLleganDeLaCalle = cantPersonasQueLleganDeLaCalle;
        this.frecuencia = frecuencia;

    }

    public int cantPersonasQueBajanEnLacroze(int capacidadDelSubte) {
        return min(this.cantPersonasQueBajanEnLacroze.obtenerValor(), capacidadDelSubte);
    }

    public int cantPersonasQueSeQuedanEnElSubte(int capacidadDelSubte) {
        return min(this.cantPersonaQueSeQuedanEnElSubte.obtenerValor(), capacidadDelSubte);
    }

    public int cantPersonasQueLleganDeLaCalle() {

        return this.cantPersonasQueLleganDeLaCalle.obtenerValor();

    }

    public int obtenerFrecuencia() {

        return this.frecuencia;

    }

}
