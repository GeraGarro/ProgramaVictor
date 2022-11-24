
package Data;

import Entidades.Conexion;
import Entidades.GeneradorConsultorio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class GeneradorConsultorio_Data {
    private Connection conx;
    
    public GeneradorConsultorio_Data(){
        this.conx= Conexion.getConexion();
                
    }
    
 public void agregarGenerador(GeneradorConsultorio gc){
        
            String sql="INSERT INTO `generador_consultorio`( `Nombre`, `Cuit`, `Domicilio`) VALUES (?, ?, ?, ?)";
            
         try {   
            PreparedStatement ps=conx.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, gc.getNombre());
            ps.setString(2, gc.getCuit());
            ps.setString(3, gc.getDomicilio());
         
            int nuevoDato=ps.executeUpdate();
            String mensaje;
            if(nuevoDato>0){
                mensaje="Nuevo Consultorio Ingresado";
                
            }
            
            else{
                mensaje="No se pudo Ingresar el consultorio";
            }
             JOptionPane.showMessageDialog(null, mensaje);
         } catch (SQLException ex) {

             JOptionPane.showMessageDialog(null, ex);        }
     
 }
}
