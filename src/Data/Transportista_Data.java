package Data;

import Entidades.Conexion;
import Entidades.Transportista;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Transportista_Data {
    private Connection conx;
    
    public Transportista_Data (){
        
}
    public void crearTransportista(Transportista t){
        
        try {
            conx=Conexion.getConexion();
            PreparedStatement ps=conx.prepareStatement("INSERT INTO `transportista`(`nombre`, `apellido`, `cuit`, `estado`) VALUES ( ?, ?, ?, ?)");
            ps.setString(1, t.getNombre());
            ps.setString(2, t.getApellido());
            ps.setString(3, t.getCuit());
            ps.setBoolean(4, t.isEstado());
            
            int resultado=ps.executeUpdate();
            String mensaje;
            if(resultado>0){
                mensaje="Se logro incorporar a la base de datos el nuevo transportista";
            }else{
                mensaje="No se pudo realizar la solicitud";
            }
            JOptionPane.showMessageDialog(null, mensaje, "aviso", JOptionPane.INFORMATION_MESSAGE);
            conx.close();
        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "ERROR!",JOptionPane.WARNING_MESSAGE);
            //Logger.getLogger(Transportista_Data.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void CambiarEstadoTransportista(int id){
        
        try {
            conx=Conexion.getConexion();
       
            PreparedStatement ps= conx.prepareStatement("UPDATE `transportista` SET `estado`= NOT `estado` WHERE id_transportista= ?");
            PreparedStatement ps2=conx.prepareStatement("SELECT `estado` FROM `transportista` WHERE id_transportista= ?");
            
            ps.setInt(1, id);
            int resultado=ps.executeUpdate();
            
             ps2.setInt(1, id);
            ResultSet rs=ps2.executeQuery();
            
            rs.next();
            
            String mensaje;
            String estado;
            
            if(resultado>0){
                mensaje="Se Logro Cambiar el estado de Actividad del Transportista";
            }else{
                mensaje="No fue posible realizar la petición";
            }
            if(rs.getBoolean("estado")){
                estado="Activo";
            }else{
                estado="Inactivo";
            }
            JOptionPane.showMessageDialog(null, mensaje+" Tranporista: "+estado, "Reporte",JOptionPane.INFORMATION_MESSAGE);
            conx.close();
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, ex,"ERROR", JOptionPane.WARNING_MESSAGE);
            Logger.getLogger(Transportista_Data.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void modificarTransportista(Transportista t,int id){
        try {conx=Conexion.getConexion();
            PreparedStatement ps=conx.prepareStatement("UPDATE `transportista` SET `nombre`= ?,`apellido`= ?,`cuit`= ?,`estado`= ? WHERE id_transportista= ?");
        
            ps.setString(1, t.getNombre());
            ps.setString(2, t.getApellido());
            ps.setString(3, t.getCuit());
            ps.setBoolean(4, t.isEstado());
            ps.setInt(5, id);
        
            int resultado=ps.executeUpdate();
            String mensaje;
            
            if(resultado>0){
                mensaje="Se pudo realizar la modificacion al Tranportista con id: "+id;  
            }else{
                mensaje="No fue capaz de procesarse la modificación";
            }
            
            JOptionPane.showMessageDialog(null, mensaje, "Aviso",JOptionPane.INFORMATION_MESSAGE);
            conx.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex,"ERROR!",JOptionPane.WARNING_MESSAGE);
           // Logger.getLogger(Transportista_Data.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public ArrayList<Transportista> listaTransportistaTodos(){
        ArrayList<Transportista> lista=new ArrayList<>();
        try {
            conx=Conexion.getConexion();
            PreparedStatement ps=conx.prepareStatement("SELECT * FROM `transportista`");
            
            ResultSet rs=ps.executeQuery();
            
            while(rs.next()){
                Transportista t=new Transportista();
                t.setNombre(rs.getString("nombre"));
                t.setApellido(rs.getString("apellido"));
                t.setCuit(rs.getString("cuit"));
                t.setEstado(rs.getBoolean("estado"));
                t.setId(rs.getInt(1));
                lista.add(t);
            }  
            
            conx.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
            Logger.getLogger(Transportista_Data.class.getName()).log(Level.SEVERE, null, ex);
        }
    return lista;}
    
     public ArrayList<Transportista> listaTransportistaActivos(){
        ArrayList<Transportista> lista=new ArrayList<>();
        try {conx=Conexion.getConexion();
            
            PreparedStatement ps=conx.prepareStatement("SELECT * FROM `transportista` WHERE estado= 1");
            
            ResultSet rs=ps.executeQuery();
            
            while(rs.next()){
                Transportista t=new Transportista();
                t.setNombre(rs.getString("nombre"));
                t.setApellido(rs.getString("apellido"));
                t.setCuit(rs.getString("cuit"));
                t.setEstado(rs.getBoolean("estado"));
                t.setId(rs.getInt(1));
                lista.add(t);
            }  
            conx.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
            Logger.getLogger(Transportista_Data.class.getName()).log(Level.SEVERE, null, ex);
        }
    return lista;}

public ArrayList<Transportista> buscarTransportistaPorNombre(String nombre){
        ArrayList<Transportista> lista=new ArrayList<>();
    
        try {conx=Conexion.getConexion();
            PreparedStatement ps=conx.prepareStatement("SELECT * FROM `transportista` WHERE CONCAT (nombre,' ',apellido) LIKE ?");
            ps.setString(1, "%"+nombre+"%");
            
            ResultSet rs=ps.executeQuery();
            
            while(rs.next()){
                Transportista t=new Transportista();
                t.setNombre(rs.getString("nombre"));
                t.setApellido(rs.getString("apellido"));
                t.setCuit(rs.getString("cuit"));
                t.setEstado(rs.getBoolean("estado"));
                t.setId(rs.getInt(1));
                lista.add(t);
            }  
            conx.close();
        } catch (SQLException ex) {
            Logger.getLogger(Transportista_Data.class.getName()).log(Level.SEVERE, null, ex);
        
        }
        
return lista;}


    public Transportista obtenerTransportista(int id){
            Transportista t=new Transportista();
        try {
                conx=Conexion.getConexion();
                PreparedStatement ps=conx.prepareStatement("SELECT * FROM `transportista` WHERE id_transportista= ?");
                ps.setInt(1, id);
                
                ResultSet rs=ps.executeQuery();
                String mensaje;
                if(rs.next()){
                    t.setId(id);
                    t.setNombre(rs.getString("nombre"));
                    t.setApellido(rs.getString("apellido"));
                    t.setCuit(rs.getString("cuit"));
                    t.setEstado(rs.getBoolean(5));
                    
                    
                }
                ps.close();
                conx.close();
                } catch (SQLException ex) {
                    
                    JOptionPane.showMessageDialog(null, ex);
                //Logger.getLogger(Transportista_Data.class.getName()).log(Level.SEVERE, null, ex);
            }
    return t;
    }
} 




