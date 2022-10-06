package logica.managers;

import java.util.List;

import datos.dao.implementation.DAO_Pedido;
import java.util.Collection;
import objects.Pedido;
import objects.RenglonPedido;

public class ManagerPedido {
    private static DAO_Pedido dao_Pedido = new DAO_Pedido();

    public static void cargarPedido(Pedido p, Collection<RenglonPedido> lrp) {
        dao_Pedido.create(p);
        for (RenglonPedido rp : lrp) {
            ManagerRenglonPedido.CargarRenglon(p, rp);   
        }
    }
    
    public static int generarKey() {
        return dao_Pedido.generateNextKey();
    }
    
}
