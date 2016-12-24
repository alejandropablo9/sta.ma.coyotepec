package utilerias;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Alejandro
 */
public class Icono implements Icon{
    private String url;
    
    public Icono(String url){
        this.url = url;
    }
    
    public void setUrl(String url){
        this.url = url;
    }
    
    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        try{
            Image image = new ImageIcon(getClass().getResource(url)).getImage();
            g.drawImage(image, x, y, c);
        }catch(Exception e){
             JOptionPane.showMessageDialog(null,e);
        }
    }
 
    @Override
    public int getIconWidth() {
        return 48;
    }
 
    @Override
    public int getIconHeight() {
        return 48;
    }
}
