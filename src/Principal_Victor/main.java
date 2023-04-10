
package Principal_Victor;

import componentes.jPanel_Certificados;
import componentes.jPanel_Consultorio;
import componentes.jPanel_Residuos;
import componentes.jPanel_Tickets;
import componentes.jPanel_Transportistas;
import eventos.EventosMenuSeleccion;
import java.awt.Color;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;
import javax.swing.JPanel;

public class main extends javax.swing.JFrame {

  
    public main() {
        try {
            initComponents();
            setBackground(new Color(0,0,0,0));
            menu.initMoving(main.this);
            menu.agregarEventoMenuSeleccion(new EventosMenuSeleccion() {
                @Override
                public void seleccion(int index) {
                    switch (index){
                        case 0:
                            setForm(new jPanel_Consultorio());
                            break;
                        case 2:
                        {
                            try {
                                setForm(new jPanel_Tickets());
                            } catch (SQLException ex) {
                                Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        break;
                        
                        case 4:
                            setForm(new jPanel_Certificados());
                            break;
                        case 7:
                            setForm(new jPanel_Residuos());
                            break;
                        case 9:
                            setForm(new jPanel_Transportistas());
                            break;
                    }
                    
                }
            });
            setForm(new jPanel_Tickets());
        } catch (SQLException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

   private void setForm(JComponent com){
       jPanelPrincipal.removeAll();
       jPanelPrincipal.add(com);
       jPanelPrincipal.repaint();
       jPanelPrincipal.revalidate();
   } 
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorde1 = new componentes.PanelBorde();
        menu = new componentes.Menu();
        jPanelPrincipal = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panelBorde1.setBackground(new java.awt.Color(241, 233, 233));
        panelBorde1.setPreferredSize(new java.awt.Dimension(800, 600));

        jPanelPrincipal.setOpaque(false);
        jPanelPrincipal.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout panelBorde1Layout = new javax.swing.GroupLayout(panelBorde1);
        panelBorde1.setLayout(panelBorde1Layout);
        panelBorde1Layout.setHorizontalGroup(
            panelBorde1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorde1Layout.createSequentialGroup()
                .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelBorde1Layout.setVerticalGroup(
            panelBorde1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menu, javax.swing.GroupLayout.DEFAULT_SIZE, 602, Short.MAX_VALUE)
            .addComponent(jPanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorde1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 871, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorde1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 602, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

  
    public static void main(String args[]) {
  
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanelPrincipal;
    private componentes.Menu menu;
    private componentes.PanelBorde panelBorde1;
    // End of variables declaration//GEN-END:variables
}
