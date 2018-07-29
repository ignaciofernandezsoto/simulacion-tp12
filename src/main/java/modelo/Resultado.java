package modelo;

public class Resultado {

    private final float promedioPersonasEnAnden;
    private final float promedioDeEsperaEnAnden;
    private final float porcentajeDeArrepentidos;

    public Resultado(float promedioPersonasEnAnden,
                     float promedioDeEsperaEnAnden,
                     float porcentajeDeArrepentidos) {

        this.promedioPersonasEnAnden = promedioPersonasEnAnden;
        this.promedioDeEsperaEnAnden = promedioDeEsperaEnAnden;
        this.porcentajeDeArrepentidos = porcentajeDeArrepentidos;

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
