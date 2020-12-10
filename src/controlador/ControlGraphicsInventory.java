package controlador;

import Graficador.Graficador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.GraficosPestana;
import java.sql.Connection;
import javax.swing.JOptionPane;
import modelo.ConsultInventory;
public class ControlGraphicsInventory implements ActionListener{
    private GraficosPestana panel;
    private Graficador graficador;
    private ConsultInventory consultInventory;
    private static final String MENSAJEANOVALIDO="Por favor, ingrese un año válido";
    private static final String[] COMBOBOXITEMS={"Inventario","Unidades Vendidas","Unidades vendidas mes","Unidades Vendidas (Año)"};
    public ControlGraphicsInventory(GraficosPestana panel,Connection conexion){
        this.panel=panel;
        this.graficador=new Graficador(conexion);
        this.consultInventory=new ConsultInventory(conexion);
        startControl();
    }
    public void startControl(){
        panel.addComboBoxActionListener(ae->ComboBoxIngresosActionPerformed(ae));
        panel.fillProductComboBox(consultInventory.getRow());
        panel.fillGraficasComboBox(COMBOBOXITEMS);
        panel.hideDate();
        panel.hideProduct();
        panel.addALButton(this);
    }
    
    public void actionPerformed(ActionEvent ae){
        int ano;
        if(ae.getSource()==panel.getButtonGraficar()){
            switch(panel.getComboBoxGraficasIndex()){
                case 0:
                    graficador.inventario();
                    break;
                case 1:
                    graficador.unidadesVendidas();
                    break;
                case 2:
                    ano=panel.getYear();
                    if(ano>0){
                        graficador.unidadesVendidas(panel.getMonth(), ano);
                    }else{
                        JOptionPane.showMessageDialog(panel,MENSAJEANOVALIDO);
                    }
                    break;
                case 3:
                    ano=panel.getYear();
                    if(ano>0){
                        graficador.unidadesVendidasAno(consultInventory.getIdproducto(panel.getProduct()), ano);
                    }else{
                        JOptionPane.showMessageDialog(panel,MENSAJEANOVALIDO);
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
                panel.hideDate();
                panel.hideProduct();
                break;
            case 2:
                panel.unhideDate();
                panel.hideProduct();
                break;
            case 3:
                panel.unhideYear();
                panel.hideMonth();
                panel.unhideProduct();
                
        }
    }
    public void updateProductComboBox(){
        panel.clearProductComboBox();
        panel.fillProductComboBox(consultInventory.getRow());
    }
}
