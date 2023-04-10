
package swing;

import Data.GeneradorConsultorio_Data;
import Data.Transportista_Data;
import Entidades.GeneradorConsultorio;
import Entidades.Transportista;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import model.TiposStatus;

public class TablaConStatus extends JTable{
   
   
    public TablaConStatus(){
        
        
        setShowHorizontalLines(true);
        setShowVerticalLines(false);
        setRowHeight(50);
        setGridColor(new Color(0,0,100));    
         
        
        getTableHeader().setReorderingAllowed(false);
        getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer(){
            @Override
            public Component getTableCellRendererComponent(JTable table, Object o, boolean bln, boolean bnl2, int i, int i2) {
            TableHeader cabecera=new TableHeader(o + "");          
               cabecera.setHorizontalAlignment(JLabel.CENTER);  
            return cabecera;
            }});
            setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object o, boolean selected, boolean bnl2, int i, int i2) {
            setRowHeight(30);
                if(i2 != table.getColumnCount()-2){
                   Component com=super.getTableCellRendererComponent(table, o, selected, bnl2, i, i2); 
                   com.setBackground(new Color(215,215,215));
                    setBorder(noFocusBorder);
                    //com.setBackground(Color.WHITE);
                   if(selected){
                       com.setForeground(new Color(185, 136, 232));
                   }else{
                       com.setForeground(new Color(102,102,102));
                   }
                    
                    return com;
                   
               }else{
                    TiposStatus   tipo= (TiposStatus)o;
                   StatusDeCelula celula= new StatusDeCelula(tipo);
                   return celula;
               
            }
            }     
});
            
    }
    public void agregarFila(Object[] fila){
     DefaultTableModel model= (DefaultTableModel) getModel();
     model.addRow(fila);
 }

    
  public void agregarFilasConsultorio(GeneradorConsultorio_Data gcD){
     DefaultTableModel model= (DefaultTableModel) getModel();
      model.setRowCount(0);
  
      for (GeneradorConsultorio consultorio : gcD.listarConsultoriosTodos()) {
          Object[] filas=new Object[4];
        filas[0]=consultorio.getNombre();
        filas[1]=consultorio.getCuit();
        filas[2]=consultorio.getDomicilio();
        if(consultorio.isEstado()){
            filas[3]=TiposStatus.ACTIVO;
        }else{
            filas[3]=TiposStatus.INACTIVO;
        }
         model.addRow(filas);
     
 }
 setModel(model);
}
  
public void agregarTablaTransportistas(Transportista_Data tD){
    DefaultTableModel modeloTabla= (DefaultTableModel) getModel();
    modeloTabla.setRowCount(0);
    
    for (Transportista  transportista : tD.listaTransportistaTodos()) {
        Object [] filas=new Object [6];
        filas[0] =transportista.getId();
        filas[1] =transportista.getNombre();
        filas[2] = transportista.getApellido();
        filas[3] = transportista.getCuit();
        if(transportista.isEstado()){
           filas[4]=TiposStatus.ACTIVO;
    
        }else{
            filas[4]=TiposStatus.INACTIVO;
        }
       modeloTabla.addRow(filas);
    }
    setModel(modeloTabla);
}
  

  
}