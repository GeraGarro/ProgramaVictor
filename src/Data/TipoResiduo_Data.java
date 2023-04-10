
package Data;

import Entidades.Conexion;
import Entidades.TipoResiduo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.mariadb.jdbc.internal.util.dao.PrepareResult;

public class TipoResiduo_Data {
    private Connection conx;
    
    public TipoResiduo_Data(){
        
        this.conx=Conexion.getConexion();
    }
    
    public void CrearTipoResiduo(TipoResiduo tr){
        try {
            String sql="INSERT INTO `tiporesiduo`(`descripcion`,`estado`) VALUES (?, ?)";
            PreparedStatement ps=conx.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, tr.getDescripcion());
            ps.setBoolean(2, tr.isEstado());
            
            String mensaje;
            
            if(ps.executeUpdate()>0){
                mensaje="Se ha registrado el nuevo dato";
            }else{
                mensaje="No se pudo realizar la creacion del un nuevo tipo de residuo";
            }
            JOptionPane.showMessageDialog(null, mensaje);
        
        } catch (SQLException ex) {
          //  Logger.getLogger(TipoResiduo_Data.class.getName()).log(Level.SEVERE, null, ex);
          JOptionPane.showMessageDialog(null, ex);
          
        }
    }
    
    public void CambiarEstadoTipoResiduo(int id_TipoResiduo){
        
        try {
            String sql="UPDATE `tiporesiduo` SET estado= not estado WHERE id_tipoResiduo= ?";
            
            String sqlSecundario="SELECT `estado` FROM `tiporesiduo` WHERE id_tipoResiduo= ?";
            
            PreparedStatement ps= conx.prepareStatement(sql);
            PreparedStatement ps2=conx.prepareStatement(sqlSecundario);
            
            
             ps.setInt(1, id_TipoResiduo);
            int contadorSentencia=ps.executeUpdate();
            
           
            
            ps2.setInt(1, id_TipoResiduo);
            ResultSet rs=ps2.executeQuery();
            
            rs.next();
            
             String mensaje;
            String estado;
            
            if(rs.getBoolean("estado")){
                estado="Activo";
            }else{
                estado="Inactivo";
            }
          
            
            
            if(contadorSentencia>0){
                mensaje="Se Realizó la modificacion del estado del Residuo,nuevo estado: "+estado;
            }else{
                mensaje="No se pudo Realizar el cambio de estado actual del Residuo";
            }
            JOptionPane.showMessageDialog(null, mensaje);
        
        } catch (SQLException ex) {
           // Logger.getLogger(TipoResiduo_Data.class.getName()).log(Level.SEVERE, null, ex);
           JOptionPane.showMessageDialog(null, ex);
           
        }
    }
 public ArrayList<TipoResiduo> ListaTipoResiduoTodos(){
        ArrayList<TipoResiduo> lista=new ArrayList();
        try {
            String sql="SELECT * FROM `tiporesiduo`";
            PreparedStatement ps=conx.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            
            while(rs.next()){
                TipoResiduo tR=new TipoResiduo();
                tR.setId_TipoResiduo(rs.getInt(1));
                tR.setDescripcion(rs.getString(2));
                tR.setEstado(rs.getBoolean(3));
                
                lista.add(tR);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
           // Logger.getLogger(TipoResiduo_Data.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
     return lista;
 
 }
 
 
  public ArrayList<TipoResiduo> ListaTipoResiduoActivos(){
        ArrayList<TipoResiduo> lista=new ArrayList();
        try {
            String sql="SELECT * FROM `tiporesiduo` WHERE estado=1";
            PreparedStatement ps=conx.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            
            while(rs.next()){
                TipoResiduo tR=new TipoResiduo();
                tR.setId_TipoResiduo(rs.getInt(1));
                tR.setDescripcion(rs.getString(2));
                tR.setEstado(rs.getBoolean(3));
                
                lista.add(tR);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
            Logger.getLogger(TipoResiduo_Data.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
     return lista;
 
 }
  
  public void modificarTipoResiduo(TipoResiduo tR,int id){
        try {
            PreparedStatement ps=conx.prepareStatement("UPDATE `tiporesiduo` SET `descripcion`= ?,`estado`=  ? WHERE id_tipoResiduo= ?");
            
            ps.setString(1, tR.getDescripcion());
            ps.setBoolean(2, tR.isEstado());
            ps.setInt(3, id);
            
            int cambio=ps.executeUpdate();
            
            String mensaje;
            if(cambio>0){
                mensaje="Se ha realizado modificacion en el Tipo de Residuo";
            }else{
                mensaje="No se pudo realizar la modificacón solicitada";
            }
            JOptionPane.showMessageDialog(null, mensaje, "Aviso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            Logger.getLogger(TipoResiduo_Data.class.getName()).log(Level.SEVERE, null, ex);
        }
      
  }
  
  public ArrayList<TipoResiduo> buscarTiposResiduosPorNombre(String nombre){
        ArrayList<TipoResiduo> lista=new ArrayList();
      try {
            PreparedStatement ps=conx.prepareStatement("SELECT * FROM `tiporesiduo` WHERE `descripcion`LIKE ?");
            ps.setString(1, "%"+nombre+"%");
            
            ResultSet rs=ps.executeQuery();
            
            while(rs.next()){
                TipoResiduo tR=new TipoResiduo();
               tR.setId_TipoResiduo(rs.getInt(1));
               tR.setDescripcion(rs.getString(2));
               tR.setEstado(rs.getBoolean(3));
               lista.add(tR);
            }
            
        } catch (SQLException ex) {
           // JOptionPane.showMessageDialog(null, ex, "Atencion",JOptionPane.WARNING_MESSAGE);
            Logger.getLogger(TipoResiduo_Data.class.getName()).log(Level.SEVERE, null, ex);
        }
  return lista;
  }
  
  public TipoResiduo ObtenerTipoResiduo(int id){
      TipoResiduo tR=new TipoResiduo();
      
      try {
            PreparedStatement ps=conx.prepareStatement("SELECT * FROM `tiporesiduo` WHERE id_tipoResiduo= ?");
             ps.setInt(1, id);
             
             ResultSet rs=ps.executeQuery();
             
             if(rs.next()){
              tR.setId_TipoResiduo(id);
              tR.setDescripcion(rs.getString(2));
              tR.setEstado(rs.getBoolean("estado"));
             }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(TipoResiduo_Data.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    return tR;
  }
  
}
