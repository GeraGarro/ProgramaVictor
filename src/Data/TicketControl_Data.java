package Data;

import Entidades.Conexion;
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
   private Connection conx; 
   
public TicketControl_Data(){
    this.conx=Conexion.getConexion();    
}

public void agregarTicket(TicketControl tc){
    
       try {
           String sql="INSERT INTO `ticket_control`(`Transportista`, `id_Consultorio`, `Fecha`, `ResiduoTipo`, `ResiduoCant`) VALUES (? ,? ,? ,? ,?)";
           
           
           PreparedStatement ps=conx.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
           
           ps.setString(1,Transportista.TRANSPORTISTA.getNombre() );
           ps.setInt(2, tc.getC1().getId_Consultorio());
           ps.setDate(3, Date.valueOf(tc.getFecha()));
           ps.setString(4, tc.getR1().getTipo());
           ps.setDouble(5, tc.getR1().getPeso());
           
           String mensaje;
           
           int registroNuevo=ps.executeUpdate();
           
           if(registroNuevo>0){
               mensaje="Registro Agregado con Exito";
               
           }
           
           else{
               mensaje="No se Pudo Agregar";
               
           }
           JOptionPane.showMessageDialog(null, mensaje);
       } catch (SQLException ex) {

           JOptionPane.showMessageDialog(null, ex);       }
    
}

public void eliminarTicket(int id_ticket){
      String mensaje;
    try {
           String sql="DELETE FROM `ticket_control` WHERE id_Ticket= ?";
           
           PreparedStatement ps=conx.prepareStatement(sql);
           int datoNuevo=ps.executeUpdate();
           
           if(datoNuevo>0){
               mensaje="Se ha Eliminado el Ticket";
               
           }
           else{
               mensaje="Error al eliminar el ticket";
           }
           
           JOptionPane.showMessageDialog(null, mensaje);
       } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
       }
     
}
 public ArrayList<TicketControl> ListadoTicket() {
      
           ArrayList<TicketControl> lista=new ArrayList<>();
           TicketControl tC=null;
           
           String sql="SELECT * FROM ticket_Control";
           
           PreparedStatement ps=null;
          try {  
           ps=conx.prepareStatement(sql);
           
           ResultSet rs=ps.executeQuery();
           while (rs.next()){
               tC=new TicketControl();
               GeneradorConsultorio_Data gcD=new GeneradorConsultorio_Data();
               
               
           } } catch (SQLException ex) {
           Logger.getLogger(TicketControl_Data.class.getName()).log(Level.SEVERE, null, ex);
       }
   }

}
