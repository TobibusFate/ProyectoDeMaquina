package datos.dao.implementation;

import datos.DatosBase;
import datos.dao.IDAO;
import objects.Venta;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class DAO_Venta implements IDAO<Venta> {
    private static final Logger ERRLOGGER = LogManager.getLogger("error-log");

    @Override
    public List<Venta> read(Venta venta) {
        Connection conn = DatosBase.getInstance().getConnection();
        Statement statement;
        List<Venta> list = new ArrayList<>();
        ResultSet rs;

        try {
            statement = conn.createStatement();
            if (venta != null) {
                rs = statement.executeQuery("SELECT * FROM Ventas WHERE (Venta_CODIGO = '" +venta.getCodigoV()+"')");
                while (rs.next()) {
                    list.add(new Venta(
                            rs.getInt("Venta_CODIGO"),
                            rs.getString("Venta_Cuen_USUARIO"),
                            rs.getBoolean("Venta_CERRADA"),
                            rs.getFloat("Venta_MONTO"),
                            rs.getDate("Venta_FECHA"),
                            rs.getTime("Venta_HORA")
                    ));
                }
                // query para retornar lista de productos
            } else {
                rs = statement.executeQuery("SELECT * FROM Ventas ORDER BY Venta_CODIGO");
                while (rs.next()) {
                    list.add(new Venta(
                            rs.getInt("Venta_CODIGO"),
                            rs.getString("Venta_Cuen_USUARIO"),
                            rs.getBoolean("Venta_CERRADA"),
                            rs.getFloat("Venta_MONTO"),
                            rs.getDate("Venta_FECHA"),
                            rs.getTime("Venta_HORA")
                    ));
                }
            }
        } catch (SQLException e) {
            ERRLOGGER.error(e.getMessage());
        }
        return list;
    }

    /*
    "Venta_CODIGO INTEGER, "
                + "Venta_Cuen_USUARIO VARCHAR(255) NOT NULL, "
                + "Venta_CERRADA BOOLEAN NOT NULL, "
                + "Venta_MONTO REAL NOT NULL, "
                + "Venta_FECHA DATE, "
                + "Venta_HORA TIME, "
     */

    @Override
    public boolean create(Venta venta) {
        Connection conn = DatosBase.getInstance().getConnection();
        Statement statement;
        boolean exito = false;
        LocalDateTime lt = LocalDateTime.now();

        try {
            statement = conn.createStatement();
            exito = statement.execute(
                    "INSERT INTO Ventas (Venta_CODIGO, Venta_Cuen_USUARIO, Venta_CERRADA, Venta_MONTO, Venta_FECHA, Venta_HORA) VALUES ('"
                            +venta.getCodigoV()+"', '"
                            +venta.getCuentaVendedor()+"', '"
                            +venta.getCerradaV()+"', '"
                            +venta.getMontoV()+"', '"
                            +LocalDate.now()+"', '"
                            +lt.getHour() +":"+ lt.getMinute() +":"+ lt.getSecond()
                            +"' )");

        } catch (SQLException e) {
            ERRLOGGER.error(e.getMessage());
        }
        DatosBase.getInstance().closeConnection();
        return exito;
    }

    @Override
    public boolean update(Venta venta) {
        /** query para actualizar venta*/
        return false;
    }

    @Override
    public boolean delete(Venta venta) {
        /** query para eliminar venta*/
        return false;
    }
    public int generateNextKey() {
        int value = 0;
        Connection conn = DatosBase.getInstance().getConnection();
        Statement statement;
        ResultSet rs;
        try {
            statement = conn.createStatement();
            rs = statement.executeQuery("SELECT COALESCE (MAX (Venta_CODIGO),0) FROM Ventas");
            if (rs.next()){
                value = rs.getInt("coalesce");
            }

        } catch (SQLException e) {
            ERRLOGGER.error(e.getMessage());
        }
        DatosBase.getInstance().closeConnection();
        return value+1;
    }
}
