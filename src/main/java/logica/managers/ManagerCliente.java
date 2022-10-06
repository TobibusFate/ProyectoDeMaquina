package logica.managers;

import datos.dao.implementation.DAO_Cliente;
import datos.dao.implementation.DAO_Persona;
import objects.Cliente;
import objects.Cliente_Fisico;
import objects.Cliente_Juridico;
import objects.Persona;

import java.util.HashMap;
import java.util.List;

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


    public static HashMap<Integer, Cliente> generarMapa(Cliente cliente) {
        HashMap<Integer, Cliente> clienteHashMap = new HashMap<>();
        List<Cliente> list = dao_cliente.read(cliente);
        System.out.println("a");
        for (Cliente c: list) {
            Persona p;
            if (cliente instanceof Cliente_Juridico) {
                p = ManagerPersona.getPersonaClienteJuridico(c.getDni());
            } else {
                p = ManagerPersona.getPersonaClienteFisico(c.getDni());
            }
            c.setApellido(p.getApellido());
            c.setNombre(p.getNombre());
            c.setTelefono(p.getTelefono());
            clienteHashMap.put(c.getDni(),c);
        }
        return clienteHashMap;
    }
}
