
package Data;
import Entidades.Transportista;
import Entidades.Conexion;
import java.sql.Connection;


public class Tranportista_Data {
  
    private Connection conx;
    
    public Tranportista_Data(){
        this.conx=Conexion.getConexion();
        
    }
    
    public Transportista obtenerTransportista(String transportista){
        
        String sql="SELECT * FROM `ticket_control` WHERE Transportista= ?";
        
        return TRANSPORTISTA;
    
    }
}
