package Objects;

import java.util.List;

import javax.swing.AbstractAction;

public abstract class Persona {
    private String Apellido, Nombre;
    private int DNI, Telefono;
    

    public Persona(String apell, String name, int DNI, int tel) {
        setApellido(apell);
        setNombre(name);
        setDNI(DNI);
        setTelefono(tel);
    }

    public String getApellido() {
        return Apellido;
    }
    public void setApellido(String apellido) {
        Apellido = apellido;
    }
    public String getNombre() {
        return Nombre;
    }
    public void setNombre(String nombre) {
        Nombre = nombre;
    }
    
    public int getDNI() {
        return DNI;
    }
    public void setDNI(int dNI) {
        DNI = dNI;
    }
    public int getTelefono() {
        return Telefono;
    }
    public void setTelefono(int telefono) {
        Telefono = telefono;
    }

    /// retorna una lista con los valores de los atributos de persona, para usar con la BD.
    public abstract List<String> getValueList();

    // TODO: crear listas similares a la de arriba para los nombres y valores de las keys.
    //public abstract List<String> getAttributeNamesList();
    //public abstract List<String> getKeyNamesList();
    //public abstract List<Integer> getKeyValuesList();
}
