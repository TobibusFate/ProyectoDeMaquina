package datos.dao.implementation;

import datos.DatosBase;
import datos.dao.IDAO;
import objects.RenglonVenta;
import objects.Venta;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class DAO_RenglonVenta implements IDAO<RenglonVenta> {
    private static final Logger ERRLOGGER = LogManager.getLogger("error-log");
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
            ERRLOGGER.error(e.getMessage());
        }

        DatosBase.getInstance().closeConnection();
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

    public List<RenglonVenta> readRenglonVentaToVenta(Venta venta ) {
        Connection conn = DatosBase.getInstance().getConnection();
        Statement statement;
        List<RenglonVenta> list = new ArrayList<>();
        ResultSet rs;

        try {
            statement = conn.createStatement();
            rs = statement.executeQuery("SELECT * FROM Renglon_Venta WHERE (RenV_Venta_CODIGO = '" +venta.getCodigoV()+"')");
            while (rs.next()) {
                list.add(new RenglonVenta(
                        rs.getInt("RenV_CODIGO"),
                        rs.getInt("RenV_UNIDADES")
                ));
            }
        } catch (SQLException e) {
            ERRLOGGER.error(e.getMessage());
        }

        return list;
    }
}
