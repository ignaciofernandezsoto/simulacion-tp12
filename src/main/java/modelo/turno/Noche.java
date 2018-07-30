package modelo.turno;

import modelo.fdp.Noche.CantPersonasQueBajanEnLacrozeNoche;
import modelo.fdp.Noche.CantPersonasQueViajanEnElSubteNoche;
import modelo.fdp.Noche.CantPersonasQueLleganDeLaCalleNoche;

public class Noche extends Turno {
    public Noche(int frecuencia) {
        super(
                new CantPersonasQueBajanEnLacrozeNoche(),
                new CantPersonasQueViajanEnElSubteNoche(),
                new CantPersonasQueLleganDeLaCalleNoche(),
                frecuencia
        );
    }
}
