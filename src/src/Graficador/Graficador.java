package Graficador;
import modelo.*;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JPanel;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
public class Graficador {
    private GraficaBarras graficaBarras;
    private GraficaCircular graficaCircular;
    private GraficaLineal graficaLineal;
    private Histograma histograma;
    private Connection conexion;
    private ResultSet iterador;
    private JPanel panel;
    private ConsultInventory controlInventory;
    private ConsultPurchase controlPurchase;
    private ConsultSales controlSales;
    private PreparedStatement accesor;
    private static final String[] MESES={"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};
    public Graficador(JPanel panel,Connection conexion){ 
        this.controlInventory=new ConsultInventory(conexion);
        this.controlPurchase=new ConsultPurchase(conexion);
        this.controlSales=new ConsultSales(conexion);
        this.panel=panel; 
    }
    public Graficador(Connection conexion){
        this(null, conexion);
    }
    public void limpiar(){ //Limpia el panel y borra todas las graficas instanciadas (o almenos borra la referencia.
        limpiarBarras();
        limpiarCircular(); 
        limpiarLineal();
        limpiarHistograma();
    }
    public void limpiarBarras(){
        this.graficaBarras=null;
    }
    public void limpiarCircular(){
        this.graficaCircular=null;
    }
    public void limpiarLineal(){
        this.graficaLineal=null;
    }
    public void limpiarHistograma(){
        this.histograma=null;
    }

    //Gráficas Definidad:
    //Ingresos/Ventas:
        public void ingresosPorProductoMes(int month, int year){
        //Representa con unagrafica torta que porcentaje del ingresos total de un mes fue por cada uno de los productos
        try {
            limpiar();
            ResultSet iterador=controlInventory.getRow();
            this.graficaCircular=new GraficaCircular("Ingreso por producto ("+MESES[month]+"/"+year+")");
            while(iterador.next()){
                graficaCircular.anadirDato(iterador.getString("nombre"),controlSales.getIngresosMes(iterador.getInt("idarticulos"),month, year));
            }
            graficaCircular.graficar();
        } catch (SQLException ex) {
            Logger.getLogger(Graficador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void ingresosPorProducto(){
        //Representa con unagrafica torta que porcentaje del ingresos total fue por cada uno de los productos
        try {
            limpiar();
            ResultSet iterador=controlInventory.getRow();
            
            this.graficaCircular=new GraficaCircular("Ingreso por producto");
            while(iterador.next()){
                graficaCircular.anadirDato(iterador.getString("nombre"),controlSales.getIngresoTotal(iterador.getInt("idarticulos")));
            }
            graficaCircular.graficar();
            
        } catch (SQLException ex) {
            Logger.getLogger(Graficador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void ingresosAno(int year){
        limpiar();
        this.graficaBarras=new GraficaBarras("Ingresos Totales Mensuales ("+year+")","Mes","$",true,true);
        for(int i=0;i<MESES.length;i++){
            graficaBarras.anadirDato(this.controlSales.getIngresosMes(i, year), "Ingresos", MESES[i]);
        }
        graficaBarras.graficar();
    }
    public void ingresosAno(int id,int year){
        limpiar();
        this.graficaBarras=new GraficaBarras("Ingresos Mensuales "+controlInventory.getName(id)+" ("+year+")","Mes","$",true,true);
        for(int i=0;i<MESES.length;i++){
            graficaBarras.anadirDato(this.controlSales.getIngresosMes(id,i, year), "Ingresos", MESES[i]);
        }
        graficaBarras.graficar();
    }
    //Balance
    public void ingresosVsVentasTotales(){
            limpiar();
            this.graficaBarras=new GraficaBarras("Ingresos vs Ventas","","$",true,true);
            graficaBarras.anadirDato(controlSales.getIngresoTotal(), "Ingresos", "Ingresos Totales");
            graficaBarras.anadirDato(controlPurchase.getGastoTotal(), "Gastos", "Gastos Totales");
            
            graficaBarras.graficar();
    }
    public void ingresosVsVentasTotalesMes(int month,int year){
        limpiar();
        this.graficaBarras=new GraficaBarras("Ingresos vs Ventas ("+MESES[month]+"/"+year+")","","$",true,true);
        graficaBarras.anadirDato(this.controlSales.getIngresosMes(month, year), "Ingresos", "Ingresos Totales");
        graficaBarras.anadirDato(this.controlPurchase.getGastosMes(month, year), "Gastos", "Gastos Totales");
        graficaBarras.graficar();
        
    }
    public void ingresosVsVentasTotalesMes(int id,int month,int year){
        limpiar();
        String name=controlInventory.getName(id);
        this.graficaBarras=new GraficaBarras("Ingresos vs Ventas "+name+" ("+MESES[month]+"/"+year+")","","$",true,true);
        graficaBarras.anadirDato(this.controlSales.getIngresosMes(id,month, year), "Ingresos", name);
        graficaBarras.anadirDato(this.controlPurchase.getGastosMes(id,month, year), "Gastos",name);
        graficaBarras.graficar();
        
    }

    public void ingresosVsVentasPorProducto(){
        try {
            limpiar();
            this.graficaBarras=new GraficaBarras("Ingresos vs Ventas por Producto","Producto","",true,true);
            ResultSet iterador=controlInventory.getRow();
            while(iterador.next()){
                graficaBarras.anadirDato(controlPurchase.getGastoTotal(iterador.getInt("idarticulos")), "Gastos", iterador.getString("nombre"));
                graficaBarras.anadirDato(controlSales.getIngresoTotal(iterador.getInt("idarticulos")), "Ingresos", iterador.getString("nombre"));
            }
            graficaBarras.graficar();
        } catch (SQLException ex) {
            Logger.getLogger(Graficador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void ingresosVsVentasPorProductoMes(int month, int year){
        try {
            limpiar();
            this.graficaBarras=new GraficaBarras("Ingresos vs Ventas por producto ("+MESES[month]+"/"+year+")","","$",true,true);
            ResultSet iterador=controlInventory.getRow();
            while(iterador.next()){
                graficaBarras.anadirDato(controlSales.getIngresosMes(iterador.getInt("idarticulos"),month, year),"Ingresos",iterador.getString("nombre"));
                graficaBarras.anadirDato(controlPurchase.getGastosMes(iterador.getInt("idarticulos"),month,year), "Gastos", iterador.getString("nombre"));
            }
            graficaBarras.graficar();
        } catch (SQLException ex) {
            Logger.getLogger(Graficador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void ingresosVsVentasVsGanancias(){
        try {
            limpiar();
            this.graficaBarras=new GraficaBarras("Ingresos vs Ventas  Vs Ganacias por Producto","Producto","",true,true);
            ResultSet iterador=controlInventory.getRow();
            float gasto,ingreso;
            while(iterador.next()){
                gasto=controlPurchase.getGastoTotal(iterador.getInt("idarticulos"));
                ingreso=controlSales.getIngresoTotal(iterador.getInt("idarticulos"));
                graficaBarras.anadirDato(gasto, "Gastos", iterador.getString("nombre"));
                graficaBarras.anadirDato(ingreso, "Ingresos", iterador.getString("nombre"));
                graficaBarras.anadirDato(ingreso-gasto, "Ganancias", iterador.getString("nombre"));
            }
            graficaBarras.graficar();
        } catch (SQLException ex) {
            Logger.getLogger(Graficador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void ingresosVsVentasVsGanancias(int month, int year){
        try {
            limpiar();
            this.graficaBarras=new GraficaBarras("Ingresos, Ventas  y balance por Producto ("+MESES[month]+"/"+year+")","Producto","$",true,true);
            ResultSet iterador=controlInventory.getRow();
            while(iterador.next()){
                float ingresos=controlSales.getIngresosMes(iterador.getInt("idarticulos"), month, year);
                float gastos=controlPurchase.getGastosMes(iterador.getInt("idarticulos"),month, year);
                graficaBarras.anadirDato(gastos, "Gastos", iterador.getString("nombre"));
                graficaBarras.anadirDato(ingresos, "Ingresos", iterador.getString("nombre"));
                graficaBarras.anadirDato(ingresos-gastos, "Ganancias", iterador.getString("nombre"));
            }
            graficaBarras.graficar();
        } catch (SQLException ex) {
            Logger.getLogger(Graficador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //Gasto


    

    public void gastoPorProductoMes(int month, int year){
        try {
            limpiar();
            ResultSet iterador=controlInventory.getRow();
            
            this.graficaCircular=new GraficaCircular("Gasto por producto ("+MESES[month]+"/"+year+")");
            while(iterador.next()){
                graficaCircular.anadirDato(iterador.getString("nombre"),controlPurchase.getGastosMes(iterador.getInt("idarticulos"),month,year));
            }
            graficaCircular.graficar();
            
        } catch (SQLException ex) {
            Logger.getLogger(Graficador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void gastoPorProducto(){
        try {
            limpiar();
            ResultSet iterador=controlInventory.getRow();
            this.graficaCircular=new GraficaCircular("Gasto por producto");
            while(iterador.next()){
                graficaCircular.anadirDato(iterador.getString("nombre"),controlPurchase.getGastoTotal(iterador.getInt("idarticulos")));
            }
            graficaCircular.graficar();
        } catch (SQLException ex) {
            Logger.getLogger(Graficador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void gastosAno(int year){
        limpiar();
        this.graficaBarras=new GraficaBarras("Gastos Totales Mensuales ("+year+")","Mes","$",true,true);
        for(int i=0;i<MESES.length;i++){
            graficaBarras.anadirDato(controlPurchase.getGastosMes(i, year),"Gastos",MESES[i]);
        }
        graficaBarras.graficar();
    }
    public void gastosAno(int id,int year){
        limpiar();
        this.graficaBarras=new GraficaBarras("Gastos Totales Mensuales "+controlInventory.getName(id)+" ("+year+")","Mes","$",true,true);
        for(int i=0;i<MESES.length;i++){
            graficaBarras.anadirDato(controlPurchase.getGastosMes(id,i, year),"Gastos",MESES[i]);
        }
        graficaBarras.graficar();
    }
    
/*    public void ingresosVsVentasTotalesMes(int month,int year){
        limpiar();
        this.graficaBarras=new GraficaBarras("Ingresos vs Ventas ("+MESES[month]+"/"+year+")","","$",true,true);
        graficaBarras.anadirDato(this.controlSales.getIngresosMes(month, year), "Ingresos", "Ingresos Totales");
        graficaBarras.anadirDato(this.controlPurchase.getGastosMes(month, year), "Gastos", "Gastos Totales");
        graficaBarras.graficar();
        
    }*/
    //Inventario
    public void unidadesVendidas(){
        try {
            limpiar(); 
            this.graficaBarras=new GraficaBarras("Unidades Vendidas Por Producto","Producto","Unidades Vendidas",true,false);
            
            ResultSet rs =controlInventory.getRow();
            while(rs.next()){
                graficaBarras.anadirDato(controlSales.getUnidadesVendidas(rs.getInt("idarticulos")),"Unidades Vendidas" , rs.getString("nombre"));
                //
            }
            graficaBarras.graficar();
        } catch (SQLException ex) {  
            Logger.getLogger(Graficador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void unidadesVendidas(int month, int year){
        try {
            limpiar(); 
            this.graficaBarras=new GraficaBarras("Unidades Vendidas Por Producto("+MESES[month]+"/"+year+")","Producto","Unidades Vendidas",true,false);
            
            ResultSet rs =controlInventory.getRow();
            while(rs.next()){
                graficaBarras.anadirDato(controlSales.getUnidadesVendidas(rs.getInt("idarticulos"),month,year),"Unidades Vendidas" , rs.getString("nombre"));
            }
            graficaBarras.graficar();
        } catch (SQLException ex) {  
            Logger.getLogger(Graficador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void inventario(){
        try {
            limpiar(); 
            this.graficaBarras=new GraficaBarras("Inventario","Producto","Unidades",true,false);
            
            ResultSet rs =controlInventory.getRow();
            this.graficaBarras.anadirDato(rs,"Unidades","cantidad","nombre");
            graficaBarras.graficar();
        } catch (SQLException ex) {  
            JOptionPane.showMessageDialog(panel, "Ha ocurrido un error. F");
        }
    }
    public void unidadesVendidasAno(int id,int year){
            limpiar(); 
            this.graficaBarras=new GraficaBarras("Unidades Vendidas Mensualmente "+controlInventory.getName(id)+" ("+year+")","Producto","Unidades Vendidas",true,true);
            
            
            for(int i=0;i<MESES.length;i++){
                this.graficaBarras.anadirDato(controlSales.getUnidadesVendidas(id,i,year),"Unidades Vendidas" ,MESES[i]);
            }
            graficaBarras.graficar();
    }

}

    

