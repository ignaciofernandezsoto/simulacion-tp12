package modelo.turno;

import modelo.fdp.Mañana.CantPersonasBajadasDelSubteMañana;
import modelo.fdp.Mañana.CantPersonasLlegadasMañana;

public class Mañana extends Turno {

    public Mañana() {
        super(new CantPersonasBajadasDelSubteMañana(), new CantPersonasLlegadasMañana());
    }
}
