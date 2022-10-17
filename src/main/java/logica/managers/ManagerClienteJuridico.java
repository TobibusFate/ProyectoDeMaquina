package logica.managers;


import datos.dao.implementation.DAO_ClienteJuridico;
import objects.Cliente_Juridico;

import java.util.ArrayList;
import java.util.List;

public class ManagerClienteJuridico {
    private static DAO_ClienteJuridico dao_clienteJuridico = new DAO_ClienteJuridico();

    public static List<Cliente_Juridico> getClientesJuridico () {
        List<Cliente_Juridico> list = new ArrayList<>();
        for (Cliente_Juridico cf: dao_clienteJuridico.read(null)) {
            list.add(cf);
        }
        return list;
    }

    public static Cliente_Juridico getCLienteJurudico(int dni) {
        List<Cliente_Juridico> list = dao_clienteJuridico.read(new Cliente_Juridico(dni));
        if (list.isEmpty()){
            return null;
        }
        else {
            return list.get(0);
        }
    }

}