package modelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class ConsultBalance extends Consult{
    public ConsultBalance(Connection conexion){
        super(conexion);
    }
    public float getIngresoTotal(){
        return getSum("ventas","total","ingresototal");
    }
    public float getIngresoTotal(int id ){
        return getSumWhere("ventas","total","ingresoproducto","idproducto_productos1",id);
    }
    public float getGastoTotal(){
        return getSum("compras","total","gastototal");
    }
    public float getGastoTotal(int id){
        return getSumWhere("compras","total","gastototal","idproducto_productos",id);
    }
    public int getUnidadesVendidas(int id){
        return (int)getSumWhere("ventas","cantidad","unidades","idproducto_productos1",id);
    }
    public float getIngresoTotalOn(int year, int month){
        return 0;
    }
    public String[][] getTableAsMatriz(){
        return null;
    }
}
