
package componentes;

import java.awt.Color;


public class Emergente2 extends javax.swing.JFrame {

    
    public Emergente2() {
        initComponents();
        setBackground(new Color(0,0,0,0));
        panelEmergente.setBackground(new Color(108, 14, 169 ));
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelEmergente = new componentes.PanelBorde();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jLabel1.setText("jLabel1");

        javax.swing.GroupLayout panelEmergenteLayout = new javax.swing.GroupLayout(panelEmergente);
        panelEmergente.setLayout(panelEmergenteLayout);
        panelEmergenteLayout.setHorizontalGroup(
            panelEmergenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEmergenteLayout.createSequentialGroup()
                .addGap(202, 202, 202)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(198, Short.MAX_VALUE))
        );
        panelEmergenteLayout.setVerticalGroup(
            panelEmergenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEmergenteLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(334, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelEmergente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelEmergente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

 
    public static void main(String args[]) {
     
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Emergente2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private componentes.PanelBorde panelEmergente;
    // End of variables declaration//GEN-END:variables
}
