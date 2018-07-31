import modelo.Resultado;
import modelo.Simulacion;
import modelo.subte.TipoDeSubte;

public class App {

    public static void main(String[] args) {
        int vagones = 4;
        int eidans = 1;
        int CAFs = 2;
        int frecuenciaManana = 10;
        int frecuenciaTarde = 10;
        int frecuenciaNoche = 10;
        final int avanceDelTiempo = 1;
        TipoDeSubte subteAComenzar = TipoDeSubte.CAF;

        Simulacion simulacion = new Simulacion(
                avanceDelTiempo,
                vagones,
                eidans,
                CAFs,
                frecuenciaManana,
                frecuenciaTarde,
                frecuenciaNoche,
                subteAComenzar
        );

        Resultado resultado = simulacion.simular();
        System.out.println("---------------------");
        System.out.println("VARIABLES DE CONTROL");
        System.out.println("---------------------");
        System.out.println("Vagones: " + vagones);
        System.out.println("Trenes Mitsubishi Eidan 500: " + eidans);
        System.out.println("Trenes CAF Serie 6000: " + CAFs);
        System.out.println("Frecuencia a la mañana: " + frecuenciaManana);
        System.out.println("Frecuencia a la tarde: " + frecuenciaTarde);
        System.out.println("Frecuencia a la noche: " + frecuenciaNoche);
        System.out.println("Personas que llegan desde la calle: " + simulacion.personasQueEntraronAlSistemaDesdeLaCalle);
        System.out.println("---------------------");
        System.out.println("RESULTADO");
        System.out.println("---------------------");
        System.out.println("Porcentaje de arrepentidos: " + resultado.getPorcentajeDeArrepentidos() + "%");
        System.out.println("Promedio de espera en andén: " + resultado.getPromedioDeEsperaEnAnden());
        System.out.println("Promedio de personas en andén por minuto: " + resultado.getPromedioPersonasEnAnden());
        System.out.println("---------------------");
    }

}
