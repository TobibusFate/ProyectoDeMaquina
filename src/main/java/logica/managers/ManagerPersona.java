package logica.managers;

import datos.dao.implementation.DAO_Persona;
import objects.Cliente_Fisico;
import objects.Cliente_Juridico;
import objects.Persona;
import objects.Trabajador;

public class ManagerPersona {

    private static DAO_Persona dao_Persona = new DAO_Persona();

    public static Persona getPersonaClienteFisico(int dni) {
        return dao_Persona.readtobias((Persona) new Cliente_Fisico(dni)).get(0);
    }
    public static Persona getPersonaClienteJuridico(int dni) {
        return dao_Persona.readtobias((Persona) new Cliente_Juridico(dni)).get(0);
    }
    public static Persona getPersonaTrabajador(int DNI) {
        
        return dao_Persona.read((Persona) new Trabajador("", "", DNI, 0, null)).get(0);
    }
    
}
