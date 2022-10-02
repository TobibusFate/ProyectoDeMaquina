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
                + "PRIMARY KEY(CliJ_DNI, CliJ_CUIL), "
                + "FOREIGN KEY(CliJ_DNI) REFERENCES Clientes(Cli_DNI)"
                + ")"
            );
            
            // no sé si poner la foreign key de cuenta acá o en cuenta poner trab_dni
            query.execute("CREATE TABLE IF NOT EXISTS Trabajadores ("
                + "Trab_DNI INTEGER, "
                + "Trab_USUARIO VARCHAR(255) NOT NULL, "
                + "PRIMARY KEY(Trab_DNI), "
                + "FOREIGN KEY(Trab_DNI) REFERENCES Personas(Pers_DNI), "
                + "FOREIGN KEY(Trab_USUARIO) REFERENCES Cuentas(Cuen_USUARIO)"
                + ")"
            );

            query.execute("CREATE TABLE IF NOT EXISTS Cuentas ("
                    + "Cuen_USUARIO VARCHAR(255), "
                    + "Cuen_CONTRASEÑA VARCHAR(255) NOT NULL, "
                    + "Cuen_PERMISOS BOOLEAN NOT NULL, "
                    + "Cuen_EMAIL VARCHAR(255) NOT NULL, "
                    + "PRIMARY KEY(Cuen_USUARIO)"
                    + ")"
            );

            query.execute("CREATE TABLE IF NOT EXISTS Administradores ("
                + "Admin_DNI INTEGER, "
                + "PRIMARY KEY(Admin_DNI), "
                + "FOREIGN KEY(Admin_DNI) REFERENCES Trabajadores(Trab_DNI)"
                + ")"
            );
            
            query.execute("CREATE TABLE IF NOT EXISTS Pedidos ("
                + "Ped_Prov_CUIT BIGINT, "
                + "Ped_Admin_DNI INTEGER, "
                + "Ped_CODIGO INTEGER, "
                + "Ped_FECHAPEDIDO DATE NOT NULL, "
                + "Ped_FECHAENTREGA DATE, "
                + "PRIMARY KEY(Ped_Prov_CUIT, Ped_Admin_DNI, Ped_CODIGO), "
                + "FOREIGN KEY(Ped_Prov_CUIT) REFERENCES Proveedores(Prov_CUIT), "
                + "FOREIGN KEY(Ped_Admin_DNI) REFERENCES Administradores(Admin_DNI)"
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

            query.execute("CREATE TABLE IF NOT EXISTS Ventas ("
                + "Venta_CODIGO INTEGER, "
                + "Venta_CERRADA BOOLEAN NOT NULL, "
                + "Venta_MONTO REAL NOT NULL, "
                + "Venta_FECHA DATE, "
                + "Venta_HORA TIME, "
                + "PRIMARY KEY(Venta_CODIGO)"
                + ")"
            );

            query.execute("CREATE TABLE IF NOT EXISTS Pagos("
                + "Pago_CODIGO INTEGER, "
                + "Pago_Venta_CODIGO INTEGER, "
                + "Pago_MONTO REAL NOT NULL, "
                + "Pago_FECHAPAGO DATE NOT NULL, "
                + "Pago_FECHALIMITE DATE, "
                + "Pago_CUOTAS INTEGER NOT NULL, "
                + "Pago_TIPO ENUM('Fiado','Efectivo','TarjetaDebito','TarjetaCredito'), "
                + "PRIMARY KEY(Pago_CODIGO, Pago_Venta_CODIGO), "
                + "FOREIGN KEY(Pago_Venta_CODIGO) REFERENCES Ventas(Venta_CODIGO)"
            );
/*
            query.execute("CREATE TABLE IF NOT EXISTS MetodosDePago ("
                + "Metod_TIPO ENUM('Fiado','Efectivo','TarjetaDebito','TarjetaCredito'), "
                + "Metod_TITULAR VARCHAR(255), "
                + "Metod_CUOTAS"
                + ""
                + ""
            );
*/

            
            //query.execute("INSERT INTO Usuarios (Usuario_usuario, Usuario_contraseña, Usuario_tipo, Usuario_telefono, Usuario_Email) " +
              //      "VALUES ('user', '123', '1', '2266646', 'correo1234') ");
            //query.execute("INSERT INTO Usuarios (Usuario_usuario, Usuario_contraseña, Usuario_tipo, Usuario_telefono, Usuario_Email) " +
                //    "VALUES ('admin', '123', '2', '2266646', 'correo1234') ");

            query.execute("CREATE TABLE IF NOT EXISTS Renglon ("
                + "Ren_CODIGO INTEGER, "
                + "Ren_Prod_CODIGO INTEGER, "
                + "Ren_MONTOTOTAL REAL NOT NULL, "
                + "Ren_DESCUENTO INTEGER NOT NULL, "
                + "PRIMARY KEY(Ren_Prod_CODIGO, Ren_CODIGO), "
                + "FOREIGN KEY(Ren_Prod_CODIGO) REFERENCES Productos(Prod_CODIGO)"
                + ")"
            );

            query.execute("CREATE TABLE IF NOT EXISTS Renglon-Venta ("
                + "RenC_CODIGO INTEGER, "
                + "RenC_Venta_CODIGO INTEGER, "
                + "RenC_UNIDADES INTEGER NOT NULL, "
                + "PRIMARY KEY(RenC_CODIGO, RenC_Venta_CODIGO), "
                + "FOREIGN KEY(RenC_CODIGO) REFERENCES Renglon(Ren_CODIGO), "
                + "FOREIGN KEY(RenC_Venta_CODIGO) REFERENCES Ventas(Venta_CODIGO)"
                + ")"
            );
            query.execute("CREATE TABLE IF NOT EXISTS Renglon-Pedido ("
                + "RenP_CODIGO INTEGER, "
                + "RenP_Ped_CODIGO INTEGER, "
                + "RenP_Tipo ENUM('Bolsones', 'Bultos Cerrados', 'Pallets') NOT NULL, "
                + "RenP_CANTIDAD INTEGER NOT NULL, "
                + "PRIMARY KEY(RenP_CODIGO, RenP_Ped_CODIGO), "
                + "FOREIGN KEY(RenP_Ped_CODIGO) REFERENCES Pedidos(Ped_CODIGO)"
                + ")"
            );
            
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
