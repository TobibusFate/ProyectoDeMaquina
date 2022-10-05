package objects;

import java.util.ArrayList;
import java.util.List;

public abstract class Cliente extends Persona {
    private String condicion_IVA;
    private boolean moroso;

    public Cliente(int dni) {
        super(dni);
    }

    public Cliente(String apell, String name, int dni, long tel, String condicion_IVA, boolean moroso) {
        super(apell, name, dni, tel);
        this.condicion_IVA = condicion_IVA;
        this.moroso = moroso;
    }


    public String getCondicion_IVA() {
        return condicion_IVA;
    }

    public void setCondicion_IVA(String condicion_IVA) {
        this.condicion_IVA = condicion_IVA;
    }
    public boolean isMoroso() {
        return moroso;
    }

    public void setMoroso(boolean moroso) {
        this.moroso = moroso;
    }
    
    @Override
    public List<String> getAttributeNamesList() {
        List<String> l = new ArrayList<>();
        l.add("Cli_DNI");
        l.add("Cli_IVA");
        l.add("Cli_MOROSO");
        return l;
    }

    @Override
    public List<String> getAttributeValuesList() {
        List<String> l = new ArrayList<>();
        l.add(Integer.toString(getDni()));
        l.add(condicion_IVA);
        l.add(String.valueOf(moroso));
        return l;
    }

    @Override
    public List<String> getKeyNamesList() {
        List<String> l = new ArrayList<>();
        l.add("Cli_DNI");
        return l;
    }

    @Override
    public List<String> getKeyValuesList() {
        List<String> l = new ArrayList<>();
        l.add(Integer.toString(getDni()));
        return l;
    }

}
