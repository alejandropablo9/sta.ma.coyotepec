package modelo;

import basededatos.SQLite;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import utilerias.Log;
import utilerias.Mensaje;

/**
 *
 * @author alejandro
 */
public final class ViewReciboDAO {
    
    public static ViewRecibo reciboDelServicioConFecha(int mes, int anio, int id_servicio){
        ViewRecibo vr = new ViewRecibo();
        Connection cn = SQLite.obtenerConexion();       
        boolean existe = false;
        try{
            PreparedStatement consulta = cn.prepareStatement("SELECT * FROM recibos WHERE "
                    + "id_servicio= ? AND mes= ? AND anio= ?");
            consulta.setInt(1, id_servicio);
            consulta.setInt(2, mes);
            consulta.setInt(3, anio);
            ResultSet res= consulta.executeQuery();            
            while(res.next()){
                existe = true;
                vr.setId_recibo(res.getInt(1));
                vr.setNdi(res.getInt(2));
                vr.setNombre(res.getString(3));
                vr.setApellidos(res.getString(4));
                vr.setZona(res.getString(5));
                vr.setCalle(res.getString(6));
                vr.setNodecalle(res.getString(7));
                vr.setEstado(res.getString(8));
                vr.setMes(res.getInt(9));
                vr.setAnio(res.getInt(10));
                vr.setId_servicio(res.getInt(11));
                vr.setMonto(res.getInt(12));        
            }
            res.close();
            Log.info(ViewReciboDAO.class.getName(), "reciboDelServicioConFecha()", "consultado: "+vr);
            SQLite.cerrarConexion(cn);
        }catch(SQLException e){
            Mensaje.deError("Ha ocurrido un error"+e);
            Log.info(ViewReciboDAO.class.getName(), "reciboDelServicioConFecha()", "Error: "+e);
        }
        if(existe)
            return vr;
        return null;
    }
    
    public static ArrayList<ViewRecibo> recibosDeLaFecha(int mes, int anio) {
        ArrayList<ViewRecibo> listaRecibos = new ArrayList();
        Connection cn = SQLite.obtenerConexion();
        ResultSet recibos = SQLite.getRegistros("SELECT * FROM recibos "
                                                +"WHERE mes = "+mes
                                                +" AND anio = "+anio, cn);
        try{
            while(recibos.next()){
                ViewRecibo vr = new ViewRecibo();
                vr.setId_recibo(recibos.getInt(1));
                vr.setNdi(recibos.getInt(2));
                vr.setNombre(recibos.getString(3));
                vr.setApellidos(recibos.getString(4));
                vr.setZona(recibos.getString(5));
                vr.setCalle(recibos.getString(6));
                vr.setNodecalle(recibos.getString(7));
                vr.setEstado(recibos.getString(8));
                vr.setMes(recibos.getInt(9));
                vr.setAnio(recibos.getInt(10));
                vr.setId_servicio(recibos.getInt(11));
                vr.setMonto(recibos.getInt(12));
                listaRecibos.add(vr);                
            }   
            recibos.close();
            SQLite.cerrarConexion(cn);
        }catch(Exception e){
            Log.info(ViewReciboDAO.class.getName(), "recibosDeLaFecha()", "Error: "+e);
            Mensaje.deError("Ha ocurrido un error"+e);
        }
        return listaRecibos;
    }
    
    public static ArrayList<ViewRecibo> todosLosRecibos() {
        ArrayList<ViewRecibo> listaRecibos = new ArrayList();
        Connection cn = SQLite.obtenerConexion();
        ResultSet recibos = SQLite.getRegistros("SELECT * FROM recibos", cn);
        try{
            while(recibos.next()){
                ViewRecibo vr = new ViewRecibo();
                vr.setId_recibo(recibos.getInt(1));
                vr.setNdi(recibos.getInt(2));
                vr.setNombre(recibos.getString(3));
                vr.setApellidos(recibos.getString(4));
                vr.setZona(recibos.getString(5));
                vr.setCalle(recibos.getString(6));
                vr.setNodecalle(recibos.getString(7));
                vr.setEstado(recibos.getString(8));
                vr.setMes(recibos.getInt(9));
                vr.setAnio(recibos.getInt(10));
                vr.setId_servicio(recibos.getInt(11));
                vr.setMonto(recibos.getInt(12));
                listaRecibos.add(vr);                
            }   
            recibos.close();
            SQLite.cerrarConexion(cn);
        }catch(SQLException e){
            Log.info(ViewReciboDAO.class.getName(), "todosLosRecibos()", "Error: "+e);
            Mensaje.deError("Ha ocurrido un error"+e);
        }
        return listaRecibos;
    }
    
    public static ArrayList<ViewRecibo> recibosComo(ViewRecibo vrecibo) {
        ArrayList<ViewRecibo> listaRecibos = new ArrayList();
        Connection cn = SQLite.obtenerConexion();
        ResultSet recibos = SQLite.getRegistros("SELECT * FROM recibos"
                + " WHERE zona LIKE '"+vrecibo.getZona()+"%' AND nombre LIKE '"
                + vrecibo.getNombre()+"%' AND apellidos LIKE '"+vrecibo.getApellidos()+"%'"
                + " AND estado = '" +vrecibo.getEstado()+"' "
                + " AND calle LIKE '"+vrecibo.getCalle()+"%' AND anio = " +vrecibo.getAnio() 
                + " AND mes = " +vrecibo.getMes(), cn);
        try{
            while(recibos.next()){
                ViewRecibo vr = new ViewRecibo();
                vr.setId_recibo(recibos.getInt(1));
                vr.setNdi(recibos.getInt(2));
                vr.setNombre(recibos.getString(3));
                vr.setApellidos(recibos.getString(4));
                vr.setZona(recibos.getString(5));
                vr.setCalle(recibos.getString(6));
                vr.setNodecalle(recibos.getString(7));
                vr.setEstado(recibos.getString(8));
                vr.setMes(recibos.getInt(9));
                vr.setAnio(recibos.getInt(10));
                vr.setId_servicio(recibos.getInt(11));
                vr.setMonto(recibos.getInt(12));
                listaRecibos.add(vr);                
            }   
            recibos.close();
            SQLite.cerrarConexion(cn);
        }catch(SQLException e){
            Log.info(ViewReciboDAO.class.getName(), "recibosComo()", "Error: "+e);
            Mensaje.deError("Ha ocurrido un error"+e);
        }
        return listaRecibos;
    }
    
    public static ArrayList<ViewRecibo> recibosdelServicio(int id_servicio) {
        ArrayList<ViewRecibo> listaRecibos = new ArrayList();
        Connection cn = SQLite.obtenerConexion();
        ResultSet recibos = SQLite.getRegistros("SELECT * FROM recibos"
                + " WHERE id_servicio = "+id_servicio, cn);
        try{
            while(recibos.next()){
                ViewRecibo vr = new ViewRecibo();
                vr.setId_recibo(recibos.getInt(1));
                vr.setNdi(recibos.getInt(2));
                vr.setNombre(recibos.getString(3));
                vr.setApellidos(recibos.getString(4));
                vr.setZona(recibos.getString(5));
                vr.setCalle(recibos.getString(6));
                vr.setNodecalle(recibos.getString(7));
                vr.setEstado(recibos.getString(8));
                vr.setMes(recibos.getInt(9));
                vr.setAnio(recibos.getInt(10));
                vr.setId_servicio(recibos.getInt(11));
                vr.setMonto(recibos.getInt(12));
                listaRecibos.add(vr);                
            }   
            recibos.close();
            SQLite.cerrarConexion(cn);
        }catch(SQLException e){
            Log.info(ViewReciboDAO.class.getName(), "recibosdelServicio()", "Error: "+e);
            Mensaje.deError("Ha ocurrido un error"+e);
        }
        return listaRecibos;
    }
    
}
