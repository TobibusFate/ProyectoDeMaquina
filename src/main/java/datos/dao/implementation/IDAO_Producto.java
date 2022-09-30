package datos.dao.implementation;

import datos.dao.DAO;
import objects.Producto;

import java.util.List;

public class IDAO_Producto implements DAO<Producto> {
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
