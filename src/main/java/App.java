import modelo.Resultado;
import modelo.Simulacion;

public class App {

    public static void main(String[] args) {

        Simulacion simulacion = new Simulacion(
                6,
                1,
                2,
                3,
                4,
                5
        );

        Resultado resultado = simulacion.simular();

    }

}
