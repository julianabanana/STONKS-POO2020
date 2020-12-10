package Graficador;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GraficaCircular {
    private final String titulo; //Titulo del gráfico
    private JFreeChart grafico; //El gráfico como tal
    private DefaultPieDataset datos; //Conjunto de datos
    
    public GraficaCircular(String titulo){
        this.titulo=titulo;
        crearDataset();
    }
    private void crearDataset(){ //Se instancia el conjunto de datos donde se agregará información
        this.datos=new DefaultPieDataset();
    }
    public void anadirDato(String nombre, double x){
//Se añade info al dataset, solo nombre del pedazo de la torta y un valor numérico
        this.datos.setValue(nombre,x);
    }
    public void anadirDato(ResultSet rs,String keyNombre,String keyX) throws SQLException{ 
    /*Recibe un rs(Itera en una tablas sql), la llave/index (String) de la columna del 
    nombre y la del valor numérico para que agregue el dato de cada fila.*/
        while(rs.next()){
            anadirDato(rs.getString(keyNombre),rs.getFloat(keyX));
        }
    }
    
    public void anadirDato(ResultSet rs,int indexNombre,int indexX) throws SQLException{ 
    /*Recibe un rs(Itera en una tablas sql), el index (int) de la columna del nombre y
    y la del valor numérico para que agregue el dato de cada fila.*/
        while(rs.next()){
            anadirDato(rs.getString(indexNombre),rs.getFloat(indexX));
        }
    }
    public void mostrar(){
        /*Muestra la gráfica en un JFrame (Ventana ) independiente del que se instancie
        */
        JFrame ventana=new JFrame(this.titulo); //Ventana "emergente"
        ventana.getContentPane().add(new ChartPanel(grafico));
        ventana.setVisible(true);
        ventana.setSize(1000,1000);
        ventana.setLocationRelativeTo(null);
        ventana.setMinimumSize(new Dimension(300,300));
        ventana.pack();
    }
    public void graficar(){
        /*Crea el Chart y el JFrame independiente con la grafica */
        crearChart();
        mostrar();
    }
    public void graficar(JPanel j){
        /*Crea el Chart y lo añade a un JPanel como parámetro (Configura el Layout del JPanel)*/
        crearChart();
        j.setLayout(new java.awt.BorderLayout());
        j.add(new ChartPanel(grafico));
        j.validate();
    }
    public void crearChart(){
        /*Crea el Chart, con el metodo estático de ChartFactory,
        createPieChart, el específico para eta clase de gráfica (Torta)*/
        this.grafico=ChartFactory.createPieChart(this.titulo, datos, true, true, false);
    }
    
}
