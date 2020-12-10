package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConsultSales extends Consult{
	
    public static final String TABLENAME="ventas";
    public static final String IDPRODUCT="idproducto_productos1";
    public static final String IDCLIENT="idcliente_clientes";
    public static final String PRICE="precio";
    public static final String AMOUNT="cantidad";
    public static final String TOTAL="total";
    public static final String DATE="fecha";
    
    public ConsultSales(Connection conexion){
        super(conexion);
    }
    public ResultSet getRow(){
        return super.getRow(TABLENAME);
    }
    public String[][] getTableAsMatriz(){
        try {
            ResultSet rs=this.getRow();
            int rowSize=0;
            rs.last();
            rowSize=rs.getRow();
            rs.beforeFirst();
            String[][] matriz=new String[rowSize][5];
            for(int i=0;rs.next() && i<rowSize ;i++){
                matriz[i][0]=getName("clientes","idclientes",rs.getInt(IDCLIENT));
                matriz[i][1]=getName("articulos","idarticulos",rs.getInt(IDPRODUCT));
                matriz[i][2]=rs.getInt(AMOUNT)+"";
                matriz[i][3]=rs.getFloat(TOTAL)+"";
                matriz[i][4]=rs.getDate(DATE).toString();
            }
            return matriz;
        } catch (SQLException ex) {
            Logger.getLogger(ConsultClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        return  null;
    }
    public boolean register(Sale sale){
        int newAmount=newAmount(sale);
        if(newAmount>0){
            
            String[] columns={IDCLIENT,IDPRODUCT,AMOUNT,PRICE,TOTAL};
            Object[] values={sale.getIdcliente(),sale.getIdproducto(),sale.getCantidad(),sale.getCosto(),sale.getTotal()};
            return super.register(TABLENAME,columns,values) && super.update("articulos","cantidad="+newAmount,"idarticulos", ""+sale.getIdproducto());
        }
        return false;
    }
    public int newAmount(Sale sale){
        try {
            ResultSet unidades = getDataWhere("articulos","cantidad","idarticulos",sale.getIdproducto());
            int unidadesProducto=0;
            if(unidades.next()){
                unidadesProducto=unidades.getInt("cantidad");
            }else{
                return -1;
            }
            int nuevasUnidades=unidadesProducto-sale.getCantidad();
            
            
            return nuevasUnidades;
        } catch (SQLException ex) {
            Logger.getLogger(ConsultSales.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
    private float getIngresosMes(ResultSet rs, int month, int year){
        try {
            Date date;
            float ingreso=0;
            while(rs.next()){
                
                date=rs.getDate(DATE);
                if(date.getMonth()==month && date.getYear()+1900==year){
                    ingreso+=rs.getFloat(TOTAL);
                }
            }
            return ingreso;
        } catch (SQLException ex) {
            Logger.getLogger(ConsultSales.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
    public float getIngresosMes(int month,int year){
        return getIngresosMes(this.getRow(),month,year);
    }
    public float getIngresosMes(int idproducto,int month,int year){
        return getIngresosMes(this.getRowWhere(TABLENAME, IDPRODUCT, idproducto),month,year);
    }
    public int getUnidadesVendidas(int id){
        return (int)getSumWhere(TABLENAME, AMOUNT, "unidades",IDPRODUCT, id);
    }
    public int getUnidadesVendidas(int id, int month, int year){
        return getUnidadesVendidas(getRowWhere(TABLENAME,IDPRODUCT,id),month,year);
    }
    public int getUnidadesVendidas(ResultSet rs,int month,int year){
        try {
            Date date;
            int sum=0;
            while(rs.next()){
                date=rs.getDate(DATE);
                if(date.getMonth()==month && date.getYear()+1900==year){
                    sum+=rs.getInt(AMOUNT);
                }
            }
            return sum;
        } catch (SQLException ex) {
            Logger.getLogger(ConsultPurchase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
    public float getIngresoTotal(){
        return getSum(TABLENAME,TOTAL,"ingresototal");
    }
    public float getIngresoTotal(int id ){
        return getSumWhere(TABLENAME,TOTAL,"ingresoproducto",IDPRODUCT,id);
    }
    public int getItem(String table, String column, String name) {
    	int item = 0;
    	Conexion con = new Conexion();
    	PreparedStatement ps ;
		ResultSet rs ;
		Connection conex = con.getConexion();
		
    	try {
    		String sql = "SELECT * FROM "+table+" WHERE nombre=\""+name+"\"";
    		ps = conex.prepareStatement(sql);
            rs = ps.executeQuery();;
            
            while(rs.next()) {
            	item = rs.getInt(column);
            }
            rs.close();
        } 
        catch (SQLException e) {
            System.err.println(e.toString());
        }
		return item;
    }
    
    
}
