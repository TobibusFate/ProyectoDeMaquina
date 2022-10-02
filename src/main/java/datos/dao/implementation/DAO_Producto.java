package datos.dao.implementation;

import datos.DatosBase;
import datos.dao.IDAO;
import objects.Producto;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DAO_Producto implements IDAO<Producto> {
    @Override
    public List<Producto> read(Producto p) {
        Connection conn = DatosBase.getInstance().getConnection();
        Statement statement;
        List<Producto> list = new ArrayList<>();
        ResultSet rs;
        try {
            statement = conn.createStatement();
            // query para retornar el producto
            if (p != null) {
                rs = statement.executeQuery("SELECT * FROM Productos WHERE Prod_CODIGO = " +p.getCodigoP());
                list.add(new Producto(rs.getInt("Prod_CODIGO"),
                        rs.getString("Prod_NOMBRE"),
                        rs.getString("Prod_CATEGORIA"),
                        rs.getInt("Prod_PRECIO"),
                        rs.getInt("Prod_STOCK"),
                        rs.getInt("Prod_STOCK_MINIMO")
                        ));
            // query para retornar lista de productos
            } else {
                rs = statement.executeQuery("SELECT * FROM Productos ORDER BY COD)");
                while (rs.next()){
                    list.add(new Producto(rs.getInt("Prod_CODIGO"),
                            rs.getString("Prod_NOMBRE"),
                            rs.getString("Prod_CATEGORIA"),
                            rs.getInt("Prod_PRECIO"),
                            rs.getInt("Prod_STOCK"),
                            rs.getInt("Prod_STOCK_MINIMO")
                    ));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public boolean create(Producto producto) {
        return false;
    }

    @Override
    public boolean update(Producto producto) {
        /*Connection conn = DatosBase.getInstance().getConnection();
        Statement statement;

        try {
            statement = conn.createStatement();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }*/
        return false;
    }

    @Override
    public boolean delete(Producto producto) {
        return false;
    }
}
