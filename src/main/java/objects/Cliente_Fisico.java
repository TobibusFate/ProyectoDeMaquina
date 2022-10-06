package objects;

import java.util.ArrayList;
import java.util.List;

public class Cliente_Fisico extends Cliente{
    private long cuil;

    public Cliente_Fisico(int dni) {
        super(dni);

    }

    public Cliente_Fisico(int dni, long cuil) {
        super(dni);
        this.cuil = cuil;
    }

    public Cliente_Fisico(int dni, String condicion_IVA, boolean moroso, float deuda, long cuil) {
        super(dni, condicion_IVA, moroso, deuda);
        this.cuil = cuil;
    }

    public Cliente_Fisico(String apellido, String nombre, int dni, long telefono, String condicion_IVA, boolean moroso, float deuda, long cuil) {
        super(apellido, nombre, dni, telefono, condicion_IVA, moroso, deuda);
        this.cuil = cuil;
    }

    public long getCuil() {
        return cuil;
    }

    public void setCuil(long cuil) {
        this.cuil = cuil;
    }

    @Override
    public List<String> getAttributeNamesList() {
        List<String> l = new ArrayList<>();
        l.add("CliF_DNI");
        l.add("CliF_CUIL");
        return l;
    }

    @Override
    public List<String> getAttributeValuesList() {
        List<String> l = new ArrayList<>();
        l.add(Integer.toString(getDni()));
        l.add(Long.toString(cuil));
        return l;
    }

    @Override
    public List<String> getKeyNamesList() {
        List<String> l = new ArrayList<>();
        l.add("CliF_DNI");
        l.add("CliF_CUIL");
        return l;
    }

    @Override
    public List<String> getKeyValuesList() {
        List<String> l = new ArrayList<>();
        l.add(Integer.toString(getDni()));
        l.add(Long.toString(cuil));
        return l;
    }
    
}