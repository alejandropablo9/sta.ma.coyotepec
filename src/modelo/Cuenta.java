package modelo;

/**
 *
 * @author Alejandro
 */
public class Cuenta {
    private int id;
    private int ndiUsuario;
    private String nombreUsuario;
    private String apellidosUsuario;
    private int noMedidor;
    private String nombreZona;
    private String calleServicio;
    private String estadoUsuario;

    public Cuenta() {
    }

    public Cuenta(int id, int ndiUsuario, String nombreUsuario, String apellidosUsuario, int noMedidor, String nombreZona, String calleServicio, String estadoUsuario) {
        this.id = id;
        this.ndiUsuario = ndiUsuario;
        this.nombreUsuario = nombreUsuario;
        this.apellidosUsuario = apellidosUsuario;
        this.noMedidor = noMedidor;
        this.nombreZona = nombreZona;
        this.calleServicio = calleServicio;
        this.estadoUsuario = estadoUsuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNdiUsuario() {
        return ndiUsuario;
    }

    public void setNdiUsuario(int ndiUsuario) {
        this.ndiUsuario = ndiUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getApellidosUsuario() {
        return apellidosUsuario;
    }

    public void setApellidosUsuario(String apellidosUsuario) {
        this.apellidosUsuario = apellidosUsuario;
    }

    public int getNoMedidor() {
        return noMedidor;
    }

    public void setNoMedidor(int noMedidor) {
        this.noMedidor = noMedidor;
    }

    public String getNombreZona() {
        return nombreZona;
    }

    public void setNombreZona(String nombreZona) {
        this.nombreZona = nombreZona;
    }

    public String getCalleServicio() {
        return calleServicio;
    }

    public void setCalleServicio(String calleServicio) {
        this.calleServicio = calleServicio;
    }

    public String getEstadoUsuario() {
        return estadoUsuario;
    }

    public void setEstadoUsuario(String estadoUsuario) {
        this.estadoUsuario = estadoUsuario;
    }
    
    
}
