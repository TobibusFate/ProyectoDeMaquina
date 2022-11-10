import datos.DB_Init;
import interfaces_graficas.menus.LogIn;
import javax.swing.JOptionPane;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;


public class Main {
    
    private static final Logger ERRLOGGER = LogManager.getLogger("error-log");
    public static void main(String[] args) {
        try {
            DB_Init.initializeDataBase();
            LogIn logIn = new LogIn();
            logIn.setVisible(true); 
        } catch (Exception e) {
            ERRLOGGER.fatal(e.getMessage());
            JOptionPane.showMessageDialog(null, e.getMessage()+"\nVerifique que la base de datos ha sido creada.", "Error en inicialización", JOptionPane.ERROR_MESSAGE);
        }
    }


}