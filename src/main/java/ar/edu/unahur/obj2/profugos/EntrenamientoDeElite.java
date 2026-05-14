package ar.edu.unahur.obj2.profugos;

public class EntrenamientoDeElite extends EvolucionProfugo{

    public EntrenamientoDeElite(Profugo unProfugo) {
        super(unProfugo);
        unProfugo.dejarDeEstarNervioso();
    }

    @Override
    public void volverseNervioso() {}

    
    
    
}
