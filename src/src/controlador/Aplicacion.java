package controlador;

import modelo.Logica;
import vista.VentanaLogin;
import vista.VentanaPrincipal;
import vista.VentanaConsultaIndividual;

public class Aplicacion {
	
	public void iniciarSistema() {
		
		//Instanciacion de clases unicas
		VentanaPrincipal miVentana = new VentanaPrincipal();
		VentanaLogin miLogin = new VentanaLogin(miVentana, true);
		Coordinador miCoordinador = new Coordinador();
		Logica miLogica = new Logica();
		VentanaConsultaIndividual miVentanaConsultaIndividual = new VentanaConsultaIndividual(miVentana, true);
		
		//Relacionamos las clases con el coordinador
		miVentana.setCoordinador(miCoordinador);
		miLogin.setCoordinador(miCoordinador);
		miLogica.setCoordinador(miCoordinador);
		miVentanaConsultaIndividual.setCoordinador(miCoordinador);
		
		//Relacionamos el coordinador con las clases
		miCoordinador.setVentanaPrincipal(miVentana);
		miCoordinador.setVentanaLogin(miLogin);
		miCoordinador.setLogica(miLogica);
		miCoordinador.setVentanaConsultaIndividual(miVentanaConsultaIndividual);
		
		miVentana.setVisible(true);
		miLogin.setVisible(true);
		
	}
	
}
