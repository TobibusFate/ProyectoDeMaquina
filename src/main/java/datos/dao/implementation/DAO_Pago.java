package datos.dao.implementation;

import datos.DatosBase;
import datos.dao.IDAO;
import objects.Cliente_Fisico;
import objects.Pago;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.List;

public class DAO_Pago implements IDAO<Pago> {
    @Override
    public List<Pago> read(Pago pago) {
        return null;
    }

    @Override
    public boolean create(Pago pago) {
        Connection conn = DatosBase.getInstance().getConnection();
        Statement statement;
        boolean exito = false;
        if (pago.getCliente() == null) {
            pago.setCliente(new Cliente_Fisico(0));
        }
        try {
            statement = conn.createStatement();
            exito = statement.execute(
                    "INSERT INTO Pagos (Pago_CODIGO, Pago_Venta_CODIGO, Pago_Cliente_DNI, Pago_MONTO, Pago_FECHAPAGO, Pago_FECHALIMITE, Pago_CUOTAS, Pago_TIPO) VALUES ('"
                            +pago.getCodigoP()+"', '"
                            +pago.getVenta().getCodigoV()+"', '"
                            +pago.getCliente().getDni()+"', '"
                            +pago.getMontoP()+"', '"
                            +pago.getFechaP()+"', '"
                            +pago.getFechaLimiteP()+"', '"
                            +pago.getCuotas()+"', '"
                            +pago.getMetodoPago()
                            +"' )");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        DatosBase.getInstance().closeConnection();
        return exito;
    }

    @Override
    public boolean update(Pago pago) {
        return false;
    }

    @Override
    public boolean delete(Pago pago) {
        return false;
    }
    public int generateNextKey() {
        int value = 0;
        Connection conn = DatosBase.getInstance().getConnection();
        Statement statement;
        ResultSet rs;
        try {
            statement = conn.createStatement();
            rs = statement.executeQuery("SELECT COALESCE (MAX (Pago_CODIGO),0) FROM Pagos");
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
