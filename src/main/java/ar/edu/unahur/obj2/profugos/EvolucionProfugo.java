package ar.edu.unahur.obj2.profugos;

public abstract class EvolucionProfugo implements IProfugo {

    protected Profugo unProfugo;

    public EvolucionProfugo(Profugo unProfugo) {
        this.unProfugo = unProfugo;
    }

    @Override
    public void dejarDeEstarNervioso() {
        unProfugo.dejarDeEstarNervioso();
    }

    @Override
    public void disminuirInocencia() {
        unProfugo.disminuirInocencia();
    }

    @Override
    public Boolean esNervioso() {
        return
            unProfugo.esNervioso();
    }

    @Override
    public Integer getHabilidad() {
        return
            unProfugo.getHabilidad();
    }

    @Override
    public Integer getInocencia() {
        return
            unProfugo.getInocencia();
    }

    @Override
    public void reducirHabilidad() {
        unProfugo.reducirHabilidad();
    }

    @Override
    public void volverseNervioso() {
        unProfugo.volverseNervioso();
    }
    
    
}
