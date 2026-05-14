package ar.edu.unahur.obj2.profugos;

public class Profugo implements IProfugo {

    protected Integer inocencia;
    protected Integer habilidad;
    protected Boolean esNervioso;

    public Profugo(Integer inocencia, Integer habilidad, Boolean esNervioso) {
        this.inocencia = inocencia;
        this.habilidad = habilidad;
        this.esNervioso = esNervioso;
    }

    @Override
    public void dejarDeEstarNervioso() {
        esNervioso = Boolean.FALSE;
        
    }

    @Override
    public void disminuirInocencia() {
        inocencia = Math.max(0, inocencia - 2);
        
    }

    @Override
    public Boolean esNervioso() {
        return
            esNervioso;
    }

    @Override
    public Integer getHabilidad() {
        return
            habilidad;
    }

    @Override
    public Integer getInocencia() {
        return
            inocencia;
    }

    @Override
    public void reducirHabilidad() {
        habilidad = Math.max(0, habilidad - 5);
        
    }

    @Override
    public void volverseNervioso() {
        esNervioso = Boolean.TRUE;
        
    }
    
    
}
