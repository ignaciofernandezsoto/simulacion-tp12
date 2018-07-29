package modelo.turno;

import modelo.fdp.Mañana.CantPersonasQueBajanEnLacrozeMañana;
import modelo.fdp.Mañana.CantPersonaQueSeQuedanEnElSubteMañana;
import modelo.fdp.Mañana.CantPersonasQueLleganDeLaCalleMañana;

public class Mañana extends Turno {

    public Mañana(int frecuencia) {
        super(
                new CantPersonasQueBajanEnLacrozeMañana(),
                new CantPersonaQueSeQuedanEnElSubteMañana(),
                new CantPersonasQueLleganDeLaCalleMañana(),
                frecuencia
        );
    }
}
