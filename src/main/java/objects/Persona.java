package objects;

import java.util.List;

public abstract class Persona {
    private String apellido, nombre;
    private int dni, telefono;

    public Persona(String apellido, String nombre, int dni, int telefono) {
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

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    /// retorna una lista con los valores de los atributos de persona, para usar con la BD.
    public abstract List<String> getValueList();

    // TODO: crear listas similares a la de arriba para los nombres y valores de las keys.
    //public abstract List<String> getAttributeNamesList();
    //public abstract List<String> getKeyNamesList();
    //public abstract List<Integer> getKeyValuesList();
}
