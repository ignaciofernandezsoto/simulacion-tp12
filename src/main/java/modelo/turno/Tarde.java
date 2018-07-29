package modelo.turno;

import modelo.fdp.Tarde.CantPersonasQueBajanEnLacrozeTarde;
import modelo.fdp.Tarde.CantPersonaQueSeQuedanEnElSubteTarde;
import modelo.fdp.Tarde.CantPersonasQueLleganDeLaCalleTarde;

public class Tarde extends Turno {

    public Tarde(int frecuencia) {
        super(
                new CantPersonasQueBajanEnLacrozeTarde(),
                new CantPersonaQueSeQuedanEnElSubteTarde(),
                new CantPersonasQueLleganDeLaCalleTarde(),
                frecuencia
        );
    }

}
