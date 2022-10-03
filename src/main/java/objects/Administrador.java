package objects;

import java.util.ArrayList;
import java.util.List;

public class Administrador extends Trabajador {

    public Administrador(String apellido, String nombre, int dni, long telefono, Cuenta cuenta) {
        super(apellido, nombre, dni, telefono, cuenta);
    }
    
    public List<String> getAttributeNamesList() {
        List<String> l = new ArrayList<>();
        l.add("Admin_USUARIO");
        l.add("Admin_DNI");
        return l;
    }

    public List<String> getAttributeValuesList() {
        List<String> l = new ArrayList<>();
        l.add(getCuenta().getCuenta());
        l.add(Integer.toString(getDni()));
        return l;
    }

    public List<String> getKeyNamesList() {
        List<String> l = new ArrayList<>();
        l.add("Admin_USUARIO");
        l.add("Admin_DNI");
        return l;
    }

    public List<String> getKeyValuesList() {
        List<String> l = new ArrayList<>();
        l.add(getCuenta().getCuenta());
        l.add(Integer.toString(getDni()));
        return l;
    }


}
