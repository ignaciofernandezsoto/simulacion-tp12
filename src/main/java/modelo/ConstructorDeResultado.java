package modelo;

public class ConstructorDeResultado {

    public Resultado construir(int personasEnAnden,
                               int sumatoriaLlegadas,
                               int sumatoriaSalidas,
                               int cantidadDeGenteDeCalleQueSalio,
                               int personasQueIngresaronAlSistema,
                               int arrepentidos,
                               int minutosQueDuraElDia,
                               int diasQueDuroLaSimulacion) {

        int promedioPersonasEnAndenPorMinuto = personasEnAnden / minutosQueDuraElDia*diasQueDuroLaSimulacion;

        float promedioEsperaEnAnden =
                (float) (sumatoriaSalidas - sumatoriaLlegadas) / cantidadDeGenteDeCalleQueSalio;


        float porcentajeDeArrepentidos =
                (float) arrepentidos * 100 /
                        personasQueIngresaronAlSistema;

        return new Resultado(
                promedioPersonasEnAndenPorMinuto,
                promedioEsperaEnAnden,
                porcentajeDeArrepentidos
        );

    }

}
