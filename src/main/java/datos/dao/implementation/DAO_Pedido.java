
package datos.dao.implementation;

import datos.DB_BasicQuerys;
import datos.DatosBase;
import datos.dao.IDAO;
import java.sql.Connection;
import java.util.List;
import objects.Pedido;


public class DAO_Pedido implements IDAO<Pedido> {

    @Override
    public List<Pedido> read(Pedido p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean create(Pedido p) {
        Connection conn = DatosBase.getInstance().getConnection();
        
        return DB_BasicQuerys.insertTuple(p.getKeyNamesList(), p.getAttributeValuesList(), "Pedidos", conn);
    }

    @Override
    public boolean update(Pedido p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Pedido p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
