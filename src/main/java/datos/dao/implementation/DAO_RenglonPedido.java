
package datos.dao.implementation;

import datos.DB_BasicQuerys;
import datos.DatosBase;
import datos.dao.IDAO;
import logica.managers.ManagerPedido;
import logica.managers.ManagerRenglon;
import objects.Pedido;
import objects.RenglonPedido;
import objects.TipoCantidad;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class DAO_RenglonPedido implements IDAO<RenglonPedido>{

    private static final Logger ERRLOGGER = LogManager.getLogger("error-log");
    @Override
    public List<RenglonPedido> read(RenglonPedido rp) {
        Connection conn = DatosBase.getInstance().getConnection();
        List<RenglonPedido> list = new ArrayList<>();
        ResultSet rs = null;
        try {
            if (rp != null && rp.getCodigo() == 0) rs = DB_BasicQuerys.findTuple(rp.getKeyNamesList(), rp.getKeyValuesList(), "Renglon_Pedido", conn);
            else if (rp != null) {
                List<String> names = new ArrayList<>() {{add("RenP_Ped_CODIGO");}};
                List<String> values = new ArrayList<>();
                values.add(Integer.toString(rp.getCodigo()));
                rs = DB_BasicQuerys.customFindQuery("Pedidos, Renglon_Pedido", "RenP_CODIGO, RenP_Ped_CODIGO, RenP_TIPO, RenP_CANTIDAD", names, values, conn);
            }
            else rs = DB_BasicQuerys.findTuple(null, null, "Renglon_Pedido", conn);
            
            while (rs.next()) {
                Pedido pedido = ManagerPedido.getPedido(new Pedido(rs.getInt("RenP_Ped_CODIGO"), null, null));
                RenglonPedido renglon_pedido = new RenglonPedido(
                        rs.getInt("RenP_CODIGO"),
                        null,
                        pedido,
                        rs.getInt("RenP_CANTIDAD"),
                        TipoCantidad.valueOf(rs.getString("RenP_TIPO")),
                        0F,
                        0F
                        );
                RenglonPedido renglon = (RenglonPedido) ManagerRenglon.getRenglonPedido(rs.getInt("RenP_CODIGO"));
                
                renglon_pedido.setProducto(renglon.getProducto());
                renglon_pedido.setDescuento(renglon.getDescuento());
                renglon_pedido.setMontoTotal(renglon.getMontoTotal());
                
                list.add(renglon_pedido);
            }
            rs.close();
        } catch (SQLException e) {
            ERRLOGGER.error(e.getMessage());
        }
        DatosBase.getInstance().closeConnection();
        return list;
    }

    @Override
    public boolean create(RenglonPedido rp) {
        Connection conn = DatosBase.getInstance().getConnection();
        
        boolean result = DB_BasicQuerys.insertTuple(rp.getKeyNamesList(), rp.getAttributeValuesList(), "Renglon_Pedido", conn);
        DatosBase.getInstance().closeConnection();
        return result;
    }

    @Override
    public boolean update(RenglonPedido rp) {
        Connection conn = DatosBase.getInstance().getConnection();
        PreparedStatement ps;
        boolean exito = false;
        try{
            ps = conn.prepareStatement("UPDATE Renglon_Pedido SET RenP_Tipo = ?::TIPOCANTIDAD, RenP_CANTIDAD = ? WHERE RenP_CODIGO = ? AND RenP_Ped_CODIGO = ?");
            ps.setString(1, rp.getTipoCantidad().toString());
            ps.setInt(2, rp.getCantidad());
            ps.setInt(3, rp.getCodigo());
            ps.setInt(4, rp.getPedido().getCodigo());
            exito = ps.executeUpdate() != 0;
        } catch (SQLException e) {
            ERRLOGGER.error(e.getMessage());
        }
        return exito;
    }

    @Override
    public boolean delete(RenglonPedido rp) {
        Connection conn = DatosBase.getInstance().getConnection();
        
        boolean result = DB_BasicQuerys.deleteTuple(rp.getKeyNamesList(), rp.getKeyValuesList(), "Renglon_Pedido", conn);
        DatosBase.getInstance().closeConnection();
        return result;
    }

}
