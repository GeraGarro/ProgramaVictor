package Entidades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class Conexion {
    private static String url="jdbc:mysql://localhost/residuos";
  private static String usuario="root";
  private static String password="";
 private static Conexion con=null;

private Conexion(){
    try {
      Class.forName("org.mariadb.jdbc.Driver");
      
    } catch (ClassNotFoundException e) {
        JOptionPane.showMessageDialog(null, "Error de Conexion por falta de Driver");
    
    }
    
}

public static Connection getConexion(){
  Connection conx=null;
    if (con== null){
      con=new Conexion();
      JOptionPane.showMessageDialog(null,"Conexion Exitosa a Programa Victor");
  }
    try {
        conx=DriverManager.getConnection(url+ "?useLegacyDatetimeCode=false&serverTimezone=UTC" + "&user=" + usuario + "&password=" + password);
    } catch (SQLException e) {  
    JOptionPane.showMessageDialog(null, "Error De Conexion");
    }
    return conx;
   
}
}

