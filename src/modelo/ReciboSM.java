package modelo;

/**
 *
 * @author Alejandro
 */
public class ReciboSM {
    private int id_recibo;
    private int id_servicio;
    private int mes;
    private int anio;
    private int monto;
    private String estado;

    public ReciboSM(int id_servicio, int mes, int anio, int monto, String estado) {
        this.id_servicio = id_servicio;
        this.mes = mes;
        this.anio = anio;
        this.monto = monto;
        this.estado = estado;        
    }

    public ReciboSM() {
    }

    public int getId_recibo() {
        return id_recibo;
    }

    public void setId_recibo(int id_recibo) {
        this.id_recibo = id_recibo;
    }

    public int getId_servicio() {
        return id_servicio;
    }

    public void setId_servicio(int id_servicio) {
        this.id_servicio = id_servicio;
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

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }
    
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public void normalizarMonto(double monto){
        this.monto = (int) monto * 100;
    }
    
    public double getMontoDouble(){
        return (double) this.monto / 100;
    }         

    @Override
    public String toString() {
        return "ReciboSM{" + "id_recibo=" + id_recibo + ", id_servicio=" + id_servicio + ", mes=" + mes + ", anio=" + anio + ", monto=" + monto + ", estado=" + estado + '}';
    }  
}
