package modelo;

import java.sql.Date;

public class Purchase {
	
	private int idcompra;
	private int idproducto;
	private int proveedor;
	private int cantidad;
	private int costo;
	private Date date;
	
	public int getProveedor() {
		return proveedor;
	}
	public void setProveedor(int proveedor) {
		this.proveedor = proveedor;
	}
	public int getIdcompra() {
		return idcompra;
	}
	public void setIdcompra(int idcompra) {
		this.idcompra = idcompra;
	}
	public int getIdproducto() {
		return idproducto;
	}
	public void setIdproducto(int idproducto) {
		this.idproducto = idproducto;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public int getCostoIndividual() {
		return costo;
	}
	public void setCostoIndividual(int costoIndividual) {
		this.costo = costoIndividual;
	}
	public int getCostoTotal() {
		return costo*cantidad;
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
}