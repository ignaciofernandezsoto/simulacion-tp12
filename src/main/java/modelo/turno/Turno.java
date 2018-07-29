package modelo.turno;

import modelo.Frecuencia;
import modelo.fdp.FDP;

public abstract class Turno {

    private FDP cantPersonasBajadasDelSubte;
    private FDP cantPersonaLlegadas;
    private int frecuencia;

    public Turno(FDP cantPersonasBajadasDelSubte, FDP cantPersonaLlegadas, int frecuencia) {
        this.cantPersonasBajadasDelSubte = cantPersonasBajadasDelSubte;
        this.cantPersonaLlegadas = cantPersonaLlegadas;
        this.frecuencia = frecuencia;
    }

    public int obtenerCantPersonasBajadasSubte() {
        return this.cantPersonasBajadasDelSubte.obtenerValor().intValue();
    }

    public int obtenerCantPersonasLlegadasAnden() {
        return this.cantPersonaLlegadas.obtenerValor().intValue();
    }

    public int obtenerFrecuencia() {

        return this.frecuencia;

    }

}
