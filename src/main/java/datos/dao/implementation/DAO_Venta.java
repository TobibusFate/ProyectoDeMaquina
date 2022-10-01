package datos.dao.implementation;

import datos.dao.IDAO;
import objects.Venta;

import java.util.List;


public class DAO_Venta implements IDAO<Venta> {

    @Override
    public List<Venta> read(Venta venta) {
        if (venta != null) {
            /** query para recuperar venta*/
        } else {
            /** query para retornar lista de ventas*/
        }
        return null;
    }

    @Override
    public boolean create(Venta venta) {
        /** query para crear venta*/
        return false;
    }

    @Override
    public boolean update(Venta venta) {
        /** query para actualizar venta*/
        return false;
    }

    @Override
    public boolean delete(Venta venta) {
        /** query para eliminar venta*/
        return false;
    }
}
