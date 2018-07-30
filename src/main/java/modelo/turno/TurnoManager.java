package modelo.turno;

public class TurnoManager {

    private static int INICIO_MANANA = 300; // 5am
    private static int INICIO_TARDE = 660; // 11am
    private static int INICIO_NOCHE = 1020; // 17pm
    private static int FIN_NOCHE = 1320; // 22pm

    private Mañana turnoMañana;
    private Tarde turnoTarde;
    private Noche turnoNoche;

    public TurnoManager(int frecuenciaM, int frecuenciaT, int frecuenciaN) {
        this.turnoMañana = new Mañana(frecuenciaM);
        this.turnoTarde = new Tarde(frecuenciaT);
        this.turnoNoche = new Noche(frecuenciaN);
    }

    public Turno obtenerTurno(int minutos) {
        if(minutos >= INICIO_MANANA && minutos < INICIO_TARDE)
            return this.turnoMañana;

        if(minutos >= INICIO_TARDE && minutos <= INICIO_NOCHE)
            return this.turnoTarde;

        if(minutos >= INICIO_NOCHE && minutos < FIN_NOCHE)
            return this.turnoNoche;

        throw new RuntimeException("No pueden llegar minutos superiores a las 22pm!");
    }

    public Noche getNoche() {
        return this.turnoNoche;
    }
}
