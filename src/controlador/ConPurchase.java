package controlador;

import java.awt.event.*;
import javax.swing.JOptionPane;

import modelo.ConsultPurchase;
import modelo.Purchase;
import vista.PanelPurchase;

public class ConPurchase implements ActionListener{
	
	private Purchase purchase;
	private ConsultPurchase query;
	private PanelPurchase panel;

	//constructor
	public ConPurchase(Purchase purchase, ConsultPurchase query, PanelPurchase panel) {
		
		this.purchase = purchase;
		this.query = query;
		this.panel = panel;
		this.panel.getBtnAnadir().addActionListener(this);
		fillCombos();
		
	}
	//method for initializing the view (title and location)
	public void start() {
		panel.setTitle("Compra");
		panel.setLocationRelativeTo(null);
	}
	
	//methods that listen to the clicks (events)
	public void actionPerformed(ActionEvent e){
		//Adding button
		if(e.getSource() == panel.getBtnAnadir()){
			
			int idprod = query.getId("articulos","idarticulos",((String) panel.getComboProducto().getSelectedItem()));
			int idprov = query.getId("proveedores","idproveedores",((String) panel.getComboProveedor().getSelectedItem()));
			int cantidad = Integer.parseInt(panel.getTxtCantidad().getText());
			
			purchase.setIdproducto(idprod);
			purchase.setProveedor(idprov);
			purchase.setCantidad(cantidad);
			purchase.setCostoIndividual(Integer.parseInt(panel.getTxtPrecioDeCompra().getText()));

			clean();
			if(query.register(purchase)){
				clean();
				JOptionPane.showMessageDialog(null, "Compra guardado");
			}else {
				JOptionPane.showMessageDialog(null, "Ha ocurrido un error. Debe anadir producto, proveedor, cantidad y precio de compra.");

			}
		}
	}
	
	//method for cleaning the boxes
	public void clean(){
		panel.getTxtCantidad().setText(null);
		panel.getTxtPrecioDeCompra().setText(null);
	}
	
	public void fillCombos() {
			panel.fillCombo(panel.getComboProducto(),"articulos","nombre");
			panel.fillCombo(panel.getComboProveedor(),"proveedores","nombre");
	}
	
}
