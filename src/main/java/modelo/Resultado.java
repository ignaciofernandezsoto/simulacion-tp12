package modelo;

public class Resultado {

    private final int promedioPersonasEnAnden;
    private final int promedioDeEsperaEnAnden;
    private final int porcentajeDeArrepentidos;

    public Resultado(int promedioPersonasEnAnden,
                     int promedioDeEsperaEnAnden,
                     int porcentajeDeArrepentidos) {

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
