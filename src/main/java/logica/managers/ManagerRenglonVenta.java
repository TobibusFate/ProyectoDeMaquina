package logica.managers;

import datos.dao.implementation.DAO_RenglonVenta;
import objects.Renglon;
import objects.RenglonVenta;
import objects.Venta;

import java.util.Collection;
import java.util.HashMap;

public class ManagerRenglonVenta {
    private static DAO_RenglonVenta dao_renglonVenta = new DAO_RenglonVenta();

    public static void cargarRenglon (Collection<RenglonVenta> crv, Venta v) {
        for (RenglonVenta rv: crv) {
            rv.setVenta(v);
            rv.setCodigo(ManagerRenglon.generarKey());
            ManagerRenglon.cargarRenglon(rv);
            dao_renglonVenta.create(rv);
            ManagerProducto.updateStock(rv.getProducto(),rv.getUnidades());
        }
    }

}
