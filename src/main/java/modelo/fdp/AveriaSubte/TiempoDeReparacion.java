package modelo.fdp.AveriaSubte;

import modelo.fdp.FDPIntervalos;

public class TiempoDeReparacion extends FDPIntervalos {

    private static int INICIO_MANANA = 300; // 5am
    private static int FIN_NOCHE = 1320; // 22pm

    private int valorInicial = 0;
    private int valorFinal = 0;
    private int diaQueInicio = 0;

    @Override
    public int valorInicial() {
        return valorInicial;
    }

    @Override
    public int valorFinal() {
        return valorFinal;
    }

    public int obtenerValor(int diasActuales) {
        if(diasActuales != 365)
            this.valorFinal = FIN_NOCHE * (365-diasActuales); // CUALQUIER HORARIO DENTRO DEL AÑO
        else
            this.valorFinal = FIN_NOCHE; // VA A SER EL ULTIMO DIA DEL AÑO QUE VA A TENER QUE REPARARSE SÍ O SÍ ESE DÍA
        return super.obtenerValor();
    }

    public void setValorInicial(int valorInicial) {
        this.valorInicial = valorInicial;
    }

    public void setDiaQueInicio(int dia) {
        this.diaQueInicio = dia;
    }

    public int getDiaQueInicio() {
        return diaQueInicio;
    }

}
