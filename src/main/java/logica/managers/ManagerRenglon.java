package logica.managers;

import datos.dao.implementation.DAO_Renglon;
import objects.Producto;
import objects.Renglon;
import objects.RenglonPedido;
import objects.RenglonVenta;

import java.util.HashMap;

public class ManagerRenglon {
    private static DAO_Renglon dao_renglon = new DAO_Renglon();

    public static Renglon cargarRenglon (Renglon renglon){
        dao_renglon.create(renglon);
        return renglon;
    }


    public static int generarKey (){
        return dao_renglon.generateNextKey();
    }
    
    public static Renglon getRenglonPedido(int codigo) {
        return dao_renglon.read((Renglon) new RenglonPedido(codigo, null, null, 0, null, 0F, 0F)).get(0);
    }
    
    public static boolean eliminarRenglon(Renglon renglon) {
        return dao_renglon.delete(renglon);
    }
    public static boolean actualizarReglon(Renglon renglon){
        return dao_renglon.update(renglon);
    }
    
    public static Renglon getRenglonVenta(int codigo) {
        return dao_renglon.read((Renglon) new RenglonVenta(codigo)).get(0);
    }

    public static void updateProductos(Producto productoViejo, Producto productoNuevo) {
        for (Renglon r : dao_renglon.read(null)) {
            if (r.getProducto().getCodigoP() == productoViejo.getCodigoP()) {
                r.setProducto(productoNuevo);
                dao_renglon.update(r);
            }
        }
    }
}
