package modelo;

import basededatos.SQLite;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import utilerias.Mensaje;

/**
 *
 * @author Alejandro
 */
public final class CuentaDAO {
    public static final ArrayList<Cuenta> todasLasCuentas(){
        ArrayList<Cuenta> listaCuentas = new ArrayList();
        Connection cn = SQLite.obtenerConexion();
        ResultSet cuentas = SQLite.getRegistros("SELECT * FROM cuenta", cn);
        try{
            while(cuentas.next()){
                Cuenta cuenta = new Cuenta();
                cuenta.setId(cuentas.getInt(1));
                cuenta.setNdiUsuario(cuentas.getInt(2));
                cuenta.setNombreUsuario(cuentas.getString(3));
                cuenta.setApellidosUsuario(cuentas.getString(4));
                cuenta.setNoMedidor(cuentas.getInt(5));
                cuenta.setNombreZona(cuentas.getString(6));
                cuenta.setCalleServicio(cuentas.getString(7));
                cuenta.setEstadoUsuario(cuentas.getString(8));
                listaCuentas.add(cuenta);                
            }   
            cuentas.close();
            SQLite.cerrarConexion(cn);
        }catch(Exception e){
            Mensaje.deError("Ha ocurrido un error"+e);
        }
        return listaCuentas;
    }
    
    public static final ArrayList<Cuenta> cuentasComo(Cuenta c){
        ArrayList<Cuenta> listaCuentas = new ArrayList();
        Connection cn = SQLite.obtenerConexion();
        ResultSet cuentas = SQLite.getRegistros("SELECT * FROM cuenta WHERE zona LIKE '"
                +c.getNombreZona()+"%' AND nombre LIKE '"+c.getNombreUsuario()+"%' AND apellidos LIKE '"
                +c.getApellidosUsuario()+"%'", cn);
        try{
            while(cuentas.next()){
                Cuenta cuenta = new Cuenta();
                cuenta.setId(cuentas.getInt(1));
                cuenta.setNdiUsuario(cuentas.getInt(2));
                cuenta.setNombreUsuario(cuentas.getString(3));
                cuenta.setApellidosUsuario(cuentas.getString(4));
                cuenta.setNoMedidor(cuentas.getInt(5));
                cuenta.setNombreZona(cuentas.getString(6));
                cuenta.setCalleServicio(cuentas.getString(7));
                cuenta.setEstadoUsuario(cuentas.getString(8));
                listaCuentas.add(cuenta); 
            }
            cuentas.close();
            SQLite.cerrarConexion(cn);
        }catch(Exception e){         
             Mensaje.deError("Ha ocurrido un error"+e);
        } 
        return listaCuentas;
    }
}
