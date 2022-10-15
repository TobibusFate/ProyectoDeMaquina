package logica.managers;

import datos.dao.implementation.DAO_RenglonVenta;
import objects.RenglonVenta;
import objects.Venta;

import java.util.ArrayList;
import java.util.Collection;

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

    public static ArrayList<RenglonVenta> getRenglonesToVenta(Venta venta) {
        ArrayList<RenglonVenta> listaRenglonVenta = new ArrayList<>();
        for (RenglonVenta rv: dao_renglonVenta.readRenglonVentaToVenta(venta)) {
            rv.setVenta(venta);
            RenglonVenta local = (RenglonVenta) ManagerRenglon.getRenglonVenta(rv.getCodigo());
            rv.setProducto(local.getProducto());
            rv.setDescuento(local.getDescuento());
            rv.setMontoTotal(local.getMontoTotal());
            listaRenglonVenta.add(rv);
        }
        return listaRenglonVenta;
    }
}
