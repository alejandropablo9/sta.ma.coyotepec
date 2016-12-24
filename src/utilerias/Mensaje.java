package utilerias;

import javax.swing.JOptionPane;
/**
 *
 * @author Alejandro
 */
public final class Mensaje {
        
    public static void deConfirmacion(String mensaje){
        JOptionPane.showConfirmDialog(null, mensaje, "Alerta!", 
                JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
    }
    
    public static void deConfirmacion(String mensaje, String titulo, Icono icon){
        JOptionPane.showConfirmDialog(null, mensaje, titulo, 
                JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE, icon);
    }
    
    public static void deDialogo(String mensaje){
        JOptionPane.showMessageDialog(null, mensaje, "Aviso",
                JOptionPane.DEFAULT_OPTION);     
    }
    
    public static void deDialogo(String mensaje, String titulo, Icono icon){
        JOptionPane.showMessageDialog(null, mensaje, titulo,
                JOptionPane.DEFAULT_OPTION, icon);     
    }
   
    public static void deEmergencia(String mensaje){
        JOptionPane.showMessageDialog(null, mensaje,"Advertencia",
                JOptionPane.WARNING_MESSAGE);
    }
    
    public static void deEmergencia(String mensaje, Icono icon){
        JOptionPane.showMessageDialog(null, mensaje,"Advertencia",
                JOptionPane.WARNING_MESSAGE, icon);
    }        
    
    public static void deEmergencia(String mensaje, String titulo, Icono icon){
        JOptionPane.showMessageDialog(null, mensaje, titulo,
                JOptionPane.WARNING_MESSAGE, icon);
    }
    
    public static void deError(String mensaje){
        JOptionPane.showMessageDialog(null, mensaje,"Error",
                JOptionPane.ERROR_MESSAGE);
    }
    
    public static void deInformacion(String mensaje){
        JOptionPane.showMessageDialog(null, mensaje, "Información",
                JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static void deInformacion(String mensaje, String titulo, Icono icon){
        JOptionPane.showMessageDialog(null, mensaje, titulo,
                JOptionPane.INFORMATION_MESSAGE, icon);
    }
}
