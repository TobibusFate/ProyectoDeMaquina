package objects;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class Venta {
    private int codigoV;
    private Date fechaV;
    private Time horaV;
    private boolean cerradaV;
    private float montoV;
    private String cuentaVendedor;

    public Venta(int codigoV) {
        this.codigoV = codigoV;
    }

    public Venta(int codigoV, String cuentaVendedor, boolean cerradaV, float montoV , Date fechaV, Time horaV) {
        this.codigoV = codigoV;
        this.fechaV = fechaV;
        this.horaV = horaV;
        this.cerradaV = cerradaV;
        this.montoV = montoV;
        this.cuentaVendedor = cuentaVendedor;
    }

    public Venta(float montoV, boolean cerradaV, String cuentaVendedor) {
        this.cerradaV = cerradaV;
        this.montoV = montoV;
        this.cuentaVendedor = cuentaVendedor;
    }

    public Venta(int codigoV, boolean cerradaV, float montoV) {
        this.codigoV = codigoV;
        this.cerradaV = cerradaV;
        this.montoV = montoV;
    }

    public Venta(int codigoV, Date fechaV, Time horaV, boolean cerradaV, float montoV, String cuentaVendedor) {
        this.codigoV = codigoV;
        this.fechaV = fechaV;
        this.horaV = horaV;
        this.cerradaV = cerradaV;
        this.montoV = montoV;
        this.cuentaVendedor = cuentaVendedor;
    }



    public int getCodigoV() {
        return codigoV;
    }

    public void setCodigoV(int codigoV) {
        this.codigoV = codigoV;
    }

    public String getCuentaVendedor() {
        return cuentaVendedor;
    }

    public void setCuentaVendedor(String cuentaVendedor) {
        this.cuentaVendedor = cuentaVendedor;
    }

    public Date getFechaV() {
        return fechaV;
    }

    public void setFechaV(Date fechaV) {
        this.fechaV = fechaV;
    }

    public Time getHoraV() {
        return horaV;
    }

    public void setHoraV(Time horaV) {
        this.horaV = horaV;
    }

    public boolean getCerradaV() {
        return cerradaV;
    }

    public void setCerradaV(boolean cerradaV) {
        this.cerradaV = cerradaV;
    }

    public float getMontoV() {
        return montoV;
    }

    public void setMontoV(float montoV) {
        this.montoV = montoV;
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
