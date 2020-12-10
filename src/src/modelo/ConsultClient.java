package modelo;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

import vista.PanelClient;

public class ConsultClient extends Consult{
	
    private static final String TABLENAME="clientes";
    private static final String IDCLIENT="idclientes";
    private static final String NAME="nombre";
    private static final String AT="at";
    private static final String ADDRESS="direccion";
    
    public ConsultClient(Connection conexion){
        super(conexion);
    }

    public boolean register(Client client){
    	String columns = "("+NAME+","+AT+","+ADDRESS+")";
    	String values = "(\""+client.getNombre()+"\",\""+client.getAt()+"\",\""+client.getDireccion()+"\")";
        return super.register(TABLENAME,columns,values);
    }
    
    public boolean search(Client client){
    	try {
            ResultSet rs = super.getRowWhere(TABLENAME,NAME,client.getNombre());
            if(rs.next()){
                client.setId(Integer.parseInt(rs.getString(IDCLIENT)));
                client.setNombre(rs.getString(NAME));
                client.setAt(rs.getString(AT));
                client.setDireccion(rs.getString(ADDRESS));
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConsultInventory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean delete(Client client){
        return super.delete(TABLENAME,NAME ,String.valueOf(client.getNombre()));
    }
    
    public boolean update(Client client) {
        String updates = NAME+"=\""+client.getNombre()+"\","+IDCLIENT+"="+client.getId()+","+AT+"=\""+client.getAt()+"\","+ADDRESS+"=\""+client.getDireccion()+"\"";
    	return super.update(TABLENAME,updates,"nombre","\""+client.getNombre()+"\"");
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
            String[][] matriz=new String[rowSize][3];
            for(int i=0;rs.next() && i<rowSize ;i++){
                matriz[i][0]=rs.getString(NAME);
                matriz[i][1]=rs.getString(AT);
                matriz[i][2]=rs.getString(ADDRESS);
            }
            return matriz;
        } catch (SQLException ex) {
            Logger.getLogger(ConsultClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        return  null;
    }
}
