package datos.dao.implementation;

import datos.DB_BasicQuerys;
import datos.DatosBase;
import datos.dao.IDAO;
import java.sql.Connection;
import java.util.List;
import objects.Proveedor;


public class DAO_Proveedor implements IDAO<Proveedor> {

    @Override
    public List<Proveedor> read(Proveedor p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean create(Proveedor p) {
        Connection conn = DatosBase.getInstance().getConnection();
        
        return DB_BasicQuerys.insertTuple(p.getKeyNamesList(), p.getAttributeValuesList(), "Proveedores", conn);
    }

    @Override
    public boolean update(Proveedor p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Proveedor p) {
        Connection conn = DatosBase.getInstance().getConnection();
        
        return DB_BasicQuerys.deleteTuple(p.getKeyNamesList(), p.getKeyValuesList(), "Proveedores", conn); 
    }
    
    
    
}
