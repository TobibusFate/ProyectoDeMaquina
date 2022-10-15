package objects;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Pago {
    private int codigoP;
    private LocalDate fechaP;
    private LocalDate fechaLimiteP;
    private float montoP;
    private Venta venta;
    private int cuotas;
    private String metodoPago;
    private Cliente cliente;

    public Pago(float montoP, int cuotas, String metodoPago) {
        this.montoP = montoP;
        this.cuotas = cuotas;
        this.metodoPago = metodoPago;
    }

    public Pago(int codigoP, LocalDate fechaP, LocalDate fechaLimiteP, float montoP, Venta venta, int cuotas, String metodoPago) {
        this.codigoP = codigoP;
        this.fechaP = fechaP;
        this.fechaLimiteP = fechaLimiteP;
        this.montoP = montoP;
        this.venta = venta;
        this.cuotas = cuotas;
        this.metodoPago = metodoPago;
        this.cliente = null;
    }

    public Pago(int codigoP, LocalDate fechaP, LocalDate fechaLimiteP, float montoP, Venta venta, int cuotas, String metodoPago, Cliente cliente) {
        this.codigoP = codigoP;
        this.fechaP = fechaP;
        this.fechaLimiteP = fechaLimiteP;
        this.montoP = montoP;
        this.venta = venta;
        this.cuotas = cuotas;
        this.metodoPago = metodoPago;
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public int getCuotas() {
        return cuotas;
    }

    public void setCuotas(int cuotas) {
        this.cuotas = cuotas;
    }

    public int getCodigoP() {
        return codigoP;
    }

    public void setCodigoP(int codigoP) {
        this.codigoP = codigoP;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public LocalDate getFechaP() {
        return fechaP;
    }

    public void setFechaP(LocalDate fechaP) {
        this.fechaP = fechaP;
    }

    public LocalDate getFechaLimiteP() {
        return fechaLimiteP;
    }

    public void setFechaLimiteP(LocalDate fechaLimiteP) {
        this.fechaLimiteP = fechaLimiteP;
    }

    public float getMontoP() {
        return montoP;
    }

    public void setMontoP(float montoP) {
        this.montoP = montoP;
    }

    public List<String> getKeyNamesList() {
        List<String> l = new ArrayList<>();
        l.add("Pago_CODIGO");
        return l;
    }
    // valor del cuit
    public List<String> getKeyValuesList() {
        List<String> l = new ArrayList<>();
        l.add(Integer.toString(codigoP));
        return l;
    }
    
    public List<String> getAttributeNamesList() {
        List<String> l = new ArrayList<>();
        l.add("Pago_CODIGO");
        l.add("Pago_Venta_CODIGO");
        l.add("Pago_MONTO");
        l.add("Pago_FECHAPAGO");
        l.add("Pago_FECHALIMITE");
        l.add("Pago_CUOTAS");
        l.add("Pago_TIPO");
        return l;
    }
    
    public List<String> getAttributeValuesList() {
        List<String> l = new ArrayList<>();
        l.add(Integer.toString(codigoP));
        l.add(Integer.toString(venta.getCodigoV()));
        l.add(Float.toString(montoP));
        l.add("placeholder");
        l.add("placeholder");
        l.add(Integer.toString(cuotas));
        l.add(metodoPago.toString());
        return l;
    }


}
