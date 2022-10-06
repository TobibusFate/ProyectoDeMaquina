package logica.managers;

import datos.dao.implementation.DAO_Administrador;
import objects.Administrador;
import objects.Cuenta;
import objects.Trabajador;

public class ManagerAdministrador {
    private static DAO_Administrador dao_Administrador = new DAO_Administrador();

    public static Administrador getAdministrador(int DNI, String user) {
        Administrador admin = null;

        Trabajador trab = ManagerTrabajador.getTrabajador(DNI, user);

        admin = new Administrador(trab.getApellido(), trab.getNombre(), trab.getDni(), trab.getTelefono(), trab.getCuenta());

        return admin;
    }
}
