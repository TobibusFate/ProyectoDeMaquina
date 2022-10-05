package datos.dao.implementation;

import datos.DatosBase;
import datos.dao.IDAO;
import objects.Cliente;
import objects.Producto;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DAO_Cliente implements IDAO<Cliente> {
    @Override
    public List<Cliente> read(Cliente cliente) {
        Connection conn = DatosBase.getInstance().getConnection();
        Statement statement;
        List<Cliente> list = new ArrayList<>();
        ResultSet rs;
        try {
            statement = conn.createStatement();
            // query para retornar el producto
            if (cliente.getDni() != -1) {
                rs = statement.executeQuery("SELECT * FROM Clientes WHERE (Cli_DNI = '" +cliente.getDni()+"')");
                cliente.setDni(rs.getInt("Cli_DNI"));
                cliente.setCondicion_IVA(rs.getString("Cli_IVA"));
                cliente.setMoroso(rs.getBoolean("Cli_MOROSO"));
                cliente.setDeuda(rs.getFloat("Cli_DEUDA"));
                list.add(cliente);
                // query para retornar lista de productos
            } else {
                rs = statement.executeQuery("SELECT * FROM Clientes ORDER BY Cli_DNI");
                while (rs.next()){
                    cliente.setDni(rs.getInt("Cli_DNI"));
                    cliente.setCondicion_IVA(rs.getString("Cli_IVA"));
                    cliente.setMoroso(rs.getBoolean("Cli_MOROSO"));
                    cliente.setDeuda(rs.getFloat("Cli_DEUDA"));
                    list.add(cliente);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        DatosBase.getInstance().closeConnection();
        return list;
    }

    @Override
    public boolean create(Cliente cliente) {
        return false;
    }

    @Override
    public boolean update(Cliente cliente) {
        return false;
    }

    @Override
    public boolean delete(Cliente cliente) {
        return false;
    }
}
