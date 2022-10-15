
package logica.managers;

import datos.dao.implementation.DAO_RenglonPedido;
import objects.Pedido;
import objects.RenglonPedido;

import java.util.List;


public class ManagerRenglonPedido {
    private static DAO_RenglonPedido dao_renglonPedido = new DAO_RenglonPedido();
    
    public static void CargarRenglon(Pedido p, RenglonPedido rp) {
        rp.setPedido(p);
        rp.setCodigo(ManagerRenglon.generarKey());
        ManagerRenglon.cargarRenglon(rp);
        dao_renglonPedido.create(rp);
    }
    
    public static boolean eliminarRenglonPedido(RenglonPedido rp) {
        int i = 0;
        if (!dao_renglonPedido.delete(rp)) i += 1;
        if (!ManagerRenglon.eliminarRenglon(rp)) i += 1;
        return i == 0;
    }
    
    public static List<RenglonPedido> getReglonesPorPedido(Pedido p) {
        
        return dao_renglonPedido.read(new RenglonPedido(p.getCodigo(), null, null, 0, null, 0, 0));
    }
    
}
