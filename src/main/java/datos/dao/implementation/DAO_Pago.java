package datos.dao.implementation;

import datos.DatosBase;
import datos.dao.IDAO;
import logica.managers.ManagerCliente;
import objects.Cliente_Fisico;
import objects.Pago;
import objects.Venta;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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

    public List<Pago> readPagoToVenta (Venta venta) {
        Connection conn = DatosBase.getInstance().getConnection();
        Statement statement;
        List<Pago> list = new ArrayList<>();
        ResultSet rs;

        try {
            statement = conn.createStatement();
            rs = statement.executeQuery("SELECT * FROM Pagos WHERE (Pago_Venta_CODIGO = '" +venta.getCodigoV()+"')");
            while (rs.next()) {
                list.add(new Pago(
                        rs.getInt("Pago_CODIGO"),
                        rs.getDate("Pago_FECHAPAGO").toLocalDate(),
                        rs.getDate("Pago_FECHALIMITE").toLocalDate(),
                        rs.getFloat("Pago_MONTO"),
                        venta,rs.getInt("Pago_CUOTAS"),
                        rs.getString("Pago_TIPO"),
                        ManagerCliente.getCliente(rs.getInt("Pago_Cliente_DNI"))
                        )
                );
            }
            /** QUERY DE SI EXISTEN PAGOS CON ESTA VENTA*/

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return list;

    }

}
