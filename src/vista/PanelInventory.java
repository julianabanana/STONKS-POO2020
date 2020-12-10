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

public class PanelInventory extends JFrame {


	private JTextField txtNombre = new JTextField();
	private JTextField txtCantidad = new JTextField();
	private JTextField txtPrecioDeVenta = new JTextField();
	private JTextField txtCantidad3 = new JTextField();
	private JTextField txtNumeroDelProducto3 = new JTextField();
	private JTextField txtPrecioDeVenta3 = new JTextField();
	
	private JTabbedPane panelInventory = new JTabbedPane();
	
	private JTable tabla_Inventario;
	
	private JPanel panel_anadir = new JPanel();
	private JPanel panel_buscar = new JPanel();
	private JPanel panel_eliminar = new JPanel();
	
	private JButton btnAnadir = new JButton("Añadir");
	private JButton btnBuscar = new JButton("Buscar");
	private JButton btnEliminar = new JButton("Eliminar");
	
	private JLabel lblNombre = new JLabel("Nombre:");
	private JLabel lblCantidad = new JLabel("Cantidad:");
	private JLabel lblPrecioDeVenta = new JLabel("Precio de venta:");
	private JLabel lblNumeroDelProducto = new JLabel("Número del producto:");
	private JLabel lblCantidad_1 = new JLabel("Cantidad:");
	private JLabel lblDireccion_1 = new JLabel("Precio de venta:");
	private JLabel lblNombre2 = new JLabel("Nombre:");
	private JLabel lblCantidad_1_1 = new JLabel("Cantidad:");
	private JLabel lblNumeroDeCliente_1_1 = new JLabel("Número del producto:");
	private JLabel lblNombre_1_1 = new JLabel("Nombre:");
	private JLabel lblDireccion_2_2 = new JLabel("Precio de venta:");
	private JLabel lblNumeroDelProducto2 = new JLabel();
	private JLabel lblCantidad2 = new JLabel();
	private JLabel lblPrecioDeVenta2 = new JLabel();

	private JComboBox comboNombre2 = new JComboBox();
	private JComboBox comboNombre3 = new JComboBox();
	
	public JTextField getTxtNombre() {
		return txtNombre;
	}

	public JTextField getTxtCantidad() {
		return txtCantidad;
	}

	public JTextField getTxtPrecioDeVenta() {
		return txtPrecioDeVenta;
	}

	public JLabel getLblPrecioDeVenta2() {
		return lblPrecioDeVenta2;
	}

	public JLabel getLblCantidad2() {
		return lblCantidad2;
	}

	public JLabel getLblNumeroDelProducto2() {
		return lblNumeroDelProducto2;
	}

	public JTextField getTxtCantidad3() {
		return txtCantidad3;
	}

	public JTextField getTxtNumeroDelProducto3() {
		return txtNumeroDelProducto3;
	}

	public JTextField getTxtPrecioDeVenta3() {
		return txtPrecioDeVenta3;
	}

	public JTable getTabla_Inventario() {
		return tabla_Inventario;
	}

	public JButton getBtnAnadir() {
		return btnAnadir;
	}

	public JButton getBtnBuscar() {
		return btnBuscar;
	}

	public JButton getBtnEliminar() {
		return btnEliminar;
	}

	public JComboBox getComboNombre2() {
		return comboNombre2;
	}

	public JComboBox getComboNombre3() {
		return comboNombre3;
	}

	public PanelInventory() {
		
		lblNombre.setForeground(Color.WHITE);
		lblCantidad.setForeground(Color.WHITE);
		lblPrecioDeVenta.setForeground(Color.WHITE);
		lblDireccion_1.setForeground(Color.WHITE);
		lblCantidad_1.setForeground(Color.WHITE);
		lblNumeroDelProducto.setForeground(Color.WHITE);
		lblNombre2.setForeground(Color.WHITE);
		lblCantidad_1_1.setForeground(Color.WHITE);
		lblDireccion_2_2.setForeground(Color.WHITE);
		lblNombre_1_1.setForeground(Color.WHITE);
		lblNumeroDeCliente_1_1.setForeground(Color.WHITE);
		lblPrecioDeVenta2.setForeground(Color.WHITE);
		lblCantidad2.setForeground(Color.WHITE);
		lblNumeroDelProducto2.setForeground(Color.WHITE);
		
		//panel anadir
		panel_anadir.setBackground(Color.DARK_GRAY);
		panelInventory.addTab("Añadir", panel_anadir);
		//ubicacion y tamano
		GroupLayout gl_panel_anadir = new GroupLayout(panel_anadir);
		gl_panel_anadir.setHorizontalGroup(
			gl_panel_anadir.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_anadir.createSequentialGroup()
					.addGroup(gl_panel_anadir.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_anadir.createSequentialGroup()
							.addGap(77)
							.addGroup(gl_panel_anadir.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_panel_anadir.createSequentialGroup()
									.addComponent(lblPrecioDeVenta, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtPrecioDeVenta))
								.addGroup(gl_panel_anadir.createSequentialGroup()
									.addComponent(lblCantidad)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(txtCantidad))
								.addGroup(gl_panel_anadir.createSequentialGroup()
									.addComponent(lblNombre)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_panel_anadir.createSequentialGroup()
							.addGap(180)
							.addComponent(btnAnadir)))
					.addContainerGap(82, Short.MAX_VALUE))
		);
		gl_panel_anadir.setVerticalGroup(
			gl_panel_anadir.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_anadir.createSequentialGroup()
					.addGap(39)
					.addGroup(gl_panel_anadir.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombre)
						.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_anadir.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCantidad)
						.addComponent(txtCantidad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_anadir.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPrecioDeVenta)
						.addComponent(txtPrecioDeVenta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(35)
					.addComponent(btnAnadir)
					.addContainerGap(59, Short.MAX_VALUE))
		);
		panel_anadir.setLayout(gl_panel_anadir);
		
		//panel buscar
		panel_buscar.setBackground(Color.DARK_GRAY);
		panelInventory.addTab("Buscar", null, panel_buscar, null);
	
		GroupLayout gl_panel_buscar = new GroupLayout(panel_buscar);
		gl_panel_buscar.setHorizontalGroup(
			gl_panel_buscar.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_buscar.createSequentialGroup()
					.addGap(108)
					.addGroup(gl_panel_buscar.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_buscar.createSequentialGroup()
							.addComponent(lblNombre2)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(comboNombre2, 0, 156, Short.MAX_VALUE))
						.addGroup(gl_panel_buscar.createSequentialGroup()
							.addComponent(lblNumeroDelProducto)
							.addPreferredGap(ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
							.addComponent(lblNumeroDelProducto2))
						.addGroup(gl_panel_buscar.createSequentialGroup()
							.addComponent(lblCantidad_1)
							.addPreferredGap(ComponentPlacement.RELATED, 165, Short.MAX_VALUE)
							.addComponent(lblCantidad2))
						.addGroup(gl_panel_buscar.createSequentialGroup()
							.addComponent(lblDireccion_1)
							.addPreferredGap(ComponentPlacement.RELATED, 119, Short.MAX_VALUE)
							.addComponent(lblPrecioDeVenta2)))
					.addGap(99))
				.addGroup(Alignment.LEADING, gl_panel_buscar.createSequentialGroup()
					.addGap(166)
					.addComponent(btnBuscar)
					.addContainerGap(193, Short.MAX_VALUE))
		);
		gl_panel_buscar.setVerticalGroup(
			gl_panel_buscar.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_buscar.createSequentialGroup()
					.addGap(25)
					.addGroup(gl_panel_buscar.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombre2)
						.addComponent(comboNombre2, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
					.addGap(16)
					.addGroup(gl_panel_buscar.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNumeroDelProducto)
						.addComponent(lblNumeroDelProducto2))
					.addGap(20)
					.addGroup(gl_panel_buscar.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCantidad_1)
						.addComponent(lblCantidad2))
					.addGap(20)
					.addGroup(gl_panel_buscar.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDireccion_1)
						.addComponent(lblPrecioDeVenta2))
					.addGap(32)
					.addComponent(btnBuscar)
					.addContainerGap(37, Short.MAX_VALUE))
		);
		panel_buscar.setLayout(gl_panel_buscar);
		
		//panel eliminar
		panel_eliminar.setBackground(Color.DARK_GRAY);
		panelInventory.addTab("Eliminar", null, panel_eliminar, null);


		GroupLayout gl_panel_eliminar = new GroupLayout(panel_eliminar);
		gl_panel_eliminar.setHorizontalGroup(
			gl_panel_eliminar.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_eliminar.createSequentialGroup()
					.addContainerGap(82, Short.MAX_VALUE)
					.addGroup(gl_panel_eliminar.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_eliminar.createSequentialGroup()
							.addGroup(gl_panel_eliminar.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_eliminar.createSequentialGroup()
									.addComponent(lblDireccion_2_2, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
									.addGap(12)
									.addComponent(txtPrecioDeVenta3, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_eliminar.createSequentialGroup()
									.addComponent(lblNombre_1_1, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(comboNombre3, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_eliminar.createSequentialGroup()
									.addComponent(lblNumeroDeCliente_1_1, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(txtNumeroDelProducto3, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_eliminar.createSequentialGroup()
									.addComponent(lblCantidad_1_1, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(txtCantidad3, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE)))
							.addGap(77))
						.addGroup(Alignment.TRAILING, gl_panel_eliminar.createSequentialGroup()
							.addComponent(btnEliminar)
							.addGap(165))))
		);
		gl_panel_eliminar.setVerticalGroup(
			gl_panel_eliminar.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_eliminar.createSequentialGroup()
					.addGap(30)
					.addGroup(gl_panel_eliminar.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombre_1_1)
						.addComponent(comboNombre3, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
					.addGap(14)
					.addGroup(gl_panel_eliminar.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_eliminar.createSequentialGroup()
							.addGap(2)
							.addComponent(lblNumeroDeCliente_1_1))
						.addComponent(txtNumeroDelProducto3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(16)
					.addGroup(gl_panel_eliminar.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_eliminar.createSequentialGroup()
							.addGap(2)
							.addComponent(lblCantidad_1_1))
						.addComponent(txtCantidad3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_eliminar.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_eliminar.createSequentialGroup()
							.addGap(2)
							.addComponent(lblDireccion_2_2))
						.addComponent(txtPrecioDeVenta3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addComponent(btnEliminar)
					.addContainerGap(39, Short.MAX_VALUE))
		);
		panel_eliminar.setLayout(gl_panel_eliminar);
		
		JPanel panel_tabla = new JPanel();
		panel_tabla.setBackground(Color.DARK_GRAY);
		panelInventory.addTab("Tabla", null, panel_tabla, null);
		
		tabla_Inventario = new JTable();
		GroupLayout gl_panel_tabla = new GroupLayout(panel_tabla);
		gl_panel_tabla.setHorizontalGroup(
			gl_panel_tabla.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_tabla.createSequentialGroup()
					.addContainerGap()
					.addComponent(tabla_Inventario, GroupLayout.DEFAULT_SIZE, 383, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_tabla.setVerticalGroup(
			gl_panel_tabla.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel_tabla.createSequentialGroup()
					.addContainerGap()
					.addComponent(tabla_Inventario, GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel_tabla.setLayout(gl_panel_tabla);
		getContentPane().add(panelInventory);
	}
	
	Conexion con = new Conexion();
	public void fillCombo(JComboBox combo){
		
		PreparedStatement ps ;
		ResultSet res ;
		Connection conex = con.getConexion();
		combo.removeAllItems();
		try {   
            String sql = "SELECT * FROM articulos";
            ps = conex.prepareStatement(sql);
            res = ps.executeQuery();
            
            while(res.next()) {
            	combo.addItem(res.getString("nombre"));
            }
            res.close();
        } 
        catch (SQLException e) {
            System.err.println(e.toString());
        }
    }
}

