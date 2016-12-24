package basededatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import utilerias.Log;
import utilerias.Mensaje;

/**
 *
 * @author Alejandro
 */
public final class SQLite {
  private static final String _FuentedeDatos = "bd/sta_ma_aguapotable.db";

  public static final Connection obtenerConexion(){
    Connection conexionASqlite = null;
    Log.info("Obteniendo conexion la base de datos...");
    try{
      Class.forName("org.sqlite.JDBC");
      conexionASqlite = DriverManager.getConnection("jdbc:sqlite:"+_FuentedeDatos);
      Log.info("Conectando a la base de datos...");
    }catch(ClassNotFoundException | SQLException e){
      Log.info("Error: "+e);
      Mensaje.deError("Error al conectar con la base de datos");
    }
    return conexionASqlite;
  }

  public static final boolean cerrarConexion(Connection conexion){
   Log.info("Cerrando la conexion a la base de datos");
    if(conexion == null){
      return false;
    }
    try {
      conexion.close();
      Log.info("Conexion cerrada");
      return true;
    }catch(SQLException e){
       Log.info("Error: "+e);
       Mensaje.deError("Error al intentar cerrar la conexión");
    }
    return false;
  }
  
  public static final ResultSet getRegistros(String sql, Connection cn){
        Log.info("Operacion: getRegistros, consultando en la base de datos");
        ResultSet rs = null;
        try{
            Statement stmt = cn.createStatement();
            rs = stmt.executeQuery(sql);
        }catch(Exception e){
            Mensaje.deError("Ha ocurrido un error"+e);
            Log.info("Error: "+e);
        }
        return rs;
    }
}
