package ar.edu.unahur.obj2.profugos;

public class ArteMarcial extends EvolucionProfugo{

    public ArteMarcial(IProfugo unProfugo) {
        super(unProfugo);
    }

    @Override
    public Integer getHabilidad() {
        return
            Math.min(100, super.getHabilidad()*2);
    }
    
    

}
