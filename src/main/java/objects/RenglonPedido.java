package objects;

import java.util.ArrayList;
import java.util.List;

public class RenglonPedido extends Renglon {
    private int cantidad;
    private Pedido pedido;
    private TipoCantidad tipoCantidad;

    // pedido = null
    public RenglonPedido(Producto prod, int cantidad, TipoCantidad tipo, float descuento) {
        super(prod,prod.getPrecioP()*cantidad, descuento);
        this.cantidad = cantidad;
        this.tipoCantidad = tipo;
    }
    
    public RenglonPedido(Producto prod, Pedido pedido, int cantidad, TipoCantidad tipo, float descuento) {
        super(prod, prod.getPrecioP()*cantidad, descuento);
        this.cantidad = cantidad;
        this.pedido = pedido;
        this.tipoCantidad = tipo;
    }
    
    public TipoCantidad getTipoCantidad() {
        return tipoCantidad;
    }

    public void setTipoCantidad(TipoCantidad tipoCantidad) {
        this.tipoCantidad = tipoCantidad;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public List<String> getKeyNamesList() {
        List<String> l = new ArrayList<>();
        l.add("RenP_CODIGO");
        l.add("RenV_Ped_CODIGO");
        return l;
    }
    // valor del cuit
    public List<String> getKeyValuesList() {
        List<String> l = new ArrayList<>();
        l.add(Integer.toString(getCodigo()));
        l.add(Integer.toString(pedido.getCodigo()));
        return l;
    }
    
    public List<String> getAttributeNamesList() {
        List<String> l = new ArrayList<>();
        l.add("RenP_CODIGO");
        l.add("RenP_Ped_CODIGO");
        l.add("RenP_Tipo");
        l.add("RenP_CANTIDAD");
        return l;
    }
    
    public List<String> getAttributeValuesList() {
        List<String> l = new ArrayList<>();
        l.add(Integer.toString(getCodigo()));
        l.add(Integer.toString(pedido.getCodigo()));
        l.add(tipoCantidad.toString());
        l.add(Integer.toString(cantidad));
        return l;
    }


}