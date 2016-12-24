package modelo;

/**
 *
 * @author Alejandro
 */
public class Servicio {
    private int id;
    private int no_medidor;
    private int codigo_zona;
    private int ndi_usuario;
    private String calle;
    private String numero_calle;
    private String usaMedidor;    
    private String estado;
    private int mes;
    private int anio;
    private String notas;
    
    public Servicio() {
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }        
    
    public int getNo_medidor() {
        return no_medidor;
    }

    public void setNo_medidor(int no_medidor) {
        this.no_medidor = no_medidor;
    }

    public int getCodigo_zona() {
        return codigo_zona;
    }

    public void setCodigo_zona(int codigo_zona) {
        this.codigo_zona = codigo_zona;
    }

    public int getNdi_usuario() {
        return ndi_usuario;
    }

    public void setNdi_usuario(int ndi_usuario) {
        this.ndi_usuario = ndi_usuario;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumero_calle() {
        return numero_calle;
    }

    public void setNumero_calle(String numero_calle) {
        this.numero_calle = numero_calle;
    }

    public String getUsaMedidor() {
        return usaMedidor;
    }

    public void setUsaMedidor(String usaMedidor) {
        this.usaMedidor = usaMedidor;
    }
    
    public boolean usaMedidor(){
        return usaMedidor.equals("SI");
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

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    @Override
    public String toString() {
        return "Servicio{" + "id=" + id + ", no_medidor=" + no_medidor + ", codigo_zona=" + codigo_zona + ", ndi_usuario=" + ndi_usuario + ", calle=" + calle + ", numero_calle=" + numero_calle + ", usaMedidor=" + usaMedidor + ", estado=" + estado + ", mes=" + mes + ", anio=" + anio + '}';
    }
    
    
}
