package controlador;

import modelo.Zona;
import modelo.ZonaDAO;
import utilerias.Mensaje;

/**
 *
 * @author alejandro
 */
     /*##################################
    *****Validaciones para Zona*********
    *###################################*/
public final class ControladorZona {


    public static final void validarRegistroZona(Zona zona){
        if(!zona.getNombre().equals("") && zona.getCodigo() != 0){
            ZonaDAO.registrarZona(zona);
        }else{
            Mensaje.deEmergencia("Codigo y Nombre no pueden estar vacios\n"+
                    "Ni el código puede ser 0");
        }
    }
    
}
