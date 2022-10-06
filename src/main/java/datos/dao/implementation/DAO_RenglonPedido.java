
package datos.dao.implementation;

import datos.DB_BasicQuerys;
import datos.DatosBase;
import datos.dao.IDAO;
import java.sql.Connection;
import java.util.List;
import objects.RenglonPedido;


public class DAO_RenglonPedido implements IDAO<RenglonPedido>{

    @Override
    public List<RenglonPedido> read(RenglonPedido rp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean create(RenglonPedido rp) {
        Connection conn = DatosBase.getInstance().getConnection();
        
        return DB_BasicQuerys.insertTuple(rp.getKeyNamesList(), rp.getAttributeValuesList(), "Renglon_Pedido", conn);
    }

    @Override
    public boolean update(RenglonPedido rp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(RenglonPedido rp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
