/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graficador;

import javax.swing.JFrame;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.statistics.HistogramDataset;
import org.jfree.data.xy.IntervalXYDataset;

/**
 *
 * @author jczam
 */
public class Histograma {
    private String titulo;
    private String titulox;
    private String tituloy;
    private JFreeChart grafico;
    private IntervalXYDataset datos;
    private PlotOrientation orientacion;
    private void crearDataset(double[] listaDatos,int intervalos){
        HistogramDataset dataset=new HistogramDataset();
        dataset.addSeries(this.titulo,listaDatos,intervalos);
        this.datos=dataset;
    }
    public void crearChart(){
        grafico=ChartFactory.createHistogram(titulo, titulox, tituloy, datos, orientacion, true, true, true);
    }
    public void mostrar(){ //Esto creará una "ventana emergente" por decirlo así, de la gráfica
        JFrame ventana=new JFrame(this.titulo); //Ventana "emergente"
        ventana.getContentPane().add(new ChartPanel(grafico));
        ventana.pack();
        ventana.setSize(1000,1000);
        ventana.setVisible(true);
        
    }
    public void graficar(){ //Esto es para graficar en una ventana aparte
        crearChart();
        mostrar(); 
    }
    public void graficar(JPanel j){ //Para graficar dentro de un panel
        crearChart();
        j.setLayout(new java.awt.BorderLayout());
        j.add(new ChartPanel(grafico));
        j.validate();
    }
    public Histograma(String titulo,String titulox,String tituloy, boolean vertical,double[] listaDatos, int intervalos){
        this.titulo=titulo;
        this.titulox=titulox;
        this.tituloy=tituloy;
        if(vertical){
            this.orientacion=PlotOrientation.VERTICAL;
        }else{
            this.orientacion=PlotOrientation.HORIZONTAL;
        }
        crearDataset(listaDatos,intervalos);
    }
}
