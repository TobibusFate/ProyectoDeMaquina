package objects;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Venta {
    private int  codigoV;
    private Date fechaV;
    private boolean cerradaV;
    private float montoV;

    private List<RenglonVenta> renglonesDeProductos;

    public Venta(int codigoV) {
        this.codigoV = codigoV;
    }

    public Venta(int codigoV, Date fechaV, boolean cerradaV, float montoV, List<RenglonVenta> renglonesDeProductos) {
        this.codigoV = codigoV;
        this.fechaV = fechaV;
        this.cerradaV = cerradaV;
        this.renglonesDeProductos = renglonesDeProductos;
        this.montoV = montoV;
    }

    public int getCodigoV() {
        return codigoV;
    }

    public void setCodigoV(int codigoV) {
        this.codigoV = codigoV;
    }

    public Date getFechaV() {
        return fechaV;
    }

    public void setFechaV(Date fechaV) {
        this.fechaV = fechaV;
    }

    public boolean isCerradaV() {
        return cerradaV;
    }

    public void setCerradaV(boolean cerradaV) {
        this.cerradaV = cerradaV;
    }

    public List<RenglonVenta> getRenglonesDeProductos() {
        return renglonesDeProductos;
    }

    public void setRenglonesDeProductos(List<RenglonVenta> renglonesDeProductos) {
        this.renglonesDeProductos = renglonesDeProductos;
    }

    public List<String> getKeyNamesList() {
        List<String> l = new ArrayList<>();
        l.add("Venta_CODIGO");
        return l;
    }
    // valor del cuit
    public List<String> getKeyValuesList() {
        List<String> l = new ArrayList<>();
        l.add(Integer.toString(codigoV));
        return l;
    }
    
    public List<String> getAttributeNamesList() {
        List<String> l = new ArrayList<>();
        l.add("Venta_CODIGO");
        l.add("Venta_CERRADA");
        l.add("Venta_MONTO");
        l.add("Venta_FECHA");
        l.add("Venta_HORA");
        return l;
    }
    
    public List<String> getAttributeValuesList() {
        List<String> l = new ArrayList<>();
        l.add(Integer.toString(codigoV));
        l.add(Boolean.toString(cerradaV));
        l.add(Float.toString(montoV));
        l.add("placeholder");
        l.add("placeholder");
        return l;
    }

}
