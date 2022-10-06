package objects;

import java.util.ArrayList;
import java.util.List;

public class Cliente_Juridico extends Cliente {
    private long cuit;

    public Cliente_Juridico(int dni) {
        super(dni);
    }

    public Cliente_Juridico(int dni, long cuit) {
        super(dni);
        this.cuit = cuit;
    }

    public Cliente_Juridico(int dni, String condicion_IVA, boolean moroso, float deuda, long cuit) {
        super(dni, condicion_IVA, moroso, deuda);
        this.cuit = cuit;
    }

    public Cliente_Juridico(String apellido, String nombre, int dni, long telefono, String condicion_IVA, boolean moroso, float deuda, long cuit) {
        super(apellido, nombre, dni, telefono, condicion_IVA, moroso, deuda);
        this.cuit = cuit;
    }

    public long getCuit() {
        return cuit;
    }
    public void setCuit(long cuit) {
        this.cuit = cuit;
    }

    @Override
    public List<String> getAttributeNamesList() {
        List<String> l = new ArrayList<>();
        l.add("CliF_DNI");
        l.add("CliF_CUIT");
        return l;
    }

    @Override
    public List<String> getAttributeValuesList() {
        List<String> l = new ArrayList<>();
        l.add(Integer.toString(getDni()));
        l.add(Long.toString(cuit));
        return l;
    }

    @Override
    public List<String> getKeyNamesList() {
        List<String> l = new ArrayList<>();
        l.add("CliF_DNI");
        l.add("CliF_CUIT");
        return l;
    }

    @Override
    public List<String> getKeyValuesList() {
        List<String> l = new ArrayList<>();
        l.add(Integer.toString(getDni()));
        l.add(Long.toString(cuit));
        return l;
    }


}
