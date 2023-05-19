package componentes;


import Data.GeneradorConsultorio_Data;
import Data.Transportista_Data;
import Entidades.Conexion;
import java.sql.Connection;
import javafx.scene.control.ScrollBar;
import javax.swing.table.DefaultTableModel;
import model.TiposStatus;
import swing.AccionCeldaEnTabla;
import swing.AccionTablaEditar;
import swing.TablaAccionEvento;




public class jPanel_Transportistas extends javax.swing.JPanel {
    
    Transportista_Data tD=new Transportista_Data();
    public jPanel_Transportistas() {
        
        initComponents();
        TablaAccionEvento evento=new TablaAccionEvento() {
            @Override
            public void onEdit(int fila) {
            }

            @Override
            public void onDelete(int fila) {
                System.out.println("te voy a eliminar"+fila);
            }

            @Override
            public void onPrint(int fila) {
            }
        };
      // ScrollPanelTabla.setVerticalScrollBar(new ScrollBar());
      tablaTransportistas.getColumnModel().getColumn(5).setCellEditor(new AccionTablaEditar(evento));
        tablaTransportistas.getColumnModel().getColumn(5).setCellRenderer(new AccionCeldaEnTabla());
        tablaTransportistas.agregarTablaTransportistas(tD);
    }
 
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelTabla = new componentes.PanelBorde();
        jLabel1 = new javax.swing.JLabel();
        ScrollPanelTabla = new javax.swing.JScrollPane();
        tablaTransportistas = new swing.TablaConStatus();
        cabecera1 = new componentes.cabecera();
        panelVentanaControl1 = new componentes.panelVentanaControl();

        panelTabla.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(95, 94, 103));
        jLabel1.setText("Transportistas");

        tablaTransportistas.setForeground(new java.awt.Color(0, 0, 0));
        tablaTransportistas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Nombre", "Apellido", "CUIT", "Estado", "Accion"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ScrollPanelTabla.setViewportView(tablaTransportistas);

        javax.swing.GroupLayout panelTablaLayout = new javax.swing.GroupLayout(panelTabla);
        panelTabla.setLayout(panelTablaLayout);
        panelTablaLayout.setHorizontalGroup(
            panelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTablaLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panelTablaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ScrollPanelTabla)
                .addContainerGap())
        );
        panelTablaLayout.setVerticalGroup(
            panelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTablaLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ScrollPanelTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(7, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelTabla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cabecera1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(panelVentanaControl1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(panelVentanaControl1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(cabecera1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(panelTabla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane ScrollPanelTabla;
    private componentes.cabecera cabecera1;
    private javax.swing.JLabel jLabel1;
    private componentes.PanelBorde panelTabla;
    private componentes.panelVentanaControl panelVentanaControl1;
    private swing.TablaConStatus tablaTransportistas;
    // End of variables declaration//GEN-END:variables
}
