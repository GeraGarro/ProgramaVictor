
package swing;

import com.sun.corba.se.impl.orbutil.CorbaResourceUtil;
import java.awt.Color;
import java.awt.Component;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import java.awt.Scrollbar;
import java.util.EventListener;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.BasicComboPopup;
import javax.swing.plaf.basic.ComboPopup;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;


public class ComboBox<E> extends JComboBox<E>{

   
    public String getLabelText() {
        return labelText;
    }

   
    public void setLabelText(String labelText) {
        this.labelText = labelText;
    }

    
    public Color getLineaColor() {
        return LineaColor;
    }

    
    public void setLineaColor(Color LineaColor) {
        this.LineaColor = LineaColor;
    }
    
    
    
    private String labelText="Doctor";
    private Color LineaColor=new Color(3,155,216);
    private boolean mouseEncima;
    
    public ComboBox() {
        setBackground(Color.WHITE);
        setBorder(new EmptyBorder(5, 10, 5, 10));
        setUI(new ComboUI(this));
        setRenderer(new DefaultListCellRenderer(){
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                Component com= super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus); 
                setBorder(new EmptyBorder(5,5,5,5) );
                
                if(isSelected){
                    com.setBackground(new Color(240,240,240));
                }
            return com;
            }
         
        });
    }
    
    private class ComboUI extends BasicComboBoxUI{
        
          private final Animator animator;
          private boolean animacionEnTexto=true;
          private float localizacion;
          private boolean show;
          private ComboBox combo;
        public ComboUI(ComboBox combo){
            this.combo=combo;
            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent me) {
                    mouseEncima=true;
                    repaint();
                }

                @Override
                public void mouseExited(MouseEvent e) {
                   mouseEncima=false;
                   repaint();
                }
 
            });
            
            addFocusListener(new FocusAdapter() {
                @Override
                public void focusGained(FocusEvent e) {
                      showing(false);
                }

                @Override
                public void focusLost(FocusEvent e) {
                    showing(true);
                }
            });
            
            addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {
                if(!isFocusOwner()){
                    if(getSelectedIndex()==-1){
                        showing(true);
                    }else{
                        showing(false);
                    }
                }
                
                }
            });
            
            addPopupMenuListener(new PopupMenuListener() {
                @Override
                public void popupMenuWillBecomeVisible(PopupMenuEvent pe) {
               arrowButton.setBackground(new Color(200,200,200));
                
                }

                @Override
                public void popupMenuWillBecomeInvisible(PopupMenuEvent pe) {
                                arrowButton.setBackground(new Color(150,150,150));

                }

                @Override
                public void popupMenuCanceled(PopupMenuEvent pe) {
                               arrowButton.setBackground(new Color(150,150,150));

                }
            });
            
            
            TimingTarget target =new TimingTargetAdapter(){
                @Override
                public void begin() {
                    animacionEnTexto=getSelectedIndex() == -1;
                }
                
                @Override
                public void timingEvent(float fraccion){
                    localizacion=fraccion;
                    repaint();
                }
            };
            animator=new Animator(300, target);
            animator.setResolution(0);
            animator.setAcceleration(0.5f);
            animator.setDeceleration(0.5f);
        }
         @Override
        public void paintCurrentValueBackground(Graphics g, Rectangle bounds, boolean hasFocus) {
        
        
        }

        @Override
        protected JButton createArrowButton() {
            return new ArrowButton();
                    }

        @Override
        protected ComboPopup createPopup() {
            BasicComboPopup pop=new BasicComboPopup(comboBox){
                @Override
                protected JScrollPane createScroller() {
                    list.setFixedCellHeight(25);
                    JScrollPane scroll= new JScrollPane (list);
                    scroll.setBackground(Color.WHITE);
                    //Scrollbarcusto
                    //scroll.setVerticalScrollBar(sb);
                    return scroll;
                
                }
            
            };
            pop.setBorder(new LineBorder(new Color(200,200,200), 1));
            return pop;
        }
        
       
        
        @Override
        public void paint(Graphics g,JComponent jc) {
            super.paint(g,jc); 
            Graphics2D g2= (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            int width=getWidth();
            int heigth=getHeight();
            if(mouseEncima){
                g2.setColor(LineaColor);
            }else{
                g2.setColor(new Color(150,150,150));
                
            }
            g2.fillRect(2, heigth - 1, width - 4, 1);
            createHintText(g2);
            createLineStyle(g2);
            g2.dispose();
        
        }
        
        private void createHintText(Graphics g){
            Insets in=getInsets();
            g.setColor(new Color(150,150,150));
            FontMetrics ft=g.getFontMetrics();
            Rectangle2D r2=ft.getStringBounds(combo.getLabelText(), g);
            double height= getHeight() - in.top - in.bottom;
            double textY= (height - r2.getHeight()) /2;
            double size;
            if(animacionEnTexto){
                if(show){
                    size= 18*(1 - localizacion);
                }else{
                    size= 18 * localizacion;
                } 
            }else {
              size=18;
             }
            g.drawString(combo.getLabelText(), in.right,(int) (in.top + textY + ft.getAscent() - size));
        }
        
        private void createLineStyle(Graphics2D g){
            if(isFocusOwner()){
                double width= getWidth() - 4 ;
                int heigth = getHeight();
                g.setColor(LineaColor);
                double size;
                if(show){
                    size= width * (1 - localizacion);
                    
                } else{
                    size=width * localizacion;
                }
                
                double x= (width - size) / 2;
                g.fillRect((int) (x+2), heigth - 2, (int) size, 2);
            }
        }
        
        private void showing(boolean accion){
            if(animator.isRunning()){
            animator.stop();
        }else{
                localizacion=1;
            }
        animator.setStartFraction(1f - localizacion);
        show=accion;
        localizacion=1f - localizacion;
        animator.start();
        }
private class ArrowButton extends JButton{
    public ArrowButton(){
        setContentAreaFilled(false);
        setBorder(new EmptyBorder(5, 5, 5, 5));
        setBackground(new Color(150,150,150));
        
    }

            @Override
            public void paint(Graphics g) {
                super.paint(g); 
            Graphics2D g2=(Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
           int width=getWidth();
           int heigth=getHeight();
           int size=10;
           int x=(width-size)/2;
           int y =(heigth - size)/2 + 2;
           int px[]={x,x+size,x+size/2};
           int py[]={y,y,y+size};
            g2.setColor(getBackground());
            g2.fillPolygon(py, py, px.length);
            g2.dispose();
            }  
        }
      
    }
    
}
