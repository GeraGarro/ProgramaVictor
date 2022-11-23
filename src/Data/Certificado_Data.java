package Data;

import Entidades.Conexion;
import java.sql.Connection;


public class Certificado_Data {
    private Connection conx;
    
public Certificado_Data(){
  this.conx=Conexion.getConexion();
    
}    

}
