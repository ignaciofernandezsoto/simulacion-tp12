package modelo.turno;

import modelo.fdp.FDP;

public abstract class Turno {

    private FDP cantPersonasBajadasDelSubte;
    private FDP cantPersonaLlegadas;

    public Turno(FDP cantPersonasBajadasDelSubte, FDP cantPersonaLlegadas) {
        this.cantPersonasBajadasDelSubte = cantPersonasBajadasDelSubte;
        this.cantPersonaLlegadas = cantPersonaLlegadas;
    }

    public int obtenerCantPersonasBajadasSubte() {
        return this.cantPersonasBajadasDelSubte.obtenerValor().intValue();
    }

    public int obtenerCantPersonasLlegadasAnden() {
        return this.cantPersonaLlegadas.obtenerValor().intValue();
    }

}
