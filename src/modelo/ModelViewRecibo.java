package modelo;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author alejandro
 */
public class ModelViewRecibo extends  AbstractTableModel{
    private String[] nombreColumnas = {"No. Recibo", "NDI", "Nombre", "Apellidos", "Zona", "Calle", "Número", "Estado"};
    private ArrayList<ViewRecibo> recibos;

    public ModelViewRecibo(ArrayList<ViewRecibo> recibos) {
        this.recibos = recibos;
    }

    public ModelViewRecibo(int mes, int anio) {
        this.recibos = ViewReciboDao.recibosDeLaFecha(mes, anio);
    }        
    
    @Override
    public int getRowCount() {
        return recibos.size();
    }

    @Override
    public int getColumnCount() {
        return nombreColumnas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ViewRecibo vr = recibos.get(rowIndex);
        switch(columnIndex){
            case 0: return vr.getId_recibo();
            case 1: return vr.getNdi();
            case 2: return vr.getNombre();
            case 3: return vr.getApellidos();
            case 4: return vr.getZona();
            case 5: return vr.getCalle();
            case 6: return vr.getNodecalle();
            case 7: return vr.getEstado();
            default: return null;
        }        
    }
    
    public String getColumnName(int column) {
        return nombreColumnas[column];
    }
       
    public ViewRecibo getViewRecibo(int indice){
        return recibos.get(indice);
    }
        
    public boolean estVacio(){
        if(recibos == null)
            return true;
        return false;
    }
    
}
