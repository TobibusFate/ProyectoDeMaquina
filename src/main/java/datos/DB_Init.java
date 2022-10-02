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
                + "PRIMARY KEY(Prod_CODIGO)"
                + ")"
            );

            /*query.execute("INSERT INTO Productos (Prod_CODIGO, Prod_NOMBRE, Prod_CATEGORIA, Prod_PRECIO, Prod_STOCK, Prod_STOCK_MINIMO) " +
                "VALUES ('1000', 'Leche', 'Comestible', '150', '3050', '200') ");

            query.execute("INSERT INTO Productos (Prod_CODIGO, Prod_NOMBRE, Prod_CATEGORIA, Prod_PRECIO, Prod_STOCK, Prod_STOCK_MINIMO) " +
                    "VALUES ('1001', 'yorurt', 'Comestible', '190', '2500', '200') ");

            query.execute("INSERT INTO Productos (Prod_CODIGO, Prod_NOMBRE, Prod_CATEGORIA, Prod_PRECIO, Prod_STOCK, Prod_STOCK_MINIMO) " +
                    "VALUES ('1050', 'galletas de chocolate', 'Comestible', '110', '2500', '100') ");

            query.execute("INSERT INTO Productos (Prod_CODIGO, Prod_NOMBRE, Prod_CATEGORIA, Prod_PRECIO, Prod_STOCK, Prod_STOCK_MINIMO) " +
                    "VALUES ('1060', 'galletas de arroz', 'Comestible', '120', '2500', '100') ");

            query.execute("INSERT INTO Productos (Prod_CODIGO, Prod_NOMBRE, Prod_CATEGORIA, Prod_PRECIO, Prod_STOCK, Prod_STOCK_MINIMO) " +
                    "VALUES ('1065', 'galletas saladas', 'Comestible', '120', '2500', '100') ");*/

            // Recordar que pedidos tienen foreing key Proveedor
            query.execute("CREATE TABLE IF NOT EXISTS Proveedores ("
                + "Prov_CUIT INTEGER, "
                + "Prov_NombreFirma VARCHAR(255) NOT NULL, "
                + "Prov_Email VARCHAR(255) NOT NULL, "
                + "Prov_Direccion VARCHAR(255) , "
                + "PRIMARY KEY(Prov_CUIT)"
                + ")"
            );
            /*query.execute("CREATE TABLE IF NOT EXISTS Clientes ("
                // TO DO
                + ")"
            );
            // Pedidos tiene foreing key Producto
            query.execute("CREATE TABLE IF NOT EXISTS Pedidos ("
                // TO DO
                + ")"
            );*/
            query.execute("CREATE TABLE IF NOT EXISTS Ventas ("
                    + "Venta_CODIGO BIGINT, "
                    + "Venta_CERRADA BOOLEAN NOT NULL, "
                    + "Venta_MONTO REAL NOT NULL, "
                    + "Venta_FECHA DATE, "
                    + "Venta_HORA TIME, "
                    + "PRIMARY KEY(Venta_CODIGO)"
                + ")"
            );

            query.execute("CREATE TABLE IF NOT EXISTS Usuarios ("
                    + "Usuario_usuario VARCHAR(255), "
                    + "Usuario_contraseña VARCHAR(255) NOT NULL, "
                    + "Usuario_tipo INT NOT NULL, "
                    + "Usuario_email VARCHAR(255) NOT NULL, "
                    + "Usuario_telefono BIGINT, "
                    + "PRIMARY KEY(Usuario_usuario)"
                    + ")"
            );
            //query.execute("INSERT INTO Usuarios (Usuario_usuario, Usuario_contraseña, Usuario_tipo, Usuario_telefono, Usuario_Email) " +
              //      "VALUES ('user', '123', '1', '2266646', 'correo1234') ");
            //query.execute("INSERT INTO Usuarios (Usuario_usuario, Usuario_contraseña, Usuario_tipo, Usuario_telefono, Usuario_Email) " +
                //    "VALUES ('admin', '123', '2', '2266646', 'correo1234') ");

            /*query.execute("CREATE TABLE IF NOT EXISTS Renglon-Venta ("
                // TO DO
            + ")"
            );
            query.execute("CREATE TABLE IF NOT EXISTS Renglon-Pedido ("
                // TO DO
            + ")"
            );*/
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
