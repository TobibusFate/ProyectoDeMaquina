package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatosBase {
    private static final String DB_NAME = "DataBase_IngSW2";
    private static final String MySQL_URL = "jdbc:mysql://localhost:3306/" + DB_NAME, MySQL_USER = "root", MySQL_PWD = "admin";
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
            conn = DriverManager.getConnection(MySQL_URL, MySQL_USER, MySQL_PWD);
            return conn;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
    // Cierra la conexión a la BD
    public void closeConnection() {
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /* La idea es que cuando se quiera usar la BD, se haga así:
     * BD = DatosBase.getInstance();
     * conn = BD.getConnection();
     * y al finalizar:
     * BD.closeConnection();
     * 
     * o quizá:
     * conn = DatosBase.getInstance().getConnection();
     * DatosBase.getInstance().closeConnection();
     */

}
