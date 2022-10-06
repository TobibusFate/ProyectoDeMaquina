package logica.managers;

import datos.dao.implementation.DAO_Trabajador;
import objects.Cuenta;
import objects.Persona;
import objects.Trabajador;

public class ManagerTrabajador {

    private static DAO_Trabajador dao_trabajador = new DAO_Trabajador();

    public static Trabajador getTrabajador(int DNI, String user) {
        Trabajador trab;
        if(DNI != -1){ 
            trab = dao_trabajador.read(new Trabajador("", "", DNI, 0, null)).get(0);
        }
        else {
            Cuenta cuen = new Cuenta(user,"");
            trab = dao_trabajador.read(new Trabajador("","",DNI,0,cuen)).get(0);
        }
        Cuenta cuenta = ManagerCuenta.getCuenta(user);

        trab.setCuenta(cuenta);
        return trab;
    }
    
}
