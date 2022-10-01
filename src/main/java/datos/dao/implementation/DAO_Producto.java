package datos.dao.implementation;

import datos.dao.IDAO;
import objects.Producto;

import java.util.List;

public class DAO_Producto implements IDAO<Producto> {
    @Override
    public List<Producto> read(Producto producto) {
        if (producto != null) {
            /** query para retornar el producto */
        } else {
            /** query para retornar lista de productos */
        }
        return null;
    }

    @Override
    public boolean create(Producto producto) {
        return false;
    }

    @Override
    public boolean update(Producto producto) {
        return false;
    }

    @Override
    public boolean delete(Producto producto) {
        return false;
    }
}
