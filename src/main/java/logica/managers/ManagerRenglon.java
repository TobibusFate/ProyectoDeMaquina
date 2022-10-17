package logica.managers;

import datos.dao.implementation.DAO_Renglon;
import objects.Renglon;
import objects.RenglonPedido;

public class ManagerRenglon {
    private static DAO_Renglon dao_renglon = new DAO_Renglon();

    public static Renglon cargarRenglon (Renglon renglon){
        dao_renglon.create(renglon);
        return renglon;
    }

    public static int generarKey (){
        return dao_renglon.generateNextKey();
    }
    
    public static Renglon getRenglonPedido(int codigo) {
        return dao_renglon.read((Renglon) new RenglonPedido(codigo, null, null, 0, null, 0F, 0F)).get(0);
    }
    
    public static boolean eliminarRenglon(Renglon renglon) {
        return dao_renglon.delete(renglon);
    }
    
    public static boolean actualizarReglon(Renglon renglon){
        return dao_renglon.update(renglon);
    }
}
