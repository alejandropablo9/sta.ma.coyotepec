package modelo;

/**
 *
 * @author alejandro
 */
public class ViewRecibo {
    private int id_recibo;
    private int ndi;
    private String nombre;
    private String apellidos;
    private String zona;
    private String calle;
    private String nodecalle;
    private String estado;
    private int mes;
    private int anio;
    private int id_servicio;
    private int monto;
    private int no_medidor;
    
    public ViewRecibo() {
    }

    public int getId_recibo() {
        return id_recibo;
    }

    public void setId_recibo(int id_recibo) {
        this.id_recibo = id_recibo;
    }

    public int getNdi() {
        return ndi;
    }

    public void setNdi(int ndi) {
        this.ndi = ndi;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNodecalle() {
        return nodecalle;
    }

    public void setNodecalle(String nodecalle) {
        this.nodecalle = nodecalle;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getId_servicio() {
        return id_servicio;
    }

    public void setId_servicio(int id_servicio) {
        this.id_servicio = id_servicio;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }
    
    public void normalizarMonto(double monto){
        this.monto = (int) monto * 100;
    }
    
    public double getMontoDouble(){
        return (double) this.monto / 100;
    }  
    
    public String nombreCompletodeUsusrio(){
        return ""+nombre+" "+apellidos;
    }
    
    public String direcciondeUsusrio(){
        return ""+calle+" #"+nodecalle;
    }

    public int getNo_medidor() {
        return no_medidor;
    }

    public void setNo_medidor(int no_medidor) {
        this.no_medidor = no_medidor;
    }
        
    @Override
    public String toString() {
        return "ViewRecibo{" + "id_recibo=" + id_recibo + ", ndi=" + ndi + ", nombre=" + nombre + ", apellidos=" + apellidos + 
                ", zona=" + zona + ", calle=" + calle + ", nodecalle=" + nodecalle + ", estado=" + estado + ", mes=" + mes + 
                ", anio=" + anio + ", id_servicio=" + id_servicio + ", monto=" + monto + '}';
    }          
}
