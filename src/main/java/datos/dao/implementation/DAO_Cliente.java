package datos.dao.implementation;

import datos.DatosBase;
import datos.dao.IDAO;
import objects.Cliente;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAO_Cliente implements IDAO<Cliente> {
    private static final Logger ERRLOGGER = LogManager.getLogger("error-log");
    @Override
    public List<Cliente> read(Cliente cliente) {
        Connection conn = DatosBase.getInstance().getConnection();
        Statement statement;
        List<Cliente> list = new ArrayList<>();
        ResultSet rs;
        try {
            statement = conn.createStatement();
            if (cliente.getDni() != -1) {
                rs = statement.executeQuery("SELECT * FROM Clientes WHERE (Cli_DNI = '" +cliente.getDni()+"')");
                while (rs.next()) {
                    cliente.setDni(rs.getInt("Cli_DNI"));
                    cliente.setCondicion_IVA(rs.getString("Cli_IVA"));
                    cliente.setMoroso(rs.getBoolean("Cli_MOROSO"));
                    cliente.setDeuda(rs.getFloat("Cli_DEUDA"));
                    list.add(cliente);
                }

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
            ERRLOGGER.error(e.getMessage());
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
        Connection conn = DatosBase.getInstance().getConnection();
        PreparedStatement statement;
        Boolean exito = false;

        String sqlUpdate = " UPDATE Clientes SET Cli_IVA = ?, Cli_MOROSO = ?, Cli_DEUDA = ? WHERE (Cli_DNI = '" + cliente.getDni() + "')";
        try {
            statement = conn.prepareStatement(sqlUpdate);
            statement.setString(1,cliente.getCondicion_IVA());
            statement.setBoolean(2,cliente.getMoroso());
            statement.setFloat(3,cliente.getDeuda());
            statement.executeUpdate();
            exito = true;

        } catch (SQLException e) {
            ERRLOGGER.error(e.getMessage());
        }
        DatosBase.getInstance().closeConnection();
        return exito;
    }

    @Override
    public boolean delete(Cliente cliente) {
        return false;
    }
}
