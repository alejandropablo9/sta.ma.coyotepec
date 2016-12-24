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
public final class UsuarioDAO {
    
    public static final void registrarUsuario(Usuario usuario){
        Connection cn = SQLite.obtenerConexion();
        Log.info("Accion: INSER INTO Usuario");
        try{
            Statement stmt = cn.createStatement(); 
            stmt.executeUpdate("INSERT INTO Usuario Values ("+
                    usuario.getNdi()+", '"+usuario.getNombre()+"', '"+
                    usuario.getApellidos()+"', '"+usuario.getTelefono()+"')");
            //Mensaje.deInformacion("Se ha registrado\n¡Exitosamente!");
            Log.info("Usuario: "+usuario.getNdi()+" ¡REGISTRADO!");
            stmt.close();
            SQLite.cerrarConexion(cn);
        }catch(Exception e){
            Mensaje.deError("Ocurrio un error al realizar el registro");
            Log.info("Error: "+e);
        }
    }
    
    public static final void eliminarUsuario(int id){
        Connection cn = SQLite.obtenerConexion();
        try{
            Statement stmt = cn.createStatement();
            stmt.executeUpdate("DELETE FROM Usuario WHERE codigo="+id);
            Mensaje.deInformacion("Se ha eliminado\n¡Exitosamente!");
            stmt.close();
            SQLite.cerrarConexion(cn);
        }catch(Exception e){
            Mensaje.deError("No se ha sido posible eliminar esta zona...\n"+e);
        }
    }
    
    public static final void editarUsuario(Usuario c){
        Connection cn = SQLite.obtenerConexion();
        Log.info("Accion: UPDATE Usuario");
        try{
            String update = "UPDATE Usuario SET NDI= ?, nombre= ? , apellidos= ? , telefono= ? WHERE NDI= ? ";
            PreparedStatement estatuto = cn.prepareStatement(update);
            estatuto.setInt(1, c.getNdi());
            estatuto.setString(2, c.getNombre());
            estatuto.setString(3, c.getApellidos());
            estatuto.setString(4, c.getTelefono());            
            estatuto.setInt(5, c.getNdi());
            estatuto.executeUpdate();             
            SQLite.cerrarConexion(cn);
            Log.info("Usuario ndi: "+c.getNdi()+"¡ACTUALIZADO!");
        }catch(Exception e){
            Mensaje.deError("Ocurrio un error al actualizar");
            Log.info("Error: "+e);
        }
    }
    
    public static final Usuario buscarUsuario(int ndi){
        Usuario us = new Usuario();
        boolean existe = false;
        Connection cn = SQLite.obtenerConexion();                
        try{
            PreparedStatement consulta = cn.prepareStatement("SELECT * FROM Usuario WHERE NDI=? ");
            consulta.setInt(1, ndi);
            ResultSet res= consulta.executeQuery();            
            while(res.next()){
                existe = true;
                us.setNdi(res.getInt("NDI"));
                us.setNombre(res.getString("nombre"));
                us.setApellidos(res.getString("apellidos"));
                us.setTelefono(res.getString("telefono"));           
            }
            res.close();
            SQLite.cerrarConexion(cn);
        }catch(Exception e){
            Mensaje.deError("Ha ocurrido un error"+e);
        }
        if(existe)
            return us;
        return null;
    }

    public static final ArrayList<Usuario> todosLosUsuarios() {
        ArrayList<Usuario> listaUsuarios = new ArrayList();
        Connection cn = SQLite.obtenerConexion();
        ResultSet usuarios = SQLite.getRegistros("SELECT * FROM Usuario", cn);
        try{
            while(usuarios.next()){
                Usuario usuario = new Usuario();
                usuario.setNdi(usuarios.getInt(1));
                usuario.setNombre(usuarios.getString(2));
                usuario.setApellidos(usuarios.getString(3));
                usuario.setTelefono(usuarios.getString(4));
                listaUsuarios.add(usuario);
            }
            usuarios.close();
            SQLite.cerrarConexion(cn);
        }catch(Exception e){
            Mensaje.deError("Ha ocurrido un error"+e);
        }
        return listaUsuarios;
    }
    
}
