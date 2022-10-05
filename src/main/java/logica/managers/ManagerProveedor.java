package logica.managers;

import datos.dao.implementation.DAO_Proveedor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import objects.Proveedor;

public class ManagerProveedor {
    private static DAO_Proveedor dao_Proveedor = new DAO_Proveedor();
    
    public static Map<Long, Proveedor> getProveedoresMap() {
        Map<Long, Proveedor> m = new HashMap<>();
        
        for (Proveedor p: dao_Proveedor.read(null)) {
            m.put(p.getCuit(), p);
        }
        
        return m;
    }

    public static Proveedor getProveedor(Long cuit) {
        Proveedor prov = new Proveedor(cuit, "", "", "");

        return dao_Proveedor.read(prov).get(0);
    }
    
}
