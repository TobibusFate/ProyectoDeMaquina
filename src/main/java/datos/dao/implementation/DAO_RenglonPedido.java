
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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class DAO_RenglonPedido implements IDAO<RenglonPedido>{

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
            e.printStackTrace();
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(RenglonPedido rp) {
        Connection conn = DatosBase.getInstance().getConnection();
        
        boolean result = DB_BasicQuerys.deleteTuple(rp.getKeyNamesList(), rp.getKeyValuesList(), "Renglon_Pedido", conn);
        DatosBase.getInstance().closeConnection();
        return result;
    }

}
