package modelo.subte;

public class Subte {

    private final int vagones;
    private final int capacidadPorVagon;
    private final int consumoElectricoEnKW;

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

}
