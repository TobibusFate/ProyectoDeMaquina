
package datos.dao.implementation;

import datos.DB_BasicQuerys;
import datos.DatosBase;
import datos.dao.IDAO;
import logica.managers.ManagerAdministrador;
import logica.managers.ManagerProveedor;
import objects.Administrador;
import objects.Pedido;
import objects.Proveedor;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class DAO_Pedido implements IDAO<Pedido> {
    
    @Override
    public List<Pedido> read(Pedido p) {
        Connection conn = DatosBase.getInstance().getConnection();
        List<Pedido> list = new ArrayList<>();
        ResultSet rs = null;
        try {
            if (p != null) rs = DB_BasicQuerys.findTuple(p.getKeyNamesList(), p.getKeyValuesList(), "Pedidos", conn);
            else rs = DB_BasicQuerys.findTuple(null, null, "Pedidos", conn);
            while (rs.next()) {
                Proveedor prov = ManagerProveedor.getProveedor(rs.getLong("Ped_Prov_CUIT"));
                Administrador admin = ManagerAdministrador.getAdministrador(rs.getInt("Ped_Admin_DNI"), rs.getString("Ped_Admin_USUARIO"));
            
                if (rs.getDate("Ped_FECHAENTREGA") != null) { 
                    list.add(new Pedido(
                        rs.getInt("Ped_CODIGO"),
                        rs.getDate("Ped_FECHAPEDIDO").toLocalDate(),
                        rs.getDate("Ped_FECHAENTREGA").toLocalDate(),
                        admin,
                        prov
                        )
                    );   
                }
                else {
                    list.add(new Pedido(
                        rs.getInt("Ped_CODIGO"),
                        rs.getDate("Ped_FECHAPEDIDO").toLocalDate(),
                        null,
                        admin,
                        prov
                        )
                    );
                }
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DatosBase.getInstance().closeConnection();
        return list;
    }

    @Override
    public boolean create(Pedido p) {
        Connection conn = DatosBase.getInstance().getConnection();
        
        boolean result = DB_BasicQuerys.insertTuple(p.getKeyNamesList(), p.getAttributeValuesList(), "Pedidos", conn);
        DatosBase.getInstance().closeConnection();
        return result;
    }

    @Override
    public boolean update(Pedido p) {
        Connection conn = DatosBase.getInstance().getConnection();
        Statement statement;
        boolean exito = false;
        try{
            statement = conn.createStatement();
            exito = statement.execute(
                "UPDATE Pedidos SET Ped_FECHAENTREGA = " +
                        p.getFechaEntrega() +
                        " WHERE Ped_CODIGO = " +
                        p.getCodigo()
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return exito;
    }

    @Override
    public boolean delete(Pedido p) {
        Connection conn = DatosBase.getInstance().getConnection();
        
        boolean result = DB_BasicQuerys.deleteTuple(p.getKeyNamesList(), p.getKeyValuesList(), "Pedidos", conn);
        DatosBase.getInstance().closeConnection();
        return result;
    }

    public int generateNextKey() {
        int value = 0;
        Connection conn = DatosBase.getInstance().getConnection();
        Statement statement;
        ResultSet rs;
        try {
            statement = conn.createStatement();
            rs = statement.executeQuery("SELECT COALESCE (MAX (Ped_CODIGO),0) FROM Pedidos");
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
