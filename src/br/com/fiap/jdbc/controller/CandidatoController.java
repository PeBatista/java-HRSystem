package br.com.fiap.jdbc.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.fiap.jdbc.dao.CandidatoDAO;
import br.com.fiap.jdbc.factory.ConnectionFactory;
import br.com.fiap.jdbc.model.Candidato;

public class CandidatoController {
	private CandidatoDAO candidatodao;

	public CandidatoController() {
		Connection connection = new ConnectionFactory().conectar();
		this.candidatodao = new CandidatoDAO(connection);
	}
	
	public void delete(Integer idCandidato) throws SQLException {
		this.candidatodao.delete(idCandidato);
	}
	
	public void insert(Candidato candidato) throws SQLException {
		this.candidatodao.insert(candidato);
	}
	
	public void listar(int id) throws SQLException {
		List<Candidato> candidatos = this.candidatodao.listarPorArea(id);
		
		for(Candidato candidato:candidatos) {
			System.out.println(candidato.getNome());
		}
		
	}
	
	public void update(Candidato candidato) throws SQLException {
		this.candidatodao.update(candidato);
	}
}
