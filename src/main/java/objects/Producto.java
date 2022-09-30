package objects;

public class Producto {
    public int codigoProducto;
    public String nombreProducto;
    public int unidadesEnStock;

    public Producto(int codigoProducto, String nombreProducto, int unidadesEnStock) {
        this.codigoProducto = codigoProducto;
        this.nombreProducto = nombreProducto;
        this.unidadesEnStock = unidadesEnStock;
    }

    public int getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(int codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public int getUnidadesEnStock() {
        return unidadesEnStock;
    }

    public void setUnidadesEnStock(int unidadesEnStock) {
        this.unidadesEnStock = unidadesEnStock;
    }
}
