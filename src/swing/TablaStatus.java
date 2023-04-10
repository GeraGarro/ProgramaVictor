
package swing;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JLabel;
import model.TiposStatus;

public class TablaStatus extends JLabel {   

    /**
     * @return the tipo
     */
    public TiposStatus getTipo() {
        return tipo;
    }
    
    public TablaStatus(){
        setForeground(Color.WHITE);
        
    }
    
    private TiposStatus tipo;
    public void setTipo(TiposStatus tipo){
        this.tipo=tipo;
        setText(tipo.toString());
        repaint();
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
       if(tipo != null){
            Graphics2D g2=(Graphics2D)grphcs;
       g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
       GradientPaint g;
       if(tipo==TiposStatus.ACTIVO){
          g=new GradientPaint(0, 0, Color.GREEN, 0, getHeight(), new Color(107, 236, 18));
       }else {
           g=new GradientPaint(0, 0, Color.GRAY, 0, getHeight(), new Color(210,210,210));
       }
       g2.setPaint(g);
       g2.fillRoundRect(0, 0, getWidth()-3, getHeight(), 10,10);
        
      
       }
        
       super.paintComponent(grphcs);
        
    }
    
    
    
}
