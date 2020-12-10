package modelo;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
public abstract class Consult {
    private static Connection conexion;
    protected static final String ASC="ASC";
    protected static final String DESC="DESC";
    public Consult(Connection conexion){
        setConexion(conexion);
    }
    public static void setConexion(Connection conexion){
        Consult.conexion=conexion;
    }
    public Connection getConexion(){
        return conexion;
    
    }
    public String[][] getTableAsMatriz(String str){
        try {
            ResultSet rs=this.getRow(str);
            int rowSize=0;
            rs.last();
            rowSize=rs.getRow();
            rs.beforeFirst();
            
            int columnSize=rs.getMetaData().getColumnCount();
            String[][] ret=new String[rowSize][columnSize];
            int i=0;
            while(rs.next() && i<rowSize){
                for(int j=0;j<columnSize;j++){
                    ret[i][j]=rs.getString(j+1);
                }
                i++;
            }
            return ret;
        } catch (SQLException ex) {
            Logger.getLogger(Consult.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    abstract public String[][] getTableAsMatriz();
    public ResultSet getConsult(String sql){
        try {
            PreparedStatement statement; 
            ResultSet rs;
            //System.out.println(sql);
            statement=conexion.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE,  ResultSet.CONCUR_UPDATABLE);
            rs=statement.executeQuery();
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(Consult.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public boolean update(String table, String updates,String columnCondition, String valueColumnCondition){
        try {
            String sql="UPDATE "+table+" SET "+updates+" WHERE "+columnCondition+"="+valueColumnCondition;
            PreparedStatement statement=conexion.prepareStatement(sql);
            statement.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Consult.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public boolean update(String table, String[] columns,String[] values,String columnCondition,String valueColumnCondition){
        if(columns.length!=values.length){
            return false;
        }
        String updates = "";
        for(int i=0;i<columns.length-1;i++){
            updates+=columns[i]+"="+values[i]+",";
        }
        updates+=columns[columns.length-1]+"="+values[values.length-1];
        return update(table, updates,columnCondition,valueColumnCondition);
    }
    public boolean register(String table,String columns, String values){
		try {
                    String sql = "INSERT  INTO "+table+" "+columns+" VALUES "+values;
		    PreparedStatement statement = conexion.prepareStatement(sql);
                    statement.execute();
                    return true;
		}catch(SQLException e) {
			Logger.getLogger(Consult.class.getName()).log(Level.SEVERE, null, e);
		}
                return false;
    }
    public boolean register(String table,String[] columns, Object[] values){
        if(columns.length!=values.length || columns.length==0) //Verifica que las listas sean del mismo tamaño y que no sean listas vacias
            return false;
        String columnsString="(";
        String valuesString="(";
        for(int i=0;i<columns.length-1;i++){
            columnsString+=columns[i]+",";
        }
        columnsString+=columns[columns.length-1]+")";
        for(int i=0;i<values.length-1;i++){
            if(values[i] instanceof String){
                valuesString+="'"+values[i]+"',";
            }else{
            valuesString+=values[i]+",";
            }
        }
        valuesString+=values[values.length-1]+")";
        return register(table,columnsString,valuesString);        
        
    }
    public ResultSet getData(String table,String column){
        return getConsult("SELECT "+ column+" FROM "+table);
    }
    public ResultSet getRow(String table){
        return getData(table,"*");
    }
    public ResultSet getDataBy(String table, String column,String columnToOrder, boolean ascendent){
        String order="";
        if(!ascendent){
            order=DESC;
        }
        return getData(table+" ORDER BY "+columnToOrder+" "+order,column);
    }
    public ResultSet getRowBy(String table, String columnToOrder,boolean ascendent){
        return getDataBy(table, "*", columnToOrder, ascendent);
    }
    
    public ResultSet getDataWhere(String table,String column, String columnSearch, Object dataSearch){
        if(dataSearch instanceof String){ //Se hace este condicional porque los strings deben entrar con "''" para funcionar, mientras que con int y floats no sucede este problema
            return getData(table+" WHERE "+columnSearch+"= '"+dataSearch+"'",column );
        }
        return getData(table+" WHERE "+columnSearch+"="+dataSearch,column );
    }
    public ResultSet getRowWhere(String table, String columnSearch, Object dataSearch){
        return getDataWhere(table,"*",columnSearch,dataSearch);
    }
    public boolean delete(String table, String columnCondition,Object dataCondition){
        try {
            String sql;
            if(dataCondition instanceof String){
                sql="DELETE FROM "+table+" WHERE "+columnCondition+"='"+dataCondition+"'";
            }else{
                sql="DELETE FROM "+table+" WHERE "+columnCondition+"="+dataCondition;
            }
            
            PreparedStatement statement=conexion.prepareStatement(sql);
            
            statement.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Consult.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public float getSum(String table, String column,String name){
        try {
            column="SUM("+column+") as "+name;
            ResultSet rs=getData(table,column);
            if(rs.next()){
                return rs.getFloat(name);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Consult.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
    public float getSumWhere(String table, String column,String name, String columnSearch, Object dataSearch){
        try {
            column="SUM("+column+") as "+name;
            ResultSet rs=getDataWhere(table,column,columnSearch,dataSearch);
            if(rs.next()){
                return rs.getFloat(name);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Consult.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
    public String getName(String table, String columndId, int id){
        try {
            ResultSet rs=this.getDataWhere(table, "nombre", columndId, id);
            if(rs.next()){
                return rs.getString("nombre");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Consult.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
