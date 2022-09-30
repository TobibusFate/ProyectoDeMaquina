package datos.dao.implementation;

import datos.dao.DAO;
import objects.Venta;

import java.util.List;


public class IDAO_Venta implements DAO<Venta> {

    @Override
    public List<Venta> read(Venta venta) {
        if (venta != null) {
            venta.getCodigoVenta();
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
