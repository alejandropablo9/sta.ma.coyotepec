/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.Cuenta;
import modelo.CuentaDAO;
import modelo.ModelViewCuenta;
import vista.IRegistrosUsuarios;

/**
 *
 * @author alejandro
 */
public class ControladorCuenta {
    
    public static final void validarBusquedaCuentas(Cuenta c){
        if(c.getNombreUsuario().equals("NOMBRE(S)")){
            c.setNombreUsuario("");
        }
        if(c.getApellidosUsuario().equals("APELLIDOS")){
            c.setApellidosUsuario("");
        }
        if(c.getNombreZona().equals("TODAS")){
            c.setNombreZona("");
        }
        IRegistrosUsuarios.actualizaTabla(new ModelViewCuenta(CuentaDAO.cuentasComo(c)));
    }
    
}
