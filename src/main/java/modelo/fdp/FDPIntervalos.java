package modelo.fdp;

import java.util.concurrent.ThreadLocalRandom;

public abstract class FDPIntervalos {

    public int obtenerValor() {

        return ThreadLocalRandom
                .current()
                .nextInt(this.valorInicial(), this.valorFinal());

    }

    public abstract int valorInicial();

    public abstract int valorFinal();

}
