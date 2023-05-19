package componentes;


import Data.GeneradorConsultorio_Data;
import Data.Transportista_Data;
import Entidades.Conexion;
import java.sql.Connection;
import javafx.scene.control.ScrollBar;
import javax.swing.table.DefaultTableModel;
import model.TiposStatus;
import swing.AccionCeldaEnTabla;
import swing.AccionCeldaEnTabla2;
import swing.AccionTablaEditar;
import swing.AccionTablaEditar2;
import swing.TablaAccionEvento;
import swing.TablaAccionEvento2;




public class jPanel_Consultorio extends javax.swing.JPanel {
    
    GeneradorConsultorio_Data gCD=new GeneradorConsultorio_Data();
    public jPanel_Consultorio() {
        
        initComponents();
        TablaAccionEvento2 evento=new TablaAccionEvento2() {
            @Override
            public void onEdit(int fila) {
            
            }

           

            @Override
            public void onPrint(int fila) {
               
            }
        };
      // ScrollPanelTabla.setVerticalScrollBar(new ScrollBar());
      tablaConsultorios.getColumnModel().getColumn(4).setCellEditor(new AccionTablaEditar2(evento));
        tablaConsultorios.getColumnModel().getColumn(4).setCellRenderer(new AccionCeldaEnTabla2());
        tablaConsultorios.agregarFilasConsultorio(gCD);
    }
 
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelTabla = new componentes.PanelBorde();
        jLabel1 = new javax.swing.JLabel();
        ScrollPanelTabla = new javax.swing.JScrollPane();
        tablaConsultorios = new swing.TablaConStatus();
        cabecera1 = new componentes.cabecera();
        panelVentanaControl2 = new componentes.panelVentanaControl();

        panelTabla.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(95, 94, 103));
        jLabel1.setText("Consultorio");

        tablaConsultorios.setForeground(new java.awt.Color(0, 0, 0));
        tablaConsultorios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Cuit", "Domicilio", "Estado", "Accion"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ScrollPanelTabla.setViewportView(tablaConsultorios);

        javax.swing.GroupLayout panelTablaLayout = new javax.swing.GroupLayout(panelTabla);
        panelTabla.setLayout(panelTablaLayout);
        panelTablaLayout.setHorizontalGroup(
            panelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTablaLayout.createSequentialGroup()
                .addGroup(panelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelTablaLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelTablaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(ScrollPanelTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 663, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelTablaLayout.setVerticalGroup(
            panelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTablaLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ScrollPanelTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        cabecera1.setFont(new java.awt.Font("Gadugi", 0, 24)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(cabecera1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(panelTabla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(panelVentanaControl2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(panelVentanaControl2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(cabecera1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(panelTabla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane ScrollPanelTabla;
    private componentes.cabecera cabecera1;
    private javax.swing.JLabel jLabel1;
    private componentes.PanelBorde panelTabla;
    private componentes.panelVentanaControl panelVentanaControl2;
    private swing.TablaConStatus tablaConsultorios;
    // End of variables declaration//GEN-END:variables
}
