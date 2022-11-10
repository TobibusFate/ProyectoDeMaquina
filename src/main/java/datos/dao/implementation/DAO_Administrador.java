package datos.dao.implementation;

import datos.DB_BasicQuerys;
import datos.DatosBase;
import datos.dao.IDAO;
import objects.Administrador;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAO_Administrador implements IDAO<Administrador>{

    private static final Logger ERRLOGGER = LogManager.getLogger("error-log");
    @Override
    public List<Administrador> read(Administrador a) {
        Connection conn = DatosBase.getInstance().getConnection();
        List<Administrador> list = new ArrayList<>();
        ResultSet rs = null;
        try {
            if (a != null) rs = DB_BasicQuerys.findTuple(a.getKeyNamesList(),a.getKeyValuesList(), "Administradores", conn);
            else rs = DB_BasicQuerys.findTuple(null, null, "Administradores", conn);
            while (rs.next()) {
                list.add(new Administrador(null, null, 0, 0, null)
                );   
            }
            rs.close();
        } catch (SQLException e) {
            ERRLOGGER.error(e.getMessage());
        }
        DatosBase.getInstance().closeConnection();
        return list;
    }

    @Override
    public boolean create(Administrador a) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean update(Administrador a) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean delete(Administrador a) {
        // TODO Auto-generated method stub
        return false;
    }
    
}
