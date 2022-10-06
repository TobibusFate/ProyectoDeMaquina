package logica.managers;

import datos.dao.implementation.DAO_Persona;
import objects.Cliente;
import objects.Persona;
import objects.Trabajador;

public class ManagerPersona {

    private static DAO_Persona dao_Persona = new DAO_Persona();


    public static Persona getPersonaTrabajador(int DNI) {
        
        return dao_Persona.read((Persona) new Trabajador("", "", DNI, 0, null)).get(0);
    }
    
}
