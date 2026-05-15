package ar.edu.unahur.obj2.profugos;

public class EntrenamientoDeElite extends EvolucionProfugo{

    public EntrenamientoDeElite(IProfugo unProfugo) {
        super(unProfugo);
    }

    @Override
    public Boolean esNervioso() {
        return
            Boolean.FALSE;
    }

    
    
    
}
