package swing;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import model.Modelo_menu;

public class Menu_Item extends javax.swing.JPanel {

    private boolean selected;
    private  boolean delante;
    
    public Menu_Item(Modelo_menu data) {
        initComponents();
        setOpaque(false);
        if(data.getTipo()==Modelo_menu.MenuTipo.MENU){
            TIcono.setIcon(data.toIcono());
            TNombre.setText(data.getNombre());
            TNombre.setFont(new Font("Gotham",1 ,12));
        }else if(data.getTipo()==Modelo_menu.MenuTipo.TITULO){
            TIcono.setText(data.getNombre());     
            TIcono.setFont(new Font("FF DIN", 3, 30));
            TNombre.setVisible(false);
        }else{
            TNombre.setText(" ");
            
}
    }

    public void setSelected(boolean selected){
        this.selected=selected;
        repaint();
    }
    
    public void setDelante(boolean delante){
        this.delante=delante;
        repaint();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TIcono = new javax.swing.JLabel();
        TNombre = new javax.swing.JLabel();

        TIcono.setForeground(new java.awt.Color(255, 255, 255));

        TNombre.setForeground(new java.awt.Color(255, 255, 255));
        TNombre.setText("Nombre Menu");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(TIcono)
                .addGap(18, 18, 18)
                .addComponent(TNombre)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TIcono, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(TNombre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected void paintComponent(Graphics grphcs) {
        if(selected || delante){
             Graphics2D g2=(Graphics2D)grphcs;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            if(selected){
                g2.setColor(new Color(0, 0, 0,100));
            }else{               
                   g2.setColor(new Color(0, 0, 0,20));
            
            }
            g2.fillRoundRect(10, 0, getWidth()-15, getHeight(), 5, 5); 
        }       
        
        super.paintComponent(grphcs);
    }

 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel TIcono;
    private javax.swing.JLabel TNombre;
    // End of variables declaration//GEN-END:variables
}
