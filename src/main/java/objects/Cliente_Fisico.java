package objects;

import java.util.ArrayList;
import java.util.List;

public class Cliente_Fisico extends Cliente{
    private int cuil;

    public Cliente_Fisico(String apell, String name, int dni, int tel, String iva, boolean moroso, int cuil) {
        super(apell, name, dni, tel, iva, moroso);
        this.cuil = cuil;
    }

    public int getCuil() {
        return cuil;
    }

    public void setCuil(int cuil) {
        this.cuil = cuil;
    }

    @Override
    public List<String> getValueList() {
        List<String> list = new ArrayList<String>();

        list.add(Integer.toString(getDni()));
        list.add(getApellido());
        list.add(getNombre());
        list.add(Integer.toString(getTelefono()));
        // ETC...

        return list;
    }
    
}