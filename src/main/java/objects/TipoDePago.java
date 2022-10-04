package objects;

import java.util.ArrayList;

public enum TipoDePago {
    TARJETA_DE_CREDITO("Tarjeta de Credito"),
    TARJETA_DE_DEBITO("Tarjeta de Debito"),
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
