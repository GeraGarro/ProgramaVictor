
package Data;

import Entidades.Conexion;
import Entidades.GeneradorConsultorio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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

public void desactivarConsultorio(int id_Consultorio){
        
            String sql_UPDATE="UPDATE `generador_consultorio` SET estado=false WHERE id_consultorio= ?";
           try { 
            PreparedStatement ps=conx.prepareStatement(sql_UPDATE);
            ps.setInt(1, id_Consultorio);
            int cambio=ps.executeUpdate();
            String mensaje;
            if(cambio>0){
             mensaje="Se Pudo desactivar el consultorio";
                
            }
            else{
                mensaje="Error al desactivar";
            }
            JOptionPane.showMessageDialog(null, mensaje);
        } catch (SQLException ex) {
            Logger.getLogger(GeneradorConsultorio_Data.class.getName()).log(Level.SEVERE, null, ex);
        }
}

public ArrayList <GeneradorConsultorio> listarConsultorios() {
        
            ArrayList <GeneradorConsultorio> lista=new ArrayList<>();
            GeneradorConsultorio gc=new GeneradorConsultorio();
            
            String sql="SELECT * FROM generador_consultorio";
            PreparedStatement ps=null;
           try {  
           ps=conx.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            
            while(rs.next()){
                gc=new GeneradorConsultorio();
                gc.setId_Consultorio(rs.getInt("id_consultorio"));
                gc.setNombre(rs.getString("nombre"));
                gc.setCuit(rs.getString("Cuit"));
                gc.setDomicilio(rs.getString("Domicilio"));
                gc.setEstado(rs.getBoolean("estado"));
                lista.add(gc);
            }
                ps.close();
                
        } catch (SQLException ex) {
            Logger.getLogger(GeneradorConsultorio_Data.class.getName()).log(Level.SEVERE, null, ex);
        }

return lista;}

}

