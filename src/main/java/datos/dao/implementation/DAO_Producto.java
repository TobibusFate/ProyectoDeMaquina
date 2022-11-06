package datos.dao.implementation;

import datos.DB_BasicQuerys;
import datos.DatosBase;
import datos.dao.IDAO;
import objects.Producto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAO_Producto implements IDAO<Producto> {
    @Override
    public List<Producto> read(Producto producto) {
        Connection conn = DatosBase.getInstance().getConnection();
        Statement statement;
        List<Producto> list = new ArrayList<>();
        ResultSet rs;
        try {
            statement = conn.createStatement();
            // query para retornar el producto
            if (producto != null) {
                rs = statement.executeQuery("SELECT * FROM Productos WHERE (Prod_CODIGO = '" +producto.getCodigoP()+"')");
                while (rs.next()) {
                    list.add(new Producto(
                            rs.getInt("Prod_CODIGO"),
                            rs.getString("Prod_NOMBRE"),
                            rs.getString("Prod_CATEGORIA"),
                            rs.getFloat("Prod_PRECIO"),
                            rs.getInt("Prod_STOCK"),
                            rs.getInt("Prod_STOCK_MINIMO"),
                            rs.getBoolean("Prod_VISIBILIDAD")
                            ));
                }
            // query para retornar lista de productos
            } else {
                rs = statement.executeQuery("SELECT * FROM Productos ORDER BY Prod_CODIGO");
                while (rs.next()){
                    list.add(new Producto(
                            rs.getInt("Prod_CODIGO"),
                            rs.getString("Prod_NOMBRE"),
                            rs.getString("Prod_CATEGORIA"),
                            rs.getFloat("Prod_PRECIO"),
                            rs.getInt("Prod_STOCK"),
                            rs.getInt("Prod_STOCK_MINIMO"),
                            rs.getBoolean("Prod_VISIBILIDAD")
                    ));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        DatosBase.getInstance().closeConnection();
        return list;
    }

    @Override
    public boolean create(Producto producto) {
        Connection conn = DatosBase.getInstance().getConnection();
        boolean result = DB_BasicQuerys.insertTuple(producto.getKeyNamesList(), producto.getAttributeValuesList(), "Productos", conn);
        DatosBase.getInstance().closeConnection();
        
        return result;
    }
    @Override
    public boolean update(Producto producto) {
        Connection conn = DatosBase.getInstance().getConnection();
        PreparedStatement statement;
        boolean exito = false;
        String sqlUpdate = " UPDATE Productos SET Prod_NOMBRE = ?, Prod_CATEGORIA = ?, Prod_PRECIO = ?, Prod_STOCK = ?, Prod_STOCK_MINIMO = ?, Prod_VISIBILIDAD = ?" +
                " WHERE (Prod_CODIGO = '" + producto.getCodigoP() + "')";
        try {
            statement = conn.prepareStatement(sqlUpdate);
            statement.setString(1,producto.getNombreP());
            statement.setString(2,producto.getCategoriaP());
            statement.setFloat(3,producto.getPrecioP());
            statement.setInt(4,producto.getStockP());
            statement.setInt(5,producto.getStockMinimoP());
            statement.setBoolean(6,producto.isVisible());
            statement.executeUpdate();
            exito = true;

        } catch (SQLException e) {
            return false;
        }
        DatosBase.getInstance().closeConnection();
        return exito;
    }

    @Override
    public boolean delete(Producto producto) {
        Connection conn = DatosBase.getInstance().getConnection();
        PreparedStatement statement;
        Boolean exito = false;

        String sqlDelete= " DELETE Productos WHERE(Prod_CODIGO = '" + producto.getCodigoP() + "')";

        try {
            statement = conn.prepareStatement(sqlDelete);
            statement.executeUpdate();
            exito = true;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        DatosBase.getInstance().closeConnection();
        return exito;
    }
}
