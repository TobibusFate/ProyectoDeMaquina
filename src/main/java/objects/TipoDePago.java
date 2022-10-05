package objects;

public enum TipoDePago {
    TARJETA_CREDITO("Tarjeta de Credito"),
    TARJETA_DEBITO("Tarjeta de Debito"),
    EFECTIVO("Efectivo"),
    FIADO("Fiado");

    private final String tipo;

    TipoDePago(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

}
