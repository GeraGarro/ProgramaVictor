package Entidades;

public class GeneradorConsultorio {

    private int id_Consultorio;

    private String nombre;

    private String cuit;

    private String domicilio;

    public GeneradorConsultorio(int id_Consultorio,String nombre,String cuit,String domicilio) {
    this.id_Consultorio=id_Consultorio;
    this.nombre=nombre;
    this.cuit=cuit;
    this.domicilio=domicilio;}

    public GeneradorConsultorio(String nombre, String cuit, String domicilio) {
     this.nombre=nombre;
    this.cuit=cuit;
    this.domicilio=domicilio;
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

    @Override
    public String toString() {
        return "GeneradorConsultorio:{" + "id:" + id_Consultorio + "\n Nombre: " + nombre + "\n CUIT: " + cuit + "\n Domicilio: " + domicilio + '}';
    }
    
    
}
