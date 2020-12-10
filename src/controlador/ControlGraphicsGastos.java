package controlador;

import Graficador.Graficador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.GraficosPestana;
import java.sql.Connection;
import javax.swing.JOptionPane;
import modelo.ConsultInventory;
public class ControlGraphicsGastos implements ActionListener {
    private GraficosPestana panel;
    private Graficador graficador;
    private ConsultInventory consultInventory;
    private static final String MENSAJEANOVALIDO="Por favor, ingrese un año válido";
    static final String[] COMBOBOXITEMS={"Gasto Por Producto","Gasto Por Producto (Mes)","Gasto Total (Año)","Gasto Producto (Año)"};
    public ControlGraphicsGastos(GraficosPestana panel,Connection conexion){
        this.panel=panel;
        this.graficador=new Graficador(conexion);
        this.consultInventory=new ConsultInventory(conexion);
        startControl();
    }
    public void startControl(){
        panel.addComboBoxActionListener(ae->ComboBoxIngresosActionPerformed(ae));
        panel.fillProductComboBox(consultInventory.getRow());
        
        panel.addALButton(this);
        panel.fillGraficasComboBox(COMBOBOXITEMS);
        panel.hideDate();
        panel.hideProduct();
    }
    public void updateProductComboBox(){
        panel.clearProductComboBox();
        panel.fillProductComboBox(consultInventory.getRow());
    }
    public void actionPerformed(ActionEvent e){
        int ano;
        if(e.getSource()==panel.getButtonGraficar()){
            switch(panel.getComboBoxGraficasIndex()){
            case 0:
                graficador.gastoPorProducto();
                break;
            case 1:
                ano=panel.getYear();
                if(ano>0){
                    graficador.gastoPorProductoMes(panel.getMonth(),ano);
                }else{
                    JOptionPane.showMessageDialog(panel, MENSAJEANOVALIDO);
                }
                
                break;
            case 2:
                ano=panel.getYear();
                if(ano>0){
                    graficador.gastosAno(ano);
                }else{
                    JOptionPane.showMessageDialog(panel, MENSAJEANOVALIDO);
                }
                
                break;
            case 3:
                ano=panel.getYear();
                if(ano>0){
                    graficador.gastosAno(consultInventory.getIdproducto(panel.getProduct()),ano);
                }else{
                    JOptionPane.showMessageDialog(panel, MENSAJEANOVALIDO);
                }
                break;
            }
        }
    }
    public void ComboBoxIngresosActionPerformed(ActionEvent e){
        int selectedItem=panel.getComboBoxGraficasIndex();
        switch(selectedItem){
            case 0:
                panel.hideDate();
                panel.hideProduct();
                break;
            case 1:
                panel.unhideDate();
                panel.hideProduct();
                break;
            case 2:
                panel.hideMonth();
                panel.hideProduct();
                panel.unhideYear();
                break;
            case 3:
                panel.hideMonth();
                panel.unhideProduct();
                panel.unhideYear();
                break;
        }
    }
    
}
