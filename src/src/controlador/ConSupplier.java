package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import modelo.ConsultSupplier;
import modelo.Supplier;
import vista.PanelSupplier;

public class ConSupplier implements ActionListener{
	
	private Supplier supplier;
	private ConsultSupplier query;
	private PanelSupplier panel;

	
	public void start() {
		panel.setTitle("Proveedores");
		panel.setLocationRelativeTo(null);
	}
	
	//constructor
	public ConSupplier(Supplier supplier, ConsultSupplier query, PanelSupplier frame) {
		
		this.supplier = supplier;
		this.query = query;
		this.panel = frame;
		this.panel.getBtnBuscar().addActionListener(this);
		this.panel.getBtnAnadir().addActionListener(this);
		this.panel.getBtnEliminar().addActionListener(this);
		fillCombos();
		
	}
	
	//methods that listen to the clicks (events)
	public void actionPerformed(ActionEvent e){
		//Adding button
		if(e.getSource() == panel.getBtnAnadir()){
			supplier.setNombre(panel.getTxtNombre().getText());
			if(query.register(supplier)){
				JOptionPane.showMessageDialog(null, "Proveedor guardado");
				fillCombos();
				clean();
			}else {
				JOptionPane.showMessageDialog(null, ("Ha ocurrido un error. Debe anadir nombre."));

			}
		}
		//Search button
		if(e.getSource() == panel.getBtnBuscar()){
			supplier.setNombre((String) panel.getComboNombre2().getSelectedItem());
			if(query.search(supplier)){				
				panel.getLblNumeroDelProveedor2().setText(String.valueOf(supplier.getId()));					
			}else {
				clean();
				JOptionPane.showMessageDialog(null, "Proveedor no registrado");
			}
		}
		
		//Delete button
		if(e.getSource() == panel.getBtnEliminar()){
			supplier.setNombre((String) panel.getComboNombre3().getSelectedItem());
			if(query.search(supplier)){				
				panel.getTxtNumeroDeProveedor3().setText(String.valueOf(supplier.getId()));
				
			}else {
				JOptionPane.showMessageDialog(null, "No se puede mostrar el proveedor a eliminar");
			}
			int a = JOptionPane.showConfirmDialog(null,"Desea eliminar este proveedor?", "Confirmacion", JOptionPane.YES_NO_OPTION);
			if(a==0) {
				if(query.delete(supplier)){
					fillCombos();
					clean();
					JOptionPane.showMessageDialog(null, "Proveedor eliminado");
				}else {
					JOptionPane.showMessageDialog(null, "Ha ocurrido un error");
				}
			}
		}
	}
	
	public void clean() {
		panel.getTxtNombre().setText(null);
		panel.getLblNumeroDelProveedor2().setText(null);
		panel.getTxtNumeroDeProveedor3().setText(null);
	}
	public void fillCombos() {
		panel.fillCombo(panel.getComboNombre2());
		panel.fillCombo(panel.getComboNombre3());
		
	}

}
