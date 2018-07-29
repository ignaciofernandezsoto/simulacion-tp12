package modelo.turno;

import modelo.fdp.Noche.CantPersonasBajadasDelSubteNoche;
import modelo.fdp.Noche.CantPersonasLlegadasNoche;

public class Noche extends Turno {
    public Noche(int frecuencia) {
        super(
                new CantPersonasBajadasDelSubteNoche(),
                new CantPersonasLlegadasNoche(),
                frecuencia
        );
    }
}
