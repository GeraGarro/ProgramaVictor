
package swing;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;


public class AccionCeldaEnTabla2 extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
      Component com=super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
      PanelAcciones2 accion= new PanelAcciones2();
      if(isSelected == false && row % 2 == 0 ){
          accion.setBackground(Color.WHITE);
      }else{
          accion.setBackground(com.getBackground());
      }
      
      return accion;
    }
    
    
}
