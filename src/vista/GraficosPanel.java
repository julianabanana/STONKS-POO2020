package vista;
import javax.swing.JTabbedPane;
public class GraficosPanel extends JTabbedPane{
    private GraficosPestana panelIngresos,panelGastos,panelBalance,panelInventario;
    public GraficosPanel(){
        super();
        
        this.startComponents();
    }
    public void startComponents(){
        
        panelIngresos=new GraficosPestana();
        panelGastos=new GraficosPestana();
        panelBalance=new GraficosPestana();
        panelInventario=new GraficosPestana();
        
        addPestanas();
        this.setSize(430,300);
    }
    public void addPestanas(){
        this.add("Ingresos",panelIngresos);
        this.add("Gastos",panelGastos);
        this.add("Balance",panelBalance);
        this.add("Inventario",panelInventario);
    }
    public GraficosPestana getPanelIngresos() {
        return panelIngresos;
    }

    public GraficosPestana getPanelGastos() {
        return panelGastos;
    }

    public GraficosPestana getPanelBalance() {
        return panelBalance;
    }

    public GraficosPestana getPanelInventario() {
        return panelInventario;
    }
    
        
}
