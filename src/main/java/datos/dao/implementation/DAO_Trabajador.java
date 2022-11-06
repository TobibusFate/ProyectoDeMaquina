package datos.dao.implementation;

import datos.DB_BasicQuerys;
import datos.DatosBase;
import datos.dao.IDAO;
import logica.managers.ManagerPersona;
import objects.Trabajador;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DAO_Trabajador implements IDAO<Trabajador>{

    private static final Logger ERRLOGGER = LogManager.getLogger("error-log");
    @Override
    public List<Trabajador> read(Trabajador t) {
        Connection conn = DatosBase.getInstance().getConnection();
        List<Trabajador> list = new ArrayList<>();
        ResultSet rs = null;
        
        try {
            if (t != null) {
                if (t.getDni() != -1) rs = DB_BasicQuerys.findTuple(t.getKeyNamesList(), t.getKeyValuesList(), "Trabajadores", conn);
                else {
                    List<String> tempList = new ArrayList<>();
                    List<String> tempList2 = new ArrayList<>() {{add("Trab_USUARIO");}};
                    tempList.add(t.getCuenta().getCuenta());
                    rs = DB_BasicQuerys.findTuple(tempList2, tempList, "Trabajadores", conn);
                }
            }
            else rs = DB_BasicQuerys.findTuple(null, null, "Trabajadores", conn);
            while (rs.next()) {     
                Trabajador trab = (Trabajador) ManagerPersona.getPersonaTrabajador(rs.getInt("Trab_DNI"));
                list.add(new Trabajador(
                    trab.getApellido(),
                    trab.getNombre(), 
                    trab.getDni(), 
                    trab.getTelefono(), 
                    null)); 
            }
            rs.close();
        } catch (SQLException e) {
            ERRLOGGER.error(e.getMessage());
        }
        DatosBase.getInstance().closeConnection();
        return list;
    }

    @Override
    public boolean create(Trabajador t) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean update(Trabajador t) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean delete(Trabajador t) {
        // TODO Auto-generated method stub
        return false;
    }
    
}
