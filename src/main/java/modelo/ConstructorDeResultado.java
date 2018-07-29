package modelo;

public class ConstructorDeResultado {

    public Resultado construir(int personasEnAnden,
                               int sumatoriaLlegadas,
                               int sumatoriaSalidas,
                               int personasQueIngresaronAlSistema,
                               int arrepentidos,
                               int minutosQueDuraElDia,
                               int diasQueDuroLaSimulacion) {

        float promedioPersonasEnAndenPorMinuto = personasEnAnden / minutosQueDuraElDia*diasQueDuroLaSimulacion;

        float promedioEsperaEnAnden =
                (sumatoriaSalidas - sumatoriaLlegadas) /
                        (minutosQueDuraElDia * diasQueDuroLaSimulacion);

        float porcentajeDeArrepentidos =
                arrepentidos * 100 /
                        personasQueIngresaronAlSistema;

        return new Resultado(
                promedioPersonasEnAndenPorMinuto,
                promedioEsperaEnAnden,
                porcentajeDeArrepentidos
        );

    }

}
