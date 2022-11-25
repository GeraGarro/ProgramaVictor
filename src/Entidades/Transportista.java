package Entidades;

public enum Transportista {

    TRANSPORTISTA1("Victor Alvarez","1111","2222");
    
    private String nombre;
    private String cuit;
    private String legajo;

    private Transportista(String nombre, String cuit, String legajo) {
        this.nombre = nombre;
        this.cuit = cuit;
        this.legajo = legajo;
    }
    

    public String getNombre() {
        return nombre;
    }

    public String getCuit() {
        return cuit;
    }

    public String getLegajo() {
        return legajo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public void setLegajo(String legajo) {
        this.legajo = legajo;
    }

    @Override
    public String toString() {
        return "Transportista{" + "Nombre: " + nombre + ", CUIT: " + cuit + ", Legajo: " + legajo + '}';
    }
    
   
 
}
