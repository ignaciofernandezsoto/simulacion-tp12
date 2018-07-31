package modelo;

import java.util.List;
import java.util.stream.Collectors;

public class ConstructorDeResultado {

    public Resultado construir(int personasEnAnden,
                               List<Persona> pasajerosSalidos,
                               int personasQueIngresaronAlSistema,
                               int arrepentidos,
                               int minutosQueDuraElDia,
                               int diasQueDuroLaSimulacion) {

        int promedioPersonasEnAndenPorMinuto = personasEnAnden / (minutosQueDuraElDia*diasQueDuroLaSimulacion);

        List<Persona> personasLocas = pasajerosSalidos
                .stream()
                .filter(persona -> persona.getTiempoDeSalida() < persona.getTiempoDeLlegada()).collect(Collectors.toList());
        float total = pasajerosSalidos.stream().mapToInt(Persona::getTiempoEnSistema).sum();
        float promedioEsperaEnAnden = total / pasajerosSalidos.size();

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
