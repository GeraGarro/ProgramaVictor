
package swing;

import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;


public class AccionTablaEditar2  extends DefaultCellEditor{

    private TablaAccionEvento2 evento;
    
    
    public AccionTablaEditar2(TablaAccionEvento2 evento) {
        super(new JCheckBox());
        this.evento=evento;
    }


    
    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        PanelAcciones2 accion2=new PanelAcciones2();
       
        accion2.inicioEvento2(evento, row);
      
        accion2.setBackground(table.getSelectionBackground());
        return accion2;

    }
  
    
    
}
