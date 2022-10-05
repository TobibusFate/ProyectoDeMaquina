package logica.managers;

import datos.dao.implementation.DAO_Renglon;
import objects.Renglon;

public class ManagerRenglon {
    private static DAO_Renglon dao_renglon = new DAO_Renglon();

    public static Renglon cargarRenglon (Renglon renglon){
        dao_renglon.create(renglon);
        return renglon;
    }

    public static int generarKey (){
        return dao_renglon.generateNextKey();
    }
}
