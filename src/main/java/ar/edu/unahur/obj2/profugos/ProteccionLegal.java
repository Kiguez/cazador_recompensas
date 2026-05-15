package ar.edu.unahur.obj2.profugos;

public class ProteccionLegal extends EvolucionProfugo{

    public ProteccionLegal(IProfugo unProfugo) {
        super(unProfugo);
    }

    @Override
    public Integer getInocencia() {
        return
            Math.max(40, super.getInocencia());
    }
       
}
