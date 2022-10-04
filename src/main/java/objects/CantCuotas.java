package objects;

public enum CantCuotas {
    TARJETA_DE_CREDITO("1"),
    TARJETA_DE_DEBITO("2"),
    EFECTIVO("6"),
    FIADO("12");

    private String  cuota;

    CantCuotas(String  cuota) {
        this.cuota = cuota;
    }

    public String  getCuota() {
        return cuota;
    }

    public void setCuota(String  cuota) {
        this.cuota = cuota;
    }
}
