package modelo.turno;

import modelo.fdp.Mañana.CantPersonasQueBajanEnLacrozeMañana;
import modelo.fdp.Mañana.CantPersonasQueViajanEnElSubteMañana;
import modelo.fdp.Mañana.CantPersonasQueLleganDeLaCalleMañana;

public class Mañana extends Turno {

    public Mañana(int frecuencia) {
        super(
                new CantPersonasQueBajanEnLacrozeMañana(),
                new CantPersonasQueViajanEnElSubteMañana(),
                new CantPersonasQueLleganDeLaCalleMañana(),
                frecuencia
        );
    }
}
