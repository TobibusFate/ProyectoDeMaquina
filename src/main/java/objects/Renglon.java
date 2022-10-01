package objects;

public abstract class Renglon {
    public float montoTotal;
    public float descuento;

    public Renglon(float montoTotal, float descuento) {
        this.montoTotal = montoTotal;
        this.descuento = descuento;
    }

    public float getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(float montoTotal) {
        this.montoTotal = montoTotal;
    }

    public float getDescuento() {
        return descuento;
    }

    public void setDescuento(float descuento) {
        this.descuento = descuento;
    }
}
