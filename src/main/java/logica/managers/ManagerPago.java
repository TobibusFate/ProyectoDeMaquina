package logica.managers;

import datos.dao.implementation.DAO_Pago;
import objects.Pago;
import objects.TipoDePago;
import objects.Venta;

import java.util.Collection;
import java.util.HashMap;

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

    public static HashMap<Integer, Pago> getPagosToVenta(Venta venta) {
        HashMap<Integer, Pago> pagoHashMap = new HashMap<>();
        for (Pago p: dao_pago.readPagoToVenta(venta)) {
            pagoHashMap.put(p.getCodigoP(),p); /** REVISAR CONSULTA */
        }
        return pagoHashMap;
    }
}
