
package controlador;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import modelo.ReciboDAO;
import modelo.ReciboSM;
import modelo.Servicio;
import modelo.ServicioDAO;
import utilerias.Log;

/**
 *
 * @author Alejandro
 */
public final class ControladorRecibo {
    public static void generarServicios(ReciboSM rsm){
        ArrayList<Servicio> servicios = ServicioDAO.serviciosConMedidor(false);
        ArrayList<Servicio> lista = new ArrayList<>();
        SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");               

        Date registro = null;
        Date recibo = null;
        try {
            recibo = (Date) formateador.parse("01/"+(rsm.getMes()+1)+"/"+rsm.getAnio());
        } catch (ParseException ex) {
            Log.info("Error: al crear fecha del Recibo", 
                    ControladorRecibo.class.getName(), "generarServicios");
        }
        
        //Elimina los servicios que sean menores a la fecha del recibo
        for(Servicio s: servicios){
            try {
                registro = formateador.parse("01/"+s.getMes()+"/"+s.getAnio());
            } catch (ParseException ex) {
                Log.info("Error: al crear fecha del Registro "+s.getId(), 
                        ControladorRecibo.class.getName(), "generarServicios");
            }
            if(registro.before(recibo))
                lista.add(s);
        }   
        
        //servicios.forEach(s -> System.out.println(s));
        //Elimina los servicios Inactivos
        lista.removeIf(s -> (!s.getEstado().equals("ACTIVO")) );
        //lista.forEach(s -> System.out.println(s));
        ReciboDAO.registrarReciboSM(lista, rsm);
    }
}
