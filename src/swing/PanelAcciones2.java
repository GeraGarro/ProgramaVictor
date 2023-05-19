
package swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class PanelAcciones2 extends javax.swing.JPanel {


    public PanelAcciones2() {
        initComponents();
    }

    public void inicioEvento2(TablaAccionEvento2 event, int row){
        botonEdicion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                event.onEdit(row);
            }
        });
               
        
          botonImprimir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                event.onPrint(row);
            }
        });
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botonEdicion = new swing.BotonEnTabla();
        botonImprimir = new swing.BotonEnTabla();

        setLayout(new java.awt.GridLayout(1, 0));

        botonEdicion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconosAccion/edicion.png"))); // NOI18N
        botonEdicion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEdicionActionPerformed(evt);
            }
        });
        add(botonEdicion);

        botonImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconosAccion/imprimir.png"))); // NOI18N
        add(botonImprimir);
    }// </editor-fold>//GEN-END:initComponents

    private void botonEdicionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEdicionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonEdicionActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.BotonEnTabla botonEdicion;
    private swing.BotonEnTabla botonImprimir;
    // End of variables declaration//GEN-END:variables
}
