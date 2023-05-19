
package componentes;

import Data.GeneradorConsultorio_Data;
import Data.Transportista_Data;
import Entidades.GeneradorConsultorio;
import Entidades.Transportista;
import Principal_Victor.main;
import java.awt.Color;
import java.awt.Container;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import swing.ComboBox;


public class Emergente extends javax.swing.JFrame {
        private Transportista_Data tD;     
        private GeneradorConsultorio_Data gcD;
        private Map<String, Transportista> mapaTransportistas = new HashMap<>();
        private Map<String, GeneradorConsultorio> mapaConsultorio=new HashMap<>();
        private Map<String, Object> mapaObjecto=new HashMap<>();
         private main mainInstance;
         
    public Emergente() {
       
        initComponents();
       
       tD=new Transportista_Data();
       gcD=new GeneradorConsultorio_Data();
        setBackground(new Color(0,0,0,0));
        panelContenedorEmergente.setBackground(Color.WHITE);
        panelEmergente.setBackground(new Color(105, 92, 137));
        panelContenedorEmergente.setBackground(new Color(122, 154, 238, 200));
        panelResiduos.setEnabled(false);
        tF_ID.setEditable(false);
        llenarComboTransportista();
        llenarComboConsultorio();
        
    }

  

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelContenedorEmergente = new componentes.PanelBorde();
        panelEmergente = new componentes.PanelBorde();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tF_ID = new javax.swing.JTextField();
        CB_Transportista = new swing.ComboBox();
        boton1 = new swing.boton();
        CB_Generador = new swing.ComboBox();
        boton2 = new swing.boton();
        boton3 = new swing.boton();
        panelResiduos = new componentes.PanelBorde();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaSinStatus1 = new swing.TablaSinStatus();
        close = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("ID TICKET");

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("TRANSPORTISTA");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("GENERADOR");

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("FECHA");

        tF_ID.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        tF_ID.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        CB_Transportista.setForeground(new java.awt.Color(153, 153, 153));
        CB_Transportista.setLabelText("");

        boton1.setText("Editar");
        boton1.setTamañoVelocidad(1.0F);

        CB_Generador.setForeground(new java.awt.Color(153, 153, 153));
        CB_Generador.setLabelText("");

        boton2.setText("Agregar Residuo");
        boton2.setColor1(new java.awt.Color(51, 204, 0));
        boton2.setColor2(new java.awt.Color(0, 153, 102));
        boton2.setTamañoVelocidad(1.0F);

        boton3.setText("Cerrar");
        boton3.setTamañoVelocidad(1.0F);
        boton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelEmergenteLayout = new javax.swing.GroupLayout(panelEmergente);
        panelEmergente.setLayout(panelEmergenteLayout);
        panelEmergenteLayout.setHorizontalGroup(
            panelEmergenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelEmergenteLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(boton1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(boton3, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panelEmergenteLayout.createSequentialGroup()
                .addGap(131, 131, 131)
                .addComponent(boton2, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 132, Short.MAX_VALUE))
            .addGroup(panelEmergenteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelEmergenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelEmergenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(CB_Generador, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                    .addComponent(CB_Transportista, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tF_ID, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );
        panelEmergenteLayout.setVerticalGroup(
            panelEmergenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEmergenteLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(panelEmergenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tF_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(panelEmergenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelEmergenteLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelEmergenteLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(CB_Transportista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(panelEmergenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CB_Generador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(boton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addGroup(panelEmergenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45))
        );

        jLabel5.setFont(new java.awt.Font("Ebrima", 0, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Residuo");

        tablaSinStatus1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID ", "Tipo ", "Peso"
            }
        ));
        jScrollPane1.setViewportView(tablaSinStatus1);

        javax.swing.GroupLayout panelResiduosLayout = new javax.swing.GroupLayout(panelResiduos);
        panelResiduos.setLayout(panelResiduosLayout);
        panelResiduosLayout.setHorizontalGroup(
            panelResiduosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelResiduosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelResiduosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelResiduosLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelResiduosLayout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(152, 152, 152))))
        );
        panelResiduosLayout.setVerticalGroup(
            panelResiduosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelResiduosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(61, Short.MAX_VALUE))
        );

        close.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconoMenu/close2.png"))); // NOI18N
        close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelContenedorEmergenteLayout = new javax.swing.GroupLayout(panelContenedorEmergente);
        panelContenedorEmergente.setLayout(panelContenedorEmergenteLayout);
        panelContenedorEmergenteLayout.setHorizontalGroup(
            panelContenedorEmergenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContenedorEmergenteLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(panelEmergente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelContenedorEmergenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelContenedorEmergenteLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(close, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelContenedorEmergenteLayout.createSequentialGroup()
                        .addComponent(panelResiduos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 11, Short.MAX_VALUE))))
        );
        panelContenedorEmergenteLayout.setVerticalGroup(
            panelContenedorEmergenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContenedorEmergenteLayout.createSequentialGroup()
                .addGroup(panelContenedorEmergenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelContenedorEmergenteLayout.createSequentialGroup()
                        .addComponent(close, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(panelResiduos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelContenedorEmergenteLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(panelEmergente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelContenedorEmergente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelContenedorEmergente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void boton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton3ActionPerformed
   
    
    }//GEN-LAST:event_boton3ActionPerformed

    private void closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseClicked
  Container container = boton3.getParent(); // Obtener el contenedor del botón (en este caso, el JPanel "PanelContenedorEmergente")
   
  while (container != null) { // Mientras no se llegue al JFrame padre
        if (container instanceof JFrame) { // Si el contenedor es un JFrame
            JFrame frame = (JFrame) container; // Castear el contenedor a JFrame
            frame.dispose(); // Cerrar el JFrame
            break; // Salir del bucle
        }
        container = container.getParent(); // Obtener el contenedor padre
    }
        
    }//GEN-LAST:event_closeMouseClicked
    public void setIdTicket(int idTicket){
        tF_ID.setText(String.valueOf(idTicket));
    }
    
    public void llenarComboTransportista(){
      
        for (Transportista trans : tD.listaTransportistaTodos()) {
            String nombreCompleto=trans.getNombre()+" "+trans.getApellido();
            CB_Transportista.addItem(nombreCompleto);
            mapaTransportistas.put(nombreCompleto,trans);
        }
    }
    
   public void llenarComboConsultorio(){
        for(GeneradorConsultorio gc: gcD.listarConsultoriosTodos()){
            String nombreCompleto=gc.getNombre();
            CB_Generador.addItem(nombreCompleto);
            mapaConsultorio.put(nombreCompleto, gc);
        }
    }
    
      
    public ComboBox getCB_Transportista() {
        return CB_Transportista;
    }
    
    public ComboBox getCB_Consultorio(){
        return CB_Generador;
    }
    
    public Transportista obtenerTransportistaComboBox(String nombre){
 
        return mapaTransportistas.get(nombre);
    }

    
    public GeneradorConsultorio obtenerGeneradorComboBox(String nombre){
        return mapaConsultorio.get(nombre);
    }
    public static void main(String args[]) {
     
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Emergente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.ComboBox CB_Generador;
    private swing.ComboBox CB_Transportista;
    private swing.boton boton1;
    private swing.boton boton2;
    private swing.boton boton3;
    private javax.swing.JLabel close;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private componentes.PanelBorde panelContenedorEmergente;
    private componentes.PanelBorde panelEmergente;
    private componentes.PanelBorde panelResiduos;
    private javax.swing.JTextField tF_ID;
    private swing.TablaSinStatus tablaSinStatus1;
    // End of variables declaration//GEN-END:variables
}
