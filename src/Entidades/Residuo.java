
package Entidades;
 
public class Residuo {
   private int id_residuo;
   
   private TipoResiduo tipo;
   
   private float peso;
   
   private TicketControl tk;
   
   private boolean estado;

    public Residuo(int id_residuo, TipoResiduo tipo,float peso, TicketControl id_tk,boolean estado) {
        this.id_residuo = id_residuo;
        this.tipo = tipo;
        this.peso = peso;
        this.tk=id_tk;
        this.estado=estado;
    }

    public Residuo(TipoResiduo tipo, float peso, TicketControl id_tk,boolean estado) {
        this.tipo = tipo;
        this.peso = peso;
        this.tk=id_tk;
        this.estado=estado;
    }
    public Residuo() {
       }
    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

   

    public TicketControl getTk() {
        return tk;
    }

    public void setTk(TicketControl tk) {
        this.tk = tk;
    }

    public int getId_residuo() {
        return id_residuo;
    }

    public void setId_residuo(int id_residuo) {
        this.id_residuo = id_residuo;
    }

    public TipoResiduo getTipo() {
        return tipo;
    }

    public void setTipo(TipoResiduo tipo) {
        this.tipo = tipo;
    }

   

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    @Override
    public String toString() {
        return "Residuo{" + "id=" + id_residuo + ", tipo=" + tipo.getDescripcion() + ", peso=" + peso + ", {Ticket= " + tk + "}, estado=" + estado + '}';
    }

  
    
    
   
   
    
    
    
}
