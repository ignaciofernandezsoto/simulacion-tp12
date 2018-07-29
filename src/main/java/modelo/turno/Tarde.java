package modelo.turno;

import modelo.fdp.Tarde.CantPersonasBajadasDelSubteTarde;
import modelo.fdp.Tarde.CantPersonasLlegadasTarde;

public class Tarde extends Turno {

    public Tarde(int frecuencia) {
        super(
                new CantPersonasBajadasDelSubteTarde(),
                new CantPersonasLlegadasTarde(),
                frecuencia
        );
    }

}
