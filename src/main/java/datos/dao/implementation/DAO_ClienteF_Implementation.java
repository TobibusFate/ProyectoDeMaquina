package datos.dao.implementation;

import objects.Cliente_Fisico;
import datos.dao.DAO;

import java.util.List;

public class DAO_ClienteF_Implementation implements DAO<Cliente_Fisico> {

    /** IMPLEMENTACION DE LOS METODOS DEL DAO CORRESPONDIENTE */

    @Override
    public List<Cliente_Fisico> readAll() {
        return null;
    }

    @Override
    public Cliente_Fisico readOne() {
        return null;
    }

    @Override
    public boolean create(Cliente_Fisico cliente_fisico) {
        return false;
    }

    @Override
    public boolean update(Cliente_Fisico cliente_fisico) {
        return false;
    }

    @Override
    public boolean delete(Cliente_Fisico cliente_fisico) {
        return false;
    }
}
