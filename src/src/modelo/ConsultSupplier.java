package modelo;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConsultSupplier extends Consult{
	
	private static final String TABLENAME="proveedores";
    private static final String IDSUPPLIER="idproveedores";
    private static final String NAME="nombre";
    private static final String PURCHASES="compras";
	
	public ConsultSupplier(Connection conexion){
        super(conexion);
    }
    
    public boolean register(Supplier supplier){
    	String[] columns={NAME,IDSUPPLIER};
        Object[] values={supplier.getNombre(),supplier.getId()};
        return super.register(TABLENAME,columns, values);
    }
    
    public boolean search(Supplier supplier){
    	try {
            ResultSet rs = super.getRowWhere(TABLENAME,NAME,supplier.getNombre());
            if(rs.next()){
                supplier.setId(Integer.parseInt(rs.getString(IDSUPPLIER)));
                supplier.setNombre(rs.getString(NAME));
                
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConsultInventory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean delete(Supplier supplier){
        return super.delete(TABLENAME,NAME ,String.valueOf(supplier.getNombre()));
    }
    
    public ResultSet getRow(){
        return super.getRow(TABLENAME);
    }
    public String[][] getTableAsMatriz() {
	try {
            ResultSet rs=this.getRow();
            int rowSize=0;
            rs.last();
            rowSize=rs.getRow();
            rs.beforeFirst();
            String[][] matriz=new String[rowSize][2];
            for(int i=0;rs.next() && i<rowSize ;i++){
                matriz[i][0]=rs.getString(NAME);
                matriz[i][1]=rs.getInt(PURCHASES)+"";
            }
            return matriz;
        } catch (SQLException ex) {
            Logger.getLogger(ConsultClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        return  null;
    }
        
}
