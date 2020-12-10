package vista;

import java.awt.Font;
import javax.swing.*;

import javax.swing.JDialog;

import controlador.Coordinador;

public class VentanaConsultaIndividual extends JDialog {

	public VentanaConsultaIndividual(java.awt.Frame parent, boolean modal) {
		super(parent, modal);
		initComponents();
		setSize(710, 330);
		setResizable(false);
		setLocationRelativeTo(null);
	}

	private void initComponents() {
		panelRegistro = new javax.swing.JPanel();
		TituloConsulta = new javax.swing.JLabel();
		labelProfesion = new javax.swing.JLabel();
		labelTelefono = new javax.swing.JLabel();
		labelTexto = new javax.swing.JLabel();
		labelDocumento = new javax.swing.JLabel();
		labelEdad = new javax.swing.JLabel();
		labelDireccion = new javax.swing.JLabel();
		labelNombre = new javax.swing.JLabel();
		separadorInferior = new javax.swing.JSeparator();
		campoNombre = new javax.swing.JTextField();
		campoDireccion = new javax.swing.JTextField();
		campoTelefono = new javax.swing.JTextField();
		campoProfesion = new javax.swing.JTextField();
		campoConsultaDocumento = new javax.swing.JTextField();
		campoEdad = new javax.swing.JTextField();
		separadorSuperior = new javax.swing.JSeparator();
		btonCancelar = new javax.swing.JButton();
		btonConsultar = new javax.swing.JButton();
		campoDocumento = new javax.swing.JTextField();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		//getContentPane().setLayout(null);

		TituloConsulta.setFont(new java.awt.Font("Verdana", 1, 36));
		TituloConsulta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		TituloConsulta.setText("Consultar Usuario");
		TituloConsulta.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
		panelRegistro.add(TituloConsulta);
		TituloConsulta.setBounds(20, 10, 660, 60);

		labelProfesion.setFont(new Font("Verdana", 0, 12));
		labelProfesion.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		labelProfesion.setText("Profesion:");
		panelRegistro.add(labelProfesion);
		labelProfesion.setBounds(0, 170, 90, 20);

		labelTelefono.setFont(new java.awt.Font("Verdana", 0, 12));
		labelTelefono.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		labelTelefono.setText("Telefono:");
		panelRegistro.add(labelTelefono);
		labelTelefono.setBounds(400, 200, 100, 20);

		labelTexto.setFont(new java.awt.Font("Verdana", 1, 14));
		labelTexto.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		labelTexto.setText("Ingrese el documento del usuario a consultar:");
		panelRegistro.add(labelTexto);
		labelTexto.setBounds(0, 90, 380, 20);

		labelDocumento.setFont(new java.awt.Font("Verdana", 0, 12));
		labelDocumento.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		labelDocumento.setText("Documento:");
		panelRegistro.add(labelDocumento);
		labelDocumento.setBounds(400, 140, 100, 20);

		labelEdad.setFont(new java.awt.Font("Verdana", 0, 12));
		labelEdad.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		labelEdad.setText("Edad:");
		panelRegistro.add(labelEdad);
		labelEdad.setBounds(400, 170, 100, 20);

		labelDireccion.setFont(new java.awt.Font("Verdana", 0, 12));
		labelDireccion.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		labelDireccion.setText("Dirección:");
		panelRegistro.add(labelDireccion);
		labelDireccion.setBounds(0, 200, 90, 20);

		labelNombre.setFont(new java.awt.Font("Verdana", 0, 12));
		labelNombre.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		labelNombre.setText("Nombre:");
		panelRegistro.add(labelNombre);
		labelNombre.setBounds(0, 140, 90, 20);

		panelRegistro.add(separadorInferior);
		separadorInferior.setBounds(20, 240, 660, 10);
		panelRegistro.add(separadorInferior);
		separadorInferior.setBounds(20, 240, 660, 10);
		panelRegistro.add(campoNombre);
		campoNombre.setBounds(100, 140, 300, 20);
		panelRegistro.add(campoDireccion);
		campoDireccion.setBounds(100, 200, 300, 20);
		panelRegistro.add(campoTelefono);
		campoTelefono.setBounds(510, 200, 170, 20);

		panelRegistro.add(campoProfesion);
		campoProfesion.setBounds(100, 170, 300, 20);
		panelRegistro.add(campoConsultaDocumento);
		campoConsultaDocumento.setBounds(390, 90, 120, 20);
		panelRegistro.add(campoEdad);
		campoEdad.setBounds(100, 170, 300, 20);
		panelRegistro.add(separadorSuperior);
		campoEdad.setBounds(510, 170, 170, 20);
		panelRegistro.add(separadorSuperior);
		separadorSuperior.setBounds(20, 120, 660, 10);

		pack();
	}

	// new javax.swing.JButton();
	// new javax.swing.JTextField();
	private JLabel labelDireccion;
	private JLabel TituloConsulta;
	private JButton btonCancelar;
	private JButton btonConsultar;
	private JTextField campoTelefono;
	private JTextField campoDireccion;
	private JTextField campoConsultaDocumento;
	private JTextField campoDocumento;
	private JTextField campoEdad;
	private JTextField campoNombre;
	private JTextField campoProfesion;
	private JLabel labelDocumento;
	private JLabel labelEdad;
	private JLabel labelNombre;
	private JLabel labelProfesion;
	private JLabel labelTelefono;
	private JLabel labelTexto;
	private JPanel panelRegistro;
	private JSeparator separadorInferior;
	private JSeparator separadorSuperior;

	private Coordinador miCoordinador;

	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador = miCoordinador;
	}

}