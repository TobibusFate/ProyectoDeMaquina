package logica.managers;

import datos.dao.implementation.DAO_Cuenta;
import objects.Cuenta;

public class ManagerCuenta {
    private static DAO_Cuenta dao_cuenta = new DAO_Cuenta();
    public static int logear (Cuenta c) {
        Cuenta localUser = dao_cuenta.read(c).get(0);
        if (localUser == null) {
            return 0;
        }
        if (c.getCuenta().equals(localUser.getCuenta()) && c.getPass().equals(localUser.getPass())) {
            if (localUser.getTipo() == 1) {
                return 1;
            } else {
                return 2;
            }
        } else  {
            return -1;
        }
    }
}
