package modelo;

import java.sql.Date;

public class Sale {
	
	private int idventa;
    private int idcliente;
    private int idproducto;
    private float costo;
    private int cantidad;
    private float total;
    private Date date;
    
    public int getIdventa() {
        return idventa;
    }
    public int getIdcliente() {
        return idcliente;
    }

    public int getIdproducto() {
        return idproducto;
    }

    public float getCosto() {
        return costo;
    }

    public int getCantidad() {
        return cantidad;
    }
    public float getTotal() {
    	return total;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setDate(Date date){
        this.date=date;
    }
    
    public int getMonth(){
        return this.date.getMonth();
    }
    
    public int getYear(){
        return this.date.getYear();
    }
    
    public void setTotal() {
    	this.total = cantidad*costo;
    }
}
