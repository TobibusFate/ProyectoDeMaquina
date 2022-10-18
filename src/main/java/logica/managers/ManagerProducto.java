package logica.managers;

import datos.dao.implementation.DAO_Producto;
import objects.Producto;

import java.util.HashMap;

public class ManagerProducto {
    private static DAO_Producto dao_producto = new DAO_Producto();
    public static HashMap<String, Producto> getHashMapProductos() {
        HashMap <String, Producto> map = new HashMap<>();
        for (Producto producto : dao_producto.read(null)) {
            map.put(producto.getNombreP().toUpperCase(),producto);
        }
        return map;
    }
    public static void updateStock(Producto producto, int unidades) {
        producto.setStockP(producto.getStockP() - unidades);
        dao_producto.update(producto);
    }
    
    public static Producto getProducto(int codigo) {
        return dao_producto.read(new Producto(codigo)).get(0);
    }

    public static boolean cargarProducto(String codigo, String nombre, String categoria, String precio, String stock, String stockMinimo) {
        try {
            Producto prod = new Producto(
                Integer.parseInt(codigo),
                nombre.toUpperCase().trim(),
                categoria.toUpperCase().trim(),
                Float.parseFloat(precio),
                Integer.parseInt(stock),
                Integer.parseInt(stockMinimo)
            );
            return dao_producto.create(prod);
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
            return false;
        }
        
        
    }
    
    public static boolean cargarProducto(Producto prod) {
        return dao_producto.create(prod);
    }

    public static void updateProducto(Producto p) {
        dao_producto.update(p);
    }

    /*public static void updateProducto(int codigoP, Producto p) {
        dao_producto.update(p);
    }*/
    /** PARTE LOGICA ENCARGADA DE LOS PRODUCTOS */
}
