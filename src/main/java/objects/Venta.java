package objects;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Venta {
    private int codigoV;
    private LocalDate fechaV;
    private LocalDateTime horaV;
    private boolean cerradaV;
    private float montoV;
    private String cuentaVendedor;

    private List<RenglonVenta> renglonesDeProductos;

    public Venta(int codigoV) {
        this.codigoV = codigoV;
    }

    public Venta( float montoV, boolean cerradaV, String cuentaVendedor) {
        this.cerradaV = cerradaV;
        this.montoV = montoV;
        this.cuentaVendedor = cuentaVendedor;
    }

    public Venta(int codigoV, boolean cerradaV, float montoV, List<RenglonVenta> renglonesDeProductos) {
        this.codigoV = codigoV;
        this.cerradaV = cerradaV;
        this.montoV = montoV;
        this.renglonesDeProductos = renglonesDeProductos;
    }

    public Venta(int codigoV, LocalDate fechaV, LocalDateTime horaV, boolean cerradaV, float montoV, String cuentaVendedor, List<RenglonVenta> renglonesDeProductos) {
        this.codigoV = codigoV;
        this.fechaV = fechaV;
        this.horaV = horaV;
        this.cerradaV = cerradaV;
        this.montoV = montoV;
        this.cuentaVendedor = cuentaVendedor;
        this.renglonesDeProductos = renglonesDeProductos;
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

    public LocalDate getFechaV() {
        return fechaV;
    }

    public void setFechaV(LocalDate fechaV) {
        this.fechaV = fechaV;
    }

    public LocalDateTime getHoraV() {
        return horaV;
    }

    public void setHoraV(LocalDateTime horaV) {
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
