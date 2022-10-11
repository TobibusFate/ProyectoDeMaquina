package datos.dao.implementation;

import datos.DB_BasicQuerys;
import datos.DatosBase;
import datos.dao.IDAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import objects.Producto;
import objects.Proveedor;


public class DAO_Proveedor implements IDAO<Proveedor> {

    @Override
    public List<Proveedor> read(Proveedor p) {
        Connection conn = DatosBase.getInstance().getConnection();
        List<Proveedor> list = new ArrayList<>();
        ResultSet rs = null;
        try {
            if (p != null) rs = DB_BasicQuerys.findTuple(p.getKeyNamesList(), p.getKeyValuesList(), "Proveedores", conn);
            else rs = DB_BasicQuerys.findTuple(null, null, "Proveedores", conn);
            while (rs.next()) {
                list.add(new Proveedor(
                    rs.getLong("Prov_CUIT"),
                    rs.getString("Prov_NombreFirma"),
                    rs.getString("Prov_Email"),
                    rs.getString("Prov_Direccion")
                    )
                );   
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DatosBase.getInstance().closeConnection();
        return list;
    }

    @Override
    public boolean create(Proveedor p) {
        Connection conn = DatosBase.getInstance().getConnection();
        
        boolean result = DB_BasicQuerys.insertTuple(p.getKeyNamesList(), p.getAttributeValuesList(), "Proveedores", conn);
        DatosBase.getInstance().closeConnection();
        return result;
    }

    @Override
    public boolean update(Proveedor p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Proveedor p) {
        Connection conn = DatosBase.getInstance().getConnection();
        
        boolean result = DB_BasicQuerys.deleteTuple(p.getKeyNamesList(), p.getKeyValuesList(), "Proveedores", conn); 
        DatosBase.getInstance().closeConnection();
        return result;
    }
    
    
    
}
