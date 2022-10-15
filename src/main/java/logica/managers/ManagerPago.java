package logica.managers;

import datos.dao.implementation.DAO_Pago;
import objects.Pago;
import objects.TipoDePago;
import objects.Venta;

import java.util.ArrayList;
import java.util.Collection;

public class ManagerPago {
    private static DAO_Pago dao_pago = new DAO_Pago();
    public static void cargarPagos(Collection<Pago> cp, Venta v) {
        for (Pago p: cp) {
            p.setVenta(v);
            p.setCodigoP(dao_pago.generateNextKey());
            dao_pago.create(p);
            if (p.getMetodoPago().equals(TipoDePago.FIADO.getTipo())){
                ManagerCliente.agregarDeuda(p.getCliente(),p.getMontoP());
            }
        }
    }

    public static ArrayList<Pago> getPagosToVenta(Venta venta) {
        ArrayList<Pago> listaPagos= new ArrayList<>();
        listaPagos.addAll(dao_pago.readPagoToVenta(venta));
        return listaPagos;
    }
}
