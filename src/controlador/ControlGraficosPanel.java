package controlador;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import vista.GraficosPanel;
import java.sql.Connection;
public class ControlGraficosPanel implements ChangeListener{
    private GraficosPanel panel;
    private ControlGraphicsGastos controlGastos;
    private ControlGraphicsBalance controlBalance;
    private ControlGraphicsIngresos controlIngresos;
    private ControlGraphicsInventory controlInventario;
    public ControlGraficosPanel(GraficosPanel panel,Connection conexion){
        this.panel=panel;
        controlInventario= new ControlGraphicsInventory(panel.getPanelInventario(),conexion);
        controlIngresos=new ControlGraphicsIngresos(panel.getPanelIngresos(),conexion);
        controlBalance=new ControlGraphicsBalance(panel.getPanelBalance(),conexion);
        controlGastos=new ControlGraphicsGastos(panel.getPanelGastos(),conexion);
        startControl();
    }
    public void startControl(){
        
        this.panel.addChangeListener(this);
    }

    
    public void stateChanged(ChangeEvent e) {
        controlGastos.updateProductComboBox();
        controlInventario.updateProductComboBox();
        controlIngresos.updateProductComboBox();
        controlBalance.updateProductComboBox();
        
                
                
    }
}
