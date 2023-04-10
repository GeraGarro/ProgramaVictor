
package swing;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;


public class TableHeader extends JLabel{

    public TableHeader(String text) {
        super(text);
        setOpaque(true);
        setBackground(Color.WHITE);
        setFont(new Font("Malgun Gothic",1,11));
        setForeground(new Color(102,102,102));
        setBorder(new EmptyBorder(10, 5, 10, 5) );
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Shape clip = new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), 20, 20);
        g.setClip(clip);
        g.setColor(new Color(200,200,215) );
        g.drawLine(0, getHeight()-5, getWidth(), getWidth()-5);
        
    }
    
    
    
    
    
    
}
