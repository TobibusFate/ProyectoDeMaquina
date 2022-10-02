package objects;

public class RenglonVenta extends Renglon{
    private int unidades;
    private Producto producto;

    public RenglonVenta(float montoTotal, float descuento, int unidades, Producto producto) {
        super(montoTotal, descuento);
        this.unidades = unidades;
        this.producto = producto;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
}
