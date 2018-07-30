package modelo.turno;

import modelo.fdp.Tarde.CantPersonasQueBajanEnLacrozeTarde;
import modelo.fdp.Tarde.CantPersonasQueViajanEnElSubteTarde;
import modelo.fdp.Tarde.CantPersonasQueLleganDeLaCalleTarde;

public class Tarde extends Turno {

    public Tarde(int frecuencia) {
        super(
                new CantPersonasQueBajanEnLacrozeTarde(),
                new CantPersonasQueViajanEnElSubteTarde(),
                new CantPersonasQueLleganDeLaCalleTarde(),
                frecuencia
        );
    }

}
