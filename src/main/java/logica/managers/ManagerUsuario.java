package logica.managers;

import datos.dao.implementation.DAO_Usuario;
import objects.Usuario;

public class ManagerUsuario {

    public static int logear (Usuario user) {
        DAO_Usuario dao_usuario = new DAO_Usuario();

        Usuario localUser = dao_usuario.read(user).get(0);

        if (localUser == null) {
            return 0;
        }

        if (user.getUser().equals(localUser.getUser()) && user.getPass().equals(localUser.getPass())) {
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
