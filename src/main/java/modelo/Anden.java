package modelo;

public class Anden {

    private int personasLlegadasDelSubte;
    private int personasLlegadasDeLaCalle;
    private int capacidadMaxima;
    private final int caudalSalida = 150;

    public Anden(int capacidadMaxima) {
        this.personasLlegadasDelSubte = 0;
        this.personasLlegadasDeLaCalle = 0;
        this.capacidadMaxima = capacidadMaxima;
    }

    public int getPersonasTotales() {
        return personasLlegadasDelSubte + personasLlegadasDeLaCalle;
    }

    public int obtenerPersonasArrepentidas(int personasQueLlegan) {
        int personasActualmenteEnAnden = this.getPersonasTotales();
        int cantidadRestante = capacidadMaxima - personasActualmenteEnAnden;
        if(cantidadRestante >= personasQueLlegan) return 0;
        else return personasQueLlegan - cantidadRestante;
    }

    public boolean estasLleno() {
        return this.getPersonasTotales() == capacidadMaxima;
    }

    public int getPersonasLlegadasDelSubte() {
        return personasLlegadasDelSubte;
    }

    public void agregarPersonasLlegadasDelSubte(int personasLlegadasDelSubte) {

        int personasActualmenteEnAnden = this.getPersonasTotales();
        int cantidadRestante = capacidadMaxima - personasActualmenteEnAnden;

        this.personasLlegadasDelSubte += Math.min(cantidadRestante, personasLlegadasDelSubte);

    }

    public int getPersonasLlegadasDeLaCalle() {
        return personasLlegadasDeLaCalle;
    }

    public void agregarPersonasLlegadasDeLaCalle(int personasLlegadasDeLaCalle) {
        int personasActualmenteEnAnden = this.getPersonasTotales();
        int cantidadRestante = capacidadMaxima - personasActualmenteEnAnden;

        this.personasLlegadasDeLaCalle += Math.min(cantidadRestante, personasLlegadasDeLaCalle);
    }

    public void restarPersonasLlegadasDeLaCalle(int personas) {
        this.personasLlegadasDeLaCalle -= personas;
    }

    public void restarPersonasLlegadasDelSubte() {
        if(this.personasLlegadasDelSubte > 0) {
            if(personasLlegadasDelSubte < caudalSalida)
            this.personasLlegadasDelSubte = 0;
            else this.personasLlegadasDelSubte -= caudalSalida;
        }
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }
}
