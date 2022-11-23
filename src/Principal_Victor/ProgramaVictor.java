package Principal_Victor;

import Data.TicketControl_Data;
import Entidades.Conexion;
import Entidades.GeneradorConsultorio;
import Entidades.Residuo;
import Entidades.TicketControl;
import Entidades.Transportista;
import java.sql.Connection;
import java.time.LocalDate;
import java.time.Month;


public class ProgramaVictor {


    public static void main(String[] args) {
       GeneradorConsultorio c1=new GeneradorConsultorio(1,"Crespo Carlos", "2012341011", "Colon 820");
        
        TicketControl tk1=new TicketControl(Transportista.TRANSPORTISTA, LocalDate.of(22, Month.NOVEMBER, 23), Residuo.A1, c1);
       
        TicketControl_Data tkD=new TicketControl_Data();
        
       tkD.agregarTicket(tk1);
    }
    
    
}
