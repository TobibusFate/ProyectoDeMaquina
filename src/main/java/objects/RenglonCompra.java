package objects;

public class RenglonCompra extends Renglon{
    public int unidades;

    public RenglonCompra(float montoTotal, float descuento, int unidades) {
        super(montoTotal, descuento);
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }
}
