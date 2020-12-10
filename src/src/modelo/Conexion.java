package modelo;

import java.util.logging.*;
import java.sql.*;


public class Conexion {
	
	
	private final String base = "stonks";
	private final String user = "root";
	private final String password = "";
	private final String url = "jdbc:mysql://localhost/"+base;
	private Connection con = null;
	
	public Connection getConexion() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = (Connection) DriverManager.getConnection(this.url, this.user, this.password);
		}catch(SQLException e){
			System.err.println(e);
		}catch(ClassNotFoundException ex){
			Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
		}
		return con;
	}
        public static void close(Connection conex){
            try {
		conex.close();
            }catch(SQLException e) {
		System.err.println(e);
            }
	
        }

}
