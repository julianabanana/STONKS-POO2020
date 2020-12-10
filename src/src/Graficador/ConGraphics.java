/*
package controlador;

import Graficador.Graficador;
import vista.FrameGraphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class ConGraphics implements ActionListener{
    private Graficador graficador;
    private FrameGraphics frame;
    public ConGraphics(FrameGraphics frame,Connection conexion){
        this.frame=frame;
        this.graficador=new Graficador(frame.getLienzo(),conexion);
        this.frame.addGraficarAction(this);
    }
    
    public void start(){
        frame.setTitle("Graficador");
        frame.setLocationRelativeTo(null);
    }
    public void actionPerformed(ActionEvent e){     
        if(e.getSource()==frame.getBtnGraficar()){
            switch(frame.getSelectedItem()){
                case 0:
                    graficador.inventario(); 
                    break;
                case 1:
                    graficador.productosMasCaros(); 
                    break; 
                case 2:
                    graficador.ingresosVsVentasTotales();
                    break;
                case 3:
                    graficador.ingresosPorProducto();
                    break;
                case 4:
                    graficador.gastoPorProducto();
                    break;
                case 5:
                    graficador.ingresosVsVentasPorProducto();
                    break;
                case 6:
                    graficador.ingresosVsVentasVsGanancias();
                    break;
                case 7:
                    graficador.unidadesVendidas();
                    break;
            }
        }
    }
} */
