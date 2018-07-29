package modelo;

public class ConstructorDeResultado {

    public Resultado construir(int sumatoriaPersonasEnElAndenPorMinuto,
                               int sumatoriaLlegadas,
                               int sumatoriaSalidas,
                               int personasQueIngresaronAlSistema,
                               int arrepentidos,
                               int minutosQueDuraElDia,
                               int diasQueDuroLaSimulacion) {

        int promedioPersonasEnAnden =
                sumatoriaPersonasEnElAndenPorMinuto /
                        (minutosQueDuraElDia * diasQueDuroLaSimulacion);

        int promedioEsperaEnAnden =
                (sumatoriaSalidas - sumatoriaLlegadas) /
                        (minutosQueDuraElDia * diasQueDuroLaSimulacion);

        int porcentajeDeArrepentidos =
                arrepentidos * 100 /
                        personasQueIngresaronAlSistema;

        return new Resultado(
                promedioPersonasEnAnden,
                promedioEsperaEnAnden,
                porcentajeDeArrepentidos
        );

    }

}
