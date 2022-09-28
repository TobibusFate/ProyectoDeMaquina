package datos;

import java.sql.SQLException;
import java.sql.Statement;

public class DB_Init {

    private static Statement query = null;


    public static void createTables() {
        var conn = DatosBase.getInstance().getConnection();

        try {
            query = conn.createStatement();

            query.execute("CREATE TABLE IF NOT EXISTS Productos ("
                + "Prod_CODIGO INTEGER, "
                + "Prod_NOMBRE VARCHAR(255) NOT NULL, "
                + "Prod_CATEGORIA VARCHAR(255) NOT NULL, "
                + "Prod_PRECIO REAL NOT NULL, "
                + "Prod_STOCK INTEGER NOT NULL, "
                + "Prod_STOCK_MINIMO INTEGER NOT NULL, "
                + "PRIMARY KEY(Prod_CODIGO))"
            );

            // Recordar que pedidos tienen foreing key Proveedor
            query.execute("CREATE TABLE IF NOT EXISTS Proveedores ("
                // TO DO
                + ")"
            );
            query.execute("CREATE TABLE IF NOT EXISTS Clientes ("
                // TO DO
                + ")"
            );
            // Pedidos tiene foreing key Producto
            query.execute("CREATE TABLE IF NOT EXISTS Pedidos ("
                // TO DO
                + ")"
            );
            // Ventas tiene foreing key Producto
            query.execute("CREATE TABLE IF NOT EXISTS Ventas ("
                // TO DO
                + ")"
            );
            query.execute("CREATE TABLE IF NOT EXISTS Renglon-Compra ("
                // TO DO
            + ")"
            );
            query.execute("CREATE TABLE IF NOT EXISTS Renglon-Venta ("
                // TO DO
            + ")"
            );
            // Otras?
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        finally { // finally se ejecuta siempre, no importa si hubo excepcion, así aseguramos que se cierra la conexión
            DatosBase.getInstance().closeConnection();
        }
        
            
        
    }

    public static void initTables () {
        // Llena las tablas creadas con valores basicos para usar y testear. EJ: 3 proveedores, 10 productos, etc...
    }


}
