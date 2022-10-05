
package logica.managers;

import java.util.List;

import datos.dao.implementation.DAO_RenglonPedido;
import objects.RenglonPedido;


public class ManagerRenglonPedido {
    private static DAO_RenglonPedido dao_renglonPedido = new DAO_RenglonPedido();
    
    public static void CargarRenglon(RenglonPedido rp) {
        dao_renglonPedido.create(rp);
    }
    
}
