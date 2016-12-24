package controlador;

import modelo.Usuario;
import modelo.UsuarioDAO;
import utilerias.Conversion;
import utilerias.Mensaje;

/**
 *
 * @author alejandro
 */

/*##################################
*****Validaciones para Usuario******
*###################################*/

public class ControladorUsuario {
    
    public static final boolean validarRegistroUsuario(Usuario usuario){
        if((usuario.getNdi() != 0) && !usuario.getNombre().equals("") &&
                !usuario.getApellidos().equals("")){
            if(Conversion.deIntAString(usuario.getNdi()).length() == 8){
                if(UsuarioDAO.buscarUsuario(usuario.getNdi()) == null){
                    UsuarioDAO.registrarUsuario(usuario);                 
                }                
                return true;
            }else{
                Mensaje.deEmergencia("* NDI invalido");
                return false;
            }
        }else{
            Mensaje.deEmergencia("* NDI, Nombre y Apellidos *\nNo pueden estar vacios");            
        }
        return false;
    }
    
    public static final Usuario validarConsultaUsuarioConNDI(int ndi){        
        if(ndi != 0){
            return UsuarioDAO.buscarUsuario(ndi);
        }
        else{
            Mensaje.deEmergencia("El NDI: No es Valido");
        }
        return null;
    }
    
    public static final boolean validarModificarUsuario(Usuario usuario){
        if(!usuario.getNombre().equals("") && !usuario.getApellidos().equals("") 
                && Conversion.deIntAString(usuario.getNdi()).length() == 8){            
              UsuarioDAO.editarUsuario(usuario);
              return true;
        }
        Mensaje.deEmergencia("* NDI, Nombre y Apellidos *\nNo pueden estar vacios");            
        return false;
    }
}
