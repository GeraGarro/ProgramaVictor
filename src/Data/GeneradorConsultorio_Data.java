//
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
      
                
    }
    
 public void agregarGenerador(GeneradorConsultorio gc){
        
            String sql="INSERT INTO `generador_consultorio`( `Nombre`, `Cuit`, `Domicilio`, `estado`) VALUES (?, ?, ?, ?)";
            
         try {   
             conx=Conexion.getConexion();
            PreparedStatement ps=conx.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, gc.getNombre());
            ps.setString(2, gc.getCuit());
            ps.setString(3, gc.getDomicilio());
            ps.setBoolean(4, gc.isEstado());
            int nuevoDato=ps.executeUpdate();
            String mensaje;
            if(nuevoDato>0){
                mensaje="Nuevo Consultorio Ingresado";
                
            }
            
            else{
                mensaje="No se pudo Ingresar el consultorio";
            }
             JOptionPane.showMessageDialog(null, mensaje,"Aviso",JOptionPane.INFORMATION_MESSAGE);
          conx.close();   
         } catch (SQLException ex) {

             JOptionPane.showMessageDialog(null, ex);        }
         
     
 }
 
public GeneradorConsultorio obtenerGeneradorConsultorio(int id_Consultorio){
       
            String sql="SELECT * FROM `generador_consultorio` WHERE id_consultorio= ?";
            GeneradorConsultorio gC=new GeneradorConsultorio();
         try { 
             conx=Conexion.getConexion();
            PreparedStatement ps=conx.prepareStatement(sql);
            ps.setInt(1, id_Consultorio);
            ResultSet rs=ps.executeQuery();
            
            if(rs.next()){
                
              gC.setId_Consultorio(rs.getInt("id_consultorio"));
              gC.setNombre(rs.getString("nombre"));
              gC.setCuit(rs.getString("Cuit"));
              gC.setDomicilio(rs.getString("Domicilio"));
              gC.setEstado(rs.getBoolean("estado"));
              
            }
            ps.close();
            
            conx.close();
        } catch (SQLException ex) {
            Logger.getLogger(GeneradorConsultorio_Data.class.getName()).log(Level.SEVERE, null, ex);
        }
    
return gC;}

public void cambiarEstadoConsultorio(int id_Consultorio){
        
            String sql_UPDATE="UPDATE `generador_consultorio` SET estado= not estado WHERE id_consultorio= ?";
            String sql_Consulta="SELECT `nombre`,`estado`FROM `generador_consultorio` WHERE id_consultorio= ?";
            
           try { 
               conx=Conexion.getConexion();
            PreparedStatement ps=conx.prepareStatement(sql_UPDATE);
            PreparedStatement ps2=conx.prepareStatement(sql_Consulta);
            ps.setInt(1, id_Consultorio);
            int cambio=ps.executeUpdate();
            
            ps2.setInt(1, id_Consultorio);
            ResultSet rs=ps2.executeQuery();
            rs.next();
            
            String es;
            if(rs.getBoolean("estado")){
                es="Activo";
            }else{
                es="Desactivado";
            }
            
            String mensaje;
            if(cambio>0){
             mensaje="Se pudo cambiar el estado del consultorio : "+rs.getString("nombre");
                
            }
            else{
                mensaje="Error al realizar la solicitud";
            }
            JOptionPane.showMessageDialog(null, mensaje+"-> Estado "+es, "!Aviso", JOptionPane.INFORMATION_MESSAGE);
            conx.close();
        } catch (SQLException ex) {
            Logger.getLogger(GeneradorConsultorio_Data.class.getName()).log(Level.SEVERE, null, ex);
        }
}

public ArrayList <GeneradorConsultorio> listarConsultoriosTodos() {
        
            ArrayList <GeneradorConsultorio> lista=new ArrayList<>();
            GeneradorConsultorio gc=new GeneradorConsultorio();
            
            String sql="SELECT * FROM generador_consultorio";
           conx=Conexion.getConexion();
           try {  
            
            PreparedStatement ps=conx.prepareStatement(sql);
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
                conx.close();
        } catch (SQLException ex) {
            Logger.getLogger(GeneradorConsultorio_Data.class.getName()).log(Level.SEVERE, null, ex);
        }

return lista;
}


public ArrayList<GeneradorConsultorio> listaConsultoriosActivos(){
         ArrayList<GeneradorConsultorio> lista=new ArrayList<>();
    
            try {
                conx=Conexion.getConexion();
            PreparedStatement ps=conx.prepareStatement("SELECT * FROM `generador_consultorio` WHERE `estado`= 1");
            ResultSet rs= ps.executeQuery();
            
            while(rs.next()){
                GeneradorConsultorio gC=new GeneradorConsultorio();
                gC.setId_Consultorio(rs.getInt(1));
                gC.setNombre(rs.getString("nombre"));
                gC.setDomicilio(rs.getString("domicilio"));
                gC.setCuit(rs.getString(4));
                gC.setEstado(rs.getBoolean("estado"));
                
                lista.add(gC);
            }

            conx.close();
        } catch (SQLException ex) {
            Logger.getLogger(GeneradorConsultorio_Data.class.getName()).log(Level.SEVERE, null, ex);
        }
return lista;
}

public void modificarConsultorio (GeneradorConsultorio gC, int id_Consultorio){
    
        try {
            conx=Conexion.getConexion();
            PreparedStatement ps=conx.prepareStatement("UPDATE `generador_consultorio` SET `nombre`= ?,`cuit`= ?,`domicilio`= ?,`estado`= ?  WHERE id_consultorio= ?");
            ps.setString(1, gC.getNombre());
            ps.setString(2, gC.getCuit());
            ps.setString(3, gC.getDomicilio());
            ps.setBoolean(4, gC.isEstado());
            ps.setInt(5, id_Consultorio);
        
            String m;
            if(ps.executeUpdate()>0){
                m="Se pudo realizar la modificacion en el Generador Consultorio";
            }else{
                m="No fue posible Realizar la solicitud";
            }
        
            JOptionPane.showMessageDialog(null, m, "!AVISO", JOptionPane.INFORMATION_MESSAGE);
            conx.close();
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, ex, "!ERROR",JOptionPane.WARNING_MESSAGE);
           // Logger.getLogger(GeneradorConsultorio_Data.class.getName()).log(Level.SEVERE, null, ex);
        }
}

}



