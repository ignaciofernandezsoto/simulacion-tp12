package modelo;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class Anden {

    private int personasLlegadasDelSubte;
    private List<Persona> personasLlegadasDeLaCalle;
    private static final int capacidadMaxima = 358;
    private final int caudalSalida = 150;

    public Anden() {
        this.personasLlegadasDelSubte = 0;
        this.personasLlegadasDeLaCalle = new ArrayList<>();
    }

    public int getPersonasTotales() {
        return personasLlegadasDelSubte + personasLlegadasDeLaCalle.size();
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

    public boolean estasConGente() {
        return this.getPersonasTotales() > 0;
    }
    public int getPersonasLlegadasDelSubte() {
        return personasLlegadasDelSubte;
    }

    public void agregarPersonasLlegadasDelSubte(int personasLlegadasDelSubte) {

        int personasActualmenteEnAnden = this.getPersonasTotales();
        int cantidadRestante = capacidadMaxima - personasActualmenteEnAnden;

        this.personasLlegadasDelSubte += min(cantidadRestante, personasLlegadasDelSubte);

    }

    public List<Persona> getPersonasLlegadasDeLaCalle() {
        return personasLlegadasDeLaCalle;
    }

    public void agregarPersonasLlegadasDeLaCalle(List<Persona> personasLlegadasDeLaCalle) {
        this.personasLlegadasDeLaCalle.addAll(personasLlegadasDeLaCalle);
    }

    public void restarPersonasLlegadasDelSubte() {
        if(this.personasLlegadasDelSubte > 0) {
            if(personasLlegadasDelSubte < caudalSalida)
            this.personasLlegadasDelSubte = 0;
            else this.personasLlegadasDelSubte -= caudalSalida;
        }
    }

    public List<Persona> vaciarYObtenerPersonasDeLaCalleQueSalieron() {
            if(this.getPersonasTotales() < caudalSalida) {
                this.personasLlegadasDelSubte = 0;
                this.personasLlegadasDeLaCalle = new ArrayList<>();
                return this.personasLlegadasDeLaCalle;
            }
            else {
                if(this.getPersonasLlegadasDelSubte() > 0) {
                    this.personasLlegadasDelSubte -= caudalSalida;
                    return this.personasLlegadasDeLaCalle;
                }
                else {
                    List<Persona> personasQueSalen = new ArrayList<>();
                    for(int i=0; i < caudalSalida; i++) {
                        Persona persona = this.personasLlegadasDeLaCalle.remove(i);
                        personasQueSalen.add(persona);
                    }
                    return personasQueSalen;
                }
            }
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public List<Persona> realizarIntercambioDePasajerosYDevolverLosQuePudieronSubir(
            int personasQueQuierenBajarDelSubte,
            int espacioLibreSubteConLosQueBajan) {

        List<Persona> pasajerosQueQuierenSubir = this.personasLlegadasDeLaCalle;
        int pasajerosQueQuierenBajar = personasQueQuierenBajarDelSubte;

        if(pasajerosQueQuierenSubir.size() <= espacioLibreSubteConLosQueBajan) {

            this.personasLlegadasDelSubte += pasajerosQueQuierenBajar;

            this.personasLlegadasDeLaCalle = new ArrayList<>();
            return pasajerosQueQuierenSubir;

        } else {

            if(pasajerosQueQuierenBajar <= this.espacioLibre()) {

                this.personasLlegadasDelSubte += pasajerosQueQuierenBajar;

                int pasajerosQueLograronSubir = min(
                        espacioLibreSubteConLosQueBajan - pasajerosQueQuierenBajar,
                        pasajerosQueQuierenSubir.size()
                );

                List<Persona> pasajerosSubidos = new ArrayList<>();
                for(int i=0; i < pasajerosQueLograronSubir; i++) {
                    Persona persona = this.personasLlegadasDeLaCalle.remove(i);
                    pasajerosSubidos.add(persona);
                }
                return pasajerosSubidos;

            } else {

                int pasajerosQueQuedanPorSubir  = pasajerosQueQuierenSubir.size();

                int pasajerosQueQuedanPorBajar = pasajerosQueQuierenBajar;

                while(pasajerosQueQuedanPorSubir > 0
                        && pasajerosQueQuedanPorBajar > 0) {

                    pasajerosQueQuedanPorSubir--;
                    pasajerosQueQuedanPorBajar--;
                    this.personasLlegadasDelSubte++;

                }

                if(pasajerosQueQuedanPorSubir == 0 && pasajerosQueQuedanPorBajar == 0)
                    return pasajerosQueQuierenSubir;
                else {

                    if(pasajerosQueQuedanPorSubir > 0) {

                        int pasajerosQueLograronSubir = min(
                                        pasajerosQueQuierenSubir.size() - pasajerosQueQuedanPorSubir,
                                        espacioLibreSubteConLosQueBajan - pasajerosQueQuedanPorBajar
                        );
                        List<Persona> personasSubidas = new ArrayList<>();
                        for(int i=0; i < pasajerosQueLograronSubir; i++) {
                            Persona persona = this.personasLlegadasDeLaCalle.remove(i);
                            personasSubidas.add(persona);
                        }
                        return personasSubidas;

                    } else {

                        int pasajerosQueLograronBajar = (pasajerosQueQuierenBajar - pasajerosQueQuedanPorBajar)
                                + min(
                                        this.espacioLibre(),
                                        pasajerosQueQuedanPorBajar
                        );

                        this.personasLlegadasDelSubte += pasajerosQueLograronBajar;

                        return pasajerosQueQuierenSubir;

                    }

                }
            }

        }

    }

    private int espacioLibre() {

        return this.getCapacidadMaxima() - this.getPersonasTotales();

    }

}
