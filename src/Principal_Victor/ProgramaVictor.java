package Principal_Victor;

import Data.Certificado_Data;
import Data.GeneradorConsultorio_Data;
import Data.Residuo_Data;
import Data.TicketControl_Data;
import Data.TipoResiduo_Data;
import Data.Transportista_Data;
import Entidades.CertificadoDisposicionFinal;
import Entidades.Conexion;
import Entidades.GeneradorConsultorio;
import Entidades.Residuo;
import Entidades.TicketControl;
import Entidades.TipoResiduo;
import Entidades.Transportista;
import com.sun.xml.internal.bind.v2.TODO;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import javax.swing.JFrame;


public class ProgramaVictor {

    public static void main(String[] args) throws SQLException {
        
         

        //CREACION DE UN OBJETO TIPO TIPORESIDUO Y AGREGACION EN LA BASE DE DATOS EN LA TABLA CORRESPONDIENTE
         TipoResiduo tp=new TipoResiduo("Material Ultra Fino",false);
         
         TipoResiduo_Data tr_Data=new TipoResiduo_Data();
         
         //tr_Data.CrearTipoResiduo(tp);
         
          //CAMBIO DE ESTADO DEL TIPORESIDUO -> SI ESTA ACTIVO PASA A INACTIVO Y VISEVERSA
         //tr_Data.CambiarEstadoTipoResiduo(3);
         
         
         //RECORRER TODOS LOS TIPOS DE RESIDUOS EN LA BD;
         
         /*for (TipoResiduo T_residuo : tr_Data.ListaTipoResiduoTodos()) {
             System.out.println(T_residuo);
         }*/
         
         //RECORRER TODOS LOS RESIDUOS ACTIVOS EN LA BD;
         
         /*for (TipoResiduo Residuo : tr_Data.ListaTipoResiduoActivos()) {
             System.out.println(Residuo);
        }*/
         
         //MODIFICAR UN DATO DE UNA FILA DE LA TABLA TIPORESIDUO        
         //tr_Data.modificarTipoResiduo(tp, 1);
        
         //BUSCADOR DE TIPORESIDUO POR NOMBRE(STRING)
        /*for (TipoResiduo tipoResiduo : tr_Data.buscarTiposResiduosPorNombre("re")) {
            System.out.println(tipoResiduo);*/
        
     //CREAR NUEVO TRANSPORTISTA
      //  Transportista t1=new Transportista("Pepe","Argento","20073554129",false);
        
        Transportista_Data tD=new Transportista_Data();
    
       // tD.crearTransportista(t1);
       
       //CAMBIAR EL ESTADO DE ACTIVIDAD DEL TRANSPORTISTA ELEGIDO
       //tD.CambiarEstadoTransportista(1);
       
       //REALIZAR MODIFICACION A UN TRANSPORTISTA 
       
       /*Transportista t2=new Transportista("Matias", "Lombardo", "2033489173", false);
       
       tD.modificarTransportista(t2, 3);*/
       
       //RECCORRER TODOS LOS TRANSPORTISTA EXISTENTES EN LA BD
       
        /*for (Transportista t : tD.listaTransportistaTodos()) {
            System.out.println(t);
        }*/
        
        //RECCORRER TODOS LOS TRANSPORTISTA ACTIVOS EN LA BD
        /*    System.out.println("Lista Transportistas Activos");
        for (Transportista t : tD.listaTransportistaActivos()) {
            System.out.println(t);
        }*/
                    //GENERADORCONSULTORIO
           GeneradorConsultorio_Data gC_D=new GeneradorConsultorio_Data();         
        
                //AGREGAR NUEVO GENERADOR_CONSULTORIO
                    /*GeneradorConsultorio gC=new GeneradorConsultorio("Aliance", "253100421", "Las Heras 433", true);
                    GeneradorConsultorio gC2=new GeneradorConsultorio("Daniel Diaz", "305411013", "Maipu 719", true);
        
                    gC_D.agregarGenerador(gC2);*/
                    
                //CAMBIAR ESTADO CONSULTORIO
                    //gC_D.cambiarEstadoConsultorio(6);
                    
                //LISTAR TODOS LOS CONSULTORIOS
                 /*   System.out.println("Lista General de Consultorios en BD:");
                for (GeneradorConsultorio consultorio : gC_D.listarConsultoriosTodos()) {
                    System.out.println(consultorio);
        }*/
   
                //LISTAR CONSULTORIOS ACTIVOS
                /*System.out.println("Lista Consultorios Activos:");
                for (GeneradorConsultorio gC_activos : gC_D.listaConsultoriosActivos()) {
                    System.out.println(gC_activos);
        }*/
    
                //REALIZAR LA MODIFICACION EN UN GENERADORCONSULTORIO
    
                /*GeneradorConsultorio gC2=new GeneradorConsultorio("Raul Zapata", "140214110", "Maipu 1209", true);
                gC_D.modificarConsultorio(gC2, 3);*/
                
              //  TICKETCONTROL_DATA
                
              //GENERAR NUEVO TICKETCONTROL
              Transportista_Data tD2=new Transportista_Data();
              Transportista t_noBD=new Transportista("German", "Castro", "1401211", true);
              Transportista t= tD2.obtenerTransportista(1);
             
              //System.out.println(t);  
              
              GeneradorConsultorio gC_noExisteDb=new GeneradorConsultorio("Cenyr", "1234101", "Ayacucho 123", true); //Prueba no exite en DB
              GeneradorConsultorio_Data gC_D2=new GeneradorConsultorio_Data();
              GeneradorConsultorio gC= gC_D2.obtenerGeneradorConsultorio(2);
              
              //System.out.println(gC);
              
             TicketControl tk_paraAgregar=new TicketControl(t, LocalDate.of(2022, Month.MARCH, 17), gC);
              
              TicketControl tk_noBD=new TicketControl(t_noBD, LocalDate.now(), gC_noExisteDb);
              
               TicketControl_Data tk_Data=new TicketControl_Data();
              // tk_Data.CrearTicketControl(tk_paraAgregar);
              

              //OBTENCION DEL DATO DE UNA FILA DE LA TABLA TICKET para CREAR UN OBJETO RESIDUO QUE CUMPLA LA RESTRICCION Y VINCULO CON EL TICKET DEL DB
              TipoResiduo_Data tR_D=new TipoResiduo_Data();
              //TipoResiduo tR=tR_D.ObtenerTipoResiduo(1);
              TipoResiduo tR_inventado=new TipoResiduo("Papa", true);
              
              TicketControl_Data tk_D=new TicketControl_Data();
           //   TicketControl tk_DB=tk_D.obtenerTicket(33,conx);
              
             // System.out.println(tk_DB);
             // Residuo r=new Residuo(tR, 87, tk_DB,false);
              //Residuo r_inventado=new Residuo(tR_D.ObtenerTipoResiduo(2), 710, tk_DB, true); // CREACION DE UN OBJETO RESIDUO QUE NO TIENE VINCULO CON NINGUN TICKET DEL DB
              
              
            
              
              //CREACION DE UN OBJETO RESIDUO CON VINCULO A UN TICKETCONTROL DEL DB
              Residuo_Data rD=new Residuo_Data();
              //rD.agregarResiduo(r_inventado);
              
             
             //COMPROBACION DE EL BUSCADOR DE RESIDUO COLOCANDOLE UN STRING 
             /*for (Residuo R : rD.buscarResiduoPorTipo("INO")) {
                 System.out.println(R);
        }*/
             //ELIMINACION DE UN ID RESIDUO
            // rD.eliminarResiduo(26);
             
             //LISTAR TODOS LOS OBJETOS RESIDUO DE LA BASE DE DATOS
             /*System.out.println("Lista de Todos los residuos de la BD:");
             for (Residuo r : rD.listarResiduosTodos()) {
                 System.out.println(r);
        }*/
    
            //LISTAR LOS RESIDUOS ACTIVOS SOLAMENTE DE LA BASE DE DATOS
            /*System.out.println("Lista de Activos los residuos de la BD:");
             for (Residuo r : rD.listarResiduosActivos()) {
                 System.out.println(r);
        }*/
    
            //MODIFICAR UN RESIDUO
            /*Residuo r_prueba= new Residuo(tr_Data.ObtenerTipoResiduo(1), 100, tk_Data.obtenerTicket(21), false);
            
            rD.modificarResiduo(r_prueba, 14);*/
            
            //ELIMINAR TICKET DE LA BASE DE DATOS JUNTO A LOS RESIDUOS RELACIONADOS EN LA TABLA RESIDUO
            
          //  tk_Data.eliminarTicket(19);
            
            //MOSTRAR LISTA DE TODOS LOS TICKETS
           /* System.out.println("Lista de Todos los Tickets en la Base de Datos");
            for (TicketControl ticket : tk_Data.listaTicketsTodos()) {
                System.out.println(ticket);*/
           
           //MODIFICAR UN TICKET YA EXISTENTE
         /* TicketControl t_aModif=tk_Data.obtenerTicket(24);//cargamos un ticket ya existente
          System.out.println(t_aModif);                     //datos actuales
          t_aModif.setTransportista(tD.obtenerTransportista(1));//Modificamos el consultorio relacionado al ticket
          
          tk_Data.modificarTicket(t_aModif,24);*/
         
         //GENERAR NUEVO CERTIFICADO
         Certificado_Data cert_Data= new Certificado_Data();
         //CertificadoDisposicionFinal cDF=new CertificadoDisposicionFinal(LocalDate.of(2023, Month.APRIL, 12),tD.obtenerTransportista(1), 0);
         
         //cert_Data.generarNuevoCertificado(cDF);
         
         //LISTAR LOS CERTIFICADOS
         
        // for (CertificadoDisposicionFinal Certificado : cert_Data.listaCertificados()) {
           //  System.out.println(Certificado);
       // }
    
    main principal=new main();
        principal.setVisible(true);
    }
    }
    
    

       
        
        
        
    
    
    
    

