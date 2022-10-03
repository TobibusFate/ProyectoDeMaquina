package objects;

import java.util.ArrayList;
import java.util.List;

public class Cliente_Juridico extends Cliente {
    private long cuit;

    public Cliente_Juridico(String apell, String name, int dni, long tel, String condicion_IVA, boolean moroso, long cuit) {
        super(apell, name, dni, tel, condicion_IVA, moroso);
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
