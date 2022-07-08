package br.com.fiap.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.fiap.jdbc.factory.ConnectionFactory;
import br.com.fiap.jdbc.model.Candidato;



	public class CandidatoDAO {
		private Connection conexao; // PEGANDO A CONEXAO DA CLASSE CONEXAO

		public CandidatoDAO(Connection connection) {
			this.conexao = connection;

		}

		public void insert(Candidato candidato) throws SQLException {
			String sql = "INSERT INTO candidatos(nome, dataNasc, genero, tempoExperiencia, formacao, telefone, email, endereco, idArea) values (?,?,?,?,?,?,?,?,?)";
			PreparedStatement stmt = conexao.prepareStatement(sql); // CONVERS�O DESTE COMANDO NO SQL
			
			stmt.setString(1, candidato.getNome());
			stmt.setDate(2, candidato.getDataNasc());
			stmt.setFloat(3, candidato.getTempoExperiencia());
			stmt.setString(4, candidato.getFormacao());
			stmt.setString(5, candidato.getTelefone());
			stmt.setString(6, candidato.getEmail());
			stmt.setString(7, candidato.getEndereco());
			stmt.setInt(8, candidato.getIdArea());

			stmt.execute(); // EXECUTANDO DEPOIS DE TER GUARDADO OS REGISTROS NO COMANDO
			stmt.close(); // fechando...

		}

		public List<Candidato> select() throws SQLException {
			List<Candidato> candidatos = new ArrayList<Candidato>(); // RETORNANDO UMA LISTA
			String sql = "select * from candidatos";
			PreparedStatement stmt = conexao.prepareStatement(sql); // CONVERS�O DESTE COMANDO NO SQL
			ResultSet rs = stmt.executeQuery(); // SALVANDO NO RESULT, o PROCESSO

			while (rs.next()) {
				Candidato candidato = new Candidato(rs.getInt("idCandidato"), rs.getString("nome"), rs.getDate("dataNasc"), rs.getString("genero"), rs.getFloat("tempoExperiencia"), rs.getString("formacao"), rs.getString("telefone"), rs.getString("email"), rs.getString("endereco"), rs.getInt("idArea"));;//DENTRO DA PR�PRIA INSTANCIA, J� COLOCAMOS AUTOMATICAMENTE OS DADOS QUE GET

				// PEGO OS DADOS E CONSTRUO UM OBJETO PARA EXIBIR

				candidatos.add(candidato); // ADICIONANDO NA LISTA OS DADOS QUE PEGUEI DA TABELA NO BANCO
			}
			rs.close();
			stmt.close();
			return candidatos;
		}

		public Candidato selectById(Long id) throws SQLException {
			Candidato candidato = null;
			String sql = "select * from candidatos where id=?";
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setLong(1, id); //PUXANDO, GUARDANDO e ANALISANDO
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				candidato = new Candidato(rs.getInt("idCandidato"), rs.getString("nome"), rs.getDate("dataNasc"), rs.getString("genero"), rs.getFloat("tempoExperiencia"), rs.getString("formacao"), rs.getString("telefone"), rs.getString("email"), rs.getString("endereco"), rs.getInt("idArea")); //DENTRO DA PR�PRIA INSTANCIA, J� COLOCAMOS AUTOMATICAMENTE OS DADOS QUE GET
				System.out.println(rs.getString("nome")); //QUEREMOS RETORNAR O NOME PELO ID --> ID PASSADO
			}
			rs.close();
			stmt.close();
			return candidato;

		}

		public void delete(Integer id) throws SQLException {
			String sql = "delete from candidatos where id=?";
			PreparedStatement stmt = conexao.prepareStatement(sql); // CONVERS�O DESTE COMANDO NO SQL
			stmt.setLong(1, id);
			stmt.execute();
			stmt.close();
		}

		public void update(Candidato candidato) throws SQLException {
			String sql = "update candidatos set nome=?, email=?, telefone=? where id=?";

			PreparedStatement stmt = conexao.prepareStatement(sql); // CONVERS�O DESTE COMANDO NO SQL
			stmt.setInt(1, candidato.getIdCandidato());
			stmt.setString(2, candidato.getNome());
			stmt.setDate(3, candidato.getDataNasc());
			stmt.setFloat(4, candidato.getTempoExperiencia());
			stmt.setString(5, candidato.getFormacao());
			stmt.setString(6, candidato.getTelefone());
			stmt.setString(7, candidato.getEmail());
			stmt.setString(8, candidato.getEndereco());
			stmt.setInt(9, candidato.getIdArea());

			stmt.execute();
			stmt.close();
		}
		
		public List<Candidato> listarPorArea(int idArea) {
			List<Candidato> candidatos = new ArrayList<Candidato>();
			try {

				String sql = "SELECT idCandidato, nome, dataNasc, genero, tempoExperiencia, formacao, telefone, email, endereco, idArea FROM CANDIDATO WHERE idArea = ?";

				PreparedStatement stmt = conexao.prepareStatement(sql);
				stmt.setInt(1, idArea);
				ResultSet rs = stmt.executeQuery();

				while (rs.next()) {
					Candidato candidato = new Candidato(idArea, sql, null, sql, idArea, sql, sql, sql, sql, idArea);
					candidato.setIdCandidato(rs.getInt(1));
					candidato.setNome(rs.getString(2));
					candidato.setDataNasc(rs.getDate(3));
					candidato.setGenero(rs.getString(4));
					candidato.setTempoExperiencia(rs.getFloat(5));
					candidato.setFormacao(rs.getString(6));
					candidato.setTelefone(rs.getString(7));
					candidato.setEmail(rs.getString(8));
					candidato.setEndereco(rs.getString(9));
					candidato.setIdArea(rs.getInt(10));
					
					candidatos.add(candidato);
				}
				stmt.close();
				rs.close();
				return candidatos;
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
}

