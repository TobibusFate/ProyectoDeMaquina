package datos.dao.implementation;

import datos.dao.IDAO;
import objects.Pago;

import java.util.List;

public class DAO_Pago implements IDAO<Pago> {
    @Override
    public List<Pago> read(Pago pago) {
        return null;
    }

    @Override
    public boolean create(Pago pago) {
        return false;
    }

    @Override
    public boolean update(Pago pago) {
        return false;
    }

    @Override
    public boolean delete(Pago pago) {
        return false;
    }
}
