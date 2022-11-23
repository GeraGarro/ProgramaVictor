package Entidades;

import java.time.LocalDate;

public class TicketControl {

    private int id_ticket;

    private Transportista t1;

    private LocalDate fecha;

    private Residuo r1;

    private GeneradorConsultorio c1;
    
    private float peso;

    public TicketControl(int id_ticket, Transportista t1, LocalDate fecha, Residuo r1, GeneradorConsultorio c1) {
        this.id_ticket=id_ticket;
        this.t1=t1;
        this.fecha=fecha;
        this.r1=r1;
        this.c1=c1;
       ;
    }

    public TicketControl(Transportista t1, LocalDate fecha, Residuo r1, GeneradorConsultorio c1) {
        this.t1=t1;
        this.fecha=fecha;
        this.r1=r1;
        this.c1=c1;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public TicketControl() {
    }

    public int getId_ticket() {
        return id_ticket;
    }

    public void setId_ticket(int id_ticket) {
        this.id_ticket = id_ticket;
    }

    public Transportista getT1() {
        return t1;
    }

    public void setT1(Transportista t1) {
        this.t1 = t1;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Residuo getR1() {
        return r1;
    }

    public void setR1(Residuo r1) {
        this.r1 = r1;
    }

    public GeneradorConsultorio getC1() {
        return c1;
    }

    public void setC1(GeneradorConsultorio c1) {
        this.c1 = c1;
    }

    @Override
    public String toString() {
        return "TicketControl{" + "Id: " + id_ticket + ", Transportista: " + t1 + ", Fecha: " + fecha + ", Consultorio" + r1 + ", Residuo: " + c1 + '}';
    }
    
    
}
