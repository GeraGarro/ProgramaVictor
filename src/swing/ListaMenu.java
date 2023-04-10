package swing;

import eventos.EventosMenuSeleccion;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.SwingUtilities;
import model.Modelo_menu;

public class ListaMenu<E extends Object> extends JList<E>{
   private final DefaultListModel modelo;
   private int selectedIndex= -1;
   private int overIndex=-1;
   
   private EventosMenuSeleccion evento;
        
        public void agregarEventoMenuSeleccion(EventosMenuSeleccion evento){
            this.evento=evento;
            
            
        }
   
   public ListaMenu(){
      modelo=new DefaultListModel();
       setModel(modelo);
       addMouseListener(new MouseAdapter() {
          @Override
          public void mouseExited(MouseEvent e) {
              overIndex= -1;
              repaint();
          }
          
           
           @Override
          public void mousePressed(MouseEvent me) {
             if(SwingUtilities.isLeftMouseButton(me)) {
                int index=locationToIndex(me.getPoint());
                Object o=modelo.getElementAt (index);
                if(o instanceof Modelo_menu){
                    Modelo_menu menu=(Modelo_menu) o;
                    if(menu.getTipo()==Modelo_menu.MenuTipo.MENU){
                        selectedIndex =index; 
                        if(evento != null){
                            
                            evento.seleccion(index);
                        }
                    }else{
                        selectedIndex=index;
                    }
                    repaint();
                }
             }           
          }

       });
       
       
       addMouseMotionListener(new MouseMotionAdapter() {
          
          @Override
          public void mouseMoved(MouseEvent me) {
              int index=locationToIndex(me.getPoint());
              
              if(index!=overIndex){
                  Object o=modelo.getElementAt(index);
                  if(o instanceof Modelo_menu){
                      Modelo_menu menu= (Modelo_menu) o;
                      if(menu.getTipo()==Modelo_menu.MenuTipo.MENU){
                          overIndex=index;
                      }else{
                          overIndex=-1;
                      }
                      repaint();
                  }
              }
            
          
          }
       
       });
   } 
    
   @Override
    public ListCellRenderer<? super E> getCellRenderer(){
        return new DefaultListCellRenderer(){
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object o, int index, boolean seleted, boolean focus) {
            Modelo_menu data;
            if(o instanceof Modelo_menu){
                data=(Modelo_menu) o;
            }else{
                data=new Modelo_menu("",o+"",Modelo_menu.MenuTipo.VACIO);
            }
            Menu_Item item=new Menu_Item(data);
            item.setSelected(selectedIndex==index);
            item.setDelante(overIndex==index);
            return item;
            }
           
        };              
     } 
    
         public void agregarItem(Modelo_menu data){
                modelo.addElement(data);
    }
    
    
    
    
    
}
