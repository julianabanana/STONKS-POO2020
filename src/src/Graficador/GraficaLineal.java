
package Graficador;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
public class GraficaLineal {
    final private String titulo; //Titulo del gráfico
    final private String titulox; //Titulo en el eje x
    final private String tituloy; //Titulo en el eje y 
    private DefaultCategoryDataset datos; //Conjunto de datos
    private JFreeChart grafico; //El gráfico como tal
    final private PlotOrientation orientacion; //Orientación de la gráfica (true:vertical,false:horizontal)
    public void crearDataset(){ //Se instancia el conjunto de datos donde se agregará la información a graficar
        this.datos=new DefaultCategoryDataset();
    }
    public void reiniciarDataset(){ //Se limpia el conjunto de datos
        datos.clear();
    }
    public void anadirDato(double x, String nombre,String comparable){ //Se añade info al dataset, siendo x el valor numérico, el nombre se sobreentiende..., el comparable es el valor en x para que sea ordenado.
        datos.addValue(x, nombre, comparable);
    }
    public void mostrar(){ //Cuando se quiera mostrar en un frame aparte
        JFrame ventana=new JFrame(this.titulo); //Ventana "emergente"
        ventana.getContentPane().add(new ChartPanel(grafico));
        ventana.setVisible(true);
        ventana.setSize(500,500);
        ventana.setLocationRelativeTo(null);
        ventana.setMinimumSize(new Dimension(300,300));
        ventana.pack();
        
    }
    public void graficar(){
        crearChart();
        mostrar();
    }
    public void graficar(JPanel j){
        crearChart();
        j.setLayout(new java.awt.BorderLayout());
        j.add(new ChartPanel(grafico));
        j.validate();
    }
    public void crearChart(){ //Se crea el grafico
        grafico=ChartFactory.createLineChart(
                titulo,
                titulox,
                tituloy, 
                datos,
                orientacion,
                true, //
                true, //
                false); //URL's que no son necesarias
    }


    public GraficaLineal(String titulo,String titulox,String tituloy, boolean vertical){ //Instanciacion del objeto, en caso de que se quiera horizontal, se da false
        this.titulo=titulo;
        this.titulox=titulox;
        this.tituloy=tituloy;
        if(vertical){
            this.orientacion=PlotOrientation.VERTICAL;
        }else{
            this.orientacion=PlotOrientation.HORIZONTAL;
        }
        crearDataset();
    }
    public GraficaLineal(String titulo,String titulox,String tituloy){ //Instanciacion del objeto, vertical por defecto
        this(titulo,titulox,tituloy,true);
    }
}
