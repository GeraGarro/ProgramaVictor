
package calendar;

import java.awt.Color;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JLabel;


public class celula extends JButton{

    
    private Date date;
    private boolean titulo;
    
    public celula() {
        setContentAreaFilled(false);
        setBorder(null);
        setHorizontalAlignment(JLabel.CENTER);
    }
    
    public void comoTitulo(){
        titulo=true;
    }
    
    public boolean esTitulo(){
        return titulo;
    }
    
    public void recorridoMes(boolean act){
        if(act){
            setForeground(new Color(68,68,68));
        }else {
            setForeground(new Color(169,169,169));
        }
    }
}
