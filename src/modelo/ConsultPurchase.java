package modelo;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class ConsultPurchase extends Consult{
    private static final String TABLENAME="compras";
    private static final String IDPRODUCT="idproducto_productos";
    private static final String IDPROVIDER="idproveedores1";
    private static final String PRICE="costo_individual";
    private static final String AMOUNT="cantidad";
    private static final String TOTAL="total";
    private static final String DATE="fecha";
    public ConsultPurchase(Connection conexion){
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
                matriz[i][0]=getName("proveedores","idproveedores",rs.getInt(IDPROVIDER));
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
    public boolean register(Purchase purchase){
        try {
            if(!registerProvider(purchase.getProveedor(),purchase.getCantidad())){
                return false;
            }
            ResultSet unidades=getData("articulos","cantidad");
            int unidadesProducto=0;
            if(unidades.next()){
                unidadesProducto=unidades.getInt("cantidad");
            }else{
                return false;
            }
            
            int nuevasUnidades=unidadesProducto+purchase.getCantidad();
            String[] columns={IDPRODUCT,AMOUNT,PRICE,TOTAL,IDPROVIDER};
            Object[] values={purchase.getIdproducto(),purchase.getCantidad(),purchase.getCostoIndividual(),purchase.getCostoTotal(),purchase.getProveedor()};
            return super.register(TABLENAME,columns,values) && super.update("articulos","cantidad="+nuevasUnidades,"idarticulos", ""+purchase.getIdproducto());

        } catch (SQLException ex) {
            Logger.getLogger(ConsultPurchase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public boolean registerProvider(int idProvider,int unidades) {
        try {
            ResultSet rs=super.getDataWhere("proveedores", "*", "idproveedores", idProvider);
            int amount=0;
            if(rs.next()){
                amount=rs.getInt("compras");
            }else{
                return false;
            }
            
            amount+=unidades;
            super.update("proveedores",new String[] {"compras"},new String[]{amount+""} ,"idproveedores", ""+idProvider);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ConsultPurchase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
        
    }
    public float getGastosMes(int month,int year){
        return getDatoMes(this.getRow(),month,year);
    }
    public float getGastosMes(int idproducto,int month,int year){
        return getDatoMes(getRowWhere(TABLENAME,IDPRODUCT,idproducto),month,year);
    }
    public float getDatoMes(ResultSet rs,int month,int year){
        try {
            Date date;
            float sum=0;
            while(rs.next()){
                date=rs.getDate(DATE);
                if(date.getMonth()==month && date.getYear()+1900==year){
                    sum+=rs.getFloat(TOTAL);
                }
            }
            return sum;
        } catch (SQLException ex) {
            //Logger.getLogger(ConsultPurchase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
    public float getGastoTotal(){
        return getSum(TABLENAME,TOTAL,"gastototal");
    }
    public float getGastoTotal(int id){
        return getSumWhere(TABLENAME,TOTAL,"gastototal",IDPRODUCT,id);
    }
    public int getId(String table, String column, String name) {
    	Conexion con = new Conexion();
		PreparedStatement ps ;
		ResultSet rs ;
		Connection conex = con.getConexion();
		int result = 0;

		try {   
            String sql = "SELECT * FROM "+table+" WHERE nombre=\""+name+"\"";
            ps = conex.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()) {
            	result = rs.getInt(column);
            }
            rs.close();
        } 
        catch (SQLException e) {
            System.err.println(e.toString());
        }
		return result;
    }
    
}
