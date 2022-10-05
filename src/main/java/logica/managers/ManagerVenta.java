package logica.managers;

import datos.dao.implementation.DAO_Venta;
import objects.RenglonVenta;
import objects.Venta;
import java.util.Collection;
public class ManagerVenta {

    private static DAO_Venta dao_venta = new DAO_Venta();
    public static void cargarVenta(Venta v, Collection<RenglonVenta> crv) {
        v.setCodigoV(dao_venta.generateNextKey());
        dao_venta.create(v);
        ManagerRenglonVenta.cargarRenglon(crv,v);
    }
}
