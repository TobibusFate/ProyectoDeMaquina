package datos.dao.implementation;

import datos.DatosBase;
import datos.dao.IDAO;
import objects.Renglon;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class DAO_Renglon implements IDAO<Renglon> {
    @Override
    public List<Renglon> read(Renglon renglon) {
        return null;
    }

    @Override
    public boolean create(Renglon renglon) {
        Connection conn = DatosBase.getInstance().getConnection();
        Statement statement;
        boolean exito = false;
        LocalDateTime lt = LocalDateTime.now();

        try {
            statement = conn.createStatement();
            exito = statement.execute(
                    "INSERT INTO Renglon (Ren_CODIGO, Ren_Prod_CODIGO, Ren_MONTOTOTAL, Ren_DESCUENTO) VALUES ('"
                            +renglon.getCodigo()+"', '"
                            +renglon.getProducto().getCodigoP()+"', '"
                            +renglon.getMontoTotal()+"', '"
                            + renglon.getDescuento()
                            +"' )");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        DatosBase.getInstance().closeConnection();
        return exito;
    }

    @Override
    public boolean update(Renglon renglon) {
        return false;
    }

    @Override
    public boolean delete(Renglon renglon) {
        return false;
    }

    public int generateNextKey() {
        int value = 0;
        Connection conn = DatosBase.getInstance().getConnection();
        Statement statement;
        ResultSet rs;
        try {
            statement = conn.createStatement();
            rs = statement.executeQuery("SELECT COALESCE (MAX (Ren_CODIGO),0) FROM Renglon");
            if (rs.next()){
                value = rs.getInt("coalesce");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        DatosBase.getInstance().closeConnection();
        return value+1;
    }

}
