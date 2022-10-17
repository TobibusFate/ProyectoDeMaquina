package logica.managers;

import datos.dao.implementation.DAO_Cliente;
import objects.Cliente;
import objects.Cliente_Fisico;
import objects.Cliente_Juridico;

import java.util.HashMap;

public class ManagerCliente {
    private static DAO_Cliente dao_cliente = new DAO_Cliente();

    public static HashMap<Integer, Cliente> getHashMapClientes() {
        HashMap<Integer, Cliente> clienteHashMap = new HashMap<>();
        for (Cliente_Fisico cf: ManagerClienteFisico.getClientesFisicos()) {
            Cliente cliente = dao_cliente.read(cf).get(0);
            cf.setDeuda(cliente.getDeuda());
            cf.setCondicion_IVA(cliente.getCondicion_IVA());
            cf.setMoroso(cliente.getMoroso());
            clienteHashMap.put(cf.getDni(),cf);
        }
        for (Cliente_Juridico cj: ManagerClienteJuridico.getClientesJuridico()) {
            Cliente cliente = dao_cliente.read(cj).get(0);
            cj.setDeuda(cliente.getDeuda());
            cj.setCondicion_IVA(cliente.getCondicion_IVA());
            cj.setMoroso(cliente.getMoroso());
            clienteHashMap.put(cj.getDni(),cj);
        }
        return clienteHashMap;
    }

    public static void agregarDeuda(Cliente cliente, Float monto) {
        cliente.setDeuda(cliente.getDeuda()+monto);
        dao_cliente.update(cliente);
    }

    public static Cliente getCliente(int dni) {
        Cliente c = null;
        if (dni != 0) {
            c = ManagerClienteFisico.getClienteFisico(dni);
            if (c == null) {
                c = ManagerClienteJuridico.getCLienteJurudico(dni);
            }
            //c = dao_cliente.read(c).get(0);
        } else {
            c = dao_cliente.read(new Cliente_Fisico(0)).get(0);
        }
        return c;
    }
}
