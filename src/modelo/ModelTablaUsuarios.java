package modelo;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Alejandro
 */
public class ModelTablaUsuarios extends AbstractTableModel{
    private String[] nombreColumnas = {"NDI", "Nombre", "Apellidos", "Telefono", "estado"};
    private ArrayList<Usuario> usuarios;

    public ModelTablaUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    
    public ModelTablaUsuarios(){
        this.usuarios = UsuarioDAO.todosLosUsuarios();
    }

    @Override
    public int getRowCount() {
        return usuarios.size();
    }

    @Override
    public int getColumnCount() {
        return nombreColumnas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Usuario usuario = usuarios.get(rowIndex);
        switch(columnIndex){
            case 0: return usuario.getNdi();
            case 1: return usuario.getNombre();
            case 2: return usuario.getApellidos();
            case 3: return usuario.getTelefono();
            default: return null;                    
        }
    }
    
    @Override
    public String getColumnName(int column) {
        return nombreColumnas[column];
    }
       
    public Usuario getUsuario(int indice){
        return usuarios.get(indice);
    }
    
    
    public boolean estVacio(){
        if(usuarios == null)
            return true;
        return false;
    }
}
