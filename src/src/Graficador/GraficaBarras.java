package Graficador;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import java.sql.ResultSet;
import java.sql.SQLException;
public class GraficaBarras {
    private final String titulo;
    private final String titulox;
    private final String tituloy;
    private JFreeChart grafico;
    private DefaultCategoryDataset datos;
    private final boolean VERCATEGORIA;
    private final PlotOrientation ORIENTACION;
    public GraficaBarras(String titulo,String titulox,String tituloy, boolean vertical,boolean verCategoria){
        this.titulo=titulo;
        this.titulox=titulox;
        this.tituloy=tituloy;
        this.VERCATEGORIA=verCategoria;
        if(vertical){
            this.ORIENTACION=PlotOrientation.VERTICAL;
        }else{
            this.ORIENTACION=PlotOrientation.HORIZONTAL;
        }
        crearDataset();
    }
    private void crearDataset(){
        this.datos=new DefaultCategoryDataset();
    }
    public void reiniciarDataset(){
        crearDataset();
    }
    public void anadirDato(double value,String categoria,String nombre){
        this.datos.addValue(value,categoria,nombre); //Agrega una barra, dependiendo de la categoría se hace el color
    }
    public void anadirDato(int value,String categoria,String nombre){
        this.datos.addValue(value,categoria,nombre); //Agrega una barra, dependiendo de la categoría se hace el color
    }
    public void anadirDato(ResultSet rs,String categoria,int indexValor,int indexNombre) throws SQLException{
    /*Recibe un rs(Itera en una tablas sql), la llave/index (String) de la columna del 
     valor numérico y del nombre para que agregue el dato de cada fila. Y un String que 
    especifique la categoria*/    
        while(rs.next()){
            anadirDato(rs.getInt(indexValor),categoria,rs.getString(indexNombre));
        }
    }
    public void anadirDato(ResultSet rs,String categoria,String indexValor,String indexNombre) throws SQLException{
    /*Recibe un rs(Itera en una tablas sql), el index (int) de la columna del 
     valor numérico y del nombre para que agregue el dato de cada fila. Y un String que 
    especifique la categoria*/   
        while(rs.next()){
            anadirDato(rs.getInt(indexValor),categoria,rs.getString(indexNombre));
        }
    }
    public void anadirDato(ResultSet rs,String categoria,String indexValor,String indexNombre,int tope) throws SQLException{
    /*Recibe un rs(Itera en una tablas sql), el index (int) de la columna del 
     valor numérico y del nombre para que agregue el dato de cada fila. Y un String que 
    especifique la categoria*/   
        while(rs.next() && tope-->0){
            anadirDato(rs.getInt(indexValor),categoria,rs.getString(indexNombre));
        }
    }
    public void crearChart(){
        /*Crea el Chart, con el metodo estático de ChartFactory,
        createBarChart, el específico para eta clase de gráfica (Barras)*/
        grafico=ChartFactory.createBarChart( 
                this.titulo, //Titulo Gráfica
                this.titulox, //...
                this.tituloy, //...
                this.datos, //Conjunto de datos que va a graficar
                this.ORIENTACION, //orientación gráfico
                VERCATEGORIA, //Etiqueta categoria
                true, //Al pasar el mouse mostra´ra el valor de la barra
                false //Uso de URL, no es muy necesario de momento o idk
        );
    }
    public void mostrar(){
        /*Muestra la gráfica en un JFrame (Ventana ) independiente del que se instancie
        */
        JFrame ventana=new JFrame(this.titulo); //Ventana "emergente"
        ventana.getContentPane().add(new ChartPanel(grafico));
        ventana.setVisible(true);
        ventana.setSize(500,500);
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
    
}
