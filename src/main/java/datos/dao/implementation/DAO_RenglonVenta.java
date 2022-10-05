package datos.dao.implementation;

import datos.DatosBase;
import datos.dao.IDAO;
import objects.RenglonVenta;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.List;

public class DAO_RenglonVenta implements IDAO<RenglonVenta> {
    @Override
    public List<RenglonVenta> read(RenglonVenta renglonVenta) {
        return null;
    }

    @Override
    public boolean create(RenglonVenta renglonVenta) {
        Connection conn = DatosBase.getInstance().getConnection();
        Statement statement;
        boolean exito = false;
        LocalDateTime lt = LocalDateTime.now();

        try {
            statement = conn.createStatement();
            exito = statement.execute(
                    "INSERT INTO Renglon_Venta (RenV_CODIGO, RenV_Venta_CODIGO, RenV_UNIDADES) VALUES ('"
                            +renglonVenta.getCodigo()+"', '"
                            +renglonVenta.getVenta().getCodigoV()+"', '"
                            +renglonVenta.getUnidades()
                            +"' )");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        /** query para crear venta*/
        return exito;
    }


    @Override
    public boolean update(RenglonVenta renglonVenta) {
        return false;
    }

    @Override
    public boolean delete(RenglonVenta renglonVenta) {
        return false;
    }
}
