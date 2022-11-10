package datos.dao.implementation;

import datos.DatosBase;
import datos.dao.IDAO;
import objects.Cuenta;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DAO_Cuenta implements IDAO<Cuenta> {
    private static final Logger ERRLOGGER = LogManager.getLogger("error-log");
    @Override
    public List<Cuenta> read(Cuenta c) {
        Connection conn = DatosBase.getInstance().getConnection();
        Statement statement;
        List<Cuenta> list = new ArrayList<>();
        try {
            statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Cuentas WHERE (Cuen_USUARIO ='"+c.getCuenta()+"')");
            while (rs.next()){
                list.add(new Cuenta(rs.getString("Cuen_USUARIO"),rs.getString("Cuen_CONTRASEÑA"), rs.getString("Cuen_EMAIL"),rs.getString("Cuen_PERMISOS")));
            }
        } catch (SQLException e) {
            ERRLOGGER.error(e.getMessage());
        }
        DatosBase.getInstance().closeConnection();
        return list;
    }

    @Override
    public boolean create(Cuenta usuario) {
        return false;
    }

    @Override
    public boolean update(Cuenta usuario) {
        return false;
    }

    @Override
    public boolean delete(Cuenta usuario) {
        return false;
    }
}
