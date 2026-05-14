package ar.edu.unahur.obj2.profugos;

public class ArteMarcial extends EvolucionProfugo{

    public ArteMarcial(Profugo unProfugo) {
        super(unProfugo);
        this.duplicarHabilidad();
    }

    public void duplicarHabilidad() {
        unProfugo.habilidad = Math.min(100 , unProfugo.habilidad * 2);
    }
    
    

}
