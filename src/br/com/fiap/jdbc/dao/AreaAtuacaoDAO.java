package br.com.fiap.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.fiap.jdbc.factory.ConnectionFactory;
import br.com.fiap.jdbc.model.AreaAtuacao;
import br.com.fiap.jdbc.model.Candidato;

public class AreaAtuacaoDAO {

			private Connection conexao; // PEGANDO A CONEXAO DA CLASSE CONEXAO

			public AreaAtuacaoDAO(Connection connection) {
				this.conexao = connection; // ESTA CONEXAO � = M�TODO DE CONEXAO

			}

			public void insert(AreaAtuacao area) throws SQLException {
				String sql = "INSERT INTO area (nome) values (?)";
				PreparedStatement stmt = conexao.prepareStatement(sql); // CONVERS�O DESTE COMANDO NO SQL
				stmt.setString(1, area.getNome());
				

				stmt.execute(); // EXECUTANDO DEPOIS DE TER GUARDADO OS REGISTROS NO COMANDO
				stmt.close(); // fechando...

			}

			public List<AreaAtuacao> select() throws SQLException {
				List<AreaAtuacao> areas = new ArrayList<AreaAtuacao>(); // RETORNANDO UMA LISTA
				String sql = "select * from areas";
				PreparedStatement stmt = conexao.prepareStatement(sql); // CONVERS�O DESTE COMANDO NO SQL
				ResultSet rs = stmt.executeQuery(); // SALVANDO NO RESULT, o PROCESSO

				while (rs.next()) {
					AreaAtuacao areaatuacao = new AreaAtuacao(rs.getInt("idArea"), rs.getString("nome"));
					// PEGO OS DADOS E CONSTRUO UM OBJETO PARA EXIBIR

					areas.add(areaatuacao); // ADICIONANDO NA LISTA OS DADOS QUE PEGUEI DA TABELA NO BANCO
				}
				rs.close();
				stmt.close();
				return areas;
			}

			public AreaAtuacao selectById(Long id) throws SQLException {
				AreaAtuacao areaatuacao = null;
				String sql = "select * from areas where id=?";
				PreparedStatement stmt = conexao.prepareStatement(sql);
				stmt.setLong(1, id); //PUXANDO, GUARDANDO e ANALISANDO
				ResultSet rs = stmt.executeQuery();
				while (rs.next()) {
					areaatuacao = new AreaAtuacao(rs.getInt("idArea"), rs.getString("nome")); //QUEREMOS RETORNAR O NOME PELO ID --> ID PASSADO
				}
				rs.close();
				stmt.close();
				return areaatuacao;

			}

			public void delete(Integer id) throws SQLException {
				String sql = "delete from areas where id=?";
				PreparedStatement stmt = conexao.prepareStatement(sql); // CONVERS�O DESTE COMANDO NO SQL
				stmt.setLong(1, id);
				stmt.execute();
				stmt.close();
			}


			public List<AreaAtuacao> listarComCandidato() {
				try {
					AreaAtuacao areaAtual = null;
					List<AreaAtuacao> areas = new ArrayList<AreaAtuacao>();

					String sql = "SELECT A.idArea, A.nome, C.idCandidato, C.nome, C.dataNasc, C.genero, C.tempoExperiencia, C.formacao, C.telefone, C.email, C.endereco, C.idArea FROM AREA A INNER JOIN CANDIDATO C ON A.idArea = C.idArea order by C.idArea";

					try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
						stmt.execute();
						ResultSet rs = stmt.getResultSet();
						while (rs.next()) {
							if (areaAtual == null || !areaAtual.getNome().equals(rs.getString(2))) {
								AreaAtuacao area = new AreaAtuacao(0, sql);
								area.setIdArea(rs.getInt(1));
								area.setNome(rs.getString(2));
								areas.add(area);
								areaAtual = area;
							}
							Candidato candidato = new Candidato(0, sql, null, sql, 0, sql, sql, sql, sql, 0);
							candidato.setIdCandidato(rs.getInt(3));
							candidato.setNome(rs.getString(4));
							candidato.setDataNasc(rs.getDate(5));
							candidato.setGenero(rs.getString(6));
							candidato.setTempoExperiencia(rs.getFloat(7));
							candidato.setFormacao(rs.getString(8));
							candidato.setTelefone(rs.getString(9));
							candidato.setEmail(rs.getString(10));
							candidato.setEndereco(rs.getString(11));
							candidato.setIdArea(rs.getInt(12));

							areas.add(areaAtual);
						}
						rs.close();
						stmt.close();
						return areas;
					}
				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
			}
			
	}

