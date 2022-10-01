package objects;

public class Producto {
    public int codigoP;
    public String nombreP;
    public int categoriaP;
    public float precioP;
    public int stockMinimoP;
    public int stockP;

    public Producto(int codigoP) {
        this.codigoP = codigoP;
    }

    public Producto(int codigoP, String nombreP, int categoriaP, float precioP, int stockMinimoP, int stockP) {
        this.codigoP = codigoP;
        this.nombreP = nombreP;
        this.categoriaP = categoriaP;
        this.precioP = precioP;
        this.stockMinimoP = stockMinimoP;
        this.stockP = stockP;
    }

    public int getCodigoP() {
        return codigoP;
    }

    public void setCodigoP(int codigoP) {
        this.codigoP = codigoP;
    }

    public String getNombreP() {
        return nombreP;
    }

    public void setNombreP(String nombreP) {
        this.nombreP = nombreP;
    }

    public int getCategoriaP() {
        return categoriaP;
    }

    public void setCategoriaP(int categoriaP) {
        this.categoriaP = categoriaP;
    }

    public float getPrecioP() {
        return precioP;
    }

    public void setPrecioP(float precioP) {
        this.precioP = precioP;
    }

    public int getStockMinimoP() {
        return stockMinimoP;
    }

    public void setStockMinimoP(int stockMinimoP) {
        this.stockMinimoP = stockMinimoP;
    }

    public int getStockP() {
        return stockP;
    }

    public void setStockP(int stockP) {
        this.stockP = stockP;
    }
}
