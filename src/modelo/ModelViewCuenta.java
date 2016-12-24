package modelo;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Alejandro
 */
public class ModelViewCuenta extends  AbstractTableModel{
    private String[] nombreColumnas = {"Cuenta", "NDI", "Nombre", "Apellidos", "No. Medidor", "Zona", "Calle", "Estado"};
    private ArrayList<Cuenta> cuentas;

    public ModelViewCuenta(ArrayList<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }

    public ModelViewCuenta() {
        this.cuentas = CuentaDAO.todasLasCuentas();
    }
    
    
    @Override
    public int getRowCount() {
        return cuentas.size();
    }

    @Override
    public int getColumnCount() {
        return nombreColumnas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Cuenta cuenta = cuentas.get(rowIndex);
        switch(columnIndex){
            case 0: return cuenta.getId();
            case 1: return cuenta.getNdiUsuario();
            case 2: return cuenta.getNombreUsuario();
            case 3: return cuenta.getApellidosUsuario();
            case 4: return cuenta.getNoMedidor();
            case 5: return cuenta.getNombreZona();
            case 6: return cuenta.getCalleServicio();
            case 7: return cuenta.getEstadoUsuario();
            default: return null;                    
        }
    }
    
    public String getColumnName(int column) {
        return nombreColumnas[column];
    }
       
    public Cuenta getCuenta(int indice){
        return cuentas.get(indice);
    }
        
    public boolean estVacio(){
        if(cuentas == null)
            return true;
        return false;
    }
}
