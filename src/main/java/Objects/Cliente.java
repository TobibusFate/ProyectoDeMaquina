package Objects;

public abstract class Cliente extends Persona {
    private String condicion_IVA;
    private boolean moroso;
    
    
    public Cliente(String apell, String name, int DNI, int tel, String IVA, boolean moroso) {
        super(apell, name, DNI, tel);
        setCondicion_IVA(IVA);
        setMoroso(moroso);
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
