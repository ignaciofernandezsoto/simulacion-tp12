package modelo;

public class Resultado {

    private final int promedioPersonasEnAnden;
    private final float promedioDeEsperaEnAnden;
    private final float porcentajeDeArrepentidos;

    public Resultado(int promedioPersonasEnAnden,
                     float promedioDeEsperaEnAnden,
                     float porcentajeDeArrepentidos) {

        this.promedioPersonasEnAnden = promedioPersonasEnAnden;
        this.promedioDeEsperaEnAnden = promedioDeEsperaEnAnden;
        this.porcentajeDeArrepentidos = porcentajeDeArrepentidos;

    }

    public int getPromedioPersonasEnAnden() {
        return promedioPersonasEnAnden;
    }

    public float getPromedioDeEsperaEnAnden() {
        return promedioDeEsperaEnAnden;
    }

    public float getPorcentajeDeArrepentidos() {
        return porcentajeDeArrepentidos;
    }

    @Override
    public String toString() {
        return "Resultado{" +
                "promedioPersonasEnAnden=" + promedioPersonasEnAnden +
                ", promedioDeEsperaEnAnden=" + promedioDeEsperaEnAnden +
                ", porcentajeDeArrepentidos=" + porcentajeDeArrepentidos +
                '}';
    }

}
