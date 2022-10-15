package datos.dao.implementation;

import datos.DB_BasicQuerys;
import datos.DatosBase;
import datos.dao.IDAO;
import logica.managers.ManagerProducto;
import objects.Producto;
import objects.Renglon;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class DAO_Renglon implements IDAO<Renglon> {
    
    @Override
    public List<Renglon> read(Renglon renglon) {
        Connection conn = DatosBase.getInstance().getConnection();
        List<Renglon> list = new ArrayList<>();
        ResultSet rs = null;
        try {
            List<String> tempList1 = new ArrayList<>() {{add("Ren_CODIGO");}};
            List<String> tempList2 = new ArrayList<>();
            tempList2.add(String.valueOf(renglon.getCodigo()));
            if (renglon != null) rs = DB_BasicQuerys.findTuple(tempList1, tempList2, "Renglon", conn);
            else rs = DB_BasicQuerys.findTuple(null, null, "Renglon", conn);
            
            while (rs.next()) {
                Producto prod = ManagerProducto.getProducto(rs.getInt("Ren_Prod_CODIGO"));
                renglon.setCodigo(rs.getInt("Ren_CODIGO"));
                renglon.setProducto(prod);
                renglon.setDescuento(rs.getFloat("Ren_DESCUENTO"));
                renglon.setMontoTotal(rs.getFloat("Ren_MONTOTOTAL"));
                list.add(renglon);
            }
            
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DatosBase.getInstance().closeConnection();
        return list;
    }

    @Override
    public boolean create(Renglon renglon) {
        Connection conn = DatosBase.getInstance().getConnection();
        Statement statement;
        boolean exito = false;
        LocalDateTime lt = LocalDateTime.now();

        try {
            statement = conn.createStatement();
            exito = statement.execute(
                    "INSERT INTO Renglon (Ren_CODIGO, Ren_Prod_CODIGO, Ren_MONTOTOTAL, Ren_DESCUENTO) VALUES ('"
                            +renglon.getCodigo()+"', '"
                            +renglon.getProducto().getCodigoP()+"', '"
                            +renglon.getMontoTotal()+"', '"
                            + renglon.getDescuento()
                            +"' )");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        DatosBase.getInstance().closeConnection();
        return exito;
    }

    @Override
    public boolean update(Renglon renglon) {
        return false;
    }

    @Override
    public boolean delete(Renglon renglon) {
        Connection conn = DatosBase.getInstance().getConnection();
        
        List<String> names = new ArrayList<>() {{add("Ren_CODIGO");}};
        List<String> values = new ArrayList<>();
        values.add(String.valueOf(renglon.getCodigo()));
        
        boolean result = DB_BasicQuerys.deleteTuple(names, values, "Renglon", conn);
        DatosBase.getInstance().closeConnection();
        return result;
    }

    public int generateNextKey() {
        int value = 0;
        Connection conn = DatosBase.getInstance().getConnection();
        Statement statement;
        ResultSet rs;
        try {
            statement = conn.createStatement();
            rs = statement.executeQuery("SELECT COALESCE (MAX (Ren_CODIGO),0) FROM Renglon");
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
