package objects;

import java.util.ArrayList;
import java.util.List;

public class RenglonVenta extends Renglon {
    private int unidades;
    private Venta venta;
    
    public RenglonVenta(int unidades, Producto producto) {
        super(producto, producto.getPrecioP()*unidades,0F);
        this.unidades = unidades;
        this.venta = venta;
    }

    public RenglonVenta(float montoTotal, float descuento, int unidades, Producto producto) {
        super(producto, montoTotal, descuento);
        this.unidades = unidades;
        this.venta = venta;
    }

    public int getUnidades() {
        return unidades;
    }



    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public List<String> getKeyNamesList() {
        List<String> l = new ArrayList<>();
        l.add("RenV_CODIGO");
        l.add("RenV_Venta_CODIGO");
        return l;
    }
    // valor del cuit
    public List<String> getKeyValuesList() {
        List<String> l = new ArrayList<>();
        l.add(Integer.toString(getCodigo()));
        l.add(Integer.toString(venta.getCodigoV()));
        return l;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
        setDescuento(super.getDescuento());
    }
    @Override
    public void setDescuento(float descuento) {
        super.setDescuento(descuento);
        float localDescuento = (super.getProducto().getPrecioP() * this.unidades) * (descuento/100);
        setMontoTotal((this.unidades * super.getProducto().getPrecioP()) -  localDescuento);

    }

    
    public List<String> getAttributeNamesList() {
        List<String> l = new ArrayList<>();
        l.add("RenV_CODIGO");
        l.add("RenV_Venta_CODIGO");
        l.add("RenV_UNIDADES");
        return l;
    }
    
    public List<String> getAttributeValuesList() {
        List<String> l = new ArrayList<>();
        l.add(Integer.toString(getCodigo()));
        l.add(Integer.toString(venta.getCodigoV()));
        l.add(Integer.toString(unidades));
        return l;
    }


}
