package modelo;

public class Anden {

    private int personasLlegadasDelSubte;
    private int personasLlegadasDeLaCalle;
    private int capacidadMaxima;

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
        this.personasLlegadasDelSubte += personasLlegadasDelSubte;
    }

    public int getPersonasLlegadasDeLaCalle() {
        return personasLlegadasDeLaCalle;
    }

    public void agregarPersonasLlegadasDeLaCalle(int personasLlegadasDeLaCalle) {
        this.personasLlegadasDeLaCalle += personasLlegadasDeLaCalle;
    }

    public void restarPersonasLlegadasDeLaCalle(int personas) {
        this.personasLlegadasDeLaCalle -= personas;
    }

    public void restarPersonasLlegadasDelSubte(int personas) {
        if(this.personasLlegadasDelSubte > 0) {
            if(personasLlegadasDelSubte < personas)
            this.personasLlegadasDelSubte = 0;
            else this.personasLlegadasDelSubte -= personas;
        }
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }
}
