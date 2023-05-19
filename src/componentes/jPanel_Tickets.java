package componentes;


import Data.GeneradorConsultorio_Data;
import Data.TicketControl_Data;
import Entidades.Conexion;
import Entidades.GeneradorConsultorio;
import Entidades.TicketControl;
import Entidades.Transportista;
import Principal_Victor.main;
import java.awt.Color;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.ScrollBar;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.TiposStatus;
import swing.AccionCeldaEnTabla;
import swing.AccionTablaEditar;
import swing.ComboBox;
import swing.TablaAccionEvento;
import swing.textoBuscador;




public class jPanel_Tickets extends javax.swing.JPanel {
    private Emergente EmergenteEditar;
    private TicketControl_Data tcD;
    private TicketControl tk;
    private main mainInstance;
    private GeneradorConsultorio_Data gCD;
    private GeneradorConsultorio gC;
    
    
    public jPanel_Tickets(main mainInstance) throws SQLException {
        
        initComponents();
        
      // ScrollPanelTabla.setVerticalScrollBar(new ScrollBar());
      tcD=new TicketControl_Data();
      gCD=new GeneradorConsultorio_Data();
      
      this.mainInstance = mainInstance;
        TablaAccionEvento event=new TablaAccionEvento() {
           
            
            @Override
            public void onEdit(int fila) { 
                
           
    try {
        if (EmergenteEditar != null) {
            EmergenteEditar.dispose();
           
        }
        EmergenteEditar = new Emergente();
        EmergenteEditar.setVisible(true);
       
        int dato=(int) tablaTickets.getValueAt(fila, 0);
        int dato2=(int) tablaTickets.getValueAt(fila, 0);
        tk=new TicketControl();
        tk=tcD.obtenerTicket(dato);      
        EmergenteEditar.setIdTicket(tk.getId_ticket());
        Transportista tp=tk.getTransportista();
        GeneradorConsultorio gConsultrio=tk.getConsultorio();      
        instanciarComboBoxTransportista(tp);
        instanciarComboBoxGeneraddor(gConsultrio);
        
    } catch (Exception e) {
        e.printStackTrace();
    }
}

            @Override
            public void onDelete(int fila) {
               
               
                    int eliminar=(int) tablaTickets.getValueAt(fila, 0);
                    System.out.println(eliminar);
                   
                    int opcion = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea eliminar el Ticket?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
                    if (opcion == JOptionPane.YES_OPTION) {
                        try {
                            try {
                                tcD.eliminarTicket(eliminar);
                            } catch (SQLException ex) {
                                Logger.getLogger(jPanel_Tickets.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            tablaTickets.agregarFilasTickets(tcD);
                            
                        } catch (SQLException ex) {
                            Logger.getLogger(jPanel_Tickets.class.getName()).log(Level.SEVERE, null, ex);
                        }
                   
             }
            }
            @Override
            public void onPrint(int fila) {

            }
        };
      tablaTickets.getColumnModel().getColumn(4).setCellRenderer(new AccionCeldaEnTabla());
       tablaTickets.getColumnModel().getColumn(4).setCellEditor(new AccionTablaEditar(event));
        tablaTickets.agregarFilasTickets(tcD);
    }
 
    public void instanciarComboBoxTransportista(Transportista tp){
            for (int i = 0; i < EmergenteEditar.getCB_Transportista().getItemCount(); i++) {
         // Obtener el nombre completo del Transportista del ítem actual
         //String nombreCompleto = (String) EmergenteEditar.getCB_Transportista().getItemAt(i);

         // Obtener el objeto Transportista correspondiente al nombre completo
         Transportista transportista = EmergenteEditar.obtenerTransportistaComboBox((String) EmergenteEditar.getCB_Transportista().getItemAt(i));

         // Comparar el objeto Transportista obtenido del ComboBox con el obtenido del Ticket
            if (transportista.equals(tp)) {

                // Si son iguales, establecer el índice seleccionado del ComboBox y salir del loop
                EmergenteEditar.getCB_Transportista().setSelectedIndex(i);
                break;
            }

        }
    }

    public void instanciarComboBoxGeneraddor(GeneradorConsultorio gc){
        for (int i = 0; i < EmergenteEditar.getCB_Consultorio().getItemCount(); i++) {
             GeneradorConsultorio generador=EmergenteEditar.obtenerGeneradorComboBox((String)EmergenteEditar.getCB_Consultorio().getItemAt(i));
            /* System.out.println("Comparacion "+i);
             System.out.println(generador);
             System.out.println(gc);*/
             if(generador.equals(gc)){
               
                  EmergenteEditar.getCB_Consultorio().setSelectedIndex(i);
              }  
        }
        
        
    }
   
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelTabla = new componentes.PanelBorde();
        TituloTicket = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaTickets = new swing.TablaSinStatus();
        cabecera1 = new componentes.cabecera();
        panelVentanaControl1 = new componentes.panelVentanaControl();

        setPreferredSize(new java.awt.Dimension(730, 606));

        panelTabla.setBackground(new java.awt.Color(255, 255, 255));

        TituloTicket.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        TituloTicket.setForeground(new java.awt.Color(95, 94, 103));
        TituloTicket.setText("Tickets");

        tablaTickets.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "id Ticket", "Transportista", "Fecha", "Consultorio", "Accion"
            }
        ));
        jScrollPane1.setViewportView(tablaTickets);

        javax.swing.GroupLayout panelTablaLayout = new javax.swing.GroupLayout(panelTabla);
        panelTabla.setLayout(panelTablaLayout);
        panelTablaLayout.setHorizontalGroup(
            panelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTablaLayout.createSequentialGroup()
                .addGroup(panelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelTablaLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(TituloTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelTablaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 663, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelTablaLayout.setVerticalGroup(
            panelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTablaLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(TituloTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(panelTabla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 10, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cabecera1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelVentanaControl1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(panelVentanaControl1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(cabecera1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(panelTabla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel TituloTicket;
    private componentes.cabecera cabecera1;
    private javax.swing.JScrollPane jScrollPane1;
    private componentes.PanelBorde panelTabla;
    private componentes.panelVentanaControl panelVentanaControl1;
    private swing.TablaSinStatus tablaTickets;
    // End of variables declaration//GEN-END:variables
}
