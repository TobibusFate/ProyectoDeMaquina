package datos.dao.implementation;

import datos.DatosBase;
import datos.dao.IDAO;
import objects.Cliente_Fisico;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DAO_ClienteFisico implements IDAO<Cliente_Fisico> {
    private static final Logger ERRLOGGER = LogManager.getLogger("error-log");
    @Override
    public List<Cliente_Fisico> read(Cliente_Fisico cliente_fisico) {
        Connection conn = DatosBase.getInstance().getConnection();
        Statement statement;
        List<Cliente_Fisico> list = new ArrayList<>();
        ResultSet rs;

        try {
            statement = conn.createStatement();
            // query para retornar el producto
            if (cliente_fisico != null) {
               
                rs = statement.executeQuery("SELECT * FROM ClientesFisicos WHERE (CliF_DNI = '" +cliente_fisico.getDni()+"')");
                while(rs.next()){
                list.add(new Cliente_Fisico(rs.getInt("CliF_DNI"),rs.getLong("CliF_CUIL")));
                }// query para retornar lista de productos
            } else {
                rs = statement.executeQuery("SELECT * FROM ClientesFisicos ORDER BY CliF_DNI");
                while (rs.next()){
                    list.add(new Cliente_Fisico(rs.getInt("CliF_DNI"),rs.getLong("CliF_CUIL")));
                }
            }

        } catch (SQLException e) {
            ERRLOGGER.error(e.getMessage());
        }
        DatosBase.getInstance().closeConnection();
        return list;
    }

    @Override
    public boolean create(Cliente_Fisico cliente_fisico) {
        return false;
    }

    @Override
    public boolean update(Cliente_Fisico cliente_fisico) {
        return false;
    }

    @Override
    public boolean delete(Cliente_Fisico cliente_fisico) {
        return false;
    }

}
