package Entidades;


public class TipoResiduo {
    private int id_TipoResiduo;
    private String descripcion;
    private boolean estado;
    
    
    public TipoResiduo(int id_TipoResiduo,String descripcion,boolean estado){
        this.id_TipoResiduo=id_TipoResiduo;
        this.descripcion=descripcion;
        this.estado=estado;
        
    }
    
    public TipoResiduo(String descripcion,boolean estado){
        this.descripcion=descripcion;
        this.estado=estado;
    }

    public TipoResiduo() {
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    

    public void setId_TipoResiduo(int id_tipoResiduo){
        this.id_TipoResiduo=id_tipoResiduo;
    }
    
    public int getId_TipoResiduo(){
        return id_TipoResiduo;
    }
    
    public void setDescripcion(String descripcion){
        this.descripcion=descripcion;
    }
 
    
    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public String toString() {
        return "TipoResiduo{" + "id_TipoResiduo=" + id_TipoResiduo + ", descripcion=" + descripcion + ", estado=" + estado + '}';
    }


   

    
    
}
