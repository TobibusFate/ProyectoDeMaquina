package logica.managers;

import java.util.List;

import datos.dao.implementation.DAO_Pedido;
import datos.dao.implementation.DAO_Venta;
import objects.Pedido;
import objects.RenglonPedido;

public class ManagerPedido {
    private static DAO_Pedido dao_Pedido = new DAO_Pedido();

    public static void cargarPedido(Pedido p, List<RenglonPedido> lrp) {
        p.setCodigo(dao_Pedido.generateNextKey());
        dao_Pedido.create(p);
        for (RenglonPedido rp : lrp) {
            ManagerRenglonPedido.CargarRenglon(rp);   
        }
    }
    
}
