
package swing;

import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;


public class AccionTablaEditar  extends DefaultCellEditor{

    private TablaAccionEvento evento;
    
    
    public AccionTablaEditar(TablaAccionEvento evento) {
        super(new JCheckBox());
        this.evento=evento;
    }


    
    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        PanelAcciones accion=new PanelAcciones();
       
        accion.inicioEvento(evento, row);
      
        accion.setBackground(table.getSelectionBackground());
        return accion;

    }
  
    
    
}
