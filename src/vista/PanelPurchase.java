package vista;

import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import modelo.Conexion;
import javax.swing.JTable;

public class PanelPurchase extends JFrame {

	private JTextField txtCantidad = new JTextField();
	private JTextField txtPrecioDeCompra = new JTextField();
	
	private JTabbedPane panelPurchase = new JTabbedPane();
	
	private JPanel panel_anadir = new JPanel();
	private JPanel panel_tabla = new JPanel();
	
	private JButton btnAnadir = new JButton("Añadir");
	
	private JLabel lblNombre = new JLabel("Producto:");
	private JLabel lblCantidad = new JLabel("Cantidad:");
	private JLabel lblProveedor = new JLabel("Proveedor:");
	private JLabel lblPreciodeCompra = new JLabel("Precio de compra:");
	
	
	private JComboBox comboProducto = new JComboBox();
	private JComboBox comboProveedor = new JComboBox();
	
	private JTable tabla_Compras = new JTable();
	

	public JTextField getTxtCantidad() {
		return txtCantidad;
	}

	public JTextField getTxtPrecioDeCompra() {
		return txtPrecioDeCompra;
	}

	public JButton getBtnAnadir() {
		return btnAnadir;
	}

	public JComboBox getComboProducto() {
		return comboProducto;
	}


	public JComboBox getComboProveedor() {
		return comboProveedor;
	}
	
	public JTable getTabla_Compras() {
		return tabla_Compras;
	}


	public PanelPurchase() {
		panelPurchase.setForeground(Color.DARK_GRAY);
		lblNombre.setForeground(Color.WHITE);
		lblCantidad.setForeground(Color.WHITE);
		lblProveedor.setForeground(Color.WHITE);
		lblPreciodeCompra.setForeground(Color.WHITE);
		
		//panel anadir
		panel_anadir.setBackground(Color.DARK_GRAY);
		panelPurchase.addTab("Añadir",panel_anadir);
        //posicion y tamano
		GroupLayout gl_panel_anadir = new GroupLayout(panel_anadir);
		gl_panel_anadir.setHorizontalGroup(
			gl_panel_anadir.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_anadir.createSequentialGroup()
					.addGap(67)
					.addGroup(gl_panel_anadir.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_anadir.createSequentialGroup()
							.addComponent(lblPreciodeCompra)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtPrecioDeCompra, GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE))
						.addGroup(gl_panel_anadir.createSequentialGroup()
							.addComponent(lblCantidad)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtCantidad, GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE))
						.addGroup(gl_panel_anadir.createSequentialGroup()
							.addComponent(lblProveedor)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(comboProveedor, 0, 218, Short.MAX_VALUE))
						.addGroup(gl_panel_anadir.createSequentialGroup()
							.addComponent(lblNombre)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(comboProducto, GroupLayout.PREFERRED_SIZE, 227, GroupLayout.PREFERRED_SIZE)))
					.addGap(60))
				.addGroup(gl_panel_anadir.createSequentialGroup()
					.addGap(176)
					.addComponent(btnAnadir)
					.addContainerGap(185, Short.MAX_VALUE))
		);
		gl_panel_anadir.setVerticalGroup(
			gl_panel_anadir.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel_anadir.createSequentialGroup()
					.addGap(22)
					.addGroup(gl_panel_anadir.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombre)
						.addComponent(comboProducto, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_anadir.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblProveedor)
						.addComponent(comboProveedor, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_anadir.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCantidad)
						.addComponent(txtCantidad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_anadir.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPreciodeCompra)
						.addComponent(txtPrecioDeCompra, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(31)
					.addComponent(btnAnadir)
					.addContainerGap(44, Short.MAX_VALUE))
		);
		panel_anadir.setLayout(gl_panel_anadir);
		
		//panel tabla
		panel_tabla.setBackground(Color.DARK_GRAY);
		panelPurchase.addTab("Tabla",panel_tabla);
		
		
		GroupLayout gl_panel_tabla = new GroupLayout(panel_tabla);
		gl_panel_tabla.setHorizontalGroup(
			gl_panel_tabla.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_tabla.createSequentialGroup()
					.addContainerGap()
					.addComponent(tabla_Compras, GroupLayout.DEFAULT_SIZE, 417, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_tabla.setVerticalGroup(
			gl_panel_tabla.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_tabla.createSequentialGroup()
					.addGap(13)
					.addComponent(tabla_Compras, GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel_tabla.setLayout(gl_panel_tabla);
		getContentPane().add(panelPurchase);
	}
	
	public void fillCombo(JComboBox combo, String table, String column){
		Conexion con = new Conexion();
		PreparedStatement ps ;
		ResultSet res ;
		Connection conex = con.getConexion();
		combo.removeAllItems();
		try {   
            String sql = "SELECT * FROM "+table;
            ps = conex.prepareStatement(sql);
            res = ps.executeQuery();
            
            while(res.next()) {
            	combo.addItem(res.getString(column));
            }
            res.close();
        } 
        catch (SQLException e) {
            System.err.println(e.toString());
        }
    }
}
