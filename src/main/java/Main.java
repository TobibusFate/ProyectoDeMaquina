import datos.DB_Init;
import interfaces_graficas.menus.LogIn;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;


public class Main {
    
    private static final Logger ERRLOGGER = LogManager.getLogger("error-log");
    public static void main(String[] args) {
        try {
            DB_Init.dropAllTables();
            DB_Init.createTables();
            DB_Init.initTables();
            LogIn logIn = new LogIn();
            logIn.setVisible(true); 
        } catch (Exception e) {
            ERRLOGGER.fatal(e.getMessage());
        }
    }


}