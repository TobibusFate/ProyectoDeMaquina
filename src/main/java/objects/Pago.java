package objects;

import java.sql.Date;

public class Pago {
    public Date fechaP;
    public Date fechaLimiteP;
    public float montoP;

    public Pago(Date fechaP, Date fechaLimiteP, float montoP) {
        this.fechaP = fechaP;
        this.fechaLimiteP = fechaLimiteP;
        this.montoP = montoP;
    }

    public Date getFechaP() {
        return fechaP;
    }

    public void setFechaP(Date fechaP) {
        this.fechaP = fechaP;
    }

    public Date getFechaLimiteP() {
        return fechaLimiteP;
    }

    public void setFechaLimiteP(Date fechaLimiteP) {
        this.fechaLimiteP = fechaLimiteP;
    }

    public float getMontoP() {
        return montoP;
    }

    public void setMontoP(float montoP) {
        this.montoP = montoP;
    }
}
