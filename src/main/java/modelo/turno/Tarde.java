package modelo.turno;

import modelo.fdp.Tarde.CantPersonasBajadasDelSubteTarde;
import modelo.fdp.Tarde.CantPersonasLlegadasTarde;

public class Tarde extends Turno {
    public Tarde() {
        super(new CantPersonasBajadasDelSubteTarde(), new CantPersonasLlegadasTarde());
    }
}
