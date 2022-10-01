package objects;

public class TipoPago {
    public int cantCuotas;
    public int metodoDePago;

    public TipoPago(int cantCuotas, int metodoDePago) {
        this.cantCuotas = cantCuotas;
        this.metodoDePago = metodoDePago;
    }

    public int getCantCuotas() {
        return cantCuotas;
    }

    public void setCantCuotas(int cantCuotas) {
        this.cantCuotas = cantCuotas;
    }

    public int getMetodoDePago() {
        return metodoDePago;
    }

    public void setMetodoDePago(int metodoDePago) {
        this.metodoDePago = metodoDePago;
    }
}
