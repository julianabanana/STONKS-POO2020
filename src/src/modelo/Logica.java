package modelo;

import controlador.Coordinador;

public class Logica {

	final int SELECCION=0;
	final int ADMINISTRADOR=1;
	final int USUARIO=2;
	
	final String PASS_ADMIN="admin";
	final String PASS_USER="1234";
	
	private Coordinador miCoordinador;
    
	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador = miCoordinador;
	}
	
	public String validarIngreso(int index, String pass) {
		String retorno="";
		if(index==SELECCION) {//0
			retorno= "error";
		}else {
			retorno=validarPass(index,pass);
		}
		return retorno;
	}

	private String validarPass(int index, String pass) {
		String retorno =""; 
		switch (index) {
		case ADMINISTRADOR: 
			if(pass.equals(PASS_ADMIN)) {
				retorno="Administrador";
			}else {
				retorno = "Pass invalido";
			}
			break;
		case USUARIO:
			if(pass.equals(PASS_USER)) {
				retorno = "Usuario";
			}else {
				retorno = "Pass invalido";
			}
			break;
		}
		return retorno;
	}
	
}
