package modelo.turno;

import modelo.fdp.FDPIntervalos;

import static java.lang.Math.min;

public abstract class Turno {

    private FDPIntervalos cantPersonasBajadasDelSubte;
    private FDPIntervalos cantPersonaLlegadas;
    private int frecuencia;

    public Turno(FDPIntervalos cantPersonasBajadasDelSubte, FDPIntervalos cantPersonaLlegadas, int frecuencia) {
        this.cantPersonasBajadasDelSubte = cantPersonasBajadasDelSubte;
        this.cantPersonaLlegadas = cantPersonaLlegadas;
        this.frecuencia = frecuencia;
    }

    public int obtenerCantPersonasBajadasSubte(int capacidadDelSubte) {
        return min(this.cantPersonasBajadasDelSubte.obtenerValor(), capacidadDelSubte);
    }

    public int obtenerCantPersonasLlegadasAnden(int capacidadDelSubte) {
        return min(this.cantPersonaLlegadas.obtenerValor(), capacidadDelSubte);
    }

    public int obtenerFrecuencia() {

        return this.frecuencia;

    }

}
