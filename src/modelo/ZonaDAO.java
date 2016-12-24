package modelo;

import basededatos.SQLite;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import utilerias.Mensaje;

/**
 * @author Alejandro
 */
public final class ZonaDAO {
    public static final void registrarZona(Zona zona){
        Connection cn = SQLite.obtenerConexion();
        try{
            Statement stmt = cn.createStatement(); 
            stmt.executeUpdate("INSERT INTO Zona VALUES ('" 
                    +zona.getCodigo()+"', '"
                    +zona.getNombre()+"')");
            Mensaje.deInformacion("Se ha registrado\n¡Exitosamente!");
            stmt.close();
            SQLite.cerrarConexion(cn);
        }catch(Exception e){
            Mensaje.deError("No se ha podido registrar...\n"+e);
        }
    }
    
    public static final void eliminarZona(int codigo){
        Connection cn = SQLite.obtenerConexion();
        try{
            Statement stmt = cn.createStatement();
            stmt.executeUpdate("DELETE FROM Zona WHERE codigo="+codigo);
            Mensaje.deInformacion("Se ha eliminado\n¡Exitosamente!");
            stmt.close();
            SQLite.cerrarConexion(cn);
        }catch(Exception e){
            Mensaje.deError("No se ha sido posible eliminar esta zona...\n"+e);
        }
    }
    
    public static final Zona buscarZona(int codigo){
        Zona z = new Zona();
        boolean existe = false;
        Connection cn = SQLite.obtenerConexion();
        try{
            PreparedStatement consulta = cn.prepareStatement("SELECT * FROM Usuario WHERE NDI=? ");
            consulta.setInt(1, codigo);
            ResultSet res= consulta.executeQuery();            
            while(res.next()){
                existe = true;
                z.setCodigo(res.getInt("codigo"));
                z.setNombre(res.getString("nombre"));
            }
            res.close();
            SQLite.cerrarConexion(cn);            
        }catch(Exception e){
            Mensaje.deError("Ha ocurrido un error"+e);
            //LOG
        }
        if(existe)
            return z;             
        return null;
    }
    
    public static ArrayList<Zona> todasLasZonas(){
        ArrayList<Zona> listaZonas = new ArrayList();
        Connection cn = SQLite.obtenerConexion();
        ResultSet zonas = SQLite.getRegistros("SELECT * FROM Zona", cn);
        try{
            while(zonas.next()){
                Zona zona = new Zona();
                zona.setCodigo(zonas.getInt(1));
                zona.setNombre(zonas.getString(2));
                listaZonas.add(zona);
            }
            zonas.close();
            SQLite.cerrarConexion(cn);
        }catch(Exception e){
            Mensaje.deError("Ha ocurrido un error"+e);
        }
        return listaZonas;
    } 
    
}
