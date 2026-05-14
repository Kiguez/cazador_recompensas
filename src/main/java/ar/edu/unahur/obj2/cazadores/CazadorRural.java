package ar.edu.unahur.obj2.cazadores;

import ar.edu.unahur.obj2.profugos.Profugo;

public class CazadorRural extends Cazador{

    public CazadorRural(Integer experiencia) {
        super(experiencia);
    }

    @Override
    public Boolean extraCaptura(Profugo unProfugo) {
        return
            unProfugo.esNervioso();
    }

    @Override
    public void extraIntimidacion(Profugo unProfugo) {
        unProfugo.volverseNervioso();
        
    }
    
    
}
