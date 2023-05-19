package Data;

import Entidades.Conexion;
import Entidades.Residuo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Residuo_Data {
    private Connection conx;
    private TipoResiduo_Data tR_Data;
    private TicketControl_Data tk_Data;
    
    public Residuo_Data(){
       
        this.tR_Data=new TipoResiduo_Data();
        this.tk_Data=new TicketControl_Data();
    }
  
    public void agregarResiduo(Residuo r){
        
        try {
            conx=Conexion.getConexion();
            String sql="INSERT INTO `residuo`( `id_tipoResiduo`, `peso`, `id_Ticket`, `estado`) VALUES ( ?, ?, ?, ?)";
            
            PreparedStatement ps= conx.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            
            ps.setInt(1, r.getTipo().getId_TipoResiduo());
            ps.setFloat(2, r.getPeso());
            ps.setInt(3, r.getTk().getId_ticket());
            ps.setBoolean(4, r.isEstado());
            
            String mensaje;
            
            if(ps.executeUpdate()>0){
                mensaje="Se pudo Agregar el registro Residuo";
                
            }
            else{
             mensaje="No se pudo realizar el registro del nuevo Residuo";
             
            }
            
            JOptionPane.showMessageDialog(null, mensaje);
            ps.close();
            conx.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Conexion Erronea, no existe el ticket Control para relacionar con el objeto residuo", "Alerta", JOptionPane.WARNING_MESSAGE);
            //Logger.getLogger(Residuo_Data.class.getName()).log(Level.SEVERE, null, ex);
          
            
        }
             
    }
    
    public ArrayList<Residuo> buscarResiduoPorTipo(String nombreTipo){
        ArrayList<Residuo> lista= new ArrayList<>();
        try {conx=Conexion.getConexion();
           
            
            String sql="SELECT *\n" +
"FROM residuo\n" +
"WHERE id_tipoResiduo  IN (\n" +
"  SELECT id_tipoResiduo\n" +
"  FROM tiporesiduo\n" +
"  WHERE descripcion LIKE ?\n" +
");";
            
            PreparedStatement ps=conx.prepareStatement(sql);
            
            ps.setString(1, "%"+nombreTipo+"%");
            
            ResultSet rs=ps.executeQuery();
            
            
                while(rs.next()){
                Residuo r=new Residuo();
                r.setId_residuo(rs.getInt(1));
                r.setTipo(tR_Data.ObtenerTipoResiduo(rs.getInt("id_tipoResiduo")));
                r.setPeso(rs.getFloat("peso"));
                r.setTk(tk_Data.obtenerTicket(rs.getInt("id_Ticket")));
                r.setEstado(rs.getBoolean("estado"));
                
                lista.add(r);
                }
                
            ps.close();
            conx.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex,"!AVISO error con la Base de Datos", JOptionPane.WARNING_MESSAGE);
           // Logger.getLogger(Residuo_Data.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
   return lista;
    }

    public void eliminarResiduo(int id_residuo){
        try {conx=Conexion.getConexion();
            PreparedStatement ps=conx.prepareStatement("DELETE FROM `residuo` WHERE id_residuo= ?");
            
            ps.setInt(1, id_residuo);
            String mensaje;
            if(ps.executeUpdate()>0){
                mensaje="Se realizo la eliminación del residuo con id:"+id_residuo;
            }else{
                mensaje="No se realizaron cambios";
            }
            JOptionPane.showMessageDialog(null, mensaje, "Atencion", JOptionPane.INFORMATION_MESSAGE);
            ps.close();
            conx.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de conexion con Base de datos");
            JOptionPane.showMessageDialog(null, ex);
            //Logger.getLogger(Residuo_Data.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public ArrayList<Residuo> listarResiduosTodos(){
        ArrayList<Residuo> lista= new ArrayList<>();
        try {conx=Conexion.getConexion();
            PreparedStatement ps=conx.prepareStatement("SELECT * FROM `residuo`");
            
            ResultSet rs= ps.executeQuery();
            
            while(rs.next()){
                Residuo r=new Residuo();
                r.setId_residuo(rs.getInt(1));
                r.setTipo(tR_Data.ObtenerTipoResiduo(rs.getInt("id_TipoResiduo")));
                r.setPeso(rs.getFloat(3));
                r.setTk(tk_Data.obtenerTicket(rs.getInt("id_Ticket")));
                
                
                lista.add(r);
                ps.close();
                conx.close();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la conexion con la base de datos");
            JOptionPane.showMessageDialog(null, ex);
          
            //Logger.getLogger(Residuo_Data.class.getName()).log(Level.SEVERE, null, ex);
        }
    return lista;}
    
     public ArrayList<Residuo> listarResiduosActivos(){
        ArrayList<Residuo> lista= new ArrayList<>();
        try {conx=Conexion.getConexion();
            conx=Conexion.getConexion();
            PreparedStatement ps=conx.prepareStatement("SELECT * FROM `residuo` WHERE estado= ?");
            
            ps.setBoolean(1, true);
            
            ResultSet rs= ps.executeQuery();
            
            while(rs.next()){
                Residuo r=new Residuo();
                r.setId_residuo(rs.getInt(1));
                r.setTipo(tR_Data.ObtenerTipoResiduo(rs.getInt("id_TipoResiduo")));
                r.setPeso(rs.getFloat(3));
                r.setTk(tk_Data.obtenerTicket(rs.getInt("id_Ticket")));
                r.setEstado(rs.getBoolean(5));
                
                lista.add(r);
                
            }
            ps.close();
            conx.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la conexion con la base de datos");
            JOptionPane.showMessageDialog(null, ex);
          
            //Logger.getLogger(Residuo_Data.class.getName()).log(Level.SEVERE, null, ex);
        }
    return lista;
     }
     
     public void modificarResiduo(Residuo r, int id_residuo){
         
        try {conx=Conexion.getConexion();
            PreparedStatement ps=conx.prepareStatement("UPDATE `residuo` SET "                   
                    + "id_TipoResiduo= ?,"
                    + "peso= ?,"
                    + "id_Ticket= ?,"
                    + "estado= ?"
                    + " WHERE id_Residuo= ?");
            
            ps.setInt(5, id_residuo);
            ps.setInt(1, r.getTipo().getId_TipoResiduo());
            ps.setFloat(2, r.getPeso());
            ps.setInt(3, r.getTk().getId_ticket());
            ps.setBoolean(4, r.isEstado());
            
            String mensaje;
            if(ps.executeUpdate()>0){
                mensaje="Se realizó exitosamente la modificación";
            }else{
                mensaje="No pudo realizarse la modificación solicitada";
            }
            
            JOptionPane.showMessageDialog(null, mensaje);
            ps.close();
            conx.close();
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, "Error de conexion con la base de datos", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            JOptionPane.showMessageDialog(null, ex);
            Logger.getLogger(Residuo_Data.class.getName()).log(Level.SEVERE, null, ex);
        }
         
     }
}
