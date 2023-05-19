
package componentes;

import eventos.EventosMenuSeleccion;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import model.Modelo_menu;


public class Menu extends javax.swing.JPanel {

        private EventosMenuSeleccion evento;
        
        public void agregarEventoMenuSeleccion(EventosMenuSeleccion evento){
            this.evento=evento;
            listaMenu3.agregarEventoMenuSeleccion(evento);
            
        }
    public Menu() {
        initComponents();
        setOpaque(false);
        listaMenu3.setOpaque(false);
        panelSalir.setOpaque(false);
        init();        
        
       
        
    
    }
    
    private void init(){
    
    listaMenu3.agregarItem(new Modelo_menu("Consultorio", "Consultorios", Modelo_menu.MenuTipo.MENU));
    listaMenu3.agregarItem(new Modelo_menu("","", Modelo_menu.MenuTipo.VACIO));
    listaMenu3.agregarItem(new Modelo_menu("retiroResiduo","Tickets",Modelo_menu.MenuTipo.MENU));   
    listaMenu3.agregarItem(new Modelo_menu("","", Modelo_menu.MenuTipo.VACIO));
    listaMenu3.agregarItem(new Modelo_menu("certificado","Certificados",Modelo_menu.MenuTipo.MENU)); 
    listaMenu3.agregarItem(new Modelo_menu("","", Modelo_menu.MenuTipo.VACIO));
    listaMenu3.agregarItem(new Modelo_menu("","", Modelo_menu.MenuTipo.VACIO));
    listaMenu3.agregarItem(new Modelo_menu("Residuos","Residuos",Modelo_menu.MenuTipo.MENU));
    listaMenu3.agregarItem(new Modelo_menu("","", Modelo_menu.MenuTipo.VACIO));
    listaMenu3.agregarItem(new Modelo_menu("transporte","Transportistas",Modelo_menu.MenuTipo.MENU));
    
    
    }
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        listaMenu1 = new swing.ListaMenu();
        listaMenu3 = new swing.ListaMenu<>();
        panelTitulo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        panelSalir = new javax.swing.JPanel();

        listaMenu3.setForeground(new java.awt.Color(153, 153, 153));
        listaMenu3.setSelectionForeground(new java.awt.Color(102, 102, 102));

        panelTitulo.setOpaque(false);

        panelTitulo.setBackground(new Color(0,0,0,0));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Ebrima", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/iconmonstr-recycling-6-24.png"))); // NOI18N
        jLabel1.setText("<html><body>Residuos <br> Patologicos</body><html>");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel1.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout panelTituloLayout = new javax.swing.GroupLayout(panelTitulo);
        panelTitulo.setLayout(panelTituloLayout);
        panelTituloLayout.setHorizontalGroup(
            panelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTituloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap())
        );
        panelTituloLayout.setVerticalGroup(
            panelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTituloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout panelSalirLayout = new javax.swing.GroupLayout(panelSalir);
        panelSalir.setLayout(panelSalirLayout);
        panelSalirLayout.setHorizontalGroup(
            panelSalirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 63, Short.MAX_VALUE)
        );
        panelSalirLayout.setVerticalGroup(
            panelSalirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelTitulo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(listaMenu3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(115, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(listaMenu3, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(panelSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(60, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected void paintChildren(Graphics grphcs) {
        Graphics2D g2=(Graphics2D)grphcs;
       g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
       GradientPaint g=new GradientPaint(0, 0, Color.decode("#4776E6"), 0, getHeight(), Color.decode("#8E54E9"));
       g2.setPaint(g);
       g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
        g2.fillRect(getWidth()-20, 0, getWidth(), getHeight());
        
        super.paintChildren(grphcs); 
    }
    private int  x;
    private int y;
    public void initMoving(JFrame fram){
        panelTitulo.addMouseListener(new MouseAdapter(){
         @Override
         public void mousePressed(MouseEvent me){
          super.mousePressed(me);
          x=me.getX();
          y=me.getY();
         }
         
        });
        
        panelTitulo.addMouseMotionListener(new MouseMotionAdapter() {
        @Override
        public void mouseDragged(MouseEvent me){
            fram.setLocation(me.getXOnScreen()-x, me.getYOnScreen()-y);
        }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private swing.ListaMenu listaMenu1;
    private swing.ListaMenu<String> listaMenu3;
    private javax.swing.JPanel panelSalir;
    private javax.swing.JPanel panelTitulo;
    // End of variables declaration//GEN-END:variables
}
