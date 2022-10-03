package objects;

import java.util.ArrayList;
import java.util.List;

public class RenglonVenta extends Renglon {
    private int unidades;
    private Venta venta;

    public RenglonVenta(int codigo, Producto prod, float montoTotal, float descuento, int unidades, Venta venta) {
        super(codigo, prod, montoTotal, descuento);
        this.unidades = unidades;
        this.venta = venta;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
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
