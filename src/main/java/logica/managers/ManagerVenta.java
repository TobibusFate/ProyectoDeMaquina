package logica.managers;

import datos.dao.implementation.DAO_Venta;
import objects.Pago;
import objects.RenglonVenta;
import objects.Venta;

import java.util.Collection;
import java.util.HashMap;

public class ManagerVenta {

    private static DAO_Venta dao_venta = new DAO_Venta();
    public static void cargarVenta(Venta v, Collection<RenglonVenta> crv, Collection<Pago> cp) {
        v.setCodigoV(dao_venta.generateNextKey());
        dao_venta.create(v);
        ManagerPago.cargarPagos(cp,v);
        ManagerRenglonVenta.cargarRenglon(crv,v);
    }

    public static HashMap<String, Venta> getAllVentas() {
        HashMap<String, Venta> ventaHashMap = new HashMap<>();
        for (Venta v: dao_venta.read(null)) {
            ventaHashMap.put(String.valueOf(v.getCodigoV()),v);
        }
        return ventaHashMap;
    }
}
