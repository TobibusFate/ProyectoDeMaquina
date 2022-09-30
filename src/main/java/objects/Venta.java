package objects;

public class Venta {
    public int  codigoVenta;
    public int fecha;

    public Venta(int codigoVenta, int fecha) {
        this.codigoVenta = codigoVenta;
        this.fecha = fecha;
    }

    public int getCodigoVenta() {
        return codigoVenta;
    }

    public void setCodigoVenta(int codigoVenta) {
        this.codigoVenta = codigoVenta;
    }

    public int getFecha() {
        return fecha;
    }

    public void setFecha(int fecha) {
        this.fecha = fecha;
    }
}
