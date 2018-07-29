package modelo;

import modelo.subte.CAF;
import modelo.subte.Eidan;
import modelo.subte.Subte;
import modelo.subte.TipoDeSubte;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ManagerDeSubtes {

    private final List<Subte> subtes;
    private int posicionSubteActual;

    public ManagerDeSubtes(int vagones,
                           int cantidadDeEidan,
                           int cantidadDeCAF,
                           TipoDeSubte subteAComenzar) {

        this.subtes = new LinkedList<>();

        List<Subte> cafs = IntStream.range(0, cantidadDeCAF)
                .mapToObj(i -> new CAF(vagones))
                .collect(Collectors.toList());

        List<Subte> eidans = IntStream.range(0, cantidadDeEidan)
                .mapToObj(i -> new Eidan(vagones))
                .collect(Collectors.toList());

        if(subteAComenzar.equals(TipoDeSubte.CAF)) {
            this.subtes.addAll(cafs);
            this.subtes.addAll(eidans);
        }else {
            this.subtes.addAll(eidans);
            this.subtes.addAll(cafs);
        }

        this.posicionSubteActual = 0;

    }

    public Subte getProximoSubte() {

        if(posicionSubteActual == this.subtes.size())
            posicionSubteActual = 0;

        Subte subte = this.subtes.get(posicionSubteActual);

        posicionSubteActual++;

        return subte;

    }

}
