
package swing;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Path2D;
import java.awt.image.BufferedImage;
import javax.swing.JButton;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

public class boton extends JButton {

    
    public Color getColor1() {
        return color1;
    }

   
    public void setColor1(Color color1) {
        this.color1 = color1;
    }

    
    public Color getColor2() {
        return color2;
    }

    
    public void setColor2(Color color2) {
        this.color2 = color2;
    }
    
    
    private Color color1=Color.decode("#1488CC");
    private Color color2=Color.decode("#2B32B2");
    private final Timer timer;
    private final Timer  tiempoPresionado;
    private float alpha=0.3f;
    private boolean mouseEncima;
    private boolean presionado;
    private Point localizacionPresionado;
    private float  tamañoPresionado;
    private float  alphaPresionado=1f;
    private float tamañoVelocidad=0.5f;
    
    public boton() {
        setContentAreaFilled(false);
        setBorder(new EmptyBorder(10, 20, 10, 20));
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setForeground(Color.WHITE);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
               mouseEncima=true;
               timer.start();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                mouseEncima=false;
               timer.start();
            }

            @Override
            public void mousePressed(MouseEvent e) {
            tamañoPresionado=0;
            alphaPresionado=0.5f;
            presionado=true;
            localizacionPresionado=e.getPoint();
            tiempoPresionado.setDelay(0);
            tiempoPresionado.start();
            }});
        
            timer=new Timer(40,new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mouseEncima){
                    if(alpha<0.6f){
                     alpha+= 0.08f;
                     repaint();
                    }else{
                        alpha=0.6f;
                        timer.stop();
                        repaint();
                    }
                          
                }else{
                    if(alpha>0.5f){
                        alpha-=0.08f;
                        repaint();
                    }else{
                        alpha=0.3f;
                        timer.stop();
                        repaint();
                    }
                }
            }
            });
        tiempoPresionado=new Timer(0,new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                    tamañoPresionado += getTamañoVelocidad();
                    if(alphaPresionado<=0){
                      presionado=false;
                      tiempoPresionado.stop();
                    }else{
                        repaint();
                    }
            }
        });    
        
    }   

    

    @Override
    protected void paintComponent(Graphics g) {
        int width=getWidth();
        int height=getHeight();
        BufferedImage img=new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2=img.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
       
        GradientPaint gra= new GradientPaint(0, 0, getColor1(), width, 0, getColor2());
          g2.setPaint(gra);
        g2.fillRoundRect(0, 0, width, height, height, height);
        creadoEstilo(g2);
        if(presionado){
            PintadoPresionado(g2); 
        }
        g2.dispose();
        g.drawImage(img, 0, 0, null);
        super.paintComponent(g);
}
    
   private void creadoEstilo(Graphics2D g2){
       g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, alpha));
       int width=getWidth();
       int height=getHeight();
       GradientPaint gra= new GradientPaint(0, 0, Color.WHITE, 0,height, new Color(255,255,255,50));
          g2.setPaint(gra);
       Path2D.Float f=new Path2D.Float();
       f.moveTo(0, 0);
       int control1= height+height/2;
       f.curveTo(0, 0, width/2, control1, width, 0);
       g2.fill(f);
   } 
  
   private void PintadoPresionado(Graphics2D g2){
       if(localizacionPresionado.x -(tamañoPresionado/2)<0&&localizacionPresionado.x + (tamañoPresionado/2)>getWidth()){
           tiempoPresionado.setDelay(20);
           alphaPresionado -= 0.05f;
           if(alphaPresionado < 0){
               alphaPresionado=0;
           }   
       }
         g2.setColor(new Color(16, 47, 144 ));
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, alphaPresionado));
           float x=localizacionPresionado.x - (tamañoPresionado/2);
           float y= localizacionPresionado.y- (tamañoPresionado/2);
       g2.fillOval((int)x,(int) y,(int) tamañoPresionado,(int) tamañoPresionado);
   }

    
    public float getTamañoVelocidad() {
        return tamañoVelocidad;
    }

  
    public void setTamañoVelocidad(float tamañoVelocidad) {
        this.tamañoVelocidad = tamañoVelocidad;
    }
}