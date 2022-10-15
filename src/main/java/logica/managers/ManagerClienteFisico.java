package logica.managers;

import datos.dao.implementation.DAO_ClienteFisico;
import objects.Cliente_Fisico;

import java.util.ArrayList;
import java.util.List;

public class ManagerClienteFisico {
    private static DAO_ClienteFisico dao_clienteFisico = new DAO_ClienteFisico();

    public static List<Cliente_Fisico> getClientesFisicos () {
        List<Cliente_Fisico> list = new ArrayList<>();
        for (Cliente_Fisico cf: dao_clienteFisico.read(null)) {
            list.add(cf);
        }
        return list;
    }

    public static Cliente_Fisico getClienteFisico(int dni) {
        List<Cliente_Fisico> list = dao_clienteFisico.read(new Cliente_Fisico(dni));
        if (list.isEmpty()){
            return null;
        }
        else {
            return list.get(0);
        }
    }
}