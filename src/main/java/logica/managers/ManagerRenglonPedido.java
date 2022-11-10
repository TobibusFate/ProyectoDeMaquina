
package logica.managers;

import datos.dao.implementation.DAO_RenglonPedido;
import java.util.ArrayList;
import java.util.Map;
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
    
    public static List<RenglonPedido> getRenglonesPorPedidoVisibles(Pedido p) {
        List<RenglonPedido> renglones = dao_renglonPedido.read(new RenglonPedido(p.getCodigo(), null, null, 0, null, 0, 0));
        List<RenglonPedido> renglonesVisibles = new ArrayList<>();
        for (RenglonPedido rp:renglones) {
            if (rp.getProducto().isVisible()) {
                renglonesVisibles.add(rp);
            }
        }
        return renglonesVisibles;
    }
    
    public static List<RenglonPedido> getRenglonesPorPedido(Pedido p) {
        return dao_renglonPedido.read(new RenglonPedido(p.getCodigo(), null, null, 0, null, 0, 0));
    }
    
    public static boolean actualizarReglonPedido(Pedido p, List<RenglonPedido> listaNueva){
        List <RenglonPedido> renglonesNuevos = new ArrayList();
        List <RenglonPedido> renglonesEliminar = new ArrayList();
        List <RenglonPedido> renglonesActualizar = new ArrayList();
        List <RenglonPedido> listaVieja = getRenglonesPorPedido(p);
        for(RenglonPedido rp: listaVieja) {
            if(!listaNueva.contains(rp))
                renglonesEliminar.add(rp);
        }
        for(RenglonPedido rp: listaNueva){
            if(!listaVieja.contains(rp))
                renglonesNuevos.add(rp);
            else
                renglonesActualizar.add(rp);
        }
        for(RenglonPedido rp: renglonesEliminar)
            eliminarRenglonPedido(rp);
        for(RenglonPedido rp: renglonesNuevos)
            CargarRenglon(p, rp);
        for(RenglonPedido rp: renglonesActualizar) {
            dao_renglonPedido.update(rp);
            ManagerRenglon.actualizarReglon(rp);
        }
        return false;
    }
}
