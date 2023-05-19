
package Principal_Victor;

import Entidades.Conexion;
import componentes.Emergente;
import componentes.jPanel_Certificados;
import componentes.jPanel_Consultorio;
import componentes.jPanel_Consultorio;
import componentes.jPanel_Residuos;
import componentes.jPanel_Tickets;
import componentes.jPanel_Transportistas;
import eventos.EventosMenuSeleccion;
import java.awt.Color;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;
import javax.swing.JPanel;

public class main extends javax.swing.JFrame {
    private Connection conx;
    private boolean estaActivo=true;
    public main() {
        try {
            initComponents();
            setBackground(new Color(0,0,0,0));
            menu.initMoving(main.this);
            Connection conx = Conexion.getConexion();
            main instanciaMain = this;
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
                            setForm(new jPanel_Tickets(instanciaMain));
                        } catch (SQLException ex) {
                            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        }
                        break;

                        
                        case 4:
                        {
                            try {
                                setForm(new jPanel_Certificados());
                            } catch (SQLException ex) {
                                Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
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
            setForm(new jPanel_Tickets(this));
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

        paneTotal = new componentes.PanelBorde();
        menu = new componentes.Menu();
        jPanelPrincipal = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        paneTotal.setBackground(new java.awt.Color(241, 233, 233));
        paneTotal.setPreferredSize(new java.awt.Dimension(800, 600));

        menu.setForeground(new java.awt.Color(102, 102, 102));

        jPanelPrincipal.setOpaque(false);
        jPanelPrincipal.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout paneTotalLayout = new javax.swing.GroupLayout(paneTotal);
        paneTotal.setLayout(paneTotalLayout);
        paneTotalLayout.setHorizontalGroup(
            paneTotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneTotalLayout.createSequentialGroup()
                .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 743, Short.MAX_VALUE))
        );
        paneTotalLayout.setVerticalGroup(
            paneTotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menu, javax.swing.GroupLayout.DEFAULT_SIZE, 657, Short.MAX_VALUE)
            .addComponent(jPanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(paneTotal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 942, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(paneTotal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 657, Short.MAX_VALUE)
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
    private componentes.PanelBorde paneTotal;
    // End of variables declaration//GEN-END:variables
}
