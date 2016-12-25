package modelo;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author alejandro
 */
public class ModelViewRecibo extends  AbstractTableModel{
    private String[] nombreColumnas = {"No. Recibo", "NDI", "Medidor", "Nombre", "Apellidos", "Zona", "Calle", "Número", "Estado"};
    private ArrayList<ViewRecibo> recibos;

    public ModelViewRecibo(ArrayList<ViewRecibo> recibos) {
        this.recibos = recibos;
    }

    public ModelViewRecibo(int mes, int anio) {
        this.recibos = ViewReciboDAO.recibosDeLaFecha(mes, anio);
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
            case 2: return vr.getNo_medidor();
            case 3: return vr.getNombre();
            case 4: return vr.getApellidos();
            case 5: return vr.getZona();
            case 6: return vr.getCalle();
            case 7: return vr.getNodecalle();
            case 8: return vr.getEstado();
            default: return null;
        }        
    }
    
    @Override
    public String getColumnName(int column) {
        return nombreColumnas[column];
    }
       
    public ViewRecibo getViewRecibo(int indice){
        return recibos.get(indice);
    }
        
    public boolean estVacio(){
        return recibos == null;
    }
    
}
