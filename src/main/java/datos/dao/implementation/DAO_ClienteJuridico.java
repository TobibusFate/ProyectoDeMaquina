package datos.dao.implementation;

import datos.DatosBase;
import datos.dao.IDAO;
import objects.Cliente_Juridico;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DAO_ClienteJuridico implements IDAO<Cliente_Juridico> {
    @Override
    public List<Cliente_Juridico> read(Cliente_Juridico cliente_juridico) {
        Connection conn = DatosBase.getInstance().getConnection();
        Statement statement;
        List<Cliente_Juridico> list = new ArrayList<>();
        ResultSet rs;

        try {
            statement = conn.createStatement();
            // query para retornar el producto
            if (cliente_juridico != null) {
                rs = statement.executeQuery("SELECT * FROM ClientesJuridicos WHERE (CliJ_DNI = '" +cliente_juridico.getDni()+"')");
                list.add(new Cliente_Juridico(rs.getInt("CliJ_DNI"),rs.getLong("CliJ_CUIT")));
                // query para retornar lista de productos
            } else {
                rs = statement.executeQuery("SELECT * FROM ClientesJuridicos ORDER BY CliJ_DNI");
                while (rs.next()){
                    list.add(new Cliente_Juridico(rs.getInt("CliJ_DNI"),rs.getLong("CliJ_CUIT")));
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        DatosBase.getInstance().closeConnection();
        return list;
    }

    @Override
    public boolean create(Cliente_Juridico cliente_juridico) {
        return false;
    }

    @Override
    public boolean update(Cliente_Juridico cliente_juridico) {
        return false;
    }

    @Override
    public boolean delete(Cliente_Juridico cliente_juridico) {
        return false;
    }
}
