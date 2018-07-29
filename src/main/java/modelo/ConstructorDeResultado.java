package modelo;

public class ConstructorDeResultado {

    public Resultado construir(int promedioPersonasEnAndenPorMinuti,
                               int sumatoriaLlegadas,
                               int sumatoriaSalidas,
                               int personasQueIngresaronAlSistema,
                               int arrepentidos,
                               int minutosQueDuraElDia,
                               int diasQueDuroLaSimulacion) {

        int promedioEsperaEnAnden =
                (sumatoriaSalidas - sumatoriaLlegadas) /
                        (minutosQueDuraElDia * diasQueDuroLaSimulacion);

        int porcentajeDeArrepentidos =
                arrepentidos * 100 /
                        personasQueIngresaronAlSistema;

        return new Resultado(
                promedioPersonasEnAndenPorMinuti,
                promedioEsperaEnAnden,
                porcentajeDeArrepentidos
        );

    }

}
