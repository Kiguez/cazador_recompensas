package ar.edu.unahur.obj2.empresa;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import ar.edu.unahur.obj2.cazadores.*;
import ar.edu.unahur.obj2.profugos.*;
import ar.edu.unahur.obj2.zonas.*;

public class Empresa {
    
    private static Empresa instance = new Empresa();
    private List<Cazador> cazadores = new ArrayList<>();

    private Empresa() {}

    public static Empresa getInstance() {
        return 
            instance;
    }

    public List<Cazador> getCazadores() {
        return cazadores;
    }

    public void contratarCazador(Cazador unCazador) {
        cazadores.add(unCazador);
    }

    public void enviarCazadorAZona(Cazador unCazador , Zona unaZona) {
        if(!cazadores.contains(unCazador)) {
            throw new RuntimeException("El cazador solicitado no pertenece a la empresa");
        }
        unaZona.recibirCazador(unCazador);
    }

    public List<Profugo> profugosCapturados() {
        return
            cazadores.stream().filter(e -> e.getCapturados() != null).
            flatMap(c -> c.getCapturados().stream()).toList();
    }

    public Profugo profugoMasHabilCapturado() {
        return
            this.profugosCapturados().stream().
            max(Comparator.comparing(p -> p.getHabilidad())).orElse(null);
    }

    public Cazador cazadorConMasCapturas() {
        return
            cazadores.stream().max(Comparator.comparing(p -> p.getCapturados().size())).orElse(null);     
    }
}
