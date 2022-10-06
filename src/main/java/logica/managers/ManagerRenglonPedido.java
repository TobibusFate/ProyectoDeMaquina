
package logica.managers;

import java.util.List;

import datos.dao.implementation.DAO_RenglonPedido;
import objects.Pedido;
import objects.RenglonPedido;


public class ManagerRenglonPedido {
    private static DAO_RenglonPedido dao_renglonPedido = new DAO_RenglonPedido();
    
    public static void CargarRenglon(Pedido p, RenglonPedido rp) {
        rp.setPedido(p);
        rp.setCodigo(ManagerRenglon.generarKey());
        ManagerRenglon.cargarRenglon(rp);
        dao_renglonPedido.create(rp);
    }
    
}
