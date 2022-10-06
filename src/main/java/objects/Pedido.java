package objects;

import java.text.DateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pedido {
    private int codigo;
    private LocalDate fechaPedido, fechaEntrega;
    private Administrador admin;
    private Proveedor prov;
    
    public Pedido(int codigo, LocalDate fechaPedido, LocalDate fechaEntrega, Administrador admin, Proveedor prov) {
        this.codigo = codigo;
        this.fechaPedido = fechaPedido;
        this.fechaEntrega = fechaEntrega;
        this.admin = admin;
        this.prov = prov;
    }
    public Pedido(int codigo, Administrador admin, Proveedor prov) {
        this.codigo = codigo;
        this.admin = admin;
        this.prov = prov;
        this.fechaPedido = LocalDate.now();
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public LocalDate getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(LocalDate fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public LocalDate getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(LocalDate fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public Administrador getAdmin() {
        return admin;
    }

    public void setAdmin(Administrador admin) {
        this.admin = admin;
    }

    public Proveedor getProv() {
        return prov;
    }

    public void setProv(Proveedor prov) {
        this.prov = prov;
    }

    public List<String> getKeyNamesList() {
        List<String> l = new ArrayList<>();
        l.add("Ped_CODIGO");
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
        l.add("Ped_CODIGO");
        l.add("Ped_Prov_CUIT");
        l.add("Ped_Admin_DNI");
        l.add("Ped_Admin_USUARIO");
        l.add("Ped_FECHAPEDIDO");
        return l;
    }
    
    public List<String> getAttributeValuesList() {
        List<String> l = new ArrayList<>();
        l.add(Integer.toString(codigo));
        l.add(Long.toString(prov.getCuit()));
        l.add(Integer.toString(admin.getDni()));
        l.add(admin.getCuenta().getCuenta());
        l.add(fechaPedido.toString());
        return l;
    }

    




}
