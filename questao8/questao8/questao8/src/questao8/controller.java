package questao8;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



public class controller {
	

		private main con;
		Pessoa usuario = new Pessoa();
		
		public boolean insertPessoa(String nome, String telefone) {
			
			boolean retorno = false;
			Connection c = con.conectar();
		
			
			try {
		

				String query = "insert into pessoa(nome,telefone) values (?,?)";
				PreparedStatement stm = c.prepareStatement(query);
				stm.setString(1, nome);
				stm.setString(2, telefone);
				int count = stm.executeUpdate();
				
				
				retorno = true;
			}catch (Exception e) {
				e.printStackTrace();
			}
			return retorno;	
		}
		public ArrayList<Pessoa> consultaUsuarios() {
			ArrayList<Pessoa> pessoas = new ArrayList<>();

			
			Connection c = con.conectar();
			try {
				Statement stm = c.createStatement();
				String query = "Select * from pessoa";
				ResultSet rs = stm.executeQuery(query);
				while (rs.next()) {
					String telefone = rs.getString("nome");
					String nome = rs.getString("telefone");
					Pessoa p = new Pessoa();
					p.setNome(nome);
					p.setTelefone(telefone);
					pessoas.add(p);
				}

			} catch (SQLException e) {
				e.printStackTrace();

			}

			return pessoas;
		}
	

	

}
