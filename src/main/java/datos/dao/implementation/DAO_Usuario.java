package datos.dao.implementation;

import datos.DatosBase;
import datos.dao.IDAO;
import objects.Usuario;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DAO_Usuario implements IDAO<Usuario> {
    @Override
    public List<Usuario> read(Usuario u) {
        Connection conn = DatosBase.getInstance().getConnection();
        Statement statement;
        List<Usuario> list = new ArrayList<>();
        try {
            statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Usuarios WHERE (Usuario_usuario ='"+u.getUser()+"')");
            while (rs.next()){
                list.add(new Usuario(rs.getString("Usuario_usuario"),rs.getString("Usuario_contraseña"),rs.getInt("Usuario_tipo")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public boolean create(Usuario usuario) {
        return false;
    }

    @Override
    public boolean update(Usuario usuario) {
        return false;
    }

    @Override
    public boolean delete(Usuario usuario) {
        return false;
    }
}
