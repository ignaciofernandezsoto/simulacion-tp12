package modelo;

public class Anden {

    private int personasLlegadasDelSubte;
    private int personasLlegadasDeLaCalle;
    private int capacidadMaxima;
    private int caudalSalida;

    public Anden(int capacidadMaxima, int caudalSalida) {
        this.personasLlegadasDelSubte = 0;
        this.personasLlegadasDeLaCalle = 0;
        this.capacidadMaxima = capacidadMaxima;
        this.caudalSalida = caudalSalida;
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
