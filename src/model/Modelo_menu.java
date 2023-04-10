
package model;

import java.io.File;
import java.io.FileFilter;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


public class Modelo_menu {

      public String getIcono() {
        return icono;
    }

    public void setIcono(String icono) {
        this.icono = icono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public MenuTipo getTipo() {
        return tipo;
    }


    public void setTipo(MenuTipo tipo) {
        this.tipo = tipo;
    }
    
    public Modelo_menu(){ 
}

    public Modelo_menu(String icono, String nombre, MenuTipo tipo) {
        this.icono = icono;
        this.nombre = nombre;
        this.tipo = tipo;
    }
    
public Icon toIcono(){
     try {
            ImageIcon icon = new ImageIcon(getClass().getResource("/iconoMenu/"+ icono +".png"));
       /* if(icon == null) {
            icon = new ImageIcon(getClass().getResource("/iconoMenu/cerrar.gif"));
        }*/
        return icon;
        
    } catch (Exception e) {
        System.out.println("Error al cargar la imagen: " + e.getMessage());
        return null;
    }
}
    private String icono;
    private String nombre;
    private MenuTipo tipo;
    
    public static enum MenuTipo{
        TITULO,MENU,VACIO
        
    }
}
