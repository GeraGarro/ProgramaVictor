package componentes;


import Data.Certificado_Data;
import Data.GeneradorConsultorio_Data;
import Entidades.Conexion;
import java.sql.Connection;
import java.sql.SQLException;
import javafx.scene.control.ScrollBar;
import javax.swing.table.DefaultTableModel;
import model.TiposStatus;
import swing.AccionCeldaEnTabla;
import swing.AccionTablaEditar;
import swing.TablaAccionEvento;




public class jPanel_Certificados extends javax.swing.JPanel {
    
    Certificado_Data cD= new Certificado_Data();
    public jPanel_Certificados() throws SQLException {
        
        initComponents();
        TablaAccionEvento evento=new TablaAccionEvento() {
            @Override
            public void onEdit(int fila) {
            }

            @Override
            public void onDelete(int fila) {
            }

            @Override
            public void onPrint(int fila) {
            }
        };
      // ScrollPanelTabla.setVerticalScrollBar(new ScrollBar());
      tablaCertificado.getColumnModel().getColumn(4).setCellEditor(new AccionTablaEditar(evento));
        tablaCertificado.getColumnModel().getColumn(4).setCellRenderer(new AccionCeldaEnTabla());
        tablaCertificado.agregarFilasCertificado(cD);
    }
 
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelTabla = new componentes.PanelBorde();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaCertificado = new swing.TablaSinStatus();
        cabecera1 = new componentes.cabecera();
        panelVentanaControl2 = new componentes.panelVentanaControl();

        panelTabla.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(95, 94, 103));
        jLabel1.setText("Certificados de Disposicion");

        jScrollPane1.setBorder(null);

        tablaCertificado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Transportista", "Periodo", "Peso Total", "Accion"
            }
        ));
        jScrollPane1.setViewportView(tablaCertificado);

        javax.swing.GroupLayout panelTablaLayout = new javax.swing.GroupLayout(panelTabla);
        panelTabla.setLayout(panelTablaLayout);
        panelTablaLayout.setHorizontalGroup(
            panelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTablaLayout.createSequentialGroup()
                .addGroup(panelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelTablaLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelTablaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 656, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(8, Short.MAX_VALUE))
        );
        panelTablaLayout.setVerticalGroup(
            panelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTablaLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(panelTabla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cabecera1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelVentanaControl2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelVentanaControl2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(cabecera1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(panelTabla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private componentes.cabecera cabecera1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private componentes.PanelBorde panelTabla;
    private componentes.panelVentanaControl panelVentanaControl2;
    private swing.TablaSinStatus tablaCertificado;
    // End of variables declaration//GEN-END:variables
}
