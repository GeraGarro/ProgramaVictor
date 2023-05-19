
package componentes;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import swing.textoBuscador;
import javax.swing.text.Document;

public class cabecera extends javax.swing.JPanel {


    public cabecera() {
        initComponents();
        setOpaque(false);
       
        textoBuscador1.getDocument().addDocumentListener(new DocumentListener() {
        @Override
        public void insertUpdate(DocumentEvent e) {
            // Este método se llama cada vez que se inserta un caracter en el texto
            // Aquí puedes escribir el código para realizar la búsqueda en la tabla
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            // Este método se llama cada vez que se elimina un caracter del texto
            // Aquí puedes escribir el código para realizar la búsqueda en la tabla
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            // Este método se llama cada vez que se cambia el estilo del texto
            // No es necesario utilizarlo en este caso
        }
    });
        
    }
    
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JIconBuscar = new javax.swing.JLabel();
        textoBuscador1 = new swing.textoBuscador();
        jHamburguesa = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        JIconBuscar.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        JIconBuscar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JIconBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icon_Buscador.png"))); // NOI18N

        jHamburguesa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jHamburguesa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-menu-rounded-50.png"))); // NOI18N
        jHamburguesa.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(JIconBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(textoBuscador1, javax.swing.GroupLayout.PREFERRED_SIZE, 598, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jHamburguesa, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JIconBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jHamburguesa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(textoBuscador1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2=(Graphics2D)g;
       g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
       g2.setColor(getBackground());
       g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
       g2.fillRect(0, 0, 25, getHeight());
       g2.fillRect(getWidth()-25, getHeight()-25, getWidth(), getHeight());
       super.paintComponent(g); 
    }

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JIconBuscar;
    private javax.swing.JLabel jHamburguesa;
    private swing.textoBuscador textoBuscador1;
    // End of variables declaration//GEN-END:variables



}
