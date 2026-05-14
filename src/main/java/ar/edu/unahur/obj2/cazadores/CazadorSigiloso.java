package ar.edu.unahur.obj2.cazadores;

import ar.edu.unahur.obj2.profugos.Profugo;

public class CazadorSigiloso extends Cazador{

    public CazadorSigiloso(Integer experiencia) {
        super(experiencia);
    }

    @Override
    public Boolean extraCaptura(Profugo unProfugo) {
        return
            unProfugo.getHabilidad() < 50;
    }

    @Override
    public void extraIntimidacion(Profugo unProfugo) {
        unProfugo.reducirHabilidad();
        
    }
    
    
}
