package objects;

import java.sql.Date;
import java.util.List;

public class Venta {
    private int  codigoV;
    private Date fechaV;
    private boolean cerradaV;

    private List<RenglonVenta> renglonesDeProductos;

    public Venta(int codigoV) {
        this.codigoV = codigoV;
    }

    public Venta(int codigoV, Date fechaV, boolean cerradaV, List<RenglonVenta> renglonesDeProductos) {
        this.codigoV = codigoV;
        this.fechaV = fechaV;
        this.cerradaV = cerradaV;
        this.renglonesDeProductos = renglonesDeProductos;
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
}
