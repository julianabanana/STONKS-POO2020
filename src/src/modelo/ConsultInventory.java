package modelo;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class ConsultInventory extends Consult{
    private static final String TABLENAME="articulos";
    private static final String ID="idarticulos";
    private static final String NAME="nombre";
    private static final String PRICE="precio";
    private static final String AMOUNT="cantidad";
    public ConsultInventory(Connection conexion){
        super(conexion);
    }
    public ResultSet getRow(){
        return super.getRow(TABLENAME);
    }
    public boolean register(Inventory inventory){
        String[] columns={NAME,AMOUNT,PRICE};
        Object[] values={inventory.getNombre(),inventory.getCantidad(),inventory.getPrecio()};
        return super.register(TABLENAME,columns, values);
    }
    public String[][] getTableAsMatriz(){
        try {
            ResultSet rs=this.getRow();
            int rowSize=0;
            rs.last();
            rowSize=rs.getRow();
            rs.beforeFirst();
            String[][] matriz=new String[rowSize][3];
            for(int i=0;rs.next() && i<rowSize ;i++){
                matriz[i][0]=rs.getString(NAME);
                matriz[i][1]=rs.getInt(AMOUNT)+"";
                matriz[i][2]=rs.getFloat(PRICE)+"";
            }
            return matriz;
        } catch (SQLException ex) {
            Logger.getLogger(ConsultClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        return  null;
    }
    public boolean search(Inventory inventory){
        try {
            ResultSet rs=super.getRowWhere(TABLENAME,NAME, inventory.getNombre());
            if(rs.next()){
                inventory.setIdproducto(Integer.parseInt(rs.getString(ID)));
		inventory.setNombre(rs.getString(NAME));
		inventory.setCantidad(rs.getInt(AMOUNT));
                inventory.setPrecio(rs.getFloat(PRICE));
		return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConsultInventory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public boolean delete(Inventory inventory){
        return super.delete(TABLENAME,NAME ,String.valueOf(inventory.getNombre()));
    }
    public int getIdproducto(String name){
        try {
            ResultSet rs=super.getDataWhere(TABLENAME, ID, NAME,name);
            if(rs.next()){
                return rs.getInt(ID);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConsultInventory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
    public String getName(int id){
        try {
            ResultSet rs=super.getDataWhere(TABLENAME, NAME, ID, id);
            if(rs.next()){
                return rs.getString(NAME);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ConsultInventory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
    public float getPrice(int id){
        try {
            ResultSet rs=super.getDataWhere(TABLENAME, PRICE, ID, id);
            if(rs.next()){
                return rs.getInt(PRICE);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConsultInventory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
    
    public ResultSet getRowByPrice(boolean ascendent){
        return getRowBy(TABLENAME,PRICE, ascendent);
    }
    
    public ResultSet getRowByPrice(){
        return getRowBy(TABLENAME,PRICE, false);
    }
    
 }
    

