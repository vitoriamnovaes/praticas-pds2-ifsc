package questao8;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class main {
	
	public static Connection conexao = null;

	
	public static void main(String args[]) {
		try {
			
			conectar();
			
			
			
			
			boolean fechou = fecharConexao(conexao);
			if(fechou) {
				System.out.println("deu certo");
			}
			
		}catch (Exception e) {
			System.out.println("deu errado");
		}
		tela tel = new tela();
		tel.setLocationRelativeTo(null);
		tel.setVisible(true);
	}
	
	public static Connection conectar() {
		
		try {
			conexao = DriverManager.getConnection("jdbc:mysql://localhost/" ,"root","root");

			String query = "create database if not exists vitoriaPDS";
			PreparedStatement prepare =  conexao.prepareStatement(query);
			prepare.executeUpdate();
			
			query = "use vitoriaPDS";
			prepare.executeUpdate(query);
				String queryy=  "CREATE TABLE if not exists Pessoa ("
					+ "id int  AUTO_INCREMENT PRIMARY KEY, "
					+ "nome VARCHAR(50) not null, "
					+ "telefone CHAR(15) not null);";
				prepare.executeUpdate(queryy);
				
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conexao;
	}

	public static boolean fecharConexao(Connection conexao) {
		try {
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
}