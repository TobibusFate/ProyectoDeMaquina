package objects;

import java.util.ArrayList;
import java.util.List;

public class Producto {
    private int codigoP;
    private String nombreP;
    private String categoriaP;
    private float precioP;
    private int stockMinimoP;
    private int stockP;

    public Producto(int codigoP) {
        this.codigoP = codigoP;
    }

    public Producto(int codigoP, String nombreP, String categoriaP, float precioP, int stockP, int stockMinimoP) {
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

    public String  getCategoriaP() {
        return categoriaP;
    }

    public void setCategoriaP(String  categoriaP) {
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

    public List<String> getAttributeNamesList() {
        List<String> l = new ArrayList<>();
        l.add("Prod_CODIGO");
        l.add("Prod_NOMBRE");
        l.add("Prod_CATEGORIA");
        l.add("Prod_PRECIO");
        l.add("Prod_STOCK");
        l.add("Prod_STOCK_MINIMO");
        return l;
    }
    public List<String> getAttributeValuesList() {
        List<String> l = new ArrayList<>();
        l.add(Integer.toString(codigoP));
        l.add(nombreP);
        l.add(categoriaP);
        l.add(Float.toString(precioP));
        l.add(Integer.toString(stockP));
        l.add(Integer.toString(stockMinimoP));
        return l;
    }
    public List<String> getKeyNamesList() {
        List<String> l = new ArrayList<>();
        l.add("Prod_CODIGO");
        return l;
    }
    public List<String> getKeyValuesList() {
        List<String> l = new ArrayList<>();
        l.add(Integer.toString(codigoP));
        return l;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 73 * hash + this.codigoP;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Producto other = (Producto) obj;
        return this.codigoP == other.codigoP;
    }
    
}
