
package stonks;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import Graficador.*;
import vista.*;
import modelo.*;
import java.text.SimpleDateFormat;
import java.sql.*;
import java.util.Arrays;
import controlador.*;
import java.awt.Container;
import javax.swing.JFrame;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
public class STONKS {
    public static int getTotal(int x , int y,int d){
        return (int)(y*x*(100-d)/100.0);
    }
    public static void main(String[] args) {
        Conexion c = new Conexion(); 
        Connection conexion=c.getConexion();
        
        Graficador g=new Graficador( conexion);
        ConsultInventory ci=new ConsultInventory(conexion);
        
        //Framexd frame=new Framexd();
        //Container container=frame.getContentPane();
        /*GraficosPanel fp=new GraficosPanel();
        
        JFrame framee=new JFrame();
        framee.setSize(450,300);
        framee.setResizable(false);
        framee.setLocationRelativeTo(null);
        framee.setTitle("XDD");
        framee.getContentPane().add(fp);
        ControlGraficosPanel controlTotal=new ControlGraficosPanel(fp,conexion);
        framee.setDefaultCloseOperation(EXIT_ON_CLOSE);
        framee.setVisible(true);*/
        /*Inventory inventory=new Inventory();
        ConsultInventory consultInventory=new ConsultInventory(conexion);
        Client client=new Client();
        ConsultClient consultClient=new ConsultClient(conexion);
        Purchase compra=new Purchase();
        ConsultPurchase consultPurchase=new ConsultPurchase(conexion);
        ConsultSupplier consultSupplier=new ConsultSupplier(conexion);
        Supplier suplier=new Supplier();
        Sale sale=new Sale();
        ConsultSales consultSale=new ConsultSales(conexion);*/
        //Inventory
        
        /*PanelInventory frameInventory=new PanelInventory();
        ConInventory controlInventory=new ConInventory(inventory,consultInventory,frameInventory);
        frameInventory.setSize(450,300);
        frameInventory.setVisible(true);
        frameInventory.setDefaultCloseOperation(EXIT_ON_CLOSE);*/
        
        //Client
        /*PanelClient frameCliente=new PanelClient();
        ConClient controlClient=new ConClient(client,consultClient,frameCliente);
        frameCliente.setSize(450,300);
        frameCliente.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frameCliente.setVisible(true);*/
        //Purchase
        /*PanelPurchase framePurchase=new PanelPurchase();
        ConPurchase controlPurchase=new ConPurchase(compra,consultPurchase,framePurchase);
        framePurchase.setSize(450,300);
        framePurchase.setDefaultCloseOperation(EXIT_ON_CLOSE);
        framePurchase.setVisible(true);*/
        /*PanelSupplier frameSupplier=new PanelSupplier();
        frameSupplier.setSize(450,300);
        
        frameSupplier.setDefaultCloseOperation(EXIT_ON_CLOSE);
        ConSupplier controlSupplier=new ConSupplier(suplier,consultSupplier,frameSupplier);
        frameSupplier.setVisible(true);*/
        /*PanelSales panelSales=new PanelSales();
        ConSale controlSale=new ConSale(consultSale,panelSales);
        //panelSales.setSize(450,300);
        
        panelSales.setDefaultCloseOperation(EXIT_ON_CLOSE);
        panelSales.setVisible(true);*/
        FramePrincipal frameprincipal=new FramePrincipal();
        PrincipalControl controlSupremo= new PrincipalControl(frameprincipal,conexion);
        frameprincipal.setVisible(true);
        
    }
    
    
}
