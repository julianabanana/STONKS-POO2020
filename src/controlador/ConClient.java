package controlador;

import java.awt.event.*;

import javax.swing.*;

import modelo.Client;
import modelo.ConsultClient;
import vista.PanelClient;

//for detecting a button being press,send the text boxes content

public class ConClient implements ActionListener{
	
	private Client client;
	private ConsultClient query;
	private PanelClient panel;
	//private Conexion con;
	
	public void start() {
		panel.setTitle("Clientes");
		panel.setLocationRelativeTo(null);
	}
	
	//constructor
	public ConClient(Client client, ConsultClient query, PanelClient frame) {
		
		this.client = client;
		this.query = query;
		this.panel = frame;
		this.panel.getBtnModificar().addActionListener(this);
		this.panel.getBtnBuscar().addActionListener(this);
		this.panel.getBtnAnadir().addActionListener(this);
		this.panel.getBtnEliminar().addActionListener(this);
		fillCombos();
		
	}
	
	//methods that listen to the clicks (events)
	public void actionPerformed(ActionEvent e){
		//Adding button
		if(e.getSource() == panel.getBtnAnadir()){
			client.setNombre(panel.getTxtNombre().getText());
			client.setDireccion(panel.getTxtDireccion().getText());
			client.setAt(panel.getTxtAt().getText());
			if(query.register(client)){
				JOptionPane.showMessageDialog(null, "Cliente guardado");
				fillCombos();
				clean();
			}else {
				JOptionPane.showMessageDialog(null, ("Ha ocurrido un error. Debe anadir nombre, direccion y una cuenta de correo o red social. La direccion es "+client.getDireccion()));

			}
		}
		//Modify button
		if(e.getSource() == panel.getBtnModificar()){ 
			client.setNombre((String) panel.getComboNombre2().getSelectedItem());
			client.setAt(panel.getTxtAt3().getText());
			client.setDireccion(panel.getTxtDireccion3().getText());
			if(query.update(client)){
				fillCombos();
				clean();
				JOptionPane.showMessageDialog(null, "Nueva informacion guardada");
			}else {
				JOptionPane.showMessageDialog(null, "Ha ocurrido un error modificando. Debe anadir id, nombre, direccion y una cuenta de correo o red social");
			}
		}
		//Delete button
		//String table, String columnCondition,Object dataCondition
		if(e.getSource() == panel.getBtnEliminar()){
			client.setNombre((String) panel.getComboNombre3().getSelectedItem());
			if(query.search(client)){				
				panel.getTxtNumeroDeCliente4().setText(String.valueOf(client.getId()));
				panel.getTxtDireccion4().setText(client.getDireccion());
				panel.getTxtAt4().setText(client.getAt());
				
			}else {
				JOptionPane.showMessageDialog(null, "No se puede mostrar el cliente a eliminar");
			}
			int a = JOptionPane.showConfirmDialog(null,"Desea eliminar este cliente?", "Confirmacion", JOptionPane.YES_NO_OPTION);
			if(a==0) {
				if(query.delete(client)){
					fillCombos();
					clean();
					JOptionPane.showMessageDialog(null, "Cliente eliminado");
				}else {
					JOptionPane.showMessageDialog(null, "Ha ocurrido un error");
				}
			}
		}
		//Search button
		if(e.getSource() == panel.getBtnBuscar()){
			client.setNombre((String) panel.getComboNombre().getSelectedItem());
			if(query.search(client)){				
				panel.getLblNumeroDeCliente2().setText(String.valueOf(client.getId()));
				panel.getLblDireccion2().setText(client.getDireccion());
				panel.getLblAt2().setText(client.getAt());
				fillCombos();
			}else {
				clean();
				JOptionPane.showMessageDialog(null, "Cliente no registrado");
			}
		}
	}
	public void clean() {
		panel.getTxtAt().setText(null);
		panel.getLblAt2().setText(null);
		panel.getTxtAt3().setText(null);
		panel.getTxtAt4().setText(null);
		panel.getTxtDireccion().setText(null);
		panel.getLblDireccion2().setText(null);
		panel.getTxtDireccion3().setText(null);
		panel.getTxtDireccion4().setText(null);
		panel.getTxtNombre().setText(null);
		panel.getLblNumeroDeCliente2().setText(null);
		panel.getTxtNumeroDeCliente4().setText(null);
	}
	
	public void fillCombos() {
		panel.fillCombo(panel.getComboNombre());
		panel.fillCombo(panel.getComboNombre2());
		panel.fillCombo(panel.getComboNombre3());
		
	}
	
}
