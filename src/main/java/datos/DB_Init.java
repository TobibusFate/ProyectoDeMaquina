package datos;

import java.sql.SQLException;
import java.sql.Statement;

public class DB_Init {

    private static Statement query = null;


    public static void createTables() {
        var conn = DatosBase.getInstance().getConnection();

        try {
            query = conn.createStatement();
            
            query.execute("CREATE TYPE PERMISO AS ENUM('Empleado', 'Administrador')");
            query.execute("CREATE TYPE METODOPAGO AS ENUM('Fiado', 'Efectivo', 'TarjetaDebito','TarjetaCredito')");
            query.execute("CREATE TYPE TIPOCANTIDAD AS ENUM('Bolsones', 'BultosCerrados', 'Pallets')");

            query.execute("CREATE TABLE IF NOT EXISTS Productos ("
                + "Prod_CODIGO INTEGER, "
                + "Prod_NOMBRE VARCHAR(255) UNIQUE NOT NULL, "
                + "Prod_CATEGORIA VARCHAR(255) NOT NULL, "
                + "Prod_PRECIO REAL NOT NULL, "
                + "Prod_STOCK INTEGER NOT NULL, "
                + "Prod_STOCK_MINIMO INTEGER NOT NULL, "
                + "PRIMARY KEY(Prod_CODIGO)"
                + ")"
            );


            query.execute("CREATE TABLE IF NOT EXISTS Personas ("
                + "Pers_DNI INTEGER, "
                + "Pers_Nombre VARCHAR(255) NOT NULL, "
                + "Pers_Apellido VARCHAR(255) NOT NULL, "
                + "Pers_Telefono BIGINT, "
                + "PRIMARY KEY(Pers_DNI)"
                + ")"
            );

            query.execute("CREATE TABLE IF NOT EXISTS Clientes ("
                + "Cli_DNI INTEGER, "
                + "Cli_IVA VARCHAR(255), "
                + "Cli_MOROSO BOOLEAN NOT NULL, "
                + "PRIMARY KEY(Cli_DNI), "
                + "FOREIGN KEY(Cli_DNI) REFERENCES Personas(Pers_DNI)"
                + ")"
            );

            query.execute("CREATE TABLE IF NOT EXISTS ClientesFisicos ("
                + "CliF_DNI INTEGER, "
                + "CliF_CUIL BIGINT, "
                + "PRIMARY KEY(CliF_DNI, CliF_CUIL), "
                + "FOREIGN KEY(CliF_DNI) REFERENCES Clientes(Cli_DNI)"
                + ")"
            );

            query.execute("CREATE TABLE IF NOT EXISTS ClientesJuridicos ("
                + "CliJ_DNI INTEGER, "
                + "CliJ_CUIT BIGINT, "
                + "PRIMARY KEY(CliJ_DNI, CliJ_CUIT), "
                + "FOREIGN KEY(CliJ_DNI) REFERENCES Clientes(Cli_DNI)"
                + ")"
            );
// no revisado con su clase
            query.execute("CREATE TABLE IF NOT EXISTS Cuentas ("
                    + "Cuen_USUARIO VARCHAR(255), "
                    + "Cuen_CONTRASEÑA VARCHAR(255) NOT NULL, "
                    + "Cuen_PERMISOS PERMISO NOT NULL, "
                    + "Cuen_EMAIL VARCHAR(255) NOT NULL, "
                    + "PRIMARY KEY(Cuen_USUARIO)"
                    + ")"
            );

           query.execute("CREATE TABLE IF NOT EXISTS Trabajadores ("
                + "Trab_USUARIO VARCHAR(255), "
                + "Trab_DNI INTEGER, "
                + "PRIMARY KEY(Trab_DNI, Trab_USUARIO), "
                + "FOREIGN KEY(Trab_DNI) REFERENCES Personas(Pers_DNI), "
                + "FOREIGN KEY(Trab_USUARIO) REFERENCES Cuentas(Cuen_USUARIO)"
                + ")"
            );

            query.execute("CREATE TABLE IF NOT EXISTS Administradores ("
                + "Admin_USUARIO VARCHAR(255), "
                + "Admin_DNI INTEGER, "
                + "PRIMARY KEY(Admin_DNI, Admin_USUARIO), "
                + "FOREIGN KEY(Admin_DNI, Admin_USUARIO) REFERENCES Trabajadores(Trab_DNI, Trab_USUARIO)"
                + ")"
            );

            query.execute("CREATE TABLE IF NOT EXISTS Proveedores ("
                + "Prov_CUIT BIGINT, "
                + "Prov_NombreFirma VARCHAR(255) NOT NULL, "
                + "Prov_Email VARCHAR(255) NOT NULL, "
                + "Prov_Direccion VARCHAR(255) , "
                + "PRIMARY KEY(Prov_CUIT)"
                + ")"
            );
            
            // fechas no revisadas en su clase
            query.execute("CREATE TABLE IF NOT EXISTS Pedidos ("
                + "Ped_CODIGO INTEGER, "
                + "Ped_Prov_CUIT BIGINT, "
                + "Ped_Admin_DNI INTEGER, "
                + "Ped_Admin_USUARIO VARCHAR(255), "
                + "Ped_FECHAPEDIDO DATE NOT NULL, "
                + "Ped_FECHAENTREGA DATE, "
                + "PRIMARY KEY(Ped_CODIGO), "
                + "FOREIGN KEY(Ped_Prov_CUIT) REFERENCES Proveedores(Prov_CUIT), "
                + "FOREIGN KEY(Ped_Admin_DNI, Ped_Admin_USUARIO) REFERENCES Administradores(Admin_DNI, Admin_USUARIO)"
                + ")"
            );
            // fechas no revisadas en su clase
            query.execute("CREATE TABLE IF NOT EXISTS Ventas ("
                + "Venta_CODIGO INTEGER, "
                + "Venta_Cuen_USUARIO VARCHAR(255) NOT NULL, "
                + "Venta_CERRADA BOOLEAN NOT NULL, "
                + "Venta_MONTO REAL NOT NULL, "
                + "Venta_FECHA DATE, "
                + "Venta_HORA TIME, "
                + "PRIMARY KEY(Venta_CODIGO), "
                + "FOREIGN KEY(Venta_Cuen_USUARIO) REFERENCES Cuentas(Cuen_USUARIO)"
                + ")"
            );
            // fechas no revisadas en su clase
            query.execute("CREATE TABLE IF NOT EXISTS Pagos ("
                + "Pago_CODIGO INTEGER, "
                + "Pago_Venta_CODIGO INTEGER, "
                + "Pago_Cliente_DNI INTEGER, "
                + "Pago_MONTO REAL NOT NULL, "
                + "Pago_FECHAPAGO DATE NOT NULL, "
                + "Pago_FECHALIMITE DATE, "
                + "Pago_CUOTAS INTEGER NOT NULL, "
                + "Pago_TIPO METODOPAGO, "
                + "PRIMARY KEY(Pago_CODIGO), "
                + "FOREIGN KEY(Pago_Cliente_DNI) REFERENCES Clientes(Cli_DNI), "
                + "FOREIGN KEY(Pago_Venta_CODIGO) REFERENCES Ventas(Venta_CODIGO)"
                + ")"
            );
            

            query.execute("CREATE TABLE IF NOT EXISTS Renglon ("
                + "Ren_CODIGO INTEGER, "
                + "Ren_Prod_CODIGO INTEGER, "
                + "Ren_MONTOTOTAL REAL NOT NULL, "
                + "Ren_DESCUENTO REAL NOT NULL, "
                + "PRIMARY KEY(Ren_CODIGO), "
                + "FOREIGN KEY(Ren_Prod_CODIGO) REFERENCES Productos(Prod_CODIGO)"
                + ")"
            );

            query.execute("CREATE TABLE IF NOT EXISTS Renglon_Venta ("
                + "RenV_CODIGO INTEGER, "
                + "RenV_Venta_CODIGO INTEGER, "
                + "RenV_UNIDADES INTEGER NOT NULL, "
                + "PRIMARY KEY(RenV_CODIGO, RenV_Venta_CODIGO), "
                + "FOREIGN KEY(RenV_CODIGO) REFERENCES Renglon(Ren_CODIGO), "
                + "FOREIGN KEY(RenV_Venta_CODIGO) REFERENCES Ventas(Venta_CODIGO)"
                + ")"
            );
            query.execute("CREATE TABLE IF NOT EXISTS Renglon_Pedido ("
                + "RenP_CODIGO INTEGER, "
                + "RenP_Ped_CODIGO INTEGER, "
                + "RenP_Tipo TIPOCANTIDAD, "
                + "RenP_CANTIDAD INTEGER NOT NULL, "
                + "PRIMARY KEY(RenP_CODIGO, RenP_Ped_CODIGO), "
                + "FOREIGN KEY(RenP_Ped_CODIGO) REFERENCES Pedidos(Ped_CODIGO)"
                + ")"
            );
            //query.execute("drop table Renglon_Venta");
            //query.execute("drop table Renglon_Pedido");
            //query.execute("drop table Renglon");
            //query.execute("drop table Productos");

        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        finally { // finally se ejecuta siempre, no importa si hubo excepcion, así aseguramos que se cierra la conexión
            DatosBase.getInstance().closeConnection();
        }



        
    }

    public static void initTables () throws SQLException {
        // Llena las tablas creadas con valores basicos para usar y testear. EJ: 3 proveedores, 10 productos, etc

        var conn = DatosBase.getInstance().getConnection();
        query = conn.createStatement();
        
        query.execute("INSERT INTO Cuentas (Cuen_USUARIO, Cuen_CONTRASEÑA, Cuen_PERMISOS, Cuen_EMAIL) " +
                    "VALUES ('user', '123', 'Empleado', 'correo1234') ");
        query.execute("INSERT INTO Cuentas (Cuen_USUARIO, Cuen_CONTRASEÑA, Cuen_PERMISOS, Cuen_EMAIL) " +
                    "VALUES ('', '', 'Empleado', 'correo1234') ");
        query.execute("INSERT INTO Cuentas (Cuen_USUARIO, Cuen_CONTRASEÑA, Cuen_PERMISOS, Cuen_EMAIL) " +
                    "VALUES ('admin', '123', 'Administrador', 'correo1234') ");

        query.execute("INSERT INTO Personas (Pers_DNI, Pers_Nombre, Pers_Apellido, Pers_Telefono) " +
                "VALUES (0, '_', 'Anonimo', '0') ");

        query.execute("INSERT INTO Clientes (Cli_DNI, Cli_IVA, Cli_MOROSO) " +
                "VALUES (0, 'patata', 'false') ");


        query.execute("INSERT INTO Productos (Prod_CODIGO, Prod_NOMBRE, Prod_CATEGORIA, Prod_PRECIO, Prod_STOCK, Prod_STOCK_MINIMO) " +
                    "VALUES ('12', 'leche', 'comestible', '150', '200', '50')");

        query.execute("INSERT INTO Productos (Prod_CODIGO, Prod_NOMBRE, Prod_CATEGORIA, Prod_PRECIO, Prod_STOCK, Prod_STOCK_MINIMO) " +
                    "VALUES ('15', 'galletas de chocolate', 'comestible', '200', '200', '50')");

        query.execute("INSERT INTO Productos (Prod_CODIGO, Prod_NOMBRE, Prod_CATEGORIA, Prod_PRECIO, Prod_STOCK, Prod_STOCK_MINIMO) " +
                    "VALUES ('19', 'galletas de coco', 'comestible', '110', '200', '50')");
        query.execute("INSERT INTO Productos (Prod_CODIGO, Prod_NOMBRE, Prod_CATEGORIA, Prod_PRECIO, Prod_STOCK, Prod_STOCK_MINIMO) " +
                    "VALUES ('200', 'aceite', 'comestible', '300', '200', '50')");
        query.execute("INSERT INTO Productos (Prod_CODIGO, Prod_NOMBRE, Prod_CATEGORIA, Prod_PRECIO, Prod_STOCK, Prod_STOCK_MINIMO) " +
                    "VALUES ('111', 'chocolate', 'comestible', '220', '200', '50')");
         
        query.execute("INSERT INTO Proveedores (Prov_CUIT, Prov_NombreFirma, Prov_Email, Prov_Direccion) " +
                    "VALUES ('20438404334', 'provtesteo', 'test@gmail.com', 'perro mojado 845')");
        
        query.execute("INSERT INTO Personas VALUES ('43840433', 'celso','fernandez','2664375249')");
        query.execute("INSERT INTO Trabajadores VALUES ('admin', '43840433')");
        query.execute("INSERT INTO Administradores VALUES ('admin', '43840433')");
        
        
        DatosBase.getInstance().closeConnection();
    }
    
    public static void dropAllTables() throws SQLException {
        var conn = DatosBase.getInstance().getConnection();
        query = conn.createStatement();
        
        query.execute("DROP TABLE IF EXISTS Renglon_Venta");
        query.execute("DROP TABLE IF EXISTS Renglon_Pedido");
        query.execute("DROP TABLE IF EXISTS Renglon");
        query.execute("DROP TABLE IF EXISTS Productos");
        query.execute("DROP TABLE IF EXISTS ClientesFisicos");
        query.execute("DROP TABLE IF EXISTS ClientesJuridicos");
        query.execute("DROP TABLE IF EXISTS Pagos");
        query.execute("DROP TABLE IF EXISTS Clientes");
        query.execute("DROP TABLE IF EXISTS Pedidos");
        query.execute("DROP TABLE IF EXISTS Proveedores");
        query.execute("DROP TABLE IF EXISTS Administradores");
        query.execute("DROP TABLE IF EXISTS Trabajadores");
        query.execute("DROP TABLE IF EXISTS Ventas");
        query.execute("DROP TABLE IF EXISTS Cuentas");
        query.execute("DROP TABLE IF EXISTS Personas");
        
        query.execute("DROP TYPE IF EXISTS PERMISO");
        query.execute("DROP TYPE IF EXISTS METODOPAGO");
        query.execute("DROP TYPE IF EXISTS TIPOCANTIDAD");
        
        DatosBase.getInstance().closeConnection();
    }


}
