package logica.managers;

import java.util.ArrayList;

import datos.dao.implementation.DAO_Pedido;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
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
    
    public static boolean eliminarPedido(Pedido p, Collection<RenglonPedido> lrp) {
        int i = 0;
        for (RenglonPedido rp: lrp) {
            if (!ManagerRenglonPedido.eliminarRenglonPedido(rp)) i += 1;
        }
        if (!dao_Pedido.delete(p)) i += 1;
        return i == 0;
    }
    
    public static int generarKey() {
        return dao_Pedido.generateNextKey();
    }
    
    public static Map<Integer,Pedido> getMapPedidos() {
        Map<Integer,Pedido> map = new HashMap<>();
        for (Pedido p: dao_Pedido.read(null) ) {
            map.put(p.getCodigo(), p);
        }
        return map;
    }
    
    public static Pedido getPedido(Pedido p) {
        return dao_Pedido.read(p).get(0);
    }
    
    public static void modificarPedido(Pedido p, ArrayList<RenglonPedido> lrp){
        dao_Pedido.update(p);
        ManagerRenglonPedido.actualizarReglonPedido(p,lrp);
    }
}
