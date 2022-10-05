package logica.managers;

import datos.dao.implementation.DAO_Pago;
import objects.Pago;

import java.util.Collection;

public class ManagerPago {
    private static DAO_Pago dao_pago = new DAO_Pago();

    public static void cargarPagos(Collection<Pago> cp) {
        for (Pago p: cp) {
            dao_pago.create(p);
        }
    }
}
