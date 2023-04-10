
package componentes;

import eventos.EventosMenuSeleccion;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JFrame;
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
        titulo = new javax.swing.JLabel();
        panelSalir = new javax.swing.JPanel();
        Cerrar = new javax.swing.JLabel();

        panelTitulo.setOpaque(false);

        panelTitulo.setBackground(new Color(0,0,0,0));

        titulo.setFont(new java.awt.Font("Unispace", 1, 24)); // NOI18N
        titulo.setForeground(new java.awt.Color(255, 255, 255));
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/iconmonstr-recycling-6-24.png"))); // NOI18N
        titulo.setText("Residuos ");
        titulo.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout panelTituloLayout = new javax.swing.GroupLayout(panelTitulo);
        panelTitulo.setLayout(panelTituloLayout);
        panelTituloLayout.setHorizontalGroup(
            panelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTituloLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        panelTituloLayout.setVerticalGroup(
            panelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTituloLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        Cerrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Cerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconoMenu/close.png"))); // NOI18N
        Cerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CerrarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelSalirLayout = new javax.swing.GroupLayout(panelSalir);
        panelSalir.setLayout(panelSalirLayout);
        panelSalirLayout.setHorizontalGroup(
            panelSalirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Cerrar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
        );
        panelSalirLayout.setVerticalGroup(
            panelSalirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSalirLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Cerrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(panelSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(panelTitulo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(14, 14, 14)
                    .addComponent(listaMenu3, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(13, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(476, 476, 476)
                .addComponent(panelSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(110, 110, 110)
                    .addComponent(listaMenu3, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(160, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void CerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CerrarMouseClicked
       System.exit(0);
    }//GEN-LAST:event_CerrarMouseClicked

    @Override
    protected void paintChildren(Graphics grphcs) {
        Graphics2D g2=(Graphics2D)grphcs;
       g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
       GradientPaint g=new GradientPaint(0, 0, Color.decode("#0575E6"), 0, getHeight(), Color.decode("#021B79"));
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
    private javax.swing.JLabel Cerrar;
    private swing.ListaMenu listaMenu1;
    private swing.ListaMenu<String> listaMenu3;
    private javax.swing.JPanel panelSalir;
    private javax.swing.JPanel panelTitulo;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
