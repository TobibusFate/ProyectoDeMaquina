package datos.dao.implementation;


import datos.DB_BasicQuerys;
import datos.DatosBase;
import datos.dao.IDAO;
import objects.Persona;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DAO_Persona implements IDAO<Persona> {

    @Override
    public List<Persona> read(Persona p) {
        Connection conn = DatosBase.getInstance().getConnection();
        List<Persona> list = new ArrayList<>();
        ResultSet rs = null;
        try {
            List<String> tempList1 = new ArrayList<>() {{add("Pers_DNI");}};
            List<String> tempList2 = new ArrayList<>();
            tempList2.add(String.valueOf(p.getDni()));
            if (p != null) rs = DB_BasicQuerys.findTuple(tempList1, tempList2, "Personas", conn);
            else rs = DB_BasicQuerys.findTuple(null, null, "Personas", conn);
            while (rs.next()) {

                p.setDni(rs.getInt("Pers_DNI"));
                p.setApellido(rs.getString("Pers_Nombre"));
                p.setNombre(rs.getString("Pers_Apellido"));
                p.setTelefono(rs.getLong("Pers_Telefono"));

                list.add(p);   
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DatosBase.getInstance().closeConnection();
        return list;
    }

    @Override
    public boolean create(Persona p) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean update(Persona p) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean delete(Persona p) {
        // TODO Auto-generated method stub
        return false;
    }
    
}