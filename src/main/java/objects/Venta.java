package objects;

import java.sql.Date;

public class Venta {
    public int  codigoV;
    public Date fechaV;
    public boolean cerradaV;

    public Venta(int codigoV) {
        this.codigoV = codigoV;
    }

    public Venta(int codigoV, Date fechaV, boolean cerradaV) {
        this.codigoV = codigoV;
        this.fechaV = fechaV;
        this.cerradaV = cerradaV;
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
}
