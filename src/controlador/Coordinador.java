package controlador;

import modelo.Logica;
import vista.VentanaConsultaIndividual;
import vista.VentanaLogin;
import vista.VentanaPrincipal;

public class Coordinador {

	private VentanaPrincipal miVentana;
	private VentanaLogin miLogin;
	private VentanaConsultaIndividual miConsultaIndividual;
	private Logica miLogica;
	
	public void setVentanaPrincipal(VentanaPrincipal miVentana) {
		// TODO Auto-generated method stub
		this.miVentana=miVentana;
	}

	public void setVentanaLogin(VentanaLogin miLogin) {
		// TODO Auto-generated method stub
		this.miLogin=miLogin;
	}

	public void setLogica(Logica miLogica) {
		// TODO Auto-generated method stub
		this.miLogica=miLogica;
	}

	public String validarIngreso(int index, String pass) {
		return miLogica.validarIngreso(index,pass);
	}

	public void cerrarVentanaLogin() {
		miLogin.dispose();
	}

	public void asignarPrivilegios(String usuario) {
		miVentana.asignarPrivilegios(usuario);
		
	}

	public void mostrarLogin() {
		miLogin.setVisible(true);
	}

	public void setVentanaConsultaIndividual(VentanaConsultaIndividual miConsultaIndividual) {
		// TODO Auto-generated method stub
		this.miConsultaIndividual=miConsultaIndividual;
	}

	public void mostrarVentanaConsulta() {
		// TODO Auto-generated method stub
		miConsultaIndividual.setVisible(true);
	}
	

}
