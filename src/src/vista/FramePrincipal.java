package vista;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;

public class FramePrincipal extends JFrame {

	private JPanel contentPane;
	private JButton btnVenta;
	private JButton btnCompra;
	private JButton btnClientes;
	private JButton btnProveedores;
	private JButton btnInventario;
	private JButton btnGraficas;
	private Container panel;
	
	private ImageIcon icon = new ImageIcon("/imagenes/Stonks.png");

	public FramePrincipal() {
		setBackground(Color.DARK_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		btnVenta = new JButton("Venta");
		panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setPreferredSize(new Dimension(450,300));
		btnCompra = new JButton("Compra");
		btnClientes = new JButton("Clientes");
		btnProveedores = new JButton("Proveedores");
		btnInventario = new JButton("Inventario");
		btnGraficas = new JButton("Gráficas");
		
		JLabel lblNewLabel = new JLabel(icon);
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(49, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(btnGraficas, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnCompra, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnVenta, GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
								.addComponent(btnProveedores, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnClientes, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnInventario, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGap(74)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 388, GroupLayout.PREFERRED_SIZE)))
					.addGap(37))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
					.addGap(24)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(41)
							.addComponent(btnVenta)
							.addGap(18)
							.addComponent(btnCompra)
							.addGap(18)
							.addComponent(btnProveedores)
							.addGap(18)
							.addComponent(btnClientes)
							.addGap(18)
							.addComponent(btnInventario)
							.addGap(18)
							.addComponent(btnGraficas))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(26)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 276, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(31, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	public void cambiarPanel(JTabbedPane oldPanel, JTabbedPane newPanel) {
		panel.remove(oldPanel);
		panel.add(newPanel);
		panel.validate();
	}
        //Metodos que he hecho xd

    public JButton getBtnVenta() {
        return btnVenta;
    }

    public JButton getBtnCompra() {
        return btnCompra;
    }

    public JButton getBtnClientes() {
        return btnClientes;
    }

    public JButton getBtnProveedores() {
        return btnProveedores;
    }

    public JButton getBtnInventario() {
        return btnInventario;
    }

    public JButton getBtnGraficas() {
        return btnGraficas;
    }
   
    private GraficosPanel panelGraficos;
    private JPanel panelInventory;
     //Panel Graficos
    public void addPanelGraficos(GraficosPanel panelGraficos){
        this.panelGraficos=panelGraficos;
        
    }
    public void addPanels(){
        panel.add(panelGraficos);
        
    }
    public void unhidePanelGraficos(){
    this.panelGraficos.setVisible(true);
    }
    public void hidePanelGraficos(){
        this.panelGraficos.setVisible(false);
    }
    //PanelInventory
    public void addPanelInventory(JPanel panel){
        this.panelInventory=panel;
    }
    public void unhidePanelInventory(){
    this.panelInventory.setVisible(true);
    }
    public void hidePanelInventory(){
        this.panelInventory.setVisible(false);
    }
    public void anadirButtonsActionListener(ActionListener al){
    btnVenta.addActionListener(al);
    btnCompra.addActionListener(al);
    btnClientes.addActionListener(al);
    btnProveedores.addActionListener(al);
    btnInventario.addActionListener(al);
    btnGraficas.addActionListener(al);
    }
    
}