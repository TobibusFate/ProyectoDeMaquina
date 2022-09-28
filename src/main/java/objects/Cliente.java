package objects;

public abstract class Cliente extends Persona {
    private String condicion_IVA;
    private boolean moroso;

    public Cliente(String apell, String name, int dni, int tel, String condicion_IVA, boolean moroso) {
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
    
}
