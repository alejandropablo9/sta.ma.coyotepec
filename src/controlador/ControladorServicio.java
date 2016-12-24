package controlador;

import modelo.Servicio;
import modelo.ServicioDAO;
import utilerias.Mensaje;

/**
 *
 * @author alejandro
 */

/*##################################
*****Validaciones para Servicio*****
*###################################*/
    
public class ControladorServicio {
    
    public static final boolean validarRegistroServicio(Servicio servicio){
        if(!servicio.getCalle().equals("")){
            if(servicio.usaMedidor()){
                if(servicio.getNo_medidor() != 0){
                    //el registro se realiza
                    ServicioDAO.registrarServicio(servicio);
                    return true;
                }else{
                    Mensaje.deEmergencia("*No. de medidor no es valido*");
                    return false;
                }
            }else{
                ServicioDAO.registrarServicio(servicio);
                return true;
            }
        }else{
            Mensaje.deEmergencia("*No. de medidor y Calle*\nNo pueden estar vacio");
        }
        return false;
    }   
    
    public static final Servicio validarConsultaServicio(int id){
        if(id != 0){
            return ServicioDAO.buscarServicio(id);
        }
        else{
            Mensaje.deEmergencia("El NDI: No es Valido");
        }
        return null;
    }
    
    public static final boolean validarModificarServicio(Servicio servicio){
        if(!servicio.getCalle().equals("")){
            if(servicio.usaMedidor()){
                if(servicio.getNo_medidor() != 0){
                    //el registro se realiza
                    ServicioDAO.editarServicio(servicio);
                    return true;
                }else{
                    Mensaje.deEmergencia("*No. de medidor no es valido*");
                    return false;
                }
            }else{
                ServicioDAO.editarServicio(servicio);
                return true;
            }
        }else{
            Mensaje.deEmergencia("*No. de medidor y Calle*\nNo pueden estar vacio");
        }
        return false;
    }
}
