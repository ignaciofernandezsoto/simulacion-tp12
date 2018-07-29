package modelo.subte;

public abstract class Subte {

    private final int vagones;
    private final int capacidadPorVagon;
    private final int consumoElectricoEnKW;
    private int cantidadDePasajeros = 0;

    public Subte(int vagones, int capacidadPorVagon, int consumoElectricoEnKW) {
        this.vagones = vagones;
        this.capacidadPorVagon = capacidadPorVagon;
        this.consumoElectricoEnKW = consumoElectricoEnKW;
    }

    public int getVagones() {
        return vagones;
    }

    public int getCapacidadPorVagon() {
        return capacidadPorVagon;
    }

    public int getConsumoElectricoEnKW() {
        return consumoElectricoEnKW;
    }

    public boolean estasLleno(int cantPasajeros) {
        return this.capacidadMaxima() == cantPasajeros;
    }

    public int capacidadMaxima() {
        return vagones*capacidadPorVagon;
    }

    public int pasajerosQuePuedenViajar(int pasajerosSubiendo){
        if(this.cantidadDePasajeros + pasajerosSubiendo <= this.capacidadMaxima()) {
            return pasajerosSubiendo;
        }
        else {
            int pasajerosQuePuedenSubir = this.capacidadMaxima() - this.cantidadDePasajeros;
            return pasajerosQuePuedenSubir;
        }
    }

}
