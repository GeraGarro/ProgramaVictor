package Entidades;

import java.time.LocalDate;
import java.util.ArrayList;

public class CertificadoDisposicionFinal {

    private int id_Certificado;

    private LocalDate fechaMensual;

    private Transportista transportista;
    
    private float totalPeso;

    public CertificadoDisposicionFinal(int id_Certificado, LocalDate fechaMensual, Transportista transportista, float totalPeso) {
    this.id_Certificado=id_Certificado;
    this.fechaMensual=fechaMensual;
    this.transportista=transportista;
    this.totalPeso=totalPeso;
    }

    public CertificadoDisposicionFinal(LocalDate fechaMensual, Transportista transportista,float totalPeso) {
    this.fechaMensual=fechaMensual;
    this.transportista=transportista;
    this.totalPeso=totalPeso;
    }

    public CertificadoDisposicionFinal() {
    }

    public float getTotalPeso() {
        return totalPeso;
    }

    public void setTotalPeso(float totalPeso) {
        this.totalPeso = totalPeso;
    }

    public int getId_Certificado() {
        return id_Certificado;
    }

    public LocalDate getFechaMensual() {
        return fechaMensual;
    }

    public Transportista getTransportista() {
        return transportista;
    }

    public void setId_Certificado(int id_Certificado) {
        this.id_Certificado = id_Certificado;
    }

    public void setFechaMensual(LocalDate fechaMensual) {
        this.fechaMensual = fechaMensual;
    }

    public void setTransportista(Transportista transportista) {
        this.transportista = transportista;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CertificadoDisposicionFinal{");
        sb.append("id_Certificado=").append(id_Certificado);
        sb.append(", fechaMensual=").append(fechaMensual);
        sb.append(", transportista=").append(transportista);
        sb.append(", totalPeso=").append(totalPeso);
        sb.append('}');
        return sb.toString();
    }
    
    

    

    

}
