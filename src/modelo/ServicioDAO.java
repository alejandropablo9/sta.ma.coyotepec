package modelo;

import basededatos.SQLite;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import utilerias.Log;
import utilerias.Mensaje;

/**
 *
 * @author Alejandro
 */
public final class ServicioDAO {
    public static final void registrarServicio(Servicio servicio)  {
        Connection cn = SQLite.obtenerConexion();
        Log.info("Accion: INSER INTO Servicio");
        try{
            Statement stmt = cn.createStatement();
            stmt.executeUpdate("INSERT INTO Servicio "
                    + "(no_medidor, ndi_usuario, id_zona, "
                    + "calle, no_calle, usamedidor, estado, mes, anio, notas) VALUES ("
                +servicio.getNo_medidor()+", "
                +servicio.getNdi_usuario()+", "
                +servicio.getCodigo_zona()+", '"
                +servicio.getCalle()+"', '"
                +servicio.getNumero_calle()+"', '"
                +servicio.getUsaMedidor()+"', '"
                +servicio.getEstado()+"', "
                +servicio.getMes()+", "
                +servicio.getAnio()+", '"
                +servicio.getNotas()+"')");            
            stmt.close();
            SQLite.cerrarConexion(cn);   
            Log.info("Servicio: "+servicio.getId()+" ¡REGISTRADO!");
        }catch(Exception e){
            Mensaje.deError("Ocurrio un error al realizar el registro");
            Log.info("Error: "+e);
        }        
    }
    
    public static final void editarServicio(Servicio servicio){
        Connection cn = SQLite.obtenerConexion();
        Log.info("Accion: UPDATE Servicio");
        try{
            String update = "UPDATE Servicio SET no_medidor= ? , ndi_usuario= ? , "+
                    "id_zona= ? , calle= ? , no_calle= ? , usamedidor = ? , "+
                    " estado= ? , mes= ? , anio= ? , notas=? WHERE id_servicio= ? ";
            PreparedStatement estatuto = cn.prepareStatement(update);
            estatuto.setInt(1, servicio.getNo_medidor());
            estatuto.setInt(2, servicio.getNdi_usuario());
            estatuto.setInt(3, servicio.getCodigo_zona());
            estatuto.setString(4, servicio.getCalle());
            estatuto.setString(5, servicio.getNumero_calle());
            estatuto.setString(6, servicio.getUsaMedidor());
            estatuto.setString(7, servicio.getEstado());
            estatuto.setInt(8, servicio.getMes());
            estatuto.setInt(9, servicio.getAnio());            
            estatuto.setString(10, servicio.getNotas());
            estatuto.setInt(11, servicio.getId());
            estatuto.executeUpdate();             
            SQLite.cerrarConexion(cn);
            Log.info("Servicio id: "+servicio.getId()+"¡ACTUALIZADO!");
        }catch(Exception e){
            Mensaje.deError("Ocurrio un error al actualizar");
            Log.info("Error: "+e);
        }
    }
    
    public static final Servicio buscarServicio(int id){
        Servicio serv = new Servicio();
        boolean existe = false;
        Connection cn = SQLite.obtenerConexion();                
        Log.info("Accion: Select Servicio");
        try{
            PreparedStatement consulta = cn.prepareStatement("SELECT * FROM Servicio WHERE id_servicio=? ");
            consulta.setInt(1, id);
            ResultSet res= consulta.executeQuery();            
            while(res.next()){
                existe = true;
                serv.setId(res.getInt(1));
                serv.setNo_medidor(res.getInt(2));
                serv.setNdi_usuario(res.getInt(3));
                serv.setCodigo_zona(res.getInt(4));
                serv.setCalle(res.getString(5));
                serv.setNumero_calle(res.getString(6));
                serv.setUsaMedidor(res.getString(7));      
                serv.setEstado(res.getString(8));
                serv.setMes(res.getInt(9));
                serv.setAnio(res.getInt(10));
                serv.setNotas(res.getString(11));
            }
            res.close();
            SQLite.cerrarConexion(cn);
        }catch(Exception e){
            Mensaje.deError("Ha ocurrido un error");
            Log.info("Error: "+e);
        }
        if(existe)
            return serv;
        return null;
    }
    
    public static final ArrayList<Servicio> serviciosConMedidor(boolean b){
        String usamedidor =  b?"SI":"NO";
            
        ArrayList<Servicio> listaServicios = new ArrayList();
        Connection cn = SQLite.obtenerConexion();
        ResultSet servicios = SQLite.getRegistros("SELECT * FROM Servicio WHERE usamedidor = '"
                +usamedidor+"'", cn);
        try{
            while(servicios.next()){
                Servicio servicio = new Servicio();
                servicio.setId(servicios.getInt(1));
                servicio.setNo_medidor(servicios.getInt(2));
                servicio.setNdi_usuario(servicios.getInt(3));
                servicio.setCodigo_zona(servicios.getInt(4));
                servicio.setCalle(servicios.getString(5));
                servicio.setNumero_calle(servicios.getString(6));
                servicio.setUsaMedidor(servicios.getString(7));
                servicio.setEstado(servicios.getString(8));
                servicio.setMes(servicios.getInt(9));                
                servicio.setAnio(servicios.getInt(10));
                servicio.setNotas(servicios.getString(11));
                listaServicios.add(servicio); 
            }
            servicios.close();
            SQLite.cerrarConexion(cn);
        }catch(Exception e){         
             Mensaje.deError("Ha ocurrido un error");
        } 
        return listaServicios;
    }
}
