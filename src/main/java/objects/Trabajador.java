package objects;

import java.util.ArrayList;
import java.util.List;

public class Trabajador extends Persona {

    Cuenta cuenta;
    
    public Trabajador(String apellido, String nombre, int dni, long telefono, Cuenta cuenta) {
        super(apellido, nombre, dni, telefono);
        this.cuenta = cuenta;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public List<String> getAttributeNamesList() {
        List<String> l = new ArrayList<>();
        l.add("Trab_USUARIO");
        l.add("Trab_DNI");
        return l;
    }

    public List<String> getAttributeValuesList() {
        List<String> l = new ArrayList<>();
        l.add(cuenta.getCuenta());
        l.add(Integer.toString(getDni()));
        return l;
    }

    public List<String> getKeyNamesList() {
        List<String> l = new ArrayList<>();
        l.add("Trab_USUARIO");
        l.add("Trab_DNI");
        return l;
    }

    public List<String> getKeyValuesList() {
        List<String> l = new ArrayList<>();
        l.add(cuenta.getCuenta());
        l.add(Integer.toString(getDni()));
        return l;
    }

    
    
}
