package componentes;


import Data.GeneradorConsultorio_Data;
import Data.TicketControl_Data;
import Entidades.Conexion;
import java.sql.Connection;
import java.sql.SQLException;
import javafx.scene.control.ScrollBar;
import javax.swing.table.DefaultTableModel;
import model.TiposStatus;




public class jPanel_Tickets extends javax.swing.JPanel {
    
    TicketControl_Data tcD=new TicketControl_Data();
    public jPanel_Tickets() throws SQLException {
        
        initComponents();
      // ScrollPanelTabla.setVerticalScrollBar(new ScrollBar());
               
        tablaTickets.agregarFilasTickets(tcD);
    }
 
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelTabla = new componentes.PanelBorde();
        TituloTicket = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaTickets = new swing.TablaSinStatus();
        panelBordeBotones = new componentes.PanelBorde();

        panelTabla.setBackground(new java.awt.Color(255, 255, 255));

        TituloTicket.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        TituloTicket.setForeground(new java.awt.Color(95, 94, 103));
        TituloTicket.setText("Tickets");

        tablaTickets.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "id Ticket", "Transportista", "Fecha", "Consultorio"
            }
        ));
        jScrollPane1.setViewportView(tablaTickets);

        javax.swing.GroupLayout panelTablaLayout = new javax.swing.GroupLayout(panelTabla);
        panelTabla.setLayout(panelTablaLayout);
        panelTablaLayout.setHorizontalGroup(
            panelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTablaLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TituloTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        panelTablaLayout.setVerticalGroup(
            panelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTablaLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(TituloTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8))
        );

        javax.swing.GroupLayout panelBordeBotonesLayout = new javax.swing.GroupLayout(panelBordeBotones);
        panelBordeBotones.setLayout(panelBordeBotonesLayout);
        panelBordeBotonesLayout.setHorizontalGroup(
            panelBordeBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 690, Short.MAX_VALUE)
        );
        panelBordeBotonesLayout.setVerticalGroup(
            panelBordeBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 89, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBordeBotones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(panelTabla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(panelBordeBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelTabla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel TituloTicket;
    private javax.swing.JScrollPane jScrollPane1;
    private componentes.PanelBorde panelBordeBotones;
    private componentes.PanelBorde panelTabla;
    private swing.TablaSinStatus tablaTickets;
    // End of variables declaration//GEN-END:variables
}
