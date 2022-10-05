package objects;

import java.util.ArrayList;
import java.util.List;

public abstract class Persona {
    private String apellido, nombre;
    private int dni;
    private long telefono;

    public Persona(String apellido, String nombre, int dni, long telefono) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.dni = dni;
        this.telefono = telefono;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public List<String> getAttributeNamesList() {
        List<String> l = new ArrayList<>();
        l.add("Pers_DNI");
        l.add("Pers_Nombre");
        l.add("Pers_Apellido");
        l.add("Pers_Telefono");
        return l;
    }

    public List<String> getAttributeValuesList() {
        List<String> l = new ArrayList<>();
        l.add(Integer.toString(dni));
        l.add(nombre);
        l.add(apellido);
        l.add(Long.toString(telefono));
        return l;
    }

    public List<String> getKeyNamesList() {
        List<String> l = new ArrayList<>();
        l.add("Pers_DNI");
        return l;
    }

    public List<String> getKeyValuesList() {
        List<String> l = new ArrayList<>();
        l.add(Integer.toString(dni));
        return l;
    }
}
