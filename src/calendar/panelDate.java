package calendar;

public class panelDate extends javax.swing.JPanel {

    private int mes;
    private int año;
    
    public panelDate(int mes, int año) {
        initComponents();
        this.mes=mes;
        this.año=año;
        init();
    }

  private void init(){
      lu.comoTitulo();
      ma.comoTitulo();
      mi.comoTitulo();
      ju.comoTitulo();
      vi.comoTitulo();
      sa.comoTitulo();
      dom.comoTitulo();
      setDate();
  }
  
  private void setDate(){
      
  }
      @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dom = new calendar.celula();
        lu = new calendar.celula();
        ma = new calendar.celula();
        mi = new calendar.celula();
        ju = new calendar.celula();
        vi = new calendar.celula();
        sa = new calendar.celula();
        celula8 = new calendar.celula();
        celula9 = new calendar.celula();
        celula10 = new calendar.celula();
        celula11 = new calendar.celula();
        celula12 = new calendar.celula();
        celula13 = new calendar.celula();
        celula14 = new calendar.celula();
        celula15 = new calendar.celula();
        celula16 = new calendar.celula();
        celula17 = new calendar.celula();
        celula18 = new calendar.celula();
        celula19 = new calendar.celula();
        celula20 = new calendar.celula();
        celula21 = new calendar.celula();
        celula22 = new calendar.celula();
        celula23 = new calendar.celula();
        celula24 = new calendar.celula();
        celula25 = new calendar.celula();
        celula26 = new calendar.celula();
        celula27 = new calendar.celula();
        celula28 = new calendar.celula();
        celula29 = new calendar.celula();
        celula30 = new calendar.celula();
        celula31 = new calendar.celula();
        celula32 = new calendar.celula();
        celula33 = new calendar.celula();
        celula34 = new calendar.celula();
        celula35 = new calendar.celula();
        celula36 = new calendar.celula();
        celula37 = new calendar.celula();
        celula38 = new calendar.celula();
        celula39 = new calendar.celula();
        celula40 = new calendar.celula();
        celula41 = new calendar.celula();
        celula42 = new calendar.celula();
        celula43 = new calendar.celula();
        celula44 = new calendar.celula();
        celula45 = new calendar.celula();
        celula46 = new calendar.celula();
        celula47 = new calendar.celula();
        celula48 = new calendar.celula();
        celula49 = new calendar.celula();

        setLayout(new java.awt.GridLayout(7, 7));

        dom.setForeground(new java.awt.Color(255, 51, 0));
        dom.setText("Do");
        dom.setFont(new java.awt.Font("MS Gothic", 1, 14)); // NOI18N
        dom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                domActionPerformed(evt);
            }
        });
        add(dom);

        lu.setText("Lu");
        lu.setFont(new java.awt.Font("MS Gothic", 1, 14)); // NOI18N
        add(lu);

        ma.setText("Ma");
        ma.setFont(new java.awt.Font("MS Gothic", 1, 14)); // NOI18N
        add(ma);

        mi.setText("Mi");
        mi.setFont(new java.awt.Font("MS Gothic", 1, 14)); // NOI18N
        add(mi);

        ju.setText("Ju");
        ju.setFont(new java.awt.Font("MS Gothic", 1, 14)); // NOI18N
        add(ju);

        vi.setText("Vi");
        vi.setFont(new java.awt.Font("MS Gothic", 1, 14)); // NOI18N
        add(vi);

        sa.setText("Sa");
        sa.setFont(new java.awt.Font("MS Gothic", 1, 14)); // NOI18N
        add(sa);

        celula8.setFont(new java.awt.Font("MS Gothic", 1, 14)); // NOI18N
        add(celula8);

        celula9.setFont(new java.awt.Font("MS Gothic", 1, 14)); // NOI18N
        add(celula9);

        celula10.setFont(new java.awt.Font("MS Gothic", 1, 14)); // NOI18N
        add(celula10);

        celula11.setFont(new java.awt.Font("MS Gothic", 1, 14)); // NOI18N
        add(celula11);

        celula12.setFont(new java.awt.Font("MS Gothic", 1, 14)); // NOI18N
        add(celula12);

        celula13.setFont(new java.awt.Font("MS Gothic", 1, 14)); // NOI18N
        add(celula13);

        celula14.setFont(new java.awt.Font("MS Gothic", 1, 14)); // NOI18N
        add(celula14);

        celula15.setFont(new java.awt.Font("MS Gothic", 1, 14)); // NOI18N
        add(celula15);

        celula16.setFont(new java.awt.Font("MS Gothic", 1, 14)); // NOI18N
        add(celula16);

        celula17.setFont(new java.awt.Font("MS Gothic", 1, 14)); // NOI18N
        add(celula17);

        celula18.setFont(new java.awt.Font("MS Gothic", 1, 14)); // NOI18N
        add(celula18);

        celula19.setFont(new java.awt.Font("MS Gothic", 1, 14)); // NOI18N
        add(celula19);

        celula20.setFont(new java.awt.Font("MS Gothic", 1, 14)); // NOI18N
        add(celula20);

        celula21.setFont(new java.awt.Font("MS Gothic", 1, 14)); // NOI18N
        add(celula21);

        celula22.setFont(new java.awt.Font("MS Gothic", 1, 14)); // NOI18N
        add(celula22);

        celula23.setFont(new java.awt.Font("MS Gothic", 1, 14)); // NOI18N
        add(celula23);

        celula24.setFont(new java.awt.Font("MS Gothic", 1, 14)); // NOI18N
        add(celula24);

        celula25.setFont(new java.awt.Font("MS Gothic", 1, 14)); // NOI18N
        add(celula25);

        celula26.setFont(new java.awt.Font("MS Gothic", 1, 14)); // NOI18N
        add(celula26);

        celula27.setFont(new java.awt.Font("MS Gothic", 1, 14)); // NOI18N
        add(celula27);

        celula28.setFont(new java.awt.Font("MS Gothic", 1, 14)); // NOI18N
        add(celula28);

        celula29.setFont(new java.awt.Font("MS Gothic", 1, 14)); // NOI18N
        add(celula29);

        celula30.setFont(new java.awt.Font("MS Gothic", 1, 14)); // NOI18N
        add(celula30);

        celula31.setFont(new java.awt.Font("MS Gothic", 1, 14)); // NOI18N
        add(celula31);

        celula32.setFont(new java.awt.Font("MS Gothic", 1, 14)); // NOI18N
        add(celula32);

        celula33.setFont(new java.awt.Font("MS Gothic", 1, 14)); // NOI18N
        add(celula33);

        celula34.setFont(new java.awt.Font("MS Gothic", 1, 14)); // NOI18N
        add(celula34);

        celula35.setFont(new java.awt.Font("MS Gothic", 1, 14)); // NOI18N
        add(celula35);

        celula36.setFont(new java.awt.Font("MS Gothic", 1, 14)); // NOI18N
        add(celula36);

        celula37.setFont(new java.awt.Font("MS Gothic", 1, 14)); // NOI18N
        add(celula37);

        celula38.setFont(new java.awt.Font("MS Gothic", 1, 14)); // NOI18N
        add(celula38);

        celula39.setFont(new java.awt.Font("MS Gothic", 1, 14)); // NOI18N
        add(celula39);

        celula40.setFont(new java.awt.Font("MS Gothic", 1, 14)); // NOI18N
        add(celula40);

        celula41.setFont(new java.awt.Font("MS Gothic", 1, 14)); // NOI18N
        add(celula41);

        celula42.setFont(new java.awt.Font("MS Gothic", 1, 14)); // NOI18N
        add(celula42);

        celula43.setFont(new java.awt.Font("MS Gothic", 1, 14)); // NOI18N
        add(celula43);

        celula44.setFont(new java.awt.Font("MS Gothic", 1, 14)); // NOI18N
        add(celula44);

        celula45.setFont(new java.awt.Font("MS Gothic", 1, 14)); // NOI18N
        add(celula45);

        celula46.setFont(new java.awt.Font("MS Gothic", 1, 14)); // NOI18N
        add(celula46);

        celula47.setFont(new java.awt.Font("MS Gothic", 1, 14)); // NOI18N
        add(celula47);

        celula48.setFont(new java.awt.Font("MS Gothic", 1, 14)); // NOI18N
        add(celula48);

        celula49.setFont(new java.awt.Font("MS Gothic", 1, 14)); // NOI18N
        add(celula49);
    }// </editor-fold>//GEN-END:initComponents

    private void domActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_domActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_domActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private calendar.celula celula10;
    private calendar.celula celula11;
    private calendar.celula celula12;
    private calendar.celula celula13;
    private calendar.celula celula14;
    private calendar.celula celula15;
    private calendar.celula celula16;
    private calendar.celula celula17;
    private calendar.celula celula18;
    private calendar.celula celula19;
    private calendar.celula celula20;
    private calendar.celula celula21;
    private calendar.celula celula22;
    private calendar.celula celula23;
    private calendar.celula celula24;
    private calendar.celula celula25;
    private calendar.celula celula26;
    private calendar.celula celula27;
    private calendar.celula celula28;
    private calendar.celula celula29;
    private calendar.celula celula30;
    private calendar.celula celula31;
    private calendar.celula celula32;
    private calendar.celula celula33;
    private calendar.celula celula34;
    private calendar.celula celula35;
    private calendar.celula celula36;
    private calendar.celula celula37;
    private calendar.celula celula38;
    private calendar.celula celula39;
    private calendar.celula celula40;
    private calendar.celula celula41;
    private calendar.celula celula42;
    private calendar.celula celula43;
    private calendar.celula celula44;
    private calendar.celula celula45;
    private calendar.celula celula46;
    private calendar.celula celula47;
    private calendar.celula celula48;
    private calendar.celula celula49;
    private calendar.celula celula8;
    private calendar.celula celula9;
    private calendar.celula dom;
    private calendar.celula ju;
    private calendar.celula lu;
    private calendar.celula ma;
    private calendar.celula mi;
    private calendar.celula sa;
    private calendar.celula vi;
    // End of variables declaration//GEN-END:variables
}
