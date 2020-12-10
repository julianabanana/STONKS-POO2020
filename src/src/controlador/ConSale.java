package controlador;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import modelo.ConsultSales;
import modelo.Sale;
import vista.PanelSales;

public class ConSale implements ActionListener{
	
	private ConsultSales query;
	private PanelSales frame;
	private ArrayList<Sale> list = new ArrayList<>();
	
	public ConSale(ConsultSales query, PanelSales frame) {
		
		this.query = query;
		this.frame = frame;
		this.frame.getBtnAnadirProducto().addActionListener(this);
		this.frame.getBtnGenerarVenta().addActionListener(this);
		this.frame.getBtnDescartarVenta().addActionListener(this);
		fillCombos();
		
	}
	//method for initializing the view (title and location)
	public void start() {
		frame.setTitle("Inventario");
		frame.setLocationRelativeTo(null);
	}
	
	//method for cleaning the boxes
	public void clean(){
		frame.getTextFieldCantidad().setText(null);
		frame.getLblResult().setText(null);
                frame.setTotal(0);
		frame.removeTable();
	}
	
	public void fillCombos() {
		frame.fillCombo(frame.getComboBoxCliente(),"clientes");
		frame.fillCombo(frame.getComboBoxProducto(),"articulos");		
	}
	
	public void actionPerformed(ActionEvent e) {
		//Boton anadir producto
		if(e.getSource() == frame.getBtnAnadirProducto()){
                    try{
			Sale sale = new Sale();
			int existencias = query.getItem("articulos","cantidad",((String) frame.getComboBoxProducto().getSelectedItem()));//como retorna int, tambien sirve
			int cantidad = Integer.parseInt(frame.getTextFieldCantidad().getText());
                        if(cantidad<0){
                            throw new NumberFormatException();
                        }
			float costo = (float) query.getItem("articulos","precio",((String) frame.getComboBoxProducto().getSelectedItem()));
			String nombre = (String) frame.getComboBoxProducto().getSelectedItem();
			sale.setIdcliente(query.getItem("clientes","idclientes",(String) frame.getComboBoxCliente().getSelectedItem()));
			sale.setIdproducto(query.getItem("articulos","idarticulos",nombre));
			sale.setCosto(costo);
			sale.setCantidad(cantidad);
			sale.setTotal();
			if(query.newAmount(sale)>0) {
				
				list.add(sale);
				frame.anadirATabla(nombre, sale);
				frame.setTotal(costo);
			}else {
				JOptionPane.showMessageDialog(null, "No hay suficientes artículos para completar la venta.");
			}
			frame.getTextFieldCantidad().setText(null);
			
			//falta mostrarlo en tabla
                        }catch(NumberFormatException exeption){
                            JOptionPane.showMessageDialog(null, "Ingrese una cantidad válida");
                        }
                    
                }
		
		if(e.getSource() == frame.getBtnDescartarVenta()){
			int a = JOptionPane.showConfirmDialog(null,"Desea descartar toda la venta?", "Confirmacion", JOptionPane.YES_NO_OPTION);
			if(a==0) {
				list.clear();
				clean();
				JOptionPane.showMessageDialog(null, "Venta descartada");
			}
			
		}
		if(e.getSource() == frame.getBtnGenerarVenta()){
			for(Sale sale:list) {
				if(query.register(sale)){
					
				}else {
					JOptionPane.showMessageDialog(null, "Ha ocurrido un error. La venta se ha descartado.");
					break;
				}
			}
			JOptionPane.showMessageDialog(null, "Venta Generada");
			list.clear();
			clean();
			
		}
	}
	

}
