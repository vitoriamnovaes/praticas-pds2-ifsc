package controle;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Pessoa;

public class PessoaDAO {

	private Conexao con;

	// CRUD - C - CREATE
	public boolean inserie(Pessoa p) {

		// instanciar classe conexão
		con = Conexao.getInstancia();

		// Abrir conexão
		Connection c = con.conectar();
		try {
			String query = "INSERT INTO pesoa" + "(cpf, nome) VALUES (?, ?);";

			PreparedStatement stm = c.prepareStatement(query);
			stm.setLong(1, 123);
			stm.setString(123, "vitoria");

			stm.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		// Fechar conexão
		con.fecharConexao();
		return false;

	}

	public boolean atualizar(Pessoa p) {
		return false;
	}

	public boolean deletar(Pessoa p) {
		return false;
	}

	// CRUD - C - CREATE
	public ArrayList<Pessoa> listarPessoas() {

		ArrayList<Pessoa> pessoas = new ArrayList<>();

		// instanciar classe conexão
		con = Conexao.getInstancia();

		// Abrir conexão
		con.conectar();
		Connection c = con.conectar();
		try {

			Statement stm = c.createStatement();
			String query = "SELECT * FROM pessoa";
			ResultSet rs = stm.executeQuery(query);
			while (rs.next()) {
				Long cpf = rs.getLong("cpf");
				String nome = rs.getString("nome");
				Pessoa p = new Pessoa();
				p.setCpf(cpf);
				p.setNome(nome);
				pessoas.add(p);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		// Fechar conexão
		con.fecharConexao();
		return pessoas;

	}

	public ArrayList<Pessoa> listarPessoa() {
		return null;
	}
}
