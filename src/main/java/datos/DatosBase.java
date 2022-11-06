package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DatosBase {
    private static final Logger ERRLOGGER = LogManager.getLogger("error-log");
    private static final String DB_NAME = "DataBase_IngSW2"; //DataBase_IngSW2
    // private static final String MySQL_URL = "jdbc:mysql://localhost:3306/" + DB_NAME, MySQL_USER = "root", MySQL_PWD = "admin"; // Para MySQL
    private static final String Postgre_URL = "jdbc:postgresql://localhost:5432/" + DB_NAME, Postgre_USER = "postgres", Postgre_PWD = "admin"; // Para Postgres

    private static DatosBase instance;
    private static Connection conn;

    private DatosBase() {
        // Empty constructor
    }

    public static DatosBase getInstance() { // Singleton. Solo una instancia.
        if (instance == null) instance = new DatosBase();
        return instance;
    }

    // Obtiene la conexión para la Base de Datos.
    public Connection getConnection() {
        try {
            conn = DriverManager.getConnection(Postgre_URL, Postgre_USER, Postgre_PWD); // podriamos hacer una selección para que el usuario decida si usar MySQL o Postgres
            return conn;
        } catch (SQLException ex) {
            ERRLOGGER.fatal("No se pudo establecer la conexión: "+ex.getMessage());
        }
        return null;
    }
    // Cierra la conexión a la BD
    public void closeConnection() {
        try {
            conn.close();
        } catch (SQLException ex) {
            ERRLOGGER.fatal("No se ha podido cerrar la conexión, se recomienda reiniciar el programa: "+ex.getMessage());
        }
    }

    /* La idea es que cuando se quiera usar la BD, se haga así:
     * var BD = DatosBase.getInstance();
     * var conn = BD.getConnection();
     * y al finalizar:
     * BD.closeConnection();
     * 
     * o quizá:
     * conn = DatosBase.getInstance().getConnection();
     * DatosBase.getInstance().closeConnection();
     * 
     * o quizá:
     * conn = DatosBase.getInstance().getConnection();
     * conn.close(); // no sé si está cerrando la misma conexión o es otra.
     */

}
