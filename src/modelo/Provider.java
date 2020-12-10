package modelo;
public class Provider {
    private int id;
    private String proveedor;
    private int compras;
    private int devoluciones;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public int getCompras() {
        return compras;
    }

    public void setCompras(int compras) {
        this.compras = compras;
    }

    public int getDevoluciones() {
        return devoluciones;
    }

    public void setDevoluciones(int devoluciones) {
        this.devoluciones = devoluciones;
    }

    public Provider(String proveedor, int compras, int devoluciones) {
        this.proveedor = proveedor;
        this.compras = compras;
        this.devoluciones = devoluciones;
    }
    
}
