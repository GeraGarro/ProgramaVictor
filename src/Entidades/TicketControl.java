package Entidades;

import java.time.LocalDate;

public class TicketControl {

    private int id_ticket;

    private Transportista transportista;

    private LocalDate fecha;

    private GeneradorConsultorio consultorio;
    

    public TicketControl(int id_ticket, Transportista transportista, LocalDate fecha, GeneradorConsultorio consultorio) {
        this.id_ticket=id_ticket;
        this.transportista=transportista;
        this.fecha=fecha;
        this.consultorio=consultorio;
       
    }

    public TicketControl(Transportista transportista, LocalDate fecha, GeneradorConsultorio consultorio) {
        this.transportista=transportista;
        this.fecha=fecha;
        this.consultorio=consultorio;
    }

    
    
    public TicketControl() {
    }

    public int getId_ticket() {
        return id_ticket;
    }

    public void setId_ticket(int id_ticket) {
        this.id_ticket = id_ticket;
    }

    public Transportista getTransportista() {
        return transportista;
    }

    public void setTransportista(Transportista transportista) {
        this.transportista = transportista;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

  
  

      
    public GeneradorConsultorio getConsultorio() {
        return consultorio;
    }

   
    public void setConsultorio(GeneradorConsultorio consultorio) {
        this.consultorio = consultorio;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TicketControl{");
        sb.append("id_ticket:").append(id_ticket);
        sb.append(", Transportista:").append(transportista);
        sb.append(", Fecha:").append(fecha);
        sb.append(", Consultorio:").append(consultorio);
        sb.append('}');
        return sb.toString();
    }

   
    
    
}
