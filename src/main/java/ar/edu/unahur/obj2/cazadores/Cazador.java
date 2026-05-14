package ar.edu.unahur.obj2.cazadores;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unahur.obj2.profugos.*;

public abstract class Cazador {
    
    private Integer experiencia;
    private List<Profugo> capturados = new ArrayList<>();

    public Cazador(Integer experiencia) {
        this.experiencia = experiencia;
    }

    public Integer getExperiencia() {
        return experiencia;
    }

    public List<Profugo> getCapturados() {
        return
            capturados;
    }

    public void aumentarExperiencia(Integer experiencia) {
        this.experiencia += experiencia; 
    }

    public Boolean puedeCapturarProfugo(Profugo unProfugo) {
        return
            experiencia > unProfugo.getInocencia() &&
            this.extraCaptura(unProfugo);
    }

    public abstract Boolean extraCaptura(Profugo unProfugo);

    public void intimidarProfugo(Profugo unProfugo) {
        unProfugo.disminuirInocencia();
        this.extraIntimidacion(unProfugo);
    }

    public abstract void extraIntimidacion(Profugo unProfugo);

    public void capturarProfugos(List<Profugo> profugos) {
        capturados.addAll(profugos);
    }

}
