package objects;

import java.util.ArrayList;
import java.util.List;

public abstract class Renglon {
    private int codigo;
    private Producto prod;
    
    private float montoTotal;
    private float descuento;
    
    public Renglon(int codigo, Producto prod, float montoTotal, float descuento) {
        this.codigo = codigo;
        this.prod = prod;
        this.montoTotal = montoTotal;
        this.descuento = descuento;
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Producto getProd() {
        return prod;
    }

    public void setProd(Producto prod) {
        this.prod = prod;
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

    public List<String> getKeyNamesList() {
        List<String> l = new ArrayList<>();
        l.add("Ren_CODIGO");
        return l;
    }
    // valor del cuit
    public List<String> getKeyValuesList() {
        List<String> l = new ArrayList<>();
        l.add(Integer.toString(codigo));
        return l;
    }
    
    public List<String> getAttributeNamesList() {
        List<String> l = new ArrayList<>();
        l.add("Ren_CODIGO");
        l.add("Ren_Prod_CODIGO");
        l.add("Ren_MONTOTOTAL");
        l.add("Ren_DESCUENTO");
        return l;
    }
    
    public List<String> getAttributeValuesList() {
        List<String> l = new ArrayList<>();
        l.add(Integer.toString(codigo));
        l.add(Integer.toString(prod.getCodigoP()));
        l.add(Float.toString(montoTotal));
        l.add(Float.toString(descuento));
        return l;
    }



}
