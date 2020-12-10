package controlador;

import Graficador.Graficador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import javax.swing.JOptionPane;
import modelo.ConsultInventory;
import vista.GraficosPestana;

public class ControlGraphicsBalance implements ActionListener{
    private GraficosPestana panel;
    private Graficador graficador;
    private ConsultInventory consultInventory;
    private static final String MENSAJEANOVALIDO="Por favor, ingrese un año válido";
    private static final String[] COMBOBOXITEMS={"Ingresos vs Ventas Totales","Ingresos vs Ventas (Mes)","Ingresos vs Ventas/Producto(Mes)","Ingresos vs Ventas por producto","Ingresos vs Ventas por producto(Mes)","Ingresos vs Ventas vs Ganancias Totales","Ingresos vs Ventas vs Ganancias Totales(Mes)"};
    public ControlGraphicsBalance(GraficosPestana panel,Connection conexion){
        this.panel=panel;
        this.graficador=new Graficador(conexion);
        this.consultInventory=new ConsultInventory(conexion);
        startControl();
    }
    public void startControl(){
        panel.addComboBoxActionListener(ae->ComboBoxBalanceActionPerformed(ae));
        panel.fillGraficasComboBox(COMBOBOXITEMS);
        panel.fillProductComboBox(consultInventory.getRow());
        panel.addALButton(this);
    }
    public void actionPerformed(ActionEvent ae){
        int ano;

        if(ae.getSource()==panel.getButtonGraficar()){
            switch(panel.getComboBoxGraficasIndex()){
                case 0:
                    graficador.ingresosVsVentasTotales();
                    break;
                case 1:
                    ano=panel.getYear();
                    if(ano>0){
                        graficador.ingresosVsVentasTotalesMes(panel.getMonth(), ano);
                    }else{
                        JOptionPane.showMessageDialog(panel,MENSAJEANOVALIDO);
                    }
                    
                    break;
                case 2:
                    ano=panel.getYear();
                    if(ano>0){
                        graficador.ingresosVsVentasTotalesMes(consultInventory.getIdproducto(panel.getProduct()), panel.getMonth(), ano);
                    }else{
                        JOptionPane.showMessageDialog(panel, MENSAJEANOVALIDO);
                    }
                    break;
                case 3:
                    graficador.ingresosVsVentasPorProducto();
                    break;
                case 4:
                    ano=panel.getYear();
                    if(ano>0){
                        graficador.ingresosVsVentasPorProductoMes(panel.getMonth(),ano);
                    }else{
                        JOptionPane.showMessageDialog(panel, MENSAJEANOVALIDO);
                    }
                    break;
                case 5:
                    graficador.ingresosVsVentasVsGanancias();
                    break;
                case 6:
                    ano=panel.getYear();
                    if(ano>0){
                        graficador.ingresosVsVentasVsGanancias(panel.getMonth(),ano);
                    }else{
                        JOptionPane.showMessageDialog(panel, MENSAJEANOVALIDO);
                    }
                    break;
                    
            }
        }
    }
    public void updateProductComboBox(){
        panel.clearProductComboBox();
        panel.fillProductComboBox(consultInventory.getRow());
    }
    private void ComboBoxBalanceActionPerformed(ActionEvent ae){
        int selectedItem=panel.getComboBoxGraficasIndex();
        switch(selectedItem){
            case 0:
                panel.hideProduct();
                panel.hideDate();
                break;
            case 1:
                panel.unhideDate();
                panel.hideProduct();
                break;
            case 2:
                panel.unhideDate();
                panel.unhideProduct();
                break;
            case 3:
                panel.hideProduct();
                panel.hideDate();
                break;
            case 4:
                panel.hideProduct();
                panel.unhideDate();
                break;
            case 5:
                panel.hideProduct();
                panel.hideDate();
                break;
            case 6:
                panel.unhideDate();
                panel.hideProduct();
                break;
            
    }
    }
}
