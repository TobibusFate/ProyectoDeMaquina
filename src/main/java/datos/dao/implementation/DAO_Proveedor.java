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
import objects.Proveedor;


public class DAO_Proveedor implements IDAO<Proveedor> {

    @Override
    public List<Proveedor> read(Proveedor p) {
        Connection conn = DatosBase.getInstance().getConnection();
        Statement statement;
        List<Proveedor> list = new ArrayList<>();
        ResultSet rs;
        try {
            statement = conn.createStatement();
            // query para retornar el proveedor
            if (p != null) {
                rs = statement.executeQuery("SELECT * FROM Proveedores WHERE (Prov_CUIT = '" +p.getCuit()+"')");
                list.add(new Proveedor(
                        rs.getLong("Prov_CUIT"),
                        rs.getString("Prov_NombreFirma"),
                        rs.getString("Prov_Email"),
                        rs.getString("Prov_Direccion")
                    ));
            // query para retornar lista de productos
            } else {
                rs = statement.executeQuery("SELECT * FROM Proveedores ORDER BY Prov_CUIT");
                while (rs.next()){
                    list.add(new Proveedor(
                        rs.getLong("Prov_CUIT"),
                        rs.getString("Prov_NombreFirma"),
                        rs.getString("Prov_Email"),
                        rs.getString("Prov_Direccion")
                    ));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        DatosBase.getInstance().closeConnection();
        return list;
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
