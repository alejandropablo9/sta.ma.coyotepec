package modelo;

/**
 *
 * @author Alejandro
 */
public class Usuario {
    private int ndi;
    private String nombre;
    private String apellidos;
    private String telefono;
    
    public Usuario(){
    }

    public Usuario(int ndi, String nombre, String apellidos, String telefono) {
        this.ndi = ndi;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
    }
    
    public int getNdi() {
        return ndi;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setNdi(int ndi) {
        this.ndi = ndi;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Usuario{" + "ndi=" + ndi + ", nombre=" + nombre + ", apellidos=" + apellidos + ", telefono=" + telefono + '}';
    }    
}
