package logica.managers;

import datos.dao.implementation.DAO_Producto;
import objects.Producto;

import java.util.HashMap;

public class ManagerProducto {
    private static DAO_Producto dao_producto = new DAO_Producto();
    public static HashMap<Integer, Producto> getHashMapProductos() {
        HashMap <Integer, Producto> map = new HashMap<>();

        for (Producto producto : dao_producto.read(null)) {
            map.put(producto.getCodigoP(),producto);
        }
        return map;
    }
    /** PARTE LOGICA ENCARGADA DE LOS PRODUCTOS */
}
