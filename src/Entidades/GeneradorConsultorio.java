package Entidades;

import java.util.Objects;

public class GeneradorConsultorio {

    private int id_Consultorio;

    private String nombre;

    private String cuit;

    private String domicilio;
    
    private boolean estado;

    public GeneradorConsultorio(int id_Consultorio,String nombre,String cuit,String domicilio,boolean estado) {
    this.id_Consultorio=id_Consultorio;
    this.nombre=nombre;
    this.cuit=cuit;
    this.domicilio=domicilio;
    this.estado=estado;
    }

    public GeneradorConsultorio(String nombre, String cuit, String domicilio,boolean estado) {
     this.nombre=nombre;
    this.cuit=cuit;
    this.domicilio=domicilio;
    this.estado=estado;
    }

    public GeneradorConsultorio() {
    }

    public void setId_Consultorio(int id_Consultorio) {
        this.id_Consultorio = id_Consultorio;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public int getId_Consultorio() {
        return id_Consultorio;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCuit() {
        return cuit;
    }

    public String getDomicilio() {
        return domicilio;
    }

     public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final GeneradorConsultorio other = (GeneradorConsultorio) obj;
        return this.id_Consultorio == other.id_Consultorio;
    }

    

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("GeneradorConsultorio{");
        sb.append("Id:").append(id_Consultorio);
        sb.append(", Nombre: ").append(nombre);
        sb.append(", CUIT: ").append(cuit);
        sb.append(", Domicilio: ").append(domicilio);
        sb.append(", Estado de Actividad:").append(estado);
        sb.append('}');
        return sb.toString();
    }

   
    
    
}
