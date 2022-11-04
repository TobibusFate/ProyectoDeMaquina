import datos.DB_Init;
import interfaces_graficas.menus.LogIn;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;


public class Main {
    
    /*private static final Logger LOGGER = LogManager.getLogger(Main.class);
    private static final Logger LOGGER1 = LogManager.getLogger("info-log");
    private static final Logger LOGGER2 = LogManager.getLogger("error-log");*/
    
    
    public static void main(String[] args) {

        try {
            /*LOGGER.debug("LOG DEBUG");
            LOGGER.warn("LOG WARNING");
            LOGGER.error("LOG ERROR");
            LOGGER.fatal("LOG FATAL");
            LOGGER.info("LOG INFO");
            LOGGER.trace("LOG TRACE");
            LOGGER1.debug("LOG DEBUG1");
            LOGGER1.warn("LOG WARNING1");
            LOGGER1.error("LOG ERROR1");
            LOGGER1.fatal("LOG FATAL1");
            LOGGER1.info("LOG INFO1");
            LOGGER1.trace("LOG TRACE1");
            LOGGER2.debug("LOG DEBUG2");
            LOGGER2.warn("LOG WARNING2");
            LOGGER2.error("LOG ERROR2");
            LOGGER2.fatal("LOG FATAL2");
            LOGGER2.info("LOG INFO2");
            LOGGER2.trace("LOG TRACE2");*/
            DB_Init.dropAllTables();
            DB_Init.createTables();
            DB_Init.initTables();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            System.out.println(e);
        }
        LogIn logIn = new LogIn();
        logIn.setVisible(true);
    }


}