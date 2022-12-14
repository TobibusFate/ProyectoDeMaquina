
package objects;

import java.util.ArrayList;
import java.util.List;


public class Proveedor {
    private String nombre, email, direccion;
    private long cuit;
    
    public Proveedor(long cuit, String nombre, String email, String direccion) {
        this.cuit = cuit;
        this.nombre = nombre;
        this.email = email;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    public long getCuit() {
        return cuit;
    }
    public void setCuit(long cuit) {
        this.cuit = cuit;
    }
    
    // la llave o primary key es el cuit del proveedor, nombre : Prov_CUIT
    public List<String> getKeyNamesList() {
        List<String> l = new ArrayList<>();
        l.add("Prov_CUIT");
        return l;
    }
    // valor del cuit
    public List<String> getKeyValuesList() {
        List<String> l = new ArrayList<>();
        l.add(Long.toString(cuit));
        return l;
    }
    
    public List<String> getAttributeNamesList() {
        List<String> l = new ArrayList<>();
        l.add("Prov_CUIT");
        l.add("Prov_NombreFirma");
        l.add("Prov_Email");
        l.add("Prov_Direccion");
        return l;
    }
    
    public List<String> getAttributeValuesList() {
        List<String> l = new ArrayList<>();
        l.add(Long.toString(cuit));
        l.add(nombre);
        l.add(email);
        l.add(direccion);
        return l;
    }
    
}
