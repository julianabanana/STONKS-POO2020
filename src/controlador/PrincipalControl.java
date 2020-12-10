
package controlador;
import modelo.*;
import vista.*;
import java.sql.Connection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

public class PrincipalControl implements ActionListener{
    private FramePrincipal frame;
    private ConClient controlCliente;
    private ConInventory controlInventory;
    private ConPurchase controlPurchase;
    private ConSale controlSale;
    private ConSupplier conSupplier;
    private ControlGraficosPanel conGraficos;
    private PanelInventory frameInventory;
    private Connection conexion;
    private ConsultInventory consultInventory;
    private GraficosPanel panelGraficos;
    private Inventory inventory;
    public PrincipalControl(FramePrincipal frame,Connection conexion){
        this.frame=frame;
        this.conexion=conexion;
        //this.frameInventory=frameInventory;
        startPanels();
        inicialControladorPrincipal();
        starControladores();
        anadirPaneles();
        
    }
    public void inicialControladorPrincipal(){
        frame.anadirButtonsActionListener(this);
    }
    public void startPanels(){
        panelGraficos= new GraficosPanel();
        this.frameInventory=new PanelInventory();
    }
    public void starControladores(){
        //this.controlInventory=new ConInventory(inventory,consultInventory,frameInventory);
        this.conGraficos= new ControlGraficosPanel(panelGraficos,conexion);
    }
    public void anadirPaneles(){
        frame.addPanelGraficos(panelGraficos);
        JPanel panelInventory=new JPanel();
        panelInventory.add(frameInventory.getContentPane());
        frame.addPanelInventory(panelInventory);
        frame.addPanels();
    }
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==frame.getBtnGraficas()){
            frame.hidePanelGraficos();
            frame.unhidePanelInventory();
        }else if(e.getSource()==frame.getBtnInventario()){
            frame.unhidePanelInventory();
            frame.hidePanelGraficos();
        }else{
            frame.hidePanelGraficos();
            frame.hidePanelInventory();
        }
    }
    
}
