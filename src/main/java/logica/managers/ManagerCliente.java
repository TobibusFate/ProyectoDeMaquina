package logica.managers;

import datos.dao.implementation.DAO_Cliente;
import datos.dao.implementation.DAO_Persona;
import objects.Cliente;
import objects.Cliente_Fisico;
import objects.Cliente_Juridico;
import objects.Persona;

import java.util.HashMap;

public class ManagerCliente {
    private static DAO_Cliente dao_cliente = new DAO_Cliente();

    public static HashMap<Integer, Cliente> getHashMapClientes() {
        HashMap<Integer, Cliente> clienteHashMap = new HashMap<>();

        Cliente_Juridico cliente_juridico = new Cliente_Juridico(-1);
        Cliente_Fisico cliente_fisico = new Cliente_Fisico(-1);


        clienteHashMap.putAll(generarMapa(cliente_fisico));
        clienteHashMap.putAll(generarMapa(cliente_juridico));

        return clienteHashMap;
    }

    public static HashMap<Integer, Cliente> generarMapa(Cliente cliente) {
        HashMap<Integer, Cliente> clienteHashMap = new HashMap<>();
        for (Cliente c: dao_cliente.read(cliente)) {
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
