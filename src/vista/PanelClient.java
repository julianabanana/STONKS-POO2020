package vista;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JPanel;

import modelo.Conexion;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTabbedPane;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTable;

public class PanelClient extends JFrame{
	
	private JTextField txtNombre = new JTextField();
	private JTextField txtAt = new JTextField();
	private JTextField txtDireccion = new JTextField();
	private JTextField txtDireccion3 = new JTextField();
	private JTextField txtAt3 = new JTextField();
	private JTextField txtDireccion4 = new JTextField();
	private JTextField txtAt4 = new JTextField();
	private JTextField txtNumeroDeCliente4 = new JTextField();
	
	private JTable tabla_Cliente = new JTable();
	
	private JButton btnAnadir = new JButton("Añadir");
	private JButton btnModificar = new JButton("Modificar");
	private JButton btnEliminar = new JButton("Eliminar");
	private JButton btnBuscar = new JButton("Buscar");
	
	private JComboBox comboNombre = new JComboBox();
	private JComboBox comboNombre2 = new JComboBox();
	private JComboBox comboNombre3 = new JComboBox();
	
	private JLabel lblNombre = new JLabel("Nombre:");
	private JLabel lblId = new JLabel("Id del Cliente:");
	private JLabel lblAt = new JLabel("@:");
	private JLabel lblDireccion = new JLabel("Direccion:");
	private JLabel lblNombre2 = new JLabel("Nombre:");
	private JLabel lblId2 = new JLabel("Id del Cliente:");
	private JLabel lblAt_2 = new JLabel("@:");
	private JLabel lblDireccion_2 = new JLabel("Direccion:");
	private JLabel lblNombre3 = new JLabel("Nombre:");
	private JLabel lblAt3 = new JLabel("@:");
	private JLabel lblDireccion3 = new JLabel("Direccion:");
	private JLabel lblNombre4 = new JLabel("Nombre:");
	private JLabel lblId4 = new JLabel("Id del Cliente:");
	private JLabel lblAt4 = new JLabel("@:");
	private JLabel lblDireccion4 = new JLabel("Direccion:");
	
	private JLabel lblAt2 = new JLabel();
	private JLabel lblNumeroDeCliente2 = new JLabel();
	private JLabel lblDireccion2 = new JLabel();
	
	private JPanel panel_anadir = new JPanel();
	private JPanel panel_buscar = new JPanel();
	private JPanel panel_modificar = new JPanel();
	private JPanel panel_eliminar = new JPanel();
	private JPanel panel_tabla = new JPanel();
	
	private JTabbedPane panelCliente = new JTabbedPane();

	public JTextField getTxtNombre() {
		return txtNombre;
	}

	public JTextField getTxtAt() {
		return txtAt;
	}

	public JTextField getTxtDireccion() {
		return txtDireccion;
	}

	public JLabel getLblDireccion2() {
		return lblDireccion2;
	}

	public JLabel getLblAt2() {
		return lblAt2;
	}

	public JLabel getLblNumeroDeCliente2() {
		return lblNumeroDeCliente2; 
	}

	public JTextField getTxtDireccion3() {
		return txtDireccion3;
	}

	public JTextField getTxtAt3() {
		return txtAt3;
	}

	public JTextField getTxtDireccion4() {
		return txtDireccion4;
	}

	public JTextField getTxtAt4() {
		return txtAt4;
	}

	public JTextField getTxtNumeroDeCliente4() {
		return txtNumeroDeCliente4;
	}

	public JTable getTabla_Cliente() {
		return tabla_Cliente;
	}

	public JButton getBtnAnadir() {
		return btnAnadir;
	}

	public JButton getBtnModificar() {
		return btnModificar;
	}

	public JButton getBtnEliminar() {
		return btnEliminar;
	}

	public JButton getBtnBuscar() {
		return btnBuscar;
	}

	public JComboBox getComboNombre() {
		return comboNombre;
	}

	public JComboBox getComboNombre2() {
		return comboNombre2;
	}

	public JComboBox getComboNombre3() {
		return comboNombre3;
	}

	public PanelClient() {
		lblNombre.setForeground(Color.WHITE);
		lblAt.setForeground(Color.WHITE);
		lblDireccion.setForeground(Color.WHITE);
		lblId.setForeground(Color.WHITE);
		lblNombre2.setForeground(Color.WHITE);
		lblAt_2.setForeground(Color.WHITE);
		lblDireccion_2.setForeground(Color.WHITE);
		lblId2.setForeground(Color.WHITE);
		lblNombre3.setForeground(Color.WHITE);
		lblAt3.setForeground(Color.WHITE);
		lblDireccion3.setForeground(Color.WHITE);
		lblNombre4.setForeground(Color.WHITE);
		lblAt4.setForeground(Color.WHITE);
		lblDireccion4.setForeground(Color.WHITE);
		lblId4.setForeground(Color.WHITE);
		lblAt2.setForeground(Color.WHITE);
		lblNumeroDeCliente2.setForeground(Color.WHITE);
		lblDireccion2.setForeground(Color.WHITE);
		
		//panel anadir
		panelCliente.add("Añadir",panel_anadir);
		panel_anadir.setBackground(Color.DARK_GRAY);
		//ubicacion y tamano
		GroupLayout gl_panel_anadir = new GroupLayout(panel_anadir);
		gl_panel_anadir.setHorizontalGroup(
			gl_panel_anadir.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_anadir.createSequentialGroup()
					.addGap(84)
					.addGroup(gl_panel_anadir.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_anadir.createSequentialGroup()
							.addComponent(lblAt)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtAt, GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE))
						.addGroup(gl_panel_anadir.createSequentialGroup()
							.addComponent(lblDireccion)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtDireccion, GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE))
						.addGroup(gl_panel_anadir.createSequentialGroup()
							.addComponent(lblNombre)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtNombre, GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)))
					.addGap(85))
				.addGroup(gl_panel_anadir.createSequentialGroup()
					.addContainerGap(189, Short.MAX_VALUE)
					.addComponent(btnAnadir)
					.addGap(172))
		);
		gl_panel_anadir.setVerticalGroup(
			gl_panel_anadir.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_anadir.createSequentialGroup()
					.addGap(28)
					.addGroup(gl_panel_anadir.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombre)
						.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_anadir.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAt)
						.addComponent(txtAt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_anadir.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDireccion)
						.addComponent(txtDireccion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(35)
					.addComponent(btnAnadir)
					.addContainerGap(58, Short.MAX_VALUE))
		);
		panel_anadir.setLayout(gl_panel_anadir);
		
		//panel buscar
		panelCliente.add("Buscar",panel_buscar);
		panel_buscar.setBackground(Color.DARK_GRAY);
		//ubicacion y tamano
		GroupLayout gl_panel_buscar = new GroupLayout(panel_buscar);
		gl_panel_buscar.setHorizontalGroup(
			gl_panel_buscar.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_buscar.createSequentialGroup()
					.addContainerGap(182, Short.MAX_VALUE)
					.addComponent(btnBuscar)
					.addGap(177))
				.addGroup(gl_panel_buscar.createSequentialGroup()
					.addGap(81)
					.addGroup(gl_panel_buscar.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_buscar.createSequentialGroup()
							.addComponent(lblNombre2)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(comboNombre, GroupLayout.PREFERRED_SIZE, 208, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_buscar.createSequentialGroup()
							.addComponent(lblAt_2)
							.addPreferredGap(ComponentPlacement.RELATED, 199, Short.MAX_VALUE)
							.addComponent(lblAt2))
						.addGroup(gl_panel_buscar.createSequentialGroup()
							.addComponent(lblId2)
							.addPreferredGap(ComponentPlacement.RELATED, 118, Short.MAX_VALUE)
							.addComponent(lblNumeroDeCliente2))
						.addGroup(gl_panel_buscar.createSequentialGroup()
							.addComponent(lblDireccion_2)
							.addPreferredGap(ComponentPlacement.RELATED, 146, Short.MAX_VALUE)
							.addComponent(lblDireccion2)))
					.addGap(74))
		);
		gl_panel_buscar.setVerticalGroup(
			gl_panel_buscar.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_buscar.createSequentialGroup()
					.addGap(29)
					.addGroup(gl_panel_buscar.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombre2)
						.addComponent(comboNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_buscar.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAt_2)
						.addComponent(lblAt2))
					.addGap(18)
					.addGroup(gl_panel_buscar.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblId2)
						.addComponent(lblNumeroDeCliente2))
					.addGap(18)
					.addGroup(gl_panel_buscar.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDireccion_2)
						.addComponent(lblDireccion2))
					.addGap(32)
					.addComponent(btnBuscar)
					.addContainerGap(18, Short.MAX_VALUE))
		);
		panel_buscar.setLayout(gl_panel_buscar);
		
		//panel modificar
		panelCliente.add("Modificar",panel_modificar);
		panel_modificar.setBackground(Color.DARK_GRAY);
		//ubicacion y tamano
		GroupLayout gl_panel_modificar = new GroupLayout(panel_modificar);
		gl_panel_modificar.setHorizontalGroup(
			gl_panel_modificar.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel_modificar.createSequentialGroup()
					.addGap(78)
					.addGroup(gl_panel_modificar.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel_modificar.createSequentialGroup()
							.addComponent(lblNombre3)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(comboNombre2, GroupLayout.PREFERRED_SIZE, 208, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_modificar.createSequentialGroup()
							.addComponent(lblAt3)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtAt3))
						.addGroup(gl_panel_modificar.createSequentialGroup()
							.addComponent(lblDireccion3)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel_modificar.createParallelGroup(Alignment.LEADING)
								.addComponent(btnModificar)
								.addComponent(txtDireccion3))))
					.addContainerGap(77, Short.MAX_VALUE))
		);
		gl_panel_modificar.setVerticalGroup(
			gl_panel_modificar.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_modificar.createSequentialGroup()
					.addGap(43)
					.addGroup(gl_panel_modificar.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombre3)
						.addComponent(comboNombre2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_modificar.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAt3)
						.addComponent(txtAt3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_modificar.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDireccion3)
						.addComponent(txtDireccion3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(34)
					.addComponent(btnModificar)
					.addContainerGap(39, Short.MAX_VALUE))
		);
		panel_modificar.setLayout(gl_panel_modificar);
		
		//panel eliminar
		panelCliente.add("Eliminar",panel_eliminar);
		panel_eliminar.setBackground(Color.DARK_GRAY);
		//ubicacion y tamano
		GroupLayout gl_panel_eliminar = new GroupLayout(panel_eliminar);
		gl_panel_eliminar.setHorizontalGroup(
			gl_panel_eliminar.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_eliminar.createSequentialGroup()
					.addContainerGap(80, Short.MAX_VALUE)
					.addGroup(gl_panel_eliminar.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_eliminar.createSequentialGroup()
							.addGroup(gl_panel_eliminar.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_panel_eliminar.createSequentialGroup()
									.addComponent(lblNombre4)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(comboNombre3, GroupLayout.PREFERRED_SIZE, 208, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_eliminar.createSequentialGroup()
									.addComponent(lblAt4)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(txtAt4))
								.addGroup(gl_panel_eliminar.createSequentialGroup()
									.addComponent(lblId4)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(txtNumeroDeCliente4))
								.addGroup(gl_panel_eliminar.createSequentialGroup()
									.addComponent(lblDireccion4)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(txtDireccion4)))
							.addGap(75))
						.addGroup(Alignment.TRAILING, gl_panel_eliminar.createSequentialGroup()
							.addComponent(btnEliminar)
							.addGap(168))))
		);
		gl_panel_eliminar.setVerticalGroup(
			gl_panel_eliminar.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_eliminar.createSequentialGroup()
					.addGap(23)
					.addGroup(gl_panel_eliminar.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombre4)
						.addComponent(comboNombre3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_eliminar.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAt4)
						.addComponent(txtAt4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_eliminar.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblId4)
						.addComponent(txtNumeroDeCliente4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_eliminar.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDireccion4)
						.addComponent(txtDireccion4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btnEliminar)
					.addContainerGap(38, Short.MAX_VALUE))
		);
		panel_eliminar.setLayout(gl_panel_eliminar);
		
		//panel tabla
		panelCliente.add("Tabla",panel_tabla);
		panel_tabla.setBackground(Color.DARK_GRAY);
		GroupLayout gl_panel_tabla = new GroupLayout(panel_tabla);
		gl_panel_tabla.setHorizontalGroup(
			gl_panel_tabla.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_tabla.createSequentialGroup()
					.addContainerGap()
					.addComponent(tabla_Cliente, GroupLayout.DEFAULT_SIZE, 417, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_tabla.setVerticalGroup(
			gl_panel_tabla.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_tabla.createSequentialGroup()
					.addContainerGap()
					.addComponent(tabla_Cliente, GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel_tabla.setLayout(gl_panel_tabla);
		
		getContentPane().add(panelCliente);		
	}
	
	Conexion con = new Conexion();
	
	
	public void fillCombo(JComboBox combo){
		PreparedStatement ps ;
		ResultSet res ;
		Connection conex = con.getConexion();
		combo.removeAllItems(); //vacia la combobox por si tiene algo
		try {   
            String sql = "SELECT * FROM clientes";
            ps = conex.prepareStatement(sql);
            res = ps.executeQuery();
            
            while(res.next()) {
            	combo.addItem(res.getString("nombre")); //la vuelva a llenar con cada registro en la columna nombre
            }
            res.close();
        } 
        catch (SQLException e) {
            System.err.println(e.toString());
        }
    }

}
