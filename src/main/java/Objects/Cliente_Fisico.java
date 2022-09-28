package Objects;

import java.util.ArrayList;
import java.util.List;

public class Cliente_Fisico extends Cliente{
    private int CUIL;
    
    public Cliente_Fisico(String apell, String name, int DNI, int tel, String IVA, boolean moroso, int CUIL) {
        super(apell, name, DNI, tel, IVA, moroso);
        setCUIL(CUIL);
    }

    public int getCUIL() {
        return CUIL;
    }
    public void setCUIL(int cUIL) {
        CUIL = cUIL;
    }

    @Override
    public List<String> getValueList() {
        List<String> list = new ArrayList<String>();

        list.add(Integer.toString(getDNI()));
        list.add(getApellido());
        list.add(getNombre());
        list.add(Integer.toString(getTelefono()));
        // ETC...

        return list;
    }
    
}