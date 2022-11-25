package Entidades;

public enum Residuo {

    A1("Materiales Organicos",0.0),
    A2("Materiales Inorganicos",0.0);
    
    private String tipo;
    private double peso;

    private Residuo(String tipo, double peso) {
        this.tipo = tipo;
        this.peso = peso;
    }
    
    public Residuo[] getResiduo(){
        return Residuo.values();
    }

    public String getTipo() {
        return tipo;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    @Override
    public String toString() {
        return "Residuo{" + "tipo=" + tipo + ", peso=" + peso + '}';
    }
    
   
}
