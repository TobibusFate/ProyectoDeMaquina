package datos.dao.implementation;



import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import datos.DB_BasicQuerys;
import datos.DatosBase;
import datos.dao.IDAO;
import objects.Persona;
import objects.Trabajador;

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
    public List<Persona> readtobias(Persona p) {
        Connection conn = DatosBase.getInstance().getConnection();
        Statement statement;
        List<Persona> list = new ArrayList<>();
        ResultSet rs;
        try {
            statement = conn.createStatement();
            if (p != null) {
                rs = statement.executeQuery("SELECT * FROM Personas WHERE (Pers_DNI = '" +p.getDni()+"')");
                while (rs.next()) {
                    p.setDni(rs.getInt("Pers_DNI"));
                    p.setApellido(rs.getString("Pers_Apellido"));
                    p.setNombre(rs.getString("Pers_Nombre"));
                    p.setTelefono(rs.getLong("Pers_Telefono"));
                    list.add(p);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DatosBase.getInstance().closeConnection();
        return list;
    }
    
}
