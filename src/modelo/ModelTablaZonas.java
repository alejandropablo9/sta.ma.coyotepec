package modelo;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Alejandro
 */
public class ModelTablaZonas extends  AbstractTableModel{
    
    private String[] nombreColumnas = {"Codigo", "Nombre"};
    private ArrayList<Zona> zonas;

    public ModelTablaZonas(ArrayList<Zona> zonas) {
        this.zonas = zonas;
    }

    public ModelTablaZonas() {
        this.zonas = ZonaDAO.todasLasZonas();
    }    
    
    @Override
    public int getRowCount() {
        return zonas.size();
    }

    @Override
    public int getColumnCount() {
        return nombreColumnas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Zona zona = zonas.get(rowIndex);
        switch(columnIndex){
            case 0: return zona.getCodigo();
            case 1: return zona.getNombre();  
            default: return null;                    
        }
    }
    
    @Override
    public String getColumnName(int column) {
        return nombreColumnas[column];
    }
       
    public Zona getZona(int indice){
        return zonas.get(indice);
    }
        
    public boolean estVacio(){
        if(zonas == null)
            return true;
        return false;
    }
    
}
