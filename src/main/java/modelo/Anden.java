package modelo;

import static java.lang.Math.min;

public class Anden {

    private int personasLlegadasDelSubte;
    private int personasLlegadasDeLaCalle;
    private static final int capacidadMaxima = 358;
    private final int caudalSalida = 150;

    public Anden() {
        this.personasLlegadasDelSubte = 0;
        this.personasLlegadasDeLaCalle = 0;
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

    public int getPersonasLlegadasDeLaCalle() {
        return personasLlegadasDeLaCalle;
    }

    public void agregarPersonasLlegadasDeLaCalle(int personasLlegadasDeLaCalle) {
        int personasActualmenteEnAnden = this.getPersonasTotales();
        int cantidadRestante = capacidadMaxima - personasActualmenteEnAnden;

        this.personasLlegadasDeLaCalle += min(cantidadRestante, personasLlegadasDeLaCalle);
    }

    public void restarPersonasLlegadasDelSubte() {
        if(this.personasLlegadasDelSubte > 0) {
            if(personasLlegadasDelSubte < caudalSalida)
            this.personasLlegadasDelSubte = 0;
            else this.personasLlegadasDelSubte -= caudalSalida;
        }
    }

    public int vaciarYObtenerPersonasDeLaCalleQueSalieron() {
            if(this.getPersonasTotales() < caudalSalida) {
                this.personasLlegadasDelSubte = 0;
                this.personasLlegadasDeLaCalle = 0;
                return this.personasLlegadasDeLaCalle;
            }
            else {
                if(this.getPersonasLlegadasDelSubte() > 0) {
                    this.personasLlegadasDelSubte -= caudalSalida;
                    return this.personasLlegadasDeLaCalle;
                }
                else {
                    this.personasLlegadasDeLaCalle -= caudalSalida;
                    return caudalSalida;
                }
            }
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public int realizarIntercambioDePasajerosYDevolverLosQuePudieronSubir(
            int personasQueQuierenBajarDelSubte,
            int espacioLibreSubteConLosQueBajan) {

        int pasajerosQueQuierenSubir = this.personasLlegadasDeLaCalle;
        int pasajerosQueQuierenBajar = personasQueQuierenBajarDelSubte;

        if(pasajerosQueQuierenSubir <= espacioLibreSubteConLosQueBajan) {

            this.personasLlegadasDelSubte += pasajerosQueQuierenBajar;
            this.personasLlegadasDeLaCalle -= pasajerosQueQuierenSubir;
            return pasajerosQueQuierenSubir;

        } else {

            if(pasajerosQueQuierenBajar <= this.espacioLibre()) {

                this.personasLlegadasDelSubte += pasajerosQueQuierenBajar;

                int pasajerosQueLograronSubir = min(
                        espacioLibreSubteConLosQueBajan - pasajerosQueQuierenBajar,
                        pasajerosQueQuierenSubir
                );

                this.personasLlegadasDeLaCalle -= pasajerosQueLograronSubir;
                return pasajerosQueLograronSubir;

            } else {

                int pasajerosQueQuedanPorSubir = pasajerosQueQuierenSubir;
                int pasajerosQueQuedanPorBajar = pasajerosQueQuierenBajar;

                while(pasajerosQueQuedanPorSubir > 0 && pasajerosQueQuedanPorBajar > 0) {

                    pasajerosQueQuedanPorSubir--;
                    this.personasLlegadasDeLaCalle--;
                    pasajerosQueQuedanPorBajar--;
                    this.personasLlegadasDelSubte++;

                }

                if(pasajerosQueQuedanPorSubir == 0 && pasajerosQueQuedanPorBajar == 0)
                    return pasajerosQueQuierenSubir;
                else {

                    if(pasajerosQueQuedanPorSubir > 0) {

                        int pasajerosQueLograronSubir = (pasajerosQueQuierenSubir - pasajerosQueQuedanPorSubir)
                                + min(
                                        espacioLibreSubteConLosQueBajan - pasajerosQueQuierenBajar,
                                        pasajerosQueQuedanPorSubir
                        );

                        this.personasLlegadasDeLaCalle -= pasajerosQueLograronSubir;

                        return pasajerosQueLograronSubir;

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
