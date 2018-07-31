import modelo.Resultado;
import modelo.Simulacion;
import modelo.subte.TipoDeSubte;

public class App {

    public static void main(String[] args) {

        int vagones = 6;
        int eidans = 1;
        int CAFs = 2;
        int frecuenciaManana = 5;
        int frecuenciaTarde = 7;
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

        System.out.println("Vagones: " + vagones);
        System.out.println("Trenes Mitsubishi Eidan 500: " + eidans);
        System.out.println("Trenes CAF Serie 6000: " + CAFs);
        System.out.println("Frecuencia a la mañana: " + frecuenciaManana);
        System.out.println("Frecuencia a la tarde: " + frecuenciaTarde);
        System.out.println("Frecuencia a la noche: " + frecuenciaNoche);

        System.out.println(resultado);

    }

}
