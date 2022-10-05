package datos.dao.implementation;

import datos.DatosBase;
import datos.dao.IDAO;
import objects.Producto;
import objects.Venta;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class DAO_Venta implements IDAO<Venta> {

    @Override
    public List<Venta> read(Venta venta) {
        if (venta != null) {
            /** query para recuperar venta*/
        } else {
            /** query para retornar lista de ventas*/
        }
        return null;
    }

    @Override
    public boolean create(Venta venta) {
        Connection conn = DatosBase.getInstance().getConnection();
        Statement statement;
        boolean exito = false;
        LocalDateTime lt = LocalDateTime.now();

        try {
            statement = conn.createStatement();
            exito = statement.execute(
                    "INSERT INTO Ventas (Venta_CODIGO, Venta_CERRADA, Venta_MONTO, Venta_FECHA, Venta_HORA) VALUES ('"
                            +venta.getCodigoV()+"', '"
                            +venta.getCerradaV()+"', '"
                            +venta.getMontoV()+"', '"
                            +LocalDate.now()+"', '"
                            +lt.getHour() +":"+ lt.getMinute() +":"+ lt.getSecond()
                            +"' )");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        /** query para crear venta*/
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
            throw new RuntimeException(e);
        }
        DatosBase.getInstance().closeConnection();
        return value+1;
    }
}
