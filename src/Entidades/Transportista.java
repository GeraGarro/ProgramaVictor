package Entidades;

import java.util.Objects;


public class Transportista {
       
    private int id;
    private String nombre;
    private String apellido;
    private String cuit;
    private boolean estado;
    
    public Transportista(int id,String nombre,String apellido,String cuit,boolean estado){
        this.id=id;
        this.nombre=nombre;
        this.apellido=apellido;
        this.cuit=cuit;
        this.estado=estado;
    }

    public Transportista(String nombre, String apellido, String cuit, boolean estado) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cuit = cuit;
        this.estado = estado;
    }

    public Transportista() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Transportista)) return false;
    Transportista that = (Transportista) o;
    return getId() == that.getId() &&
           Objects.equals(getCuit(), that.getCuit());
}
    
    @Override
    public String toString() {
        return "Transportista N°" + id + "{ Nombre:" + nombre + " " + apellido + ", CUIT: " + cuit + ", Estado: " + estado + '}';
    }
    
    
    
}
