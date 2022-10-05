package logica.managers;

import datos.dao.implementation.DAO_Pago;
import objects.Pago;
import objects.Venta;

import java.util.Collection;

public class ManagerPago {
    private static DAO_Pago dao_pago = new DAO_Pago();

    public static void cargarPagos(Collection<Pago> cp, Venta v) {
        for (Pago p: cp) {
            p.setVenta(v);
            p.setCodigoP(dao_pago.generateNextKey());
            dao_pago.create(p);
        }
    }
}
