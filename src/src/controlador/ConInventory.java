package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

import modelo.ConsultInventory;
import modelo.Inventory;
import vista.PanelInventory;

public class ConInventory implements ActionListener{
	
	private Inventory inventory;
	private ConsultInventory query;
	private PanelInventory frame;
	
	
	//constructor
	public ConInventory(Inventory inventory, ConsultInventory query, PanelInventory frame) {
		
		this.inventory = inventory;
		this.query = query;
		this.frame = frame;
		this.frame.getBtnBuscar().addActionListener(this);
		this.frame.getBtnAnadir().addActionListener(this);
		this.frame.getBtnEliminar().addActionListener(this);
		fillCombos();
		
	}
	//method for initializing the view (title and location)
	public void start() {
		frame.setTitle("Inventario");
		frame.setLocationRelativeTo(null);
	}
	
	//methods that listen to the clicks (events)
	public void actionPerformed(ActionEvent e){
		//Adding button
		if(e.getSource() == frame.getBtnAnadir()){
			inventory.setNombre(frame.getTxtNombre().getText());
			inventory.setCantidad(Integer.parseInt(frame.getTxtCantidad().getText()));
			inventory.setPrecio(Float.parseFloat(frame.getTxtPrecioDeVenta().getText()));
			if(query.register(inventory)){
				JOptionPane.showMessageDialog(null, "Nuevo artículo guardado");
				clean();
				fillCombos();
			}else {
				JOptionPane.showMessageDialog(null, "Ha ocurrido un error. Debe anadir nombre y cantidad.");

			}
		}
		
		//Search button
		if(e.getSource() == frame.getBtnBuscar()){
			inventory.setNombre((String) frame.getComboNombre2().getSelectedItem());
			if(query.search(inventory)){
				frame.getLblNumeroDelProducto2().setText(String.valueOf(inventory.getIdproducto()));
				frame.getLblCantidad2().setText(String.valueOf(inventory.getCantidad()));	
				frame.getLblPrecioDeVenta2().setText(String.valueOf(inventory.getPrecio()));	
			}else {
				clean();
				JOptionPane.showMessageDialog(null, "Artículo no registrado");
			}
		}
		
		//Delete button
		if(e.getSource() == frame.getBtnEliminar()){
			inventory.setNombre((String) frame.getComboNombre3().getSelectedItem());
			if(query.search(inventory)){				
				frame.getTxtNumeroDelProducto3().setText(String.valueOf(inventory.getIdproducto()));
				frame.getTxtCantidad3().setText(String.valueOf(inventory.getCantidad()));	
				frame.getTxtPrecioDeVenta3().setText(String.valueOf(inventory.getPrecio()));
				
			}else {
				JOptionPane.showMessageDialog(null, "No se puede mostrar el artículo a eliminar");
			}
			int a = JOptionPane.showConfirmDialog(null,"Desea eliminar este artículo?", "Confirmación", JOptionPane.YES_NO_OPTION);
			if(a==0) {
				if(query.delete(inventory)){
					fillCombos();
					clean();
					JOptionPane.showMessageDialog(null, "Artículo eliminado");
				}else {
					JOptionPane.showMessageDialog(null, "Ha ocurrido un error");
				}
			}
		}
		

	}
	
	//method for cleaning the boxes
	public void clean(){
		frame.getTxtNombre().setText(null);
		frame.getTxtCantidad().setText(null);
		frame.getTxtPrecioDeVenta().setText(null);
		frame.getLblNumeroDelProducto2().setText(null);
		frame.getLblCantidad2().setText(null);
		frame.getLblPrecioDeVenta2().setText(null);
		frame.getTxtNumeroDelProducto3().setText(null);
		frame.getTxtCantidad3().setText(null);
		frame.getTxtPrecioDeVenta3().setText(null);
		
	}
	public void fillCombos() {
		frame.fillCombo(frame.getComboNombre2());
		frame.fillCombo(frame.getComboNombre3());
		
	}
	
}
