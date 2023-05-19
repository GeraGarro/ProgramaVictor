
package swing;

import Data.Certificado_Data;
import Data.GeneradorConsultorio_Data;
import Data.Residuo_Data;
import Data.TicketControl_Data;
import Entidades.CertificadoDisposicionFinal;
import Entidades.GeneradorConsultorio;
import Entidades.Residuo;
import Entidades.TicketControl;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import model.TiposStatus;

public class TablaSinStatus extends JTable{
    private DefaultTableModel tablaModeloResiduo;
    
    public TablaSinStatus(){
        tablaModeloResiduo=new DefaultTableModel();
        
        setShowHorizontalLines(true);
        setShowVerticalLines(false);
        setRowHeight(80);
        setGridColor(new Color(100,100,100));    
         this.setBorder(null);
        this.setIntercellSpacing(new Dimension(0, 0));
        
        getTableHeader().setReorderingAllowed(false);
        getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer(){
            @Override
           public Component getTableCellRendererComponent(JTable table, Object o, boolean bln, boolean bnl2, int i, int i2) {
            TableHeader cabecera=new TableHeader(o + "");          
               cabecera.setHorizontalAlignment(JLabel.CENTER);  
            return cabecera;
            }}
        
        );
        setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object o, boolean selected, boolean bnl2, int i, int i2) {
            setRowHeight(50);
                Component com=super.getTableCellRendererComponent(table, o, selected, bnl2, i, i2); 
                   com.setBackground(new Color(255,255,255));
                   
              DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(JLabel.CENTER);
              
            return com;
            }     
});
        
               
         
    }
    public void agregarFila(Object[] fila){
     DefaultTableModel model= (DefaultTableModel) getModel();
     model.addRow(fila);
 }

  
  public void agregarFilasResiduos(Residuo_Data rD){
     DefaultTableModel modelo= (DefaultTableModel) getModel();
     modelo.setRowCount(0);
     
      for (Residuo residuo : rD.listarResiduosTodos()) {
          Object [] filas=new Object [4];
          filas[0]=residuo.getId_residuo();
          filas[1]=residuo.getTipo().getDescripcion();
          filas[2]=residuo.getPeso();
          filas[3]=residuo.getTk().getId_ticket();         
       modelo.addRow(filas);
      }
      setModel(modelo);
  }

  public void agregarFilasTickets(TicketControl_Data tD) throws SQLException{
      DefaultTableModel modelo= (DefaultTableModel) getModel();
      modelo.setRowCount(0);
      
      for (TicketControl ticket : tD.listaTicketsTodos()) {
          Object[]filas=new Object[4];
          filas[0]=ticket.getId_ticket();
          filas[1]=ticket.getTransportista().getNombre()+" "+ticket.getTransportista().getApellido();
          filas[2]=ticket.getFecha();
          filas[3]=ticket.getConsultorio().getNombre();
          modelo.addRow(filas);
      }
      setModel(modelo);
  }
  
  public void agregarFilasCertificado(Certificado_Data cD) throws SQLException{
      DefaultTableModel modelo=(DefaultTableModel) getModel();
      modelo.setRowCount(0);
      
      for (CertificadoDisposicionFinal certificado : cD.listaCertificados()) {
          Object[]filas=new Object [4];
          filas[0] = certificado.getId_Certificado();
          filas[1] = certificado.getTransportista().getNombre()+" "+certificado.getTransportista().getApellido();
          filas[2] = certificado.getFechaMensual();
          filas[3] = certificado.getTotalPeso();
          
          modelo.addRow(filas);
      }
      setModel(modelo);
  }
}