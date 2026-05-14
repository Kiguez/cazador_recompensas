package ar.edu.unahur.obj2.profugos;

public class ProteccionLegal extends EvolucionProfugo{

    public ProteccionLegal(Profugo unProfugo) {
        super(unProfugo);
        unProfugo.inocencia = Math.max(40, unProfugo.inocencia);
    }

    @Override
    public void disminuirInocencia() {
        unProfugo.inocencia = Math.max(40, unProfugo.inocencia - 2);
    }

    
    
    
}
