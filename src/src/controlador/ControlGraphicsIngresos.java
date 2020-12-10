package controlador;

import Graficador.Graficador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.GraficosPestana;
import java.sql.Connection;
import javax.swing.JOptionPane;
import modelo.*;
public class ControlGraphicsIngresos implements ActionListener{
    private GraficosPestana panel;
    private Graficador graficador;
    private ConsultInventory consultInventory;
    private static final String[] COMBOBOXITEMS={"Ingresos Totales por Producto","Ingresos por Producto (Mes)","Ingresos Totales Año","Ingresos de Producto (Año)"};
    public ControlGraphicsIngresos(GraficosPestana panel,Connection conexion){
        this.panel=panel;
        this.graficador=new Graficador(conexion);
        this.consultInventory=new ConsultInventory(conexion);
        
        startControl();
    }
    private void startControl(){
        panel.addComboBoxActionListener( e -> ComboBoxIngresosActionPerformed(e));
        panel.fillProductComboBox(consultInventory.getRow());
        panel.fillGraficasComboBox(COMBOBOXITEMS);
        panel.addALButton(this);
    }
    public void actionPerformed(ActionEvent e){
        int ano;
        if(e.getSource()==panel.getButtonGraficar()){
            switch(panel.getComboBoxGraficasIndex()){
                case 0:
                    graficador.ingresosPorProducto();
                    break;
                case 1:
                    ano=panel.getYear();
                    if(ano>0){
                        graficador.ingresosPorProductoMes(panel.getMonth(),panel.getYear());
                    }else{
                        JOptionPane.showMessageDialog(panel, "Por favor, ingrese un año válido");
                    }
                    
                    break;
                case 2:
                    ano=panel.getYear();
                    if(ano>0){
                        graficador.ingresosAno(panel.getYear());
                    }else{
                        JOptionPane.showMessageDialog(panel, "Por favor, ingrese un año válido");
                    }
                    
                    break;
                case 3:
                    ano=panel.getYear();
                    if(ano>0){
                        graficador.ingresosAno(consultInventory.getIdproducto(panel.getProduct()),panel.getYear());
                    }else{
                        JOptionPane.showMessageDialog(panel, "Por favor, ingrese un año válido");
                    }
                    
                    break;
                    
            }
        }
    }
    public void updateProductComboBox(){
        panel.clearProductComboBox();
        panel.fillProductComboBox(consultInventory.getRow());
    }
    private void ComboBoxIngresosActionPerformed(ActionEvent evt) {
        int selectedItem=panel.getComboBoxGraficasIndex();
        switch(selectedItem){
            case 0:
                panel.hideDate();
                panel.hideProduct();
                break;
            case 1://
                panel.hideProduct();
                panel.unhideDate();
                break;
            case 2:
                panel.hideProduct();
                panel.hideMonth();
                panel.unhideYear();
                break;
            case 3:
                panel.unhideProduct();
                panel.hideMonth();
                panel.unhideYear();
                break;
    }
     
    }
}
