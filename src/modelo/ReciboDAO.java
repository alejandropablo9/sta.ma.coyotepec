package modelo;

import basededatos.SQLite;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import utilerias.Log;
import utilerias.Mensaje;

/**
 *
 * @author Alejandro
 */
public final class ReciboDAO {
    public static final void registrarReciboSM(ArrayList<Servicio> servicios, ReciboSM recibo){
        Connection cn = SQLite.obtenerConexion();
        Log.info("Accion: INSER INTO Recibo");        
        try{
            Statement stmt = cn.createStatement(); 
            Iterator<Servicio> it = servicios.iterator();
            while(it.hasNext()){
                Servicio s = it.next();                
                System.out.println(s);
                System.out.println(recibo);
                stmt.executeUpdate("INSERT INTO Recibo_sin_medidor (id_servicio, mes, anio, monto, estado)"+
                                    "SELECT "+s.getId()+", "+recibo.getMes()+", "+recibo.getAnio()+", "+recibo.getMonto()+
                                            ", '"+recibo.getEstado()+"' "+
                                    "WHERE NOT EXISTS (SELECT 1 FROM Recibo_sin_medidor "+
                                        "WHERE id_servicio = "+s.getId()+
                                        "   AND mes = "+recibo.getMes()+ 
                                        "   AND anio = "+recibo.getAnio()+") "
                                    );                                              
            }
            Mensaje.deInformacion("Se ha registrado\n¡Exitosamente!");  
            stmt.close();
            Log.info("Recibos generados ¡EXITOSAMENTE!");
            SQLite.cerrarConexion(cn);
        }catch(Exception e){
            Mensaje.deError("Ocurrio un error al realizar el registro");
            Log.info("Error: "+e);
        }
    }
    
    public static final ArrayList<ReciboSM> recibosSMDelUsuario(int id_servicio, boolean adeudo){
        String a = adeudo?"PAGADO":"ADEUDO";
        ArrayList<ReciboSM> listaRecibos = new ArrayList<>();
        Connection cn = SQLite.obtenerConexion();
        ResultSet recibos = SQLite.getRegistros("SELECT * FROM Recibo_sin_medidor "
                + "WHERE id_servicio = "+id_servicio
                + " AND estado = '"+a+"'", cn);
        try{
            while(recibos.next()){
                ReciboSM rsm = new ReciboSM();
                rsm.setId_recibo(recibos.getInt(1));               
                rsm.setId_servicio(recibos.getInt(2));
                rsm.setMes(recibos.getInt(3));
                rsm.setAnio(recibos.getInt(4));
                rsm.setMonto(recibos.getInt(5));
                rsm.setEstado(recibos.getString(6));
                listaRecibos.add(rsm);                      
            }   
            recibos.close();
            SQLite.cerrarConexion(cn);
        }catch(Exception e){
            Mensaje.deError("Ha ocurrido un error"+e);
        }
        return listaRecibos;
    }
}