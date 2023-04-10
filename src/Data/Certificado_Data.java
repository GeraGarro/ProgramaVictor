package Data;

import Entidades.CertificadoDisposicionFinal;
import Entidades.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class Certificado_Data {
    private Connection conx;
    private TicketControl_Data tk_Data;
    private Transportista_Data tD;
    
public Certificado_Data(){
  this.conx=Conexion.getConexion();
  this.tk_Data=new TicketControl_Data();
  this.tD=new Transportista_Data();
}    

public void generarNuevoCertificado(CertificadoDisposicionFinal c) throws SQLException{
        PreparedStatement ps=null;
        PreparedStatement ps2=null;
        PreparedStatement ps3=null;
        PreparedStatement ps4=null;
        
        int id_transportista;
        LocalDate periodoComp;
        
    
    try {
          ps=conx.prepareStatement("INSERT INTO certificado (id_transportista, totalPeso, periodo) VALUES (?, ?, ?)",Statement.RETURN_GENERATED_KEYS);
          ps.setInt(1,c.getTransportista().getId());
          ps.setNull(2, Types.FLOAT);
          ps.setDate(3, java.sql.Date.valueOf(c.getFechaMensual()));
                         
          if(ps.executeUpdate()>0){
            JOptionPane.showMessageDialog(null, "Se ha logrado Generar un nuevo Certificado");
          }
          
          ps.close();
          int id_certificado=-1;
          ResultSet rs=ps.getGeneratedKeys();
          
          if(rs.next()){
              id_certificado=rs.getInt(1);
          }
          
          
          id_transportista=c.getTransportista().getId();
          periodoComp=c.getFechaMensual();
          
        
          
          ps2=conx.prepareStatement("SELECT `id_Ticket` FROM `ticket_control` WHERE id_transportista= ? AND DATE_FORMAT(Fecha, '%Y-%m') = DATE_FORMAT( ?, '%Y-%m')");
          System.out.println(id_transportista);
          ps2.setInt(1, id_transportista);
          ps2.setDate(2, java.sql.Date.valueOf(periodoComp));
          
          ResultSet rs2=ps2.executeQuery();
          
          while(rs2.next()){
              int id_tk=rs2.getInt("id_Ticket");
              ps3=conx.prepareStatement("INSERT INTO `ticket_en_certificado` (id_Certificado, id_Ticket) VALUES ( ?, ?)");
              ps3.setInt(1, id_certificado);
              ps3.setInt(2, id_tk);
              ps3.executeUpdate();
              ps3.close();
              
              
          }
          
          ps4=conx.prepareStatement("SELECT `id_Ticket` FROM `ticket_en_certificado` WHERE id_Certificado= ?");
          ps4.setInt(1, id_certificado);
          
         ResultSet rs_listaId= ps4.executeQuery();
         
      
         
        float pesoTotal = 0;
            while (rs_listaId.next()) {
                int id_tk = rs_listaId.getInt("id_Ticket");
               
                ps3 = conx.prepareStatement("SELECT SUM(r.peso) AS peso_total FROM residuo r JOIN ticket_control tc ON r.id_ticket = tc.id_ticket WHERE tc.id_Ticket= ?");
                ps3.setInt(1, id_tk);

                ResultSet rs_peso = ps3.executeQuery();

                if (rs_peso.next()) {
                    pesoTotal += rs_peso.getFloat("peso_total");
                   
                }
            }
         
          
          ps=conx.prepareStatement("UPDATE `certificado` SET `TotalPeso`= ? WHERE id_certificado= ?");
          ps.setFloat(1, pesoTotal);
          ps.setInt(2, id_certificado);
          ps.executeUpdate();
        } catch (SQLException ex) {
            //SI OCURRE UN ERROR SE DESHACE LA PETICION Y MUESTRAR EL ERROR DE CONEXION
            if(conx != null){
                JOptionPane.showMessageDialog(null, "Error de Comunicación con la base de Datos","Erro",JOptionPane.WARNING_MESSAGE);
                JOptionPane.showMessageDialog(null, ex.getMessage());
                Logger.getLogger(Certificado_Data.class.getName()).log(Level.SEVERE, null, ex);
            }  
        }
    finally{
        //SE FINALIZAN LA CONEXION Y EL PREPAREDSTATEMENT
        if(ps !=null && ps2!=null && ps3 !=null && ps4 != null){
            ps.close();
            ps2.close();
            ps3.close();
            ps4.close();
        }
        if(conx != null){
            conx.close();
        }
    }
}

public ArrayList<CertificadoDisposicionFinal> listaCertificados(){
        ArrayList<CertificadoDisposicionFinal> lista=new ArrayList<>();
    try {
            PreparedStatement ps=conx.prepareStatement("SELECT * FROM certificado");
            ResultSet rs=ps.executeQuery();
            
            while(rs.next()){
                CertificadoDisposicionFinal cDF=new CertificadoDisposicionFinal();
                cDF.setId_Certificado(rs.getInt(1));
                cDF.setTransportista(tD.obtenerTransportista(rs.getInt(2)));
                cDF.setFechaMensual(rs.getDate(3).toLocalDate());
                cDF.setTotalPeso(rs.getInt("TotalPeso"));
                
                lista.add(cDF);
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
            //Logger.getLogger(Certificado_Data.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
return lista;}
}
