package ar.edu.unahur.obj2.zonas;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import ar.edu.unahur.obj2.cazadores.*;
import ar.edu.unahur.obj2.profugos.*;

public class Zona {
    
    private String nombre;
    private List<Profugo> profugos = new ArrayList<>();

    public Zona(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Profugo> getProfugos() {
        return profugos;
    }

    public void agregarProfugo(Profugo unProfugo) {
        profugos.add(unProfugo);
    }

    public void recibirCazador(Cazador unCazador) {
        List<Profugo> capturados = profugos.stream().filter(p -> unCazador.puedeCapturarProfugo(p)).toList();
        profugos.removeAll(capturados);
        profugos.forEach(p -> unCazador.intimidarProfugo(p));
        Integer minHabilidadIntimidados = profugos.stream().min(Comparator.comparing(p -> p.getHabilidad())).orElse(null).getHabilidad();
        unCazador.aumentarExperiencia(minHabilidadIntimidados + (2 * capturados.size()));
        unCazador.capturarProfugos(capturados);
    }
    
}
