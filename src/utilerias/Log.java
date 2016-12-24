package utilerias;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 *
 * @author Alejandro
 */
public final class Log {
    private static String nombreLog = "Log";
    private static final String FILE_PATH = "log/Log.log";
    public static Logger getLog(){ 
        return Logger.getLogger(nombreLog);
    }
    
    public static void info(String msn){
        FileHandler fh;
        Logger logger = getLog();
        try{              
            fh = new FileHandler(FILE_PATH,  10485760, 3, true);  
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();  
            fh.setFormatter(formatter);   
            
            logger.info(msn);  
            fh.close();
        } catch (SecurityException | IOException e) {  
            e.printStackTrace();  
        }                 
    }
    
    public static void info(String msn, String sourceClass, String sourceMethod){
        FileHandler fh;
        Logger logger = getLog();
        try{              
            fh = new FileHandler(FILE_PATH,  10485760, 3, true);  
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();  
            fh.setFormatter(formatter);   
            logger.logp(Level.INFO, sourceClass, sourceMethod, msn);          
            fh.close();
        } catch (SecurityException | IOException e) {  
            e.printStackTrace();  
        }                 
    }
}
