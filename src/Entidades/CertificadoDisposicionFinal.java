package Entidades;

import java.time.LocalDate;
import java.util.ArrayList;

public class CertificadoDisposicionFinal {

    private int id_Certificado;

    private LocalDate fechaMensual;

    private ArrayList<TicketControl> ListaTicket;

    private Transportista t1;

    public CertificadoDisposicionFinal(int id_Certificado, LocalDate fechaMensual, Transportista t1) {
    this.id_Certificado=id_Certificado;
    this.fechaMensual=fechaMensual;
    this.t1=t1;
    }

    public CertificadoDisposicionFinal(LocalDate fechaMensual, Transportista t1) {
    this.fechaMensual=fechaMensual;
    this.t1=t1;
    }

    public CertificadoDisposicionFinal() {
    }

    public int getId_Certificado() {
        return id_Certificado;
    }

    public LocalDate getFechaMensual() {
        return fechaMensual;
    }

    public Transportista getT1() {
        return t1;
    }

    public void setId_Certificado(int id_Certificado) {
        this.id_Certificado = id_Certificado;
    }

    public void setFechaMensual(LocalDate fechaMensual) {
        this.fechaMensual = fechaMensual;
    }

    public void setT1(Transportista t1) {
        this.t1 = t1;
    }

    @Override
    public String toString() {
        return "CertificadoDisposicionFinal{" + "id:" + id_Certificado +",\n Tranportista=" + t1 + "\n Periodo: " + fechaMensual + "\n ListaTicket:{" + ListaTicket +"}"+ '}';
    }

    

}
