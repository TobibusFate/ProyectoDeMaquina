package logica.managers;

import datos.dao.implementation.DAO_RenglonVenta;
import objects.RenglonVenta;

import java.util.Collection;
import java.util.HashMap;

public class ManagerRenglonVenta {
    private static DAO_RenglonVenta dao_renglonVenta = new DAO_RenglonVenta();


    public static void cargarRenglon (Collection<RenglonVenta> crv) {
        for (RenglonVenta rv: crv) {
            dao_renglonVenta.create(rv);
            ManagerProducto.updateStock(rv.getProducto(),rv.getUnidades());


        }
    }

}
