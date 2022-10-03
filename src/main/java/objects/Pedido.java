package objects;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pedido {
    private int codigo;
    private Date fechaPedido, fechaEntrega;
    private Administrador admin;
    private Proveedor prov;
    
    public Pedido(int codigo, Date fechaPedido, Date fechaEntrega, Administrador admin, Proveedor prov) {
        this.codigo = codigo;
        this.fechaPedido = fechaPedido;
        this.fechaEntrega = fechaEntrega;
        this.admin = admin;
        this.prov = prov;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Date getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(Date fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
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
        l.add("Ped_FECHAENTREGA");
        return l;
    }
    
    public List<String> getAttributeValuesList() {
        List<String> l = new ArrayList<>();
        l.add(Integer.toString(codigo));
        l.add(Long.toString(prov.getCuit()));
        l.add(Integer.toString(admin.getDni()));
        l.add(admin.getCuenta().getCuenta());
        l.add("placeholder");
        l.add("placeholder");
        return l;
    }

    




}
