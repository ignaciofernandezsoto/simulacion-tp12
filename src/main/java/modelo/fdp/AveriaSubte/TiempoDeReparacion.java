package modelo.fdp.AveriaSubte;

import modelo.fdp.FDPIntervalos;

public class TiempoDeReparacion extends FDPIntervalos {

    private static int INICIO_MANANA = 300; // 5am
    private static int FIN_NOCHE = 1320; // 22pm

    private int valorInicial = 0;
    private int valorFinal = FIN_NOCHE*365; // CUALQUIER DÍA DEL AÑO EN CUALQUIER HORARIO
    private int diaQueInicio = 0;

    @Override
    public int valorInicial() {
        return valorInicial;
    }

    @Override
    public int valorFinal() {
        return valorFinal;
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
