package br.com.fiap.jdbc.factory;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
// import javax.swing.JOptionPane;

public class ConnectionFactory {
	private String schema = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
	private String user =   "usu�rio necess�rio";//JOptionPane.showInputDialog("Digite o usu�rio: ");
	private String password =    "senha do usu�rio da oracle";//JOptionPane.showInputDialog("Digite sua senha: ");

	public Connection conectar() {
		try {
			return DriverManager.getConnection(schema, user, password);
		} catch (SQLException e) {
			System.out.println("Erro ao conectar");
			throw new RuntimeException(e);
		}
	}
	
	
}
