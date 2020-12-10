package vista;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import controlador.Coordinador;

public class VentanaPrincipal extends JFrame implements ActionListener {
	

    private javax.swing.JButton botonConsultar;
    private javax.swing.JButton botonRegistrar;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JPanel miPanelPrincipal;
    
    //Barra superior y componentes
    private JMenuBar barraMenu;
    private JMenu menu;
    private JMenuItem itemOpciones;
    
    private Dimension tamPantalla;
    private Rectangle pantalla;
    /**
     * Creates new form VentanaPrincipal
     */
    public VentanaPrincipal() {
        initComponents();
        setTitle("Ventana Principal");
        setSize(580,340);
        setLocationRelativeTo(null);//Inicia en el cento de la pantalla
        tamPantalla=Toolkit.getDefaultToolkit().getScreenSize();//Captura tama�o de pantalla
        pantalla=new Rectangle(tamPantalla);//crea un rectangulo con limites definidos por argumento
        setBounds(pantalla);//crea la ventana de acuerdo al tama�o
        //
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        miPanelPrincipal = new javax.swing.JPanel();
        labelTitulo = new javax.swing.JLabel();
        botonConsultar = new javax.swing.JButton();
        botonRegistrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        miPanelPrincipal.setBackground(new java.awt.Color(204, 255, 204));
        miPanelPrincipal.setLayout(null);

        labelTitulo.setFont(new java.awt.Font("Times New Roman", 0, 48)); // NOI18N
        labelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTitulo.setText("Bienvenido al Sistema");
        miPanelPrincipal.add(labelTitulo);
        labelTitulo.setBounds(10, 20, 520, 60);

        botonConsultar.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        botonConsultar.setText("Consultar");
        botonConsultar.addActionListener(this);
        miPanelPrincipal.add(botonConsultar);
        botonConsultar.setBounds(270, 100, 140, 40);

        botonRegistrar.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        botonRegistrar.setText("Registrar");
        miPanelPrincipal.add(botonRegistrar);
        botonRegistrar.setBounds(30, 100, 140, 40);
        
        //constructor barra superior
        barraMenu=new JMenuBar();
        setJMenuBar(barraMenu);
        menu = new JMenu();
        itemOpciones = new JMenuItem();
        
        menu.setText("Opciones");
        itemOpciones.setText("Cambiar de Usuario");
        itemOpciones.addActionListener(this);
        
        menu.add(itemOpciones);
        barraMenu.add(menu);

        getContentPane().add(miPanelPrincipal);
        miPanelPrincipal.setBounds(0, 0, 560, 300);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private Coordinador miCoordinador;
	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador = miCoordinador;
	}

	public void asignarPrivilegios(String usuario) {
		labelTitulo.setText("Bienvenido: "+usuario);
		if(usuario.equals("Administrador")) {
			botonConsultar.setVisible(true);
			botonRegistrar.setVisible(true);
		}else {
			botonConsultar.setVisible(false);
			botonRegistrar.setVisible(true);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==itemOpciones) {
			//MVC en accion
			miCoordinador.mostrarLogin();
		}
		if(e.getSource()==botonConsultar) {
			miCoordinador.mostrarVentanaConsulta();
		}
	}


}