
package controlador;

import java.beans.PropertyVetoException;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLayeredPane;

/**
 *
 * @author Alejandro
 */
public class AdminIFrame {
    
    public static void mostrarVentanaFactura(JDesktopPane dp,JInternalFrame vnt)
    {        
        if(vnt != null && !vnt.isShowing())
       {
           vnt.show();
           dp.remove(vnt);
            try{
                dp.add(vnt, JLayeredPane.DEFAULT_LAYER); 
            }catch(IllegalArgumentException ex){               
                dp.add(vnt, JLayeredPane.DEFAULT_LAYER); 
            }    
       }
        
        if(vnt == null)
        {          
          dp.add(vnt, JLayeredPane.DEFAULT_LAYER);
        } 
       activarVentana(dp,vnt);
       posicionarVentanaCentro(dp, vnt);
    }
    
    private static void activarVentana(JDesktopPane dp,JInternalFrame vnt){
        try {
            vnt.setSelected(true);            
        } catch (PropertyVetoException ex) {
            ex.printStackTrace();
        }
        dp.setPosition(vnt, 0);
        
    }
    
    private static void posicionarVentanaCentro(JDesktopPane dp, JInternalFrame vnt){
        int x = dp.getWidth()/2 - vnt.getWidth()/2;
        int y = dp.getHeight()/2 - vnt.getHeight()/2;
        vnt.setLocation(x, y);
    }
    
    
}
