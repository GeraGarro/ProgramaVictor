package Data;

import Entidades.Conexion;
import Entidades.Residuo;
import Entidades.TicketControl;
import Entidades.Transportista;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class TicketControl_Data {
   
   private Transportista_Data t_Data;
   private GeneradorConsultorio_Data g_Data;
   private Connection conx;
   
public TicketControl_Data(){     
   this.t_Data=new Transportista_Data();
   this.g_Data=new GeneradorConsultorio_Data();
}

public void CrearTicketControl(TicketControl tC){
            
                try {
              conx=Conexion.getConexion();
           PreparedStatement ps=conx.prepareStatement("INSERT INTO `ticket_control`(`id_transportista`, `Fecha`, `id_Consultorio`) VALUES ( ?, ?, ?)");
           
           ps.setInt(1, tC.getTransportista().getId());        
           ps.setDate(2, java.sql.Date.valueOf(tC.getFecha()));  
         ps.setInt(3, tC.getConsultorio().getId_Consultorio());
           
           String mensaje;
           if(ps.executeUpdate()>0){
               mensaje="Nuevo Ticket Generado";
   
           }else{
            mensaje="No fue posible generar el ticket";   
           }
           
           JOptionPane.showMessageDialog(null, mensaje, "AVISO", JOptionPane.INFORMATION_MESSAGE);
       } catch (SQLException ex) {
           
           JOptionPane.showMessageDialog(null, "Error De Conexion, no fue posible establecer conexion con la Base de datos");
           JOptionPane.showConfirmDialog(null, ex);
         //  Logger.getLogger(TicketControl_Data.class.getName()).log(Level.SEVERE, null, ex);
       }   
    }

    public TicketControl obtenerTicket(int id){
        TicketControl tc=new TicketControl();
        
       try {
           conx=Conexion.getConexion();
           
           PreparedStatement ps;
               
           ps = conx.prepareStatement("SELECT * FROM `ticket_control` WHERE id_Ticket= ?");
           
           ps.setInt(1, id);
           
           ResultSet rs=ps.executeQuery();
           
           if(rs.next()){
              
               tc.setId_ticket(rs.getInt("id_Ticket"));
               tc.setTransportista(t_Data.obtenerTransportista(rs.getInt("id_transportista")));
               tc.setFecha(rs.getDate("Fecha").toLocalDate());
              tc.setConsultorio(g_Data.obtenerGeneradorConsultorio(rs.getInt("id_Consultorio")));
               
           }else{
               JOptionPane.showMessageDialog(null, "No existe el ticket solicitado","Atención", JOptionPane.WARNING_MESSAGE);
           }
           
       } catch (SQLException ex) {
           Logger.getLogger(TicketControl_Data.class.getName()).log(Level.SEVERE, null, ex);
       }
    return tc; 
    }
    
    public void eliminarTicket(int id_ticket) throws SQLException{
        
        PreparedStatement ps_deleteResiduos=null;
        PreparedStatement ps_deleteTicket=null;
        
        try {
            conx=Conexion.getConexion();
           conx.setAutoCommit(false);
           
           ps_deleteResiduos=conx.prepareStatement("DELETE FROM residuo WHERE id_Ticket= ? ");
           ps_deleteResiduos.setInt(1, id_ticket);
           ps_deleteResiduos.executeUpdate();
           
           ps_deleteTicket=conx.prepareStatement("DELETE FROM ticket_control WHERE id_Ticket= ?");
           ps_deleteTicket.setInt(1, id_ticket);
           ps_deleteTicket.executeUpdate();
           
           conx.commit();
           
           JOptionPane.showMessageDialog(null, "Se Elimino correctamente El Ticket N°:"+id_ticket+" con sus respectivos residuos");
       } catch (SQLException ex) {
           if(conx != null){
               conx.rollback();
           }
             JOptionPane.showMessageDialog(null, "Error al eliminar el ticket","Aviso", JOptionPane.WARNING_MESSAGE);
           // JOptionPane.showMessageDialog(null, "Esta intentando eliminar un ticket Asociado a un Certificado","Aviso", JOptionPane.WARNING_MESSAGE);

             JOptionPane.showMessageDialog(null, ex.getMessage());
           Logger.getLogger(TicketControl_Data.class.getName()).log(Level.SEVERE, null, ex);
       }
       finally{
             if (ps_deleteResiduos != null && ps_deleteTicket != null) {
        ps_deleteResiduos.close();
        ps_deleteTicket.close();
    }
    if (conx != null) {
        conx.close();
    }
       }
    }
    
    public ArrayList<TicketControl> listaTicketsTodos() throws SQLException{
        ArrayList <TicketControl> lista=new ArrayList<>();
        
        PreparedStatement ps=null;
        try {
            conx=Conexion.getConexion();
            ps=conx.prepareStatement("SELECT * FROM `ticket_control`");
            
            ResultSet rs=ps.executeQuery();
            
            while(rs.next()){
                TicketControl tk=new TicketControl();
                tk.setId_ticket(rs.getInt("id_Ticket"));
                tk.setFecha(rs.getDate("Fecha").toLocalDate());
                tk.setConsultorio(g_Data.obtenerGeneradorConsultorio(rs.getInt(4)));
                tk.setTransportista(t_Data.obtenerTransportista(rs.getInt(2)));
                
                lista.add(tk);
            }
                     
        } catch (SQLException ex) {
            if(conx != null){
              JOptionPane.showMessageDialog(null, "Error Con la Conexion", "!AVISO", JOptionPane.WARNING_MESSAGE); 
              JOptionPane.showMessageDialog(null, ex.getMessage());
            }
           
        }
        finally{
            if(ps != null){
            ps.close();
        }
            if(conx != null){
                conx.close();
            }
        }
   return lista; }
    
    
    public void modificarTicket(TicketControl tk,int id_tk,Connection conx) throws SQLException{
      PreparedStatement ps= null;
        
        try {
           ps=conx.prepareStatement("UPDATE `ticket_control` SET `id_transportista`=?, `Fecha`= ?, id_consultorio= ? WHERE id_Ticket= ?");
           
           ps.setInt(1, tk.getTransportista().getId());
           ps.setDate(2, java.sql.Date.valueOf(tk.getFecha()));
           ps.setInt(3, tk.getConsultorio().getId_Consultorio());
           ps.setInt(4, id_tk);
           
           String m;
           if(ps.executeUpdate()>0){
               m="Se ha realizado la modificacion";
           }else{
               m="No fue posible realizar cambios";
           }
       
           JOptionPane.showMessageDialog(null, m, "Aviso", JOptionPane.INFORMATION_MESSAGE);
       
       } catch (SQLException ex) {
            // Si hay un error, se deshace la transacción y se muestra el error
           if(conx != null){
               JOptionPane.showMessageDialog(null, "No fue Posible establecer la conexion y realizar la modificación", "Error", JOptionPane.WARNING_MESSAGE);
               JOptionPane.showMessageDialog(null, ex.getMessage());
           }
         //  Logger.getLogger(TicketControl_Data.class.getName()).log(Level.SEVERE, null, ex);
       }
       finally{
           // Se cierra la conexión y el objeto PreparedStatement
           if(ps != null){
               ps.close();
           }
           if(conx != null){
               conx.close();
           }
       }
    }
    
    
}
