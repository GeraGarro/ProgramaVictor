
package Data;

import Entidades.Conexion;
import Entidades.GeneradorConsultorio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
 
public GeneradorConsultorio obtenerGeneradorConsultorio(int id_Consultorio){
       
            String sql="SELECT * FROM `generador_consultorio` WHERE id_consultorio= ?";
            GeneradorConsultorio gC=new GeneradorConsultorio();
         try {    
            PreparedStatement ps=conx.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            
            if(rs.next()){
                
              gC.setId_Consultorio(id_Consultorio);
              gC.setNombre(rs.getString("nombre"));
              gC.setCuit(rs.getString("Cuit"));
              gC.setDomicilio(rs.getString("Domicilio"));
              gC.setEstado(rs.getBoolean("estado"));
              
            }
            ps.close();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(GeneradorConsultorio_Data.class.getName()).log(Level.SEVERE, null, ex);
        }
    
return gC;}
}
