package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;

import java.sql.*;
import modelo.*;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;


public class PanelSales extends JFrame {
	public JPanel contentPane;
	private JTextField textFieldCantidad;
	private JTable table; 
	private JTable table_1;
    private JComboBox comboBoxCliente;
    private JComboBox comboBoxProducto;
    private JButton btnAnadirProducto;
    private JButton btnGenerarVenta;
    private JButton btnDescartarVenta;
	private JLabel lblResult;
    private DefaultTableModel modelo;
    private float total=0;
    public Conexion con;
    
    public JButton getBtnAnadirProducto() {
        return btnAnadirProducto;
    }

    public JButton getBtnGenerarVenta() {
        return btnGenerarVenta;
    }
    
    public JButton getBtnDescartarVenta() {
        return btnDescartarVenta;
    }

	public JTextField getTextFieldCantidad() {
		return textFieldCantidad;
	}

	public JTable getTable_1() {
		return table_1;
	}
        public void setTotal(int x){
        this.total=x;
        }

	public JComboBox getComboBoxCliente() {
		return comboBoxCliente;
	}

	public JComboBox getComboBoxProducto() {
		return comboBoxProducto;
	}

	public JLabel getLblResult() {
		return lblResult;
	}

	public float getTotal() {
		return total;
	}

	public PanelSales() {
		setForeground(Color.WHITE);
		setTitle("Ventas");
		setBackground(Color.DARK_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		//table
        modelo=new DefaultTableModel();
		table = new JTable(modelo);
        startTable();
		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setForeground(Color.WHITE);
		JLabel lblCliente = new JLabel("Cliente:");
		lblCliente.setForeground(Color.WHITE);
		JLabel lblProducto = new JLabel("Producto:");
		lblProducto.setForeground(Color.WHITE);
		JLabel lblNewLabel = new JLabel("Cantidad:");
		lblNewLabel.setForeground(Color.WHITE);
		lblResult = new JLabel("");
		lblResult.setForeground(Color.WHITE);
		
		//comboboxes
		con = new Conexion();
		comboBoxCliente = new JComboBox();
		comboBoxProducto = new JComboBox();
		
		
		//text field
		textFieldCantidad = new JTextField("");
		textFieldCantidad.setColumns(10);
		
		//buttons
		btnAnadirProducto = new JButton("Añadir producto");
		btnGenerarVenta = new JButton("Generar Venta");
		btnDescartarVenta = new JButton("Descartar Venta");

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
											.addGroup(gl_contentPane.createSequentialGroup()
												.addGap(15)
												.addComponent(lblCliente))
											.addGroup(gl_contentPane.createSequentialGroup()
												.addContainerGap()
												.addComponent(lblProducto))
											.addGroup(gl_contentPane.createSequentialGroup()
												.addContainerGap()
												.addComponent(lblNewLabel)))
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
											.addComponent(textFieldCantidad, GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
											.addComponent(comboBoxCliente, 0, 313, Short.MAX_VALUE)
											.addComponent(comboBoxProducto, 0, 313, Short.MAX_VALUE)))
									.addGroup(gl_contentPane.createSequentialGroup()
										.addContainerGap()
										.addComponent(btnAnadirProducto)))
								.addGap(18))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGap(309)
								.addComponent(lblResult)
								.addGap(68)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(24)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnDescartarVenta)
									.addGap(18)
									.addComponent(btnGenerarVenta))
								.addComponent(table_1, GroupLayout.PREFERRED_SIZE, 391, GroupLayout.PREFERRED_SIZE))
							.addGap(9)))
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(231, Short.MAX_VALUE)
					.addComponent(lblTotal)
					.addGap(164))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBoxCliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCliente))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBoxProducto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblProducto))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldCantidad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel))
					.addGap(18)
					.addComponent(btnAnadirProducto)
					.addGap(35)
					.addComponent(table_1, GroupLayout.PREFERRED_SIZE, 275, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblResult)
						.addComponent(lblTotal))
					.addPreferredGap(ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnGenerarVenta)
						.addComponent(btnDescartarVenta))
					.addGap(21))
		);
		contentPane.setLayout(gl_contentPane);
	}

        public void setTotal(float amount){
            if(amount>0){
                total+=amount;
                lblResult.setText(total+" $");
            }
        }

        public void anadirATabla(String name, Sale sale){
            modelo.addRow(new Object[]{name,sale.getCantidad()+"",sale.getCosto()+""});
        }

        public void startTable(){
            modelo = new DefaultTableModel();
            table_1 = new JTable(modelo);
            modelo.addColumn("Nombre");
            modelo.addColumn("Unidades");
            modelo.addColumn("Precio Neto");
            modelo.addRow(new Object[]{"Nombre","Unidades","Precio Neto"});
        }
        public void removeTable(){
            DefaultTableModel tb = (DefaultTableModel) table_1.getModel();
            int a = table_1.getRowCount()-1;
            for (int i = a; i > 0; i--) {          
                tb.removeRow(tb.getRowCount()-1);
            }
        }
        public void fillCombo(JComboBox combo, String tabla){
    		PreparedStatement ps ;
    		ResultSet res ;
    		Connection conex = con.getConexion();
    		combo.removeAllItems(); //vacia la combobox por si tiene algo
    		try {   
                String sql = "SELECT * FROM "+tabla;
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
